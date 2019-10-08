package com.allaboutscala.learn.scala.seven.days.day.four

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Learn How To Use Scala's Immutable ListMap
  *
  * [[http://allaboutscala.com/tutorials/chapter-6-beginner-tutorial-using-scala-immutable-collection/scala-tutorial-learn-use-immutable-listmap/ Tutorial]]
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
object Tutorial_03_Immutable_ListMap extends App {

  println("Step 1: How to initialize a ListMap with 3 elements using key -> value notation")
  import scala.collection.immutable.ListMap
  val listMap1 = ListMap("PD" -> "Plain Donut", "SD" ->"Strawberry Donut", "CD" -> "Chocolate Donut")
  println(s"Elements of listMap1 = $listMap1")



  println("\nStep 2: How to access elements by specific key in the ListMap")
  println(s"Element by key PD = ${listMap1("PD")}")
  println(s"Element by key SD = ${listMap1("SD")}")



  println("\nStep 3: How to add elements to ListMap using +")
  val listMap2 = listMap1 + ("KD" -> "Krispy Kreme Donut")
  println(s"Elements of listMap2 = $listMap2")



  println("\nStep 4: How to add two ListMaps together using ++")
  val listMap3 = listMap1 ++ listMap2
  println(s"Elements of listMap3 = $listMap3")



  println("\nStep 5: How to remove key and value from ListMap using -")
  val listMap4  = listMap1 - "CD"
  println(s"ListMap without the key CD and its value = $listMap4")



  println("\nStep 6: How to initialize an empty ListMap")
  val emptyListMap = ListMap.empty[String,String]
  println(s"Empty ListMap with key type String and value also of type String= $emptyListMap")
}
