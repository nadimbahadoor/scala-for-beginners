package com.allaboutscala.learn.scala.seven.days.day.two

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Learn How To Create Tail Recursive Function - @annotation.tailrec
  *
  * [[http://allaboutscala.com/tutorials/chapter-3-beginner-tutorial-using-functions-scala/scala-tutorial-learn-create-tail-recursive-function-tailrec-annotation/ Tutorial]]
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
object Tutorial_08_RecursiveFunctions extends App {

  println("Step 1: How to define an Array of type String")
  val donutsVector = Vector("Vanilla Donut", "Strawberry Donut", "Plain Donut", "Glazed Donut")



  println("\nStep 2: How to define a tail recursive function")
  @annotation.tailrec
  def search(donutName: String, donuts: Vector[String], index: Int): Boolean = {
    if(donuts.length == index)
      false
    else if(donuts(index) == donutName)
      true
    else {
      val nextIndex = index + 1
      search(donutName, donuts, nextIndex)
    }
  }



  println("\nStep 3: How to call a tail recursive function")
  val found = search("Glazed Donut", donutsVector, 0)
  println(s"Find Glazed Donut = $found")

  val notFound = search("Chocolate Donut", donutsVector, 0)
  println(s"Find Chocolate Donut = $notFound")



  println("\nStep 4: Compile time checks using @annotation.tailrec")
//  @annotation.tailrec
  def searchNotTailRecursive(donutName: String, donuts: Vector[String], index: Int): Boolean = {
    if(donuts.length == index)
      throw new IllegalStateException(s"$donutName was not found!")
     else if(donuts(index) == donutName)
      true
     else {
      val nextIndex = index + 1
      search(donutName, donuts, nextIndex)
    }
  }



  println(s"${donutsVector.contains("Glazed Donut")}")
}
