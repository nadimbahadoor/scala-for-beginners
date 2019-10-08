package com.allaboutscala.learn.scala.seven.days.day.five

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Learn How To Use Slice Function With Examples
  *
  * [[http://allaboutscala.com/tutorials/chapter-8-beginner-tutorial-using-scala-collection-functions/scala-slice-example/ Tutorial]]
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
object Tutorial_38_Slice extends App {

  println("Step 1: How to initialize a Sequence of donuts")
  val donuts = Seq("Plain Donut", "Strawberry Donut", "Glazed Donut")
  println(s"Elements of donuts = $donuts")



  println("\nStep 2: How to take a section from the Sequence using the slice function")
  println(s"Take elements from the sequence from index 0 to 1 = ${donuts.slice(0,1)}")
  println(s"Take elements from the sequence from index 0 to 2 = ${donuts.slice(0,2)}")
  println(s"Take elements from the sequence from index 0 to 3 = ${donuts.slice(0,3)}")



  println("\nStep 3: How to use slice function where the index is out of range")
  println(s"Take elements from the sequence from index 0 to 4 = ${donuts.slice(0,4)}")
}
