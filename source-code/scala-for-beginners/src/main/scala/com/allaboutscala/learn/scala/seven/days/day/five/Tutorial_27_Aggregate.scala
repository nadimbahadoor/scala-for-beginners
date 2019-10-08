package com.allaboutscala.learn.scala.seven.days.day.five

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Learn How To Use Aggregate Function
  *
  * [[http://allaboutscala.com/tutorials/chapter-8-beginner-tutorial-using-scala-collection-functions/scala-aggregate-function/ Tutorial]]
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
object Tutorial_27_Aggregate extends App {

  println("Step 1: How to initialize a Set of type String to represent Donut elements")
  import scala.collection.parallel.ParSet
  import scala.collection.parallel.CollectionConverters._
  val donutBasket1 = Set("Plain Donut", "Strawberry Donut")
  val parDonutBasket1: ParSet[String] = donutBasket1.par



  println("\nStep 2: How to define an accumulator function to calculate the total length of the String elements")
  val donutLengthAccumulator: (Int, String) => Int = (acc, donutName) => acc + donutName.length



  println("\nStep 3: How to call aggregate function with the accumulator function from Step 2")
  val totalLength = parDonutBasket1.aggregate(0)(donutLengthAccumulator, _ + _)
  println(s"Total length of elements in parDonutBasket1 = $totalLength")



  println("\nStep 4: How to initialize a Set of Tuple3 elements to represent Donut name, price and quantity")
  val donutBasket2: Set[(String, Double, Int)] = Set(("Plain Donut", 1.50, 10), ("Strawberry Donut", 2.0, 10))
  val parDonutBasket2 = donutBasket2.par



  println("\nStep 5: How to define an accumulator function to calculate the total cost of Donuts")
  val totalCostAccumulator: (Double, Double, Int) => Double = (acc, price, quantity) => acc + (price * quantity)



  println("\nStep 6: How to call aggregate function with accumulator function from Step 5")
  val totalCost = parDonutBasket2.aggregate(0.0)((acc: Double, tuple: (String, Double, Int)) => totalCostAccumulator(acc, tuple._2, tuple._3), _ + _)
  println(s"Total cost of donuts in parDonutBasket2 = $totalCost")
}
