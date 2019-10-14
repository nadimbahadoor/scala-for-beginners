package com.allaboutscala.donutstore.httpserver.routes


import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives.{complete, get, path, _}
import akka.http.scaladsl.server._
import com.allaboutscala.donutstore.config.DonutStoreConfig
import com.allaboutscala.donutstore.data.DataApi

import scala.util.Try

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorials and feedback from readers at http://allaboutscala.com.
  *
  * - This class exposes an Akka HTTP route at /api-version. It is typical for other services to rely on, say, this
  *   specified version, for driving their particular interactions with the Donut Store API or endpoints.
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

class ApiVersionRoute extends HttpRoute {
  import spray.json._

  override def routes()(implicit config: DonutStoreConfig, dataApi: DataApi): Route = {
    val apiVersion =
      s"""
         |{
         | "app": "${config.app}",
         | "version": "${config.httpServer.apiVersion}"
         |}""".stripMargin

    path("api-version") {
      get {
        parameter("prettyPrint" ? "true") { prettyPrint => // the prettyPrint parameter is optional and we also default to true
          val shouldPrettyPrint = Try(prettyPrint.toBoolean).getOrElse(true) // we'll default to pretty print
        val apiVersionOutput = if (shouldPrettyPrint) apiVersion.parseJson.prettyPrint else apiVersion.parseJson.toString
          complete(HttpEntity(ContentTypes.`application/json`, apiVersionOutput))
        }
      }
    }
  }
}
