package com.allaboutscala.learn.scala.seven.days.day.five

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Learn How To Use Last Function With Examples
  *
  * [[http://allaboutscala.com/tutorials/chapter-8-beginner-tutorial-using-scala-collection-functions/scala-last-example/ Tutorial]]
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
object Tutorial_18_Last extends App {

  println("Step 1: How to initialize a Sequence of donuts")
  val donuts = Seq("Plain Donut", "Strawberry Donut", "Glazed Donut")
  println(s"Elements of donuts = $donuts")



  println("\nStep 2: How to access the last element of the donut sequence by index")
  println(s"Last element of donut sequence = ${donuts(donuts.size - 1)}")



  println("\nStep 3: How to access the last element of the donut sequence by using the last function")
  println(s"Last element of donut sequence = ${donuts.last}")



  println("\nStep 4: How to create an empty sequence")
  val donuts2 = Seq.empty[String]
  println(s"Elements of donuts2 = $donuts2")



  println("\nStep 5: How to access the last element of the donut sequence using the lastOption function")
  println(s"Last element of empty sequence = ${donuts2.lastOption.getOrElse("No donut was found!")}")
}
