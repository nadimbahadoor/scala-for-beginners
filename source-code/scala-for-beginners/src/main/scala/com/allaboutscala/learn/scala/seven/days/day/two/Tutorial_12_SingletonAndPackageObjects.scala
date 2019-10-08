package com.allaboutscala.learn.scala.seven.days.day.two

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Learn How To Declare And Use Singleton Object
  *
  * [[http://allaboutscala.com/tutorials/chapter-3-beginner-tutorial-using-classes-scala/scala-tutorial-learn-declare-use-singleton-objects/ Tutorial]]
  *
  * Tutorial: Learn How To Use Package Object
  *
  * [[http://allaboutscala.com/tutorials/chapter-3-beginner-tutorial-using-classes-scala/scala-package-object/ Tutorial]]
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
object Tutorial_12_SingletonAndPackageObjects extends App {

  println("Step 1: How to declare a Singleton Object")
  object DonutShoppingCartCalculator {

    // Step 2: How to define a global field
    val discount = 0.01


    // Step 3: How to define utility function called calculateTotalCost
    def calculateTotalCost(donuts: List[String]): Double = {
      println(s"calculateTotalCost for donuts = $donuts")
      1
    }
  }



  println("\nStep 4: How to call global fields and utility methods of Singleton Objects")
  println(s"Global discount = ${DonutShoppingCartCalculator.discount}")
  println(s"Call to calculateTotalCost function = ${DonutShoppingCartCalculator.calculateTotalCost(List())}")



  println("\nStep 5: How to use types define in a Package Object")
  val donutItem = new DonutCartItem("Plain Donut", 1)
}
