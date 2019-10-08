package com.allaboutscala.learn.scala.seven.days.day.five

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Learn How To Use Map Function With Examples
  *
  * [[http://allaboutscala.com/tutorials/chapter-8-beginner-tutorial-using-scala-collection-functions/scala-map-example/ Tutorial]]
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
object Tutorial_19_Map extends App {

  println("Step 1: How to initialize a Sequence of donuts")
  val donuts1 = Seq("Plain", "Strawberry", "Glazed")
  println(s"Elements of donuts1 = $donuts1")



  println("\nStep 2: How to append the word Donut to each element using the map function")
  val donuts2 = donuts1.map(_ + " Donut")
  println(s"Elements of donuts2 = $donuts2")



  println("\nStep 3: How to create a donut sequence with one None element")
  val donuts3 = Seq("Plain", "Strawberry", None)
  donuts3.foreach(println(_))



  println("\nStep 4: How to filter out the None element using map function")
  val donuts4 = donuts3.map {
    case donut: String => donut + " Donut"
    case None => "Unknown Donut"
  }
  println(s"Elements of donuts4 = $donuts4")



  println("\nStep 5: How to create a Sequence with each Donut length using the map function")
  val donutsLengths: Seq[Int] = donuts1.map(_.length)
  println(s"Sequence of Donut lengths = $donutsLengths")
}
