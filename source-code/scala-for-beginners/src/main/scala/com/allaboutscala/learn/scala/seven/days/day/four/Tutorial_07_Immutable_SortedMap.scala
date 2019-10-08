package com.allaboutscala.learn.scala.seven.days.day.four

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Learn How To Use Scala's Immutable SortedMap
  *
  * [[http://allaboutscala.com/tutorials/chapter-6-beginner-tutorial-using-scala-immutable-collection/scala-tutorial-learn-use-immutable-treemap/ Tutorial]]
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
object Tutorial_07_Immutable_SortedMap extends App {

  import scala.collection.immutable.SortedMap
  println("Step 1: How to initialize a SortedMap with 3 elements using Tuples key and value")
  val sortedMap1 = SortedMap(("PD","Plain Donut"),("SD","Strawberry Donut"),("CD","Chocolate Donut"))
  println(s"Elements of sortedMap1 = $sortedMap1")
  // NOTE: it is sorted by the key so CD is first followed by PD and then SD



  println("\nStep 2: How to initialize SortedMap using key -> value notation")
  val sortedMap2 = SortedMap("VD"-> "Vanilla Donut", "GD" -> "Glazed Donut")
  println(s"Elements of sortedMap2 = $sortedMap2")



  println("\nStep 3: How to access elements of SortedMap by specific key")
  println(s"Element by key VD = ${sortedMap2("VD")}")
  println(s"Element by key GD = ${sortedMap2("GD")}")



  println("\nStep 4: How to add elements to SortedMap using +")
  val sortedMap3 = sortedMap1 + ("KD" -> "Krispy Kreme Donut")
  println(s"Elements in sortedMap3 = $sortedMap3")



  println("\nStep 5: How to add two SortedMaps together using ++")
  val sortedMap4 = sortedMap1 ++ sortedMap2
  println(s"Elements in sortedMap4 = $sortedMap4")



  println("\nStep 6: How to remove key and its value from SortedMap using -")
  val sortedMap5 = sortedMap4 - "CD"
  println(s"SortedMap without the key CD and its value = $sortedMap5")



  println("\nStep 7: How to change ordering of SortedMap to descending alphabet")
  object ReverseAlphabetOrdering extends Ordering[String] {
    def compare(key1:String, key2:String) = key2.compareTo(key1)
  }
  val sortedMap6 = SortedMap(("PD","Plain Donut"),("SD","Strawberry Donut"),("CD","Chocolate Donut"))(ReverseAlphabetOrdering)
  println(s"Elements of sortedMap6 in descending order = $sortedMap6")
  // NOTE: SD is printed first followed by PD and then CD



  println("\nStep 8: How to initialize an empty SortedMap")
  val emptySortedMap = SortedMap.empty[String,String]
  println(s"Empty SortedMap = $emptySortedMap")
}
