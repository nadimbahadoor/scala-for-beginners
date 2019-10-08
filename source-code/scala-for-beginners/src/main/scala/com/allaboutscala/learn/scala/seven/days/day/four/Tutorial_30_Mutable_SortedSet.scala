package com.allaboutscala.learn.scala.seven.days.day.four

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Learn How To Use Scala's Mutable SortedSet
  *
  * [[http://allaboutscala.com/tutorials/chapter-7-beginner-tutorial-using-scala-mutable-collection/scala-tutorial-learn-use-mutable-sortedset/ Tutorial]]
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
object Tutorial_30_Mutable_SortedSet extends App {

  import scala.collection.mutable.SortedSet
  println("\nStep 1: How to initialize a SortedSet with 3 elements")
  val sortedSet1 = SortedSet("Plain Donut","Strawberry Donut","Chocolate Donut")
  println(s"Elements of sortedSet1 = $sortedSet1")



  println("\nStep 2: How to check specific elements in SortedSet")
  println(s"Element Plain Donut = ${sortedSet1("Plain Donut")}")
  println(s"Element Strawberry Donut = ${sortedSet1("Strawberry Donut")}")
  println(s"Element Chocolate Donut = ${sortedSet1("Chocolate Donut")}")



  println("\nStep 3: How to add elements to SortedSet using +=")
  sortedSet1 += "Vanilla Donut"
  println(s"Elements of sortedSet1 after adding Vanilla Donut element = $sortedSet1")



  println("\nStep 4: How to add two SortedSet together using ++=")
  sortedSet1 ++= SortedSet("Vanilla Donut", "Glazed Donut")
  println(s"Elements of sortedSet1 after adding second SortedSet = $sortedSet1")



  println("\nStep 5: How to remove element from SortedSet using -=")
  sortedSet1 -= "Plain Donut"
  println(s"sortedSet1 without Plain Donut element = $sortedSet1")



  println("\nStep 6: How to find the intersection between two SortedSets using &")
  val sortedSet2 = SortedSet("Vanilla Donut", "Glazed Donut", "Plain Donut")
  println(s"Intersection of sortedSet1 and sortedSet5 = ${sortedSet1 & sortedSet2}")



  println("\nStep 7: How to find the difference between two SortedSets using &~")
  println(s"Difference of sortedSet1 and sortedSet5 = ${sortedSet1 &~ sortedSet2}")



  println("\nStep 8: How to change ordering to descending alphabet in SortedSet")
  object ReverseAlphabetOrdering extends Ordering[String] {
    def compare(key1: String, key2: String) = key2.compareTo(key1)
  }
  val sortedSet6 = SortedSet("Plain Donut", "Strawberry Donut", "Chocolate Donut")(ReverseAlphabetOrdering)
  println(s"Elements of sortedSet6 = $sortedSet6")
  // NOTE: The elements are printed in descending order first with Strawberry Donut, then Plain Donut and finally Chocolate Donut



  println("\nStep 9: How to initialize an empty SortedSet")
  val emptySortedSet = SortedSet.empty[String]
  println(s"Empty SortedSet = $emptySortedSet")
}
