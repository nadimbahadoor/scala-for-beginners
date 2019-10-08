package com.allaboutscala.learn.scala.seven.days.day.four

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Learn How To Use Scala's Immutable List
  *
  * [[http://allaboutscala.com/tutorials/chapter-6-beginner-tutorial-using-scala-immutable-collection/scala-tutorial-learn-use-immutable-list/ Tutorial]]
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
object Tutorial_01_Immutable_List extends App {

  println("Step 1: How to initialize an immutable List with 3 elements")
  val list1 = List("Plain Donut","Strawberry Donut","Chocolate Donut")
  println(s"Elements of list1 = $list1")



  println("\nStep 2: How to access elements of immutable List at specific index")
  println(s"Element at index 0 = ${list1(0)}")
  println(s"Element at index 1 = ${list1(1)}")
  println(s"Element at index 2 = ${list1(2)}")



  println("\nStep 3: How to append elements at the end of immutable List using :+")
  val list2 = list1 :+ "Vanilla Donut"
  println(s"Append elements at the end using :+ = $list2")



  println("\nStep 4: How to prepend elements at the front of immutable List using +:")
  val list3 = "Vanilla Donut" +: list1
  println(s"Prepend elements at the front using +: = $list3")



  println("\nStep 5: How to add two immutable lists together using ::")
  val list4: List[Any] = list1 :: list2
  println(s"Add two lists together using :: = $list4")



  println("\nStep 6: How to add two immutable Lists together using :::")
  val list5: List[String] = list1 ::: list2
  println(s"Add two lists together using ::: = $list5")



  println("\nStep 7: How to initialize an empty immutable List")
  val emptyList = List.empty[String]
  println(s"Empty list = $emptyList")



  println("\nStep 8: Head and tail of List")
  println(s"Head = ${list1.head}, tail = ${list1.tail}")
}
