package com.allaboutscala.learn.scala.seven.days.day.five

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Learn How To Use Union Function With Examples
  *
  * [[http://allaboutscala.com/tutorials/chapter-8-beginner-tutorial-using-scala-collection-functions/scala-union-example/ Tutorial]]
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
object Tutorial_47_Union extends App {

  println("Step 1: How to initialize a Set of donuts")
  val donuts1 = Set("Plain Donut", "Strawberry Donut", "Glazed Donut")
  println(s"Elements of donuts1 = $donuts1")



  println("\nStep 2: How to initialize another Set of donuts")
  val donuts2 = Set("Plain Donut", "Chocolate Donut", "Vanilla Donut")
  println(s"Elements of donuts2 = $donuts2")



  println("\nStep 3: How to merge two Sets using union function")
  println(s"Union of Sets donuts1 and donuts2 = ${donuts1 union donuts2}")
  println(s"Union of Sets donuts2 and donuts1 = ${donuts2 union donuts1}")



  println("\nStep 4: How to merge two Sets using ++ function")
  println(s"Union of Sets donuts1 and donuts2 = ${donuts1 ++ donuts2}")
  println(s"Union of Sets donuts2 and donuts1 = ${donuts2 ++ donuts1}")
}
