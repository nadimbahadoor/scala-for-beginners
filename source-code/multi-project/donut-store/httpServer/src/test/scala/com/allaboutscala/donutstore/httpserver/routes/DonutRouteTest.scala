package com.allaboutscala.donutstore.httpserver.routes


import akka.http.scaladsl.model._
import akka.http.scaladsl.server._
import akka.http.scaladsl.testkit.ScalatestRouteTest
import akka.util.ByteString
import com.allaboutscala.donutstore.common.Donuts
import com.allaboutscala.donutstore.common.marshalling.JsonSupport
import org.scalatest._

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorials and feedback from readers at http://allaboutscala.com.
  *
  * - Test class for the paths below as defined within the [[DonutRoute]] class that make up the Donut Store API.*
  *   POST /add-donut
  *   GET /donuts
  *   DELETE /donuts/for some donut
  *   POST /donuts/for some donut?ingredients
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

class DonutRouteTest
  extends WordSpec
    with Matchers
    with ScalatestRouteTest
    with JsonSupport
    with TestBase {

  val donutRoutes = new DonutRoute().routes()

  "DonutStore CRUD operations" can {
    "GET call to /donuts return an empty response" in {
      Get("/donuts") ~> donutRoutes ~> check {
        val donuts = responseAs[Donuts]
        donuts.donuts.size shouldBe 0
        status shouldEqual StatusCodes.OK
        status.intValue shouldBe 200
      }
    }


    "POST /add-donut a plain donut item should produce a response with exactly one item" in {
      val jsonDonutInput = ByteString("""{"name":"plain donut", "ingredients":["sugar","flour"]}""")
      val httpPostAddDonut = HttpRequest(
        uri = "/add-donut",
        method = HttpMethods.POST,
        entity = HttpEntity(MediaTypes.`application/json`, jsonDonutInput))

      httpPostAddDonut ~> donutRoutes ~> check {
        responseAs[String] shouldEqual "plain donut has been added to the database."
        status.isSuccess() shouldEqual true
        status.intValue() shouldEqual 201
        status.reason shouldEqual "Created"
      }
    }


    "POST /donut/plain donut? should require the ingredients query parameter" in {
      Post("/donuts/plain%20donut?") ~> Route.seal(donutRoutes) ~> check {
        responseAs[String] shouldEqual "Request is missing required query parameter 'ingredients'"
        status shouldEqual StatusCodes.NotFound
      }
    }


    "POST /donuts/plain donut?ingredients=sugar,flour,syrup should update the ingredients for the plain donut item" in {
      Get("/donuts") ~> donutRoutes ~> check {
        val donutsBeforeUpdate = responseAs[Donuts]
        donutsBeforeUpdate.donuts.head.ingredients === List("sugar", "flour")
      }

      Post("/donuts/plain%20donut?ingredients=sugar,flour,syrup") ~> donutRoutes ~> check {
        responseAs[String] shouldEqual "Updated donut ingredients for donutName = plain donut"
        status.isSuccess() shouldEqual true
        status.intValue() shouldEqual 200
        status.reason shouldEqual "OK"
      }

      Get("/donuts") ~> donutRoutes ~> check {
        val donutsAfterUpdate = responseAs[Donuts]
        donutsAfterUpdate.donuts.head.ingredients === List("sugar", "flour", "syrup")
      }
    }


    "DELETE /donuts/plain donut should end up in an empty donuts database" in {
      Get("/donuts") ~> donutRoutes ~> check {
        val donutsBeforeDelete = responseAs[Donuts]
        donutsBeforeDelete.donuts.size shouldBe 1
      }

      Delete("/donuts/plain%20donut") ~> donutRoutes ~> check {
        responseAs[String] shouldEqual "Deleted plain donut from database."
        status.isSuccess() shouldEqual true
        status.intValue() shouldEqual 200
        status.reason shouldEqual "OK"
      }

      Get("/donuts") ~> donutRoutes ~> check {
        val donutsAfterDelete = responseAs[Donuts]
        donutsAfterDelete.donuts.size shouldBe 0
      }
    }
  }
}
