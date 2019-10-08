package com.allaboutscala.learn.scala.seven.days.day.five

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Learn How To Use Sorted Function With Examples
  *
  * [[http://allaboutscala.com/tutorials/chapter-8-beginner-tutorial-using-scala-collection-functions/scala-sorted-example/ Tutorial]]
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
object Tutorial_40_Sorted extends App {

  println("Step 1: How to initialize Donut prices")
  val prices = Seq(1.50, 2.0, 2.50)
  println(s"Elements of prices = $prices")



  println("\nStep 2: How to sort a Sequence of type Double using the sorted function")
  implicit val doubleOrdering = Ordering.Double.TotalOrdering
  println(s"Sort a sequence of type Double by their natural ordering = ${prices.sorted}")



  println("\nStep 3: How to sort a Sequence of type Double in descending order using the sorted function")
  object ReverseNumericalOrdering extends Ordering[Double] {
    def compare(key1: Double, key2: Double) = key2.compareTo(key1)
  }
  println(s"Sort a Sequence of type Double in descending order = ${prices.sorted(ReverseNumericalOrdering)}")



  println("\nStep 4: How to initialize a Sequence of Donuts")
  val donuts = Seq("Plain Donut", "Strawberry Donut", "Glazed Donut")
  println(s"Elements of donuts = $donuts")



  println("\nStep 5: How to sort a Sequence of type String using the sorted function")
  println(s"Sort a sequence of type String by their natural ordering = ${donuts.sorted}")
}
