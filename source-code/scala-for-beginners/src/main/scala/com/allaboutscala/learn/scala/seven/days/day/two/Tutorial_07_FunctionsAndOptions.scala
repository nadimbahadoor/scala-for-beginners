package com.allaboutscala.learn.scala.seven.days.day.two

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Learn How To Use Option In Function Parameters
  *
  * [[http://allaboutscala.com/tutorials/chapter-3-beginner-tutorial-using-functions-scala/scala-tutorial-learn-use-option-function-parameters/ Tutorial]]
  *
  * Tutorial: Learn How To Create Function With Option Return Type
  *
  * [[http://allaboutscala.com/tutorials/chapter-3-beginner-tutorial-using-functions-scala/scala-tutorial-learn-create-function-return-type/ Tutorial]]
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
object Tutorial_07_FunctionsAndOptions extends App {

  println("Step 1: How to define an Option in a function parameter")
  def calculateDonutCost(donutName: String, quantity: Int, couponCode: Option[String]): Double = {
    println(s"Calculating cost for $donutName, quantity = $quantity")
    val donutPrice = 2.50

    couponCode match {
      case Some(coupon) =>
        val discount = if (coupon == "COUPON_1234") 0.1 else 0.0
        val totalCost = donutPrice * quantity * (1 - discount)
        totalCost

      case None => donutPrice * quantity
    }
  }



  println("\nStep 2: How to call a function which has an Option parameter")
  println(s"""Total cost without couponCode = ${calculateDonutCost("Glazed Donut", 5, None)}""")
  println(s"""Total cost with couponCode = ${calculateDonutCost("Glazed Donut", 5, Some("COUPON_1234"))}""")



  println("\nStep 3: How to assign a default value to an Option parameter")
  def calculateDonutCostWithDefaultOptionValue(donutName: String, quantity: Int, couponCode: Option[String] = None): Double = {
    println(s"Calculating cost for $donutName, quantity = $quantity")
    val donutPrice = 2.50

    couponCode match{
      case Some(coupon) =>
        val discount = if (coupon == "COUPON_1234") 0.1 else 0.0
        val totalCost = donutPrice * quantity * (1 - discount)
        totalCost

      case _ => donutPrice * quantity
    }
  }

  println(s"""Total cost = ${calculateDonutCostWithDefaultOptionValue("Glazed Donut", 5)}""")
  println(s"""Total cost with discount = ${calculateDonutCostWithDefaultOptionValue("Glazed Donut", 5, Some("COUPON_1234"))}""")



  println(s"\nStep 4: Define a function which returns an Option of type String")
  def dailyCouponCode(): Option[String] = {
    // look up in database if we will provide our customers with a coupon today
    val couponFromDb = "COUPON_1234"
    Option(couponFromDb).filter(_.nonEmpty)
  }



  println(s"\nStep 5: Various ways of calling a function with Option return type")
  val todayCoupon: Option[String] = dailyCouponCode()
  println(s"Today's coupon code using getOrElse() = ${todayCoupon.getOrElse("No Coupon's Today")}")

  dailyCouponCode() match {
    case Some(couponCode) => println(s"Today's coupon code using Pattern Matching = $couponCode")
    case None => println(s"Sorry there is no coupon code today!")
  }

  dailyCouponCode().map(couponCode => println(s"Today's coupon code using map() = $couponCode"))

  val todayCouponUsingFold = dailyCouponCode().fold("No Coupon Available")(couponCode => couponCode)
  println(s"Today's coupon code using fold() = $todayCouponUsingFold")

  val todayCouponIsDefined = if (todayCoupon.isDefined) todayCoupon.get else "No Coupon Today"
  println(s"Today's coupon using isDefined() = $todayCouponIsDefined")
}
