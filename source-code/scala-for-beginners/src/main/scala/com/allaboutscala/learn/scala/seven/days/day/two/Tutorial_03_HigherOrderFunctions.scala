package com.allaboutscala.learn.scala.seven.days.day.two

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Learn How To Create Higher Order Function - Function As Parameter
  *
  * [[http://allaboutscala.com/tutorials/chapter-3-beginner-tutorial-using-functions-scala/scala-tutorial-higher-order-function-parameter/ Tutorial]]
  *
  * Tutorial: Learn How To Create Call By Name Function
  *
  * [[http://allaboutscala.com/tutorials/chapter-3-beginner-tutorial-using-functions-scala/scala-tutorial-learn-create-call-name-function/ Tutorial]]
  *
  * Tutorial: Learn How To Create Function With Callback Parameter
  *
  * [[http://allaboutscala.com/tutorials/chapter-3-beginner-tutorial-using-functions-scala/scala-tutorial-learn-create-function-callback-parameter/ Tutorial]]
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
object Tutorial_03_HigherOrderFunctions extends App {

  println("\nStep 1: How to define a higher order function which takes another function as parameter")
  def totalCostWithDiscountFunctionParameter(donutName: String)(quantity: Int)(func: Double => Double): Double = {
    println(s"Calculating total cost for $quantity $donutName")
    val donutPrice = 2.50
    val totalCost = donutPrice * quantity
    func(totalCost)
  }



  println("\nStep 2: How to define and pass a function as parameter to a higher order function")
  def applyDiscount(totalCost: Double): Double = {
    val applyDiscount = 2
    totalCost - applyDiscount
  }

  println(s"Total cost of 5 Glazed Donuts with discount function = ${totalCostWithDiscountFunctionParameter("Glazed Donut")(5)(applyDiscount)}")



  println("\nStep 3: How to call higher order function and pass an anonymous function as parameter")
  val totalCostOf5Donuts = totalCostWithDiscountFunctionParameter("Glazed Donut")(5){ totalCost =>
    val applyDiscount = 2
    totalCost - applyDiscount
  }
  println(s"Total cost of 5 Glazed Donuts with anonymous discount function = $totalCostOf5Donuts")



  println("\nStep 4: A function that returns another function")
  def generateDiscount(): (Double) => Double = {
    println("generating discount function")
    (totalCost: Double) => if (totalCost > 10) 2 else 1 // the output is in itself a function which expects an input parameter named **totalCost** of type Double, and having a return type of Double
  }

  def applyDiscount2(totalCost: Double): Double = {
    def discount = generateDiscount()
    totalCost - discount(totalCost)
  }

  println(s"Total cost of 5 Glazed Donuts using applyDiscount2 = ${totalCostWithDiscountFunctionParameter("Glazed Donut")(5)(applyDiscount2)}")




  println("\nStep 5: Higher Order Function with multiple parameters")
  def totalCostWithDiscountAndCoupon(donutName: String)(quantity: Int)(func: (Double, String) => Double): Double = {
    println(s"Calculating total cost for $quantity $donutName")
    val donutPrice = 2.50
    val totalCost = donutPrice * quantity
    val coupon = "COUPON_CODE_1234"
    func(totalCost, coupon)
  }


  def applyDiscountAndCoupon(totalCost: Double, coupon: String): Double = {
    val applyDiscount = 2
    println(s"coupon = $coupon")
    totalCost - applyDiscount
  }

  val totalCost = totalCostWithDiscountAndCoupon("Glazed Donut")(5)(applyDiscountAndCoupon)
  println(s"Total cost = $totalCost")



  println("\nStep 6: How to define a function with a callback parameter")
  def printReport(sendEmailCallback: () => Unit): Unit = {
    println("Printing report ... started")
    // look up some data in database and create a report
    println("Printing report ... finished")
    sendEmailCallback()
  }



  println("\nStep 7: How to call a function which has a callback parameter")
  printReport( () =>
    println("Sending email ... finished")
  )

  def sendEmail(): Unit = println("Sending email function")
  printReport(sendEmail)



  println("\nStep 9: Function with an optional callback parameter")
//   printReport() // You get compile time error
  printReport(() => {}) // Not that elegant if we have to keep writing `() => {}` every time we call printReport()


  def printReportWithOptionCallback(sendEmailCallback: Option[() => Unit] = None): Unit = {
    println("Printing report ... started")
    // look up some data in database and create a report
    println("Printing report ... finished")
    sendEmailCallback.map(callback => callback)
  }

  printReportWithOptionCallback() // more elegant

  printReportWithOptionCallback(Some(() => println("Sending email wrapped in Some() ... finished")))
}

