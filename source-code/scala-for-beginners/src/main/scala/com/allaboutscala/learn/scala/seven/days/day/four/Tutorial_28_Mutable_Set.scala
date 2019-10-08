package com.allaboutscala.learn.scala.seven.days.day.four

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Learn How To Use Scala's Mutable Set
  *
  * [[http://allaboutscala.com/tutorials/chapter-7-beginner-tutorial-using-scala-mutable-collection/scala-tutorial-learn-use-mutable-set/ Tutorial]]
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
object Tutorial_28_Mutable_Set extends App {

  import scala.collection.mutable.Set
  println("\nStep 1: How to initialize a Set with 3 elements")
  val set1 = Set("Plain Donut","Strawberry Donut","Chocolate Donut")
  println(s"Elements of set1 = $set1")



  println("\nStep 2: How to check specific elements in Set")
  println(s"Element Plain Donut = ${set1("Plain Donut")}")
  println(s"Element Strawberry Donut = ${set1("Strawberry Donut")}")
  println(s"Element Chocolate Donut = ${set1("Chocolate Donut")}")



  println("\nStep 3: How to add elements to Set using +=")
  set1 += "Vanilla Donut"
  println(s"Elements of set1 after adding elements Vanilla Donut = $set1")



  println("\nStep 4: How to add all elements from another Set using ++=")
  set1 ++= Set("Vanilla Donut", "Glazed Donut")
  println(s"Elements of set1 after adding second set = $set1")



  println("\nStep 5: How to remove element from Set using -=")
  set1 -= "Plain Donut"
  println(s"Elements of set1 without Plain Donut element = $set1")



  println("\nStep 6: How to find the intersection between two Sets using &")
  val set2 = Set("Vanilla Donut", "Glazed Donut", "Plain Donut")
  println(s"Intersection of set1 and set5 = ${set1 & set2}")



  println("\nStep 7: How to find the difference between two Sets using &~")
  println(s"Difference of set1 and set2 = ${set1 &~ set2}")



  println("\nStep 8: How to initialize an empty Set")
  val emptySet = Set.empty[String]
  println(s"Empty Set = $emptySet")
}
