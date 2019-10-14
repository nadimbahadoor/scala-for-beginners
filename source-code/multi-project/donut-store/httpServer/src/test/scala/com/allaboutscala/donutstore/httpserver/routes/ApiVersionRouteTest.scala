package com.allaboutscala.donutstore.httpserver.routes

import akka.http.scaladsl.model._
import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorials and feedback from readers at http://allaboutscala.com.
  *
  * - Test class for the /api-version route.
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

class ApiVersionRouteTest
  extends FlatSpec
    with Matchers
    with ScalatestRouteTest
    with TestBase {

  behavior of "ApiVersionRoute"


  val apiVersionRoute = new ApiVersionRoute().routes()


  "The api version route" should "have status code of OK and HTTP code of 200" in {
    Get("/api-version?prettyPrint=false") ~> apiVersionRoute ~> check {
      status shouldEqual StatusCodes.OK
      status.intValue shouldBe 200
    }
  }



  "The api version route content" should "be of JSON type and match the version number" in {
    Get("/api-version?prettyPrint=false") ~> apiVersionRoute ~> check {
      contentType shouldEqual ContentTypes.`application/json`
      val apiRouteExpectedJson = """{"app":"donut-store","version":"1.0.0.0"}"""
      entityAs[String] shouldEqual apiRouteExpectedJson
    }
  }
}

