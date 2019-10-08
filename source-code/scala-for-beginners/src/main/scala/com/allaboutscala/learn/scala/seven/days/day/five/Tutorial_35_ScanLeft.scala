package com.allaboutscala.learn.scala.seven.days.day.five

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Learn How To Use ScanLeft Function With Examples
  *
  * [[http://allaboutscala.com/tutorials/chapter-8-beginner-tutorial-using-scala-collection-functions/scala-scanleft-example/ Tutorial]]
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
object Tutorial_35_ScanLeft extends App {

  println("Step 1: How to initialize a Sequence of numbers")
  val numbers = (1 to 5).toSeq
  println(s"Elements of numbers = ${numbers.mkString(", ")}")



  println("\nStep 2: How to create a running total using the scanLeft function")
  val runningTotal = numbers.scanLeft(0)(_ + _)
  println(s"Running total of all elements in the collection = $runningTotal")
  // NOTE: scanLeft method iterations
  // 0 + 1             =   1
  // 1 + 2             =   3
  // 1 + 2 + 3         =   6
  // 1 + 2 + 3 + 4     =   10
  // 1 + 2 + 3 + 4 + 5 =   15



  println("\nStep 3: How to create a running total using the scanLeft function explicitly")
  val runningTotal2 = numbers.scanLeft(0) {case (acc, num) =>
    val runningTotal = acc + num
    println(s"$acc + $num   = $runningTotal")
    runningTotal
  }
  println(s"Running total of all elements in the collection = $runningTotal2")
}
