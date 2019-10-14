package com.allaboutscala.donutstore.httpserver.routes


import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.{Matchers, WordSpec}

import scala.io.Source

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorials and feedback from readers at http://allaboutscala.com.
  *
  * - Test class to validate the welcome message that is displayed at the root end point,
  *   such as, http://localhost:8080.
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

class DefaultRouteTest
  extends WordSpec
    with Matchers
    with ScalatestRouteTest
    with TestBase {

  val defaultRoutes = new DefaultRoute().routes()

  "DonutStore" can {
    "have a welcome page at the root end point" in {
      Get("/") ~> defaultRoutes ~> check {
        responseAs[String] shouldEqual welcomePage()
      }
    }
  }

  private def welcomePage(): String = {
    val path = sys.env.getOrElse("WELCOME_PAGE_PATH", "httpServer/src/main/resources/welcome.html")
    Source.fromFile(path).mkString
  }
}
