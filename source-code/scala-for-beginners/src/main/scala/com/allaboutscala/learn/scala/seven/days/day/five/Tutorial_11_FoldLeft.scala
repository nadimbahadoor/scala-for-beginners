package com.allaboutscala.learn.scala.seven.days.day.five

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Learn How To Use FoldLeft Function With Examples
  *
  * [[http://allaboutscala.com/tutorials/chapter-8-beginner-tutorial-using-scala-collection-functions/scala-foldleft-example/ Tutorial]]
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
object Tutorial_11_FoldLeft extends App {

  println("Step 1: How to initialize a sequence of donut prices")
  val prices = Seq(1.5, 2.0, 2.5)
  println(s"Donut prices = $prices")



  println("\nStep 2: How to sum all the donut prices using foldLeft function")
  val sum = prices.foldLeft(0.0)(_ + _)
  println(s"Sum = $sum")



  println("\nStep 3: How to initialize a Sequence of donuts")
  val donuts = Seq("Plain", "Strawberry", "Glazed")
  println(s"Elements of donuts1 = $donuts")



  println("\nStep 4: How to create a String of all donuts using foldLeft function")
  println(s"All donuts = ${donuts.foldLeft("")((acc, s) => acc + s + " Donut ")}")



  println("\nStep 5: How to declare a value function to create the donut string")
  val concatDonuts: (String, String) => String = (acc, s) => {
    println(s"Accumulator = $acc")
    val appendDonutLiteral = s + " Donut "
    println(s"Append Donut literal = $appendDonutLiteral")
    val mutatedAccumulator = acc + appendDonutLiteral
    println(s"Accumulator after mutation = $mutatedAccumulator")
    mutatedAccumulator
  }



  println("\nStep 6: How to create a String of all donuts using value function from Step 5 and fold function")
  println(s"All donuts = ${donuts.foldLeft("")(concatDonuts)}")
}
