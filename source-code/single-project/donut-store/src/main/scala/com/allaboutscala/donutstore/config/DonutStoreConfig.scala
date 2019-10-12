package com.allaboutscala.donutstore.config

import java.io.File

import com.typesafe.config.{ConfigFactory, ConfigParseOptions, Config}
import pureconfig.error.ConfigReaderFailures

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorials and feedback from readers at http://allaboutscala.com.
  *
  * - Trait [[DonutConfig]] uses the com.github.pureconfig artifact to automatically parse the
  *   src/main/resources/application.conf file into the corresponding [[DonutStoreConfig]] and [[HttpServer]] classes,
  *   which are defined within this scope.
  *
  * - In an enterprise application, you will most likely have additional nesting for various configurations. For
  *   simplicity, our configuration has only one depth represented by the [[HttpServer]] class.
  *
  *   donut-store {
  *     app = "donut-store"
  *     http-server {
  *       ip = 127.0.0.1
  *       port = 8080
  *       api-version = 1.0.0.0
  *     }
  *   }
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

trait DonutConfig {
  // This import is required to facilitate the automatic wiring of application.conf to the classes in scope below.
  import pureconfig.generic.auto._

  // Showing the flexibility for loading configuration from, say, a system variable named CONFIG_PATH
  private val configPath = sys.env.getOrElse("CONFIG_PATH", "src/main/resources/application.conf")

  // We enforce a strict parsing restriction
  private val parseOptions = ConfigParseOptions.defaults().setAllowMissing(false)

  def load(): Either[ConfigReaderFailures, (DonutStoreConfig, Config)] = {
    val config = ConfigFactory.parseFile(new File(configPath), parseOptions).resolve()
    pureconfig.loadConfig[DonutStoreConfig](config, "donut-store").map(_ -> config)
  }
}


/** A top level closure of all the configurations for the Donut Store.
  *
  * @param app           the name for the Donut Store application
  * @param httpServer    the [[HttpServer]] configurations
  */
final case class DonutStoreConfig(app: String, httpServer: HttpServer)


/** Captures the properties of the http-server configuration, namely, ip, port and api-version.
  *
  * @param ip the ip address for bootstrapping the Akka HTTP server
  * @param port the port at which the Akka HTTP server will be reached
  * @param apiVersion the given version for the Donut Store API
  */
final case class HttpServer(ip: String, port: Int, apiVersion: String)