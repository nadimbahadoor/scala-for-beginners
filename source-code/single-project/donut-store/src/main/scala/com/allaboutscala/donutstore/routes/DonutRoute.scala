package com.allaboutscala.donutstore.routes

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.allaboutscala.donutstore.common.Donut
import com.allaboutscala.donutstore.config.DonutStoreConfig
import com.allaboutscala.donutstore.data.DataApi
import com.allaboutscala.donutstore.marshalling.JsonSupport

import scala.util.{Failure, Success}

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorials and feedback from readers at http://allaboutscala.com.
  *
  * - This class is responsible for creating the primary Create Read Update and Delete (CRUD) endpoints that make up
  *   the Donut Store API, namely:
  *   POST /add-donut - for creating a new donut item
  *   GET /donuts - for listing all donut items
  *   DELETE /donuts/for some donut - for deleting a particular donut item
  *   POST /donuts/for some donut?ingredients - for updating the ingredients of a particular donut item
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

class DonutRoute extends HttpRoute with JsonSupport {
  override def routes()(implicit config: DonutStoreConfig, dataApi: DataApi): Route = {
    path("add-donut") {
      post {
        entity(as[Donut]) { donut =>
          onComplete(dataApi.createDonut(donut)) {
            case Success(createMessage) => complete(StatusCodes.Created, createMessage)
            case Failure(ex) => complete(s"Failed to create donut, exception = ${ex.getMessage}")
          }
        }
      } ~
      get {
        complete(StatusCodes.MethodNotAllowed)
      }
    } ~
      path("donuts") {
      get {
        onComplete(dataApi.fetchDonuts()) {
          case Success(donuts) => complete(StatusCodes.OK, donuts)
          case Failure(ex) => complete(s"Failed to fetch donuts, exception = ${ex.getMessage}")
        }
      }
    } ~
    path("donuts" / Segment) { donutName =>
      delete {
        onComplete(dataApi.deleteDonut(donutName)) {
          case Success(deleteMessage) => complete(StatusCodes.OK, deleteMessage)
          case Failure(ex) => complete(s"Failed to delete donut, exception = ${ex.getMessage}")
        }
      }
    } ~
    path("donuts" / Segment) { donutName =>
      post {
        parameter("ingredients") { ingredients =>
          val donutIngredients = ingredients.split(",").toList
          val donut = Donut(donutName, donutIngredients)
          onComplete(dataApi.updateDonutIngredients(donut)) {
            case Success(updateMessage) => complete(StatusCodes.OK, updateMessage)
            case Failure(ex) => complete(s"Failed to update ingredients, exception = ${ex.getMessage}")
          }
        }
      }
    }
  }
}
