package com.allaboutscala.donutstore.routes

import akka.http.scaladsl.server.Route
import com.allaboutscala.donutstore.config.DonutStoreConfig
import com.allaboutscala.donutstore.data.{DataApi, DonutDao}
import com.typesafe.scalalogging.LazyLogging

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorials and feedback from readers at http://allaboutscala.com.
  *
  * - This trait acts as a contract for all types that needs to expose a particular Akka HTTP Route that will
  *   form part of the overall Donut Store API endpoints.
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

trait HttpRoute extends LazyLogging {

  logRoute()

  def routes()(implicit config: DonutStoreConfig, dataApi: DataApi): Route

  def logRoute(): Unit = {
    logger.info(s"Loading route for ${getClass.getSimpleName}")
  }
}
