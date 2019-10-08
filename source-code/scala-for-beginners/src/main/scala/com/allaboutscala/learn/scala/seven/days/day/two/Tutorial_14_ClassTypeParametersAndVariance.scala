package com.allaboutscala.learn.scala.seven.days.day.two

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Learn How To Create Type Class
  *
  * [[http://allaboutscala.com/tutorials/chapter-3-beginner-tutorial-using-classes-scala/scala-type-class/ Tutorial]]
  *
  * Tutorial: Learn How To Create Covariance Type Class
  *
  * [[http://allaboutscala.com/tutorials/chapter-3-beginner-tutorial-using-classes-scala/scala-variance-covariance/ Tutorial]]
  *
  * Tutorial: Learn How To Create Contra-Variance Type Class
  *
  * [[http://allaboutscala.com/tutorials/chapter-3-beginner-tutorial-using-classes-scala/scala-variance-contra-variance/ Tutorial]]
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
object Tutorial_14_ClassTypeParametersAndVariance extends App {

  println("Step 1: Review of class inheritance")
  abstract class Donut(name: String) {
    def printName(): Unit
  }

  case class VanillaDonut(name: String) extends Donut(name) {
    override def printName(): Unit = println(name)
  }

  case class GlazedDonut(name: String) extends Donut(name) {
    override def printName(): Unit = println(name)
  }

  val vanillaDonut: VanillaDonut = VanillaDonut("Vanilla Donut")
  vanillaDonut.printName()

  val glazedDonut: Donut = GlazedDonut("Glazed Donut")
  glazedDonut.printName()



  println("\nStep 2: How to define a ShoppingCart class which expects Donut types")
  class ShoppingCart[D <: Donut](donuts: Seq[D]) {
    def printCartItems(): Unit = donuts.foreach(_.printName())
  }

  val shoppingCart: ShoppingCart[Donut] = new ShoppingCart(Seq(vanillaDonut, glazedDonut))
  shoppingCart.printCartItems()



  println("\nStep 3: How to make the ShoppingCart class covariant")
  // val shoppingCart: ShoppingCart[Donut] = new ShoppingCart[VanillaDonut](Seq(vanillaDonut))

  class ShoppingCart2[+D <: Donut](donuts: Seq[D]) {
    def printCartItems(): Unit = donuts.foreach(_.printName())
  }

  val shoppingCart2: ShoppingCart2[Donut] = new ShoppingCart2[VanillaDonut](Seq(vanillaDonut))
  shoppingCart2.printCartItems()



  println("\nStep 4: How to make the ShoppingCart class contravariant")
//    val shoppingCart: ShoppingCart[VanillaDonut] = new ShoppingCart[Donut](Seq(glazedDonut))

  class ShoppingCart3[-D <: Donut](donuts: Seq[D]) {
    def printCartItems(): Unit = donuts.foreach(_.printName())
  }

  val shoppingCart3: ShoppingCart3[VanillaDonut] = new ShoppingCart3[Donut](Seq(glazedDonut))
  shoppingCart3.printCartItems()



  println("\nStep 5: How to make the ShoppingCart class invariant")
  val shoppingCart4 = new ShoppingCart(Seq(vanillaDonut, glazedDonut))
  shoppingCart.printCartItems()
}
