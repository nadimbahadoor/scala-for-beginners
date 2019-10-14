package com.allaboutscala.donutstore.httpserver

import akka.actor.ActorSystem
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server._
import akka.stream.ActorMaterializer
import com.allaboutscala.donutstore.config.{DonutConfig, DonutStoreConfig}
import com.allaboutscala.donutstore.data.{DataApi, DonutDao}
import com.allaboutscala.donutstore.httpserver.routes.{ApiVersionRoute, DefaultRoute, DonutRoute, HttpRoute}
import com.typesafe.scalalogging.LazyLogging

import scala.concurrent.ExecutionContextExecutor

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorials and feedback from readers at http://allaboutscala.com.
  *
  * - Trait [[DonutStoreServices]] acts as a nice single closure which loads all the required services that are needed
  *   for the Donut Store application. It is obviously designed to be mixin, such as through its current application
  *   with the trait [[DonutStoreHttpController]].
  *   {{{
  *   trait DonutStoreHttpController extends LazyLogging {
  *     this: DonutStoreServices =>
  *   }
  *   }}}
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

trait DonutStoreServices extends LazyLogging {
  // load config
  val (donutStoreConfig, rawConfig) = new DonutConfig{}.load().fold(error => sys.error(error.toString), identity)
  logger.info(s"Loaded donut store config = $donutStoreConfig")

  // required values to be in the implicit scope
  implicit val cfg: DonutStoreConfig = donutStoreConfig
  implicit val dataApi: DataApi = new DonutDao()
  logger.info("Initialized data access layer")

  // Akka Http routes
  val donutApiRoutes = loadRoutes(Seq(new ApiVersionRoute(), new DonutRoute()))
  logger.info("Initialized all Akka HTTP routes")

  // Akka Http required ActorSystem, Materializer and Execution Context
  implicit val system: ActorSystem = ActorSystem("donut-store-http-server")
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  implicit val ec: ExecutionContextExecutor = system.dispatcher


  /** Helper method for producing a single Akka HTTP [[Route]] that is required for bootstrapping the Akka HTTP server.
    *
    * @param httpRoutes the Sequence which conforms to the [[com.allaboutscala.donutstore.httpserver.routes.HttpRoute]] type
    * @return an Akka HTTP [[Route]]
    */
  private def loadRoutes(httpRoutes: Seq[HttpRoute]): Route = {
    val defaultRoute = new DefaultRoute().routes()
    httpRoutes.foldLeft(defaultRoute)((acc, httpRoute) => acc ~ httpRoute.routes())
  }
}