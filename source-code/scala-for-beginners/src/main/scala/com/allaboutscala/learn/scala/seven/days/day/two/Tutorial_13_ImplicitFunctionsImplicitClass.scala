package com.allaboutscala.learn.scala.seven.days.day.two
/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Learn How To Create Implicit Function
  *
  * [[http://allaboutscala.com/tutorials/chapter-3-beginner-tutorial-using-functions-scala/scala-tutorial-learn-create-implicit-function/ Tutorial]]
  *
  * Tutorial: Learn How To Create Function With Implicit Parameter
  *
  * [[http://allaboutscala.com/tutorials/chapter-3-beginner-tutorial-using-functions-scala/scala-tutorial-learn-create-function-implicit-parameter/ Tutorial]]
  *
  * Tutorial: Learn How To Use Implicit Class - Extension Methods
  *
  * [[http://allaboutscala.com/tutorials/chapter-3-beginner-tutorial-using-classes-scala/scala-tutorial-learn-use-implicit-class-extension-methods/ Tutorial]]
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
object Tutorial_13_ImplicitFunctionsImplicitClass extends App {

    println("Step 1: How to create a wrapper String class which will extend the String type")
    class DonutString(s: String) {
      def isFavoriteDonut: Boolean = s == "Glazed Donut"
    }



    println("\nStep 2: How to create an implicit function to convert a String to the wrapper String class")
    import scala.language.implicitConversions
    object DonutImplicitExtensions {
      implicit def stringToDonutString(s: String): DonutString = new DonutString(s)
    }



    println("\nStep 3: How to access the custom String method called isFavoriteDonut")
    import DonutImplicitExtensions._

    val glazedDonut = "Glazed Donut"
    val vanillaDonut = "Vanilla Donut"

    println(s"Is Glazed Donut my favorite Donut  = ${glazedDonut.isFavoriteDonut}")
    println(s"Is Vanilla Donut my favorite Donut = ${vanillaDonut.isFavoriteDonut}")


    println("\nStep 4: How to define an implicit class to augment or extend a Donut type with a uuid field")
    case class Donut(name: String, price: Double, productCode: Option[Long] = None)

    object DonutImplicits {
      implicit class AugmentedDonut(donut: Donut) {
        def uuid: String = s"${donut.name} - ${donut.productCode.getOrElse(12345)}"
      }
    }


    import DonutImplicits._

    val plainDonut: Donut = Donut("Vanilla", 1.50)
    println(s"Vanilla donut name = ${plainDonut.name}")
    println(s"Vanilla donut price = ${plainDonut.price}")
    println(s"Vanilla donut produceCode = ${plainDonut.productCode}")
    println(s"Vanilla donut uuid = ${plainDonut.uuid}")



    println("\nStep 5: How to define a method or function with an implicit parameter")
    def totalCost(donutType: String, quantity: Int)(implicit discount: Double): Double = {
      println(s"Calculating the price for $quantity $donutType")
      val donutPrice = 2.50
      val totalCost = donutPrice * quantity * (1 - discount)
      totalCost
    }

    implicit val discount: Double = 0.1
    println(s"All customer will receive a ${discount * 100}% discount")
    println(s"""Total cost with discount of 5 Glazed Donuts = ${totalCost("Glazed Donut", 5)}""")



    case class DonutConfig(storeName: String, storeURL: String)

    println("\nStep 6: How to define a function which takes multiple implicit parameters")
    def totalCost2(donutType: String, quantity: Int)(implicit discount: Double, donutConfig: DonutConfig): Double = {
      println(s"Implicit donut configurations = $donutConfig")
      println(s"Calculating the price for $quantity $donutType")
      val donutPrice = 2.50
      val totalCost = donutPrice * quantity * (1 - discount)
      totalCost
    }


    implicit val config: DonutConfig = DonutConfig("Tasty Donut Store", "http://allaboutscala.com")
    println(s"""Total cost with discount of 5 Glazed Donuts = ${totalCost2("Glazed Donut", 5)}""")
    println(s"""Total cost with discount of 5 Glazed Donuts, manually passed-through = ${totalCost2("Glazed Donut", 5)(discount, config)}""")
}
