package com.allaboutscala.learn.scala.seven.days.day.two

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Learn How To Create And Use Functions
  *
  * [[http://allaboutscala.com/tutorials/chapter-3-beginner-tutorial-using-functions-scala/scala-tutorial-learn-create-use-functions/ Tutorial]]
  *
  * Tutorial: Learn How To Create Function With Parameters
  *
  * [[http://allaboutscala.com/tutorials/chapter-3-beginner-tutorial-using-functions-scala/scala-tutorial-learn-create-function-parameters/ Tutorial]]
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
object Tutorial_01_FunctionsBasic extends App {

  println("Step 1: How to define and use a function which has a return type")
  def favoriteDonut(): String = {
    "Glazed Donut"
  }

  val myFavoriteDonut = favoriteDonut()
  println(s"My favorite donut is $myFavoriteDonut")



  println("\nStep 2: How to define and use a function with no parenthesis")
  def leastFavoriteDonut = "Plain Donut"
  println(s"My least favorite donut is $leastFavoriteDonut")



  println("\nStep 3: How to define and use a function with no return type")
  def printDonutSalesReport(): Unit = {
    // lookup sales data in database and create some report
    println("Printing donut sales report... done!")
  }

  printDonutSalesReport()



  println("\nStep 4: How to define function with parameters")
  def calculateDonutCost(donutName: String, quantity: Int): Double = {
    println(s"Calculating cost for $donutName, quantity = $quantity")

    // make some calculations ...
    2.50 * quantity
  }



  println("\nStep 5: How to call a function with parameters")
  val totalCost = calculateDonutCost("Glazed Donut", 5)
  println(s"Total cost of donuts = $totalCost")




  println("\nStep 6: How to add default values to function parameters")
  def calculateDonutCost(donutName: String, quantity: Int, couponCode: String = "NO CODE"): Double = {
    println(s"Calculating cost for $donutName, quantity = $quantity, couponCode = $couponCode")

    // make some calculations ...
    2.50 * quantity
  }



  println("\nStep 7: How to call a function with parameters that has default values")
  val totalCostWithDiscount = calculateDonutCost("Glazed Donut", 4, "COUPON_12345")
  val totalCostWithoutDiscount = calculateDonutCost("Glazed Donut", 4)
}
