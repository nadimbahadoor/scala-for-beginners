package com.allaboutscala.donutstore.marshalling

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import com.allaboutscala.donutstore.common.{Donut, Donuts}
import spray.json.RootJsonFormat

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorials and feedback from readers at http://allaboutscala.com.
  *
  * - Trait [[JsonSupport]] acts as a convenient closure for the Abstract Data Type (ADT), namely, [[Donut]] and
  *   [[Donuts]]. These classes have been lifted into the implicit scope in order to benefit from the
  *   automatic JSON encoding/decoding that is built-in with Akka HTTP through the use of the
  *   [[SprayJsonSupport]] trait.
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

trait JsonSupport extends SprayJsonSupport {

  import spray.json.DefaultJsonProtocol._

  implicit val donutJsonFormat: RootJsonFormat[Donut] = jsonFormat2(Donut)
  implicit val donutsJsonFormat: RootJsonFormat[Donuts] = jsonFormat1(Donuts)
}
