package com.allaboutscala.learn.scala.seven.days.day.five

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Learn How To Use Par Function With Examples
  *
  * [[http://allaboutscala.com/tutorials/chapter-8-beginner-tutorial-using-scala-collection-functions/scala-par-example/ Tutorial]]
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
object Tutorial_26_Par extends App {

  println("Step 1: How to initialize an Immutable Sequence of various donut flavours")
  val donuts = Seq("Plain", "Strawberry", "Glazed")
  println(s"Elements of donuts immutable Sequence = $donuts")


  println("\nStep 2: Convert the Immutable donuts Sequence into a Parallel Collection")
  import scala.collection.parallel.ParSeq
  import scala.collection.parallel.CollectionConverters._

  val donutsParallel: ParSeq[String] = donuts.par
  println(s"Elements of donutsParallel = $donutsParallel")


  println("\nStep 3: How to use a Scala Parallel Collection")
  val donutsParSeq: ParSeq[String] = donutsParallel.map(d => s"$d Donut")
  println(s"Elements of donutsParSeq parallel collection = $donutsParSeq")


  println("\nStep 4: Explicitly create a Parallel Collection")

  import scala.collection.parallel.immutable.ParVector

  val donutsParVector = ParVector[Double](1.50, 2.0, 2.50)
  println(s"Elements of donutParVector = $donutsParVector")


  println("\nStep 5: Find the sum of all Donut prices in parallel")
  val donutsPricesSum = donutsParVector.fold(0.0)(_ + _)
  println(s"The sum of all Donut prices = $donutsPricesSum")

}
