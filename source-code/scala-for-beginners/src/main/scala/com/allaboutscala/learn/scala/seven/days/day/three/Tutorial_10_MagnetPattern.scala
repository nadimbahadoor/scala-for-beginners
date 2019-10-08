package com.allaboutscala.learn.scala.seven.days.day.three

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
object Tutorial_10_MagnetPattern extends App {

  println("Step 1: Review of applyDiscount() method")
  def applyDiscount(couponCode: String): Unit =
    println(s"Lookup percentage discount in database for $couponCode")


  def applyDiscount(percentageDiscount: Double): Unit =
    println(s"$percentageDiscount discount will be applied")


  applyDiscount("COUPON_1234")
  applyDiscount(10)



  println("\nStep 2: Overloaded methods and type erasure")
  def applyDiscount(dailyCouponCode: String, weeklyCouponCode: String, monthlyCouponCode: String): Unit = ???
  def applyDiscount(percentageDiscount: Double, holidayDiscount: Double): Double = ???



  println("\nStep 3: The Magnet Pattern")
  import scala.language.implicitConversions

  sealed trait DiscountMagnet {
    type Out
    def apply(): Out
  }

  def discount(magnet: DiscountMagnet): magnet.Out = magnet()

  object DiscountMagnet {
    implicit def discountStringCouponCode(couponCode: String) =
      new DiscountMagnet {
        override type Out = Unit

        override def apply(): Out = {
          println(s"DiscountMagnet -> discountStringCouponCode = Lookup percentage discount in database for $couponCode")
        }
      }

    implicit def discountDoubleCouponCode(percentageDiscount: Double) =
      new DiscountMagnet {
        override type Out = Double

        override def apply(): Out = {
          println(s"DiscountMagnet -> discountDoubleCouponCode $percentageDiscount discount will be applied")
          10.0
        }
      }

    implicit def discountListOfString(coupons: List[String]) =
      new DiscountMagnet {
        override type Out = Unit

        override def apply(): Out = {
          println(s"DiscountMagnet -> discountListOfString = $coupons")
        }
      }

    implicit def discountListOfInt(coupons: List[Int]) =
      new DiscountMagnet {
        override type Out = Unit

        override def apply(): Out = {
          println(s"DiscountMagnet -> discountListOfInt = $coupons")
        }
      }
  }

  discount("COUPON_1234")
  discount(10.0)



  println("\nStep 4: Type erasure and the Magnet Pattern")
  // WILL NOT COMPILE: due to type erasure
//  def applyDiscount(coupons: List[String]): Unit = ???
//  def applyDiscount(coupons: List[Int]): Unit = ???

  discount(List("COUPON_1234", "COUPON_4321"))
  discount(List(111, 222, 333))
}
