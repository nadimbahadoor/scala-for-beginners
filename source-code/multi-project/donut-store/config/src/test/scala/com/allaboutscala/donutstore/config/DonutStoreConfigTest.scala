package com.allaboutscala.donutstore.config

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorials and feedback from readers at http://allaboutscala.com.
  *
  * - Test class for verifying the corresponding values for the configurations that are defined within
  *   the application.conf file.
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

class DonutStoreConfigTest
  extends FlatSpec
    with Matchers {

  behavior of "DonutStoreConfig"

  /** Load configuration for DonutStore and lift into the implicit scope **/
  val (cfg, _) = new DonutConfig{}.load().fold(error => sys.error(error.toString), identity)
  implicit val donutStoreConfig: DonutStoreConfig = cfg


  "Configurations from application.conf" should "match their expected domain values" in {
    donutStoreConfig.app shouldEqual "donut-store"
    donutStoreConfig.httpServer.ip shouldEqual "127.0.0.1"
    donutStoreConfig.httpServer.port === 8080
    donutStoreConfig.httpServer.apiVersion shouldEqual "1.0.0.0"
  }
}
