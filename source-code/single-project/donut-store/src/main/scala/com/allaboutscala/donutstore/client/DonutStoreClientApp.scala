package com.allaboutscala.donutstore.client

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.model._
import akka.http.scaladsl.unmarshalling.Unmarshal
import akka.stream.ActorMaterializer
import akka.util.ByteString
import com.allaboutscala.donutstore.common.Donuts
import com.allaboutscala.donutstore.marshalling.JsonSupport

import scala.concurrent.{Await, ExecutionContextExecutor, Future}

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorials and feedback from readers at http://allaboutscala.com.
  *
  * - A basic client application which sends Create, Read, Update and Delete (CRUD) HTTP requests to the DonutStore
  *   REST endpoints. This client app obviously expect the DonutStore HTTP server to be up and running.
  *
  *
  * Copyright 2016 - 2019 Nadim Bahadoor (http://allaboutscala.com)
  *
  * Licensed under the Apache License, Version 2.0 (the "License"); you may not
  * use this file except in compliance with the License. You may obtain a copy of
  * the License at
  *
  *  [http://www.apache.org/licenses/LICENSE-2.0]
  *
  * Unless required by applicable law or agreed to in writing, software
  * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
  * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
  * License for the specific language governing permissions and limitations under
  * the License.
  */
object DonutStoreClientApp extends App with JsonSupport with SprayJsonSupport {
  import scala.concurrent.duration._

  implicit val system: ActorSystem = ActorSystem("akka-http-donuts-client")
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  implicit val ec: ExecutionContextExecutor = system.dispatcher
  val restEndPoint = "http://localhost:8080"



  println("HTTP POST /add-donut")
  val jsonDonutInput = ByteString("""{"name":"plain donut", "ingredients":["sugar","flour"]}""")
  val httpPostAddDonut = HttpRequest(
    uri = s"$restEndPoint/add-donut",
    method = HttpMethods.POST,
    entity = HttpEntity(MediaTypes.`application/json`, jsonDonutInput)
  )
  val donutsAdded = Await.result(sendRequest(httpPostAddDonut).flatMap(Unmarshal(_).to[String]), 5.second)
  println(donutsAdded)



  println("\nHTTP GET /donuts")
  val getDonutsRequest = HttpRequest(
    uri = s"$restEndPoint/donuts",
    method = HttpMethods.GET
  )
  val listOfDonuts = Await.result(sendRequest(getDonutsRequest).flatMap(Unmarshal(_).to[Donuts]), 5. second)
  println(listOfDonuts)



  println("\nHTTP POST /donuts/plain%20donut?ingredients=sugar,flour,syrup")
  val updateDonutRequest = HttpRequest(
    uri = s"$restEndPoint/donuts/plain%20donut?ingredients=sugar,flour,syrup",
    method = HttpMethods.POST
  )
  val donutUpdated = Await.result(sendRequest(updateDonutRequest).flatMap(Unmarshal(_).to[String]), 5.second)
  println(donutUpdated)



  println("\nHTTP DELETE /donuts/plain%20donut")
  val deleteDonutRequest = HttpRequest(
    uri = s"$restEndPoint/donuts/plain%20donut",
    method = HttpMethods.DELETE
  )
  val deletedDonut = Await.result(sendRequest(deleteDonutRequest).flatMap(Unmarshal(_).to[String]), 5.second)
  println(deletedDonut)



  println("Shutting down DonutStore Client Application.")
  Await.ready(system.terminate(), 5.second)



  /** Helper method for sending an HTTP client request to a given REST end point.
    *
    * @param httpRequest the [[HttpRequest]] which supports the typical HTTP methods, such as GET, POST, DELETE
    * @return the [[HttpResponse]] as the reply from the initial [[HttpRequest]]
    */
  private def sendRequest(httpRequest: HttpRequest): Future[HttpResponse] = {
    for {
      response <- Http().singleRequest(httpRequest)
      _ = println(s"${httpRequest.method} ${httpRequest.uri} status = ${response.status}")
    } yield response
  }
}



