package com.allaboutscala.learn.scala.seven.days.day.three

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Learn How To Use Traits For Dependency Injection Part 2 - Avoid Cake Pattern
  *
  * [[http://allaboutscala.com/tutorials/chapter-5-traits/scala-traits-depedency-injection-avoid-cake-pattern/ Tutorial]]
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
object Tutorial_06_TraitMixinAndLinearization extends App {

  println("Step 1: Review of inheritance using traits")
  case class Donut(name: String)

  trait ShoppingCart[T] {
    def printItems(items: Seq[T]): Unit
  }

  class DonutShoppingCart extends ShoppingCart[Donut] {
    override def printItems(items: Seq[Donut]): Unit = {
      items.foreach(println(_))
    }
  }

  val donuts = Seq(Donut("Plain Donut"), Donut("Vanilla Donut"))
  val donutCart = new DonutShoppingCart()
  donutCart.printItems(donuts)



  println("\nStep 2: Define trait PrettyPrintUpperCase and mixin with DonutShoppingCart")
  trait PrettyPrintUpperCase[T] extends ShoppingCart[T] {
    override def printItems(items: Seq[T]): Unit = items.foreach(item => println(item.toString.toUpperCase))
  }

  val donutCart2 = new DonutShoppingCart() with PrettyPrintUpperCase[Donut]
  donutCart2.printItems(donuts)



  println("\nStep 3: Linearization when mixin multiple traits")
  trait PrettyPrintLowerCase[T] extends ShoppingCart[T] {
    override def printItems(items: Seq[T]): Unit = items.foreach(item => println(item.toString.toLowerCase))
  }

  val donutCart3 = new DonutShoppingCart() with PrettyPrintUpperCase[Donut] with PrettyPrintLowerCase[Donut]
  donutCart3.printItems(donuts)

  val donutCart4 = new DonutShoppingCart() with PrettyPrintLowerCase[Donut] with PrettyPrintUpperCase[Donut]
  donutCart4.printItems(donuts)
}
