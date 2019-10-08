package com.allaboutscala.learn.scala.seven.days.day.two

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Learn How To Create Typed Function
  *
  * [[http://allaboutscala.com/tutorials/chapter-3-beginner-tutorial-using-functions-scala/scala-tutorial-learn-create-typed-function/ Tutorial]]
  *
  * Tutorial: Learn How To Create Polymorphic Function With Generic Return Type
  *
  * [[http://allaboutscala.com/tutorials/chapter-3-beginner-tutorial-using-functions-scala/scala-tutorial-learn-polymorphic-function-generic-return-type/ Tutorial]]
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
object Tutorial_06_FunctionPolymorphism extends App {

  println("Step 1: Review of function definition and usage")
  def applyDiscount(couponCode: String): Unit =
    println(s"Lookup percentage discount in database for $couponCode")


  def applyDiscount(percentageDiscount: Double): Unit =
    println(s"$percentageDiscount discount will be applied")

  applyDiscount("COUPON_1234")
  applyDiscount(10)



  println("\nStep 2: How to define a generic typed function which will specify the type of its parameter")
  def applyDiscountTyped[T](discount: T): Unit = {
    discount match {
      case couponCode: String =>
        println(s"Lookup percentage discount in database for $couponCode")

      case couponCode: Long =>
        println(s"Coupon code of type Long = $couponCode")

      case percentDiscount: Double =>
        println(s"$percentDiscount percentage discount will be applied")

      case _ =>
        println("Unsupported discount type")
    }
  }



  println("\nStep 3: How to call a function which has typed parameters")
  applyDiscountTyped[String]("COUPON_123")
  applyDiscountTyped[Double](10)
  applyDiscountTyped[Long](100L)


  applyDiscountTyped("COUPON_123")
  applyDiscountTyped(10)
  applyDiscountTyped(100L)


  println("\nStep 4: How to define a generic polymorphic method which also has a generic return type")
  def applyDiscountWithReturnType[T](discount: T): Seq[T] = {
    discount match {
      case couponCode: String =>
        println(s"Lookup percentage discount in database for $couponCode")
        Seq[T](discount)

      case couponCode: Long =>
        println(s"Coupon code of type Long = $couponCode")
        Seq[T](discount)

      case percentDiscount: Double =>
        println(s"$percentDiscount percentage discount will be applied")
        Seq[T](discount)

      case _ =>
        println(s"Unsupported discount type")
        Seq[T](discount)
    }
  }



  println("\nStep 5: How to call a generic polymorphic method which also has a generic return type")
  val discountShouldBeStringType = applyDiscountWithReturnType("COUPON_123")
  println(s"discountShouldBeStringType = $discountShouldBeStringType, type = ${discountShouldBeStringType.head.getClass}")

  val discountShouldBeDoubleType = applyDiscountWithReturnType(10.0)
  println(s"discountShouldBeDoubleType = $discountShouldBeDoubleType, type = ${discountShouldBeDoubleType.head.getClass}")

  val discountShouldBeLongType = applyDiscountWithReturnType(100L)
  println(s"discountShouldBeLongType = $discountShouldBeLongType, type = ${discountShouldBeLongType.head.getClass}")

  val discountIsNotASupportedType = applyDiscountWithReturnType('U')
  println(s"discountIsNotASupportedType = $discountIsNotASupportedType. type = ${discountIsNotASupportedType.head.getClass}")
}
