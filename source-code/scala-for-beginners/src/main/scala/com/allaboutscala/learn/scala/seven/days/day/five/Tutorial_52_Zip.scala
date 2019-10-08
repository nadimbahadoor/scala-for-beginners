package com.allaboutscala.learn.scala.seven.days.day.five

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Learn How To Use Zip Function With Examples
  *
  * [[http://allaboutscala.com/tutorials/chapter-8-beginner-tutorial-using-scala-collection-functions/scala-zip-example/ Tutorial]]
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
object Tutorial_52_Zip extends App {

  println("Step 1: How to initialize a Sequence of donuts")
  val donuts = Seq("Plain Donut", "Strawberry Donut", "Glazed Donut")
  println(s"Elements of donuts = $donuts")



  println("\nStep 2: How to initialize a Sequence of donut prices")
  val donutPrices = Seq(1.5, 2.0, 2.5)
  println(s"Elements of donut prices = $donutPrices")



  println("\nStep 3: How to use zip method to zip two collections")
  val zippedDonutsAndPrices: Seq[(String, Double)] = donuts zip donutPrices
  println(s"Zipped donuts and prices = $zippedDonutsAndPrices")



  println("\nStep 4: Access individual items from a zipped collection")
  val head = zippedDonutsAndPrices.head
  val middle = zippedDonutsAndPrices(1)
  val last = zippedDonutsAndPrices.last
  println(s"Zipped head donut = ${head._1} and price = ${head._2}")
  println(s"Zipped middle donut = ${middle._1} and price = ${middle._2}")
  println(s"sZipped last donut = ${last._1} and price = ${last._2}")



  println("\nStep 5: Calling zip method on collections of varying lengths")
  val donutPrices2 = Seq(1.5, 2.0)
  val zipOfDifferentLengths = donuts zip donutPrices2
  println(s"Zipped donuts and prices collections of varying lengths = $zipOfDifferentLengths")
//  List((Plain Donut,1.5), (Strawberry Donut,2.0)) - so we lose the Glazed Donut item



  println("\nStep 6: Calling zipAll on collections of varying lengths")
  val zipAllOfDifferentLengths = donuts zipAll(donutPrices2, "Missing donut price", "1.00")
  println(s"Calling zipAll on donuts and donutPrices2 collections = $zipAllOfDifferentLengths")

  // We no longer drop data points such as the Glazed Donut. Instead, donut items from the donuts
  // collection which do not have a matching price, will default to 1.00
  //  Calling zipAll on donuts and donutPrices2 collections = List((Plain Donut,1.5), (Strawberry Donut,2.0), (Glazed Donut,1.00))
}
