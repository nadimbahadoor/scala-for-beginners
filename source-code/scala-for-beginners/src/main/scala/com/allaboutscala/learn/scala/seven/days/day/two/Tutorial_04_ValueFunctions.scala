package com.allaboutscala.learn.scala.seven.days.day.two

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Learn How To Create Function Using The Val Keyword Instead Of Def
  *
  * [[http://allaboutscala.com/tutorials/chapter-3-beginner-tutorial-using-functions-scala/scala-tutorial-learn-create-val-function-val-vs-def/ Tutorial]]
  *
  * Tutorial: Learn Function Composition Using AndThen – f(x) andThen g(x)
  *
  * [[http://allaboutscala.com/tutorials/chapter-3-beginner-tutorial-using-functions-scala/scala-tutorial-learn-function-composition-andthen/ Tutorial]]
  *
  * Tutorial: Learn Function Composition Using Compose – f(x) compose g(x)
  *
  * [[http://allaboutscala.com/tutorials/chapter-3-beginner-tutorial-using-functions-scala/scala-tutorial-learn-function-composition-compose/ Tutorial]]
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
object Tutorial_04_ValueFunctions extends App {

  println("\nStep 1: Review curried and higher order function")
  def totalCostWithDiscountFunctionParameter(donutName: String)(quantity: Int)(func: Double => Double): Double = {
    println(s"Calculating total cost for $quantity $donutName")
    val donutPrice = 2.50
    val totalCost = donutPrice * quantity
    func(totalCost)
  }



  println("\nStep 2: How to define and pass-through a val function to a higher order function")
  val applyDiscountValueFunction = (totalCost: Double) => {
    println("Applying discount to total cost")
    val discount = 2
    totalCost - discount
  }
  println(s"Total cost of 5 Glazed Donuts with discount val function = ${totalCostWithDiscountFunctionParameter("Glazed Donut")(5)(applyDiscountValueFunction)}")



  println("\nStep 3: Using a value function similar to a def function")
  val totalCost: Double = 10
  println(s"Total cost of 5 donuts with discount = ${applyDiscountValueFunction(totalCost)}")



  println("\nStep 4: Value function and function composition using andThen")
  val applyTaxValFunction = (amount: Double) => {
    println("Applying tax function")
    val tax = 1 // fetch tax from database
    amount + tax
  }
  println(s"Total cost of 5 donuts = ${ (applyDiscountValueFunction andThen applyTaxValFunction)(totalCost) }")



  println("\nStep 5: Value function and function composition using compose")
  println(s"Total cost of 5 donuts = ${ (applyDiscountValueFunction compose applyTaxValFunction)(totalCost) }")
}
