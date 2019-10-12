package com.allaboutscala.donutstore.httpserver

import akka.http.scaladsl.Http
import com.typesafe.scalalogging.LazyLogging

import scala.io.StdIn
import scala.util.{Failure, Success}

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorials and feedback from readers at http://allaboutscala.com.
  *
  * - Trait [[DonutStoreHttpController]] exposes a single method named startAndBind() which is essentially
  *   responsible to setup the required bindings for an Akka HTTP server. More precisely, it initializes an
  *   [[akka.actor.ActorSystem]], an [[akka.stream.ActorMaterializer]], and also places in scope Akka's default
  *   dispatcher.
  *
  * - Before being able to bind the Akka HTTP server, it however requires the mixin of [[DonutStoreServices]] for the
  *   Route definitions, as well as any required configurations.
  *
  * - [[DonutStoreHttpController]] is best suited to be mixin, or you can also in line its usage, as so
  *   {{{
  *   val donutStoreHttpServer = new DonutStoreHttpController with DonutStoreServices
  *   donutStoreHttpServer.startAndBind()
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

trait DonutStoreHttpController extends LazyLogging {
  this: DonutStoreServices =>

  def startAndBind(): Unit = {
    logger.info("Initializing and binding Akka HTTP server")
    val httpServerFuture = Http().bindAndHandle(donutApiRoutes, cfg.httpServer.ip, cfg.httpServer.port)
    httpServerFuture.onComplete {
      case Success(binding) =>
        logger.info(s"Akka Http Server is bound to ${binding.localAddress}")
        logger.info(s"To stop the server, press the [Enter] key in IntelliJ's console.")

      case Failure(e) =>
        logger.error(s"Akka Http server failed to bind to ${cfg.httpServer.ip}:${cfg.httpServer.port}",e)
        system.terminate()
    }

    // pressing enter key will kill the server
    StdIn.readLine()
    for {
      serverBinding <- httpServerFuture
      _             <- serverBinding.unbind()
      terminated    <- system.terminate()
    } yield logger.info(s"Akka Http server was terminated = $terminated")
  }
}
