package com.allaboutscala.donutstore.httpserver.routes

import com.allaboutscala.donutstore.config.{DonutConfig, DonutStoreConfig}
import com.allaboutscala.donutstore.data.{DataApi, DonutDao}

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorials and feedback from readers at http://allaboutscala.com.
  *
  * - A basic placeholder for the shared components used in various test classes.
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

trait TestBase {
  /** Load configuration for DonutStore and lift into the implicit scope **/
  val (cfg, _) = new DonutConfig{}.load().fold(error => sys.error(error.toString), identity)
  implicit val donutStoreConfig: DonutStoreConfig = cfg

  /** Load the [[DonutDao]] and lift into the implicit scope **/
  implicit val dataApi: DataApi = new DonutDao()
}
