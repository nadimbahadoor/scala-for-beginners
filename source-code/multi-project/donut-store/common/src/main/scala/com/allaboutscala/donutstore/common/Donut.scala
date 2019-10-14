package com.allaboutscala.donutstore.common

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorials and feedback from readers at http://allaboutscala.com.
  *
  * - Classes [[Donut]] and [[Donuts]] represent the Abstract Data Type (ADT) for the JSON payload that makes up the
  *   HTTP GET request at the path http://localhost:8080/donuts.
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

/** A Donut item for the Donut Store application.
  *
  * @param name the name of the particular donut
  * @param ingredients the [[List]] of ingredients that make up this donut
  */
final case class Donut(name: String, ingredients: List[String])


/** A list of Donut items.
  *
  * @param donuts the root of the JSON payload with a [[Seq]] of [[Donut]] items
  */
final case class Donuts(donuts: Seq[Donut])