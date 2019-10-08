package com.allaboutscala.learn.scala.seven.days.day.two

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
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
object Tutorial_15_Bounds extends App {

  println("Step 1: Donut type hierarchy")
  abstract class Donut(name: String) {
    def printName(): Unit
  }

  case class VanillaDonut(name: String) extends Donut(name) {
    override def printName(): Unit = println(name)
  }

  case class GlazedDonut(name: String) extends Donut(name) {
    override def printName(): Unit = println(name)
  }

  val vanillaDonut = VanillaDonut("Vanilla Donut")
  val glazedDonut = GlazedDonut("Glazed Donut")



  println("Step 2: Upper Type Bounds")
  class Pastry[P <: Donut](pastry: P){
    def name(): Unit = pastry.printName()
  }

  val vanillaPastry = new Pastry[VanillaDonut](vanillaDonut)
  vanillaPastry.name()

  val glazedPastry = new Pastry[Donut](glazedDonut)
  glazedPastry.name()


  // to illustrate further type safety
  case class Lollipop(name: String)

  val lollipop = new Lollipop("Lollipop")

  // Compile time error because a Lollipop type does not match the P <: Donut constraint
//  val lollipopPastry = new Pastry[Lollipop](lollipop)



  println("\nStep 3: Lower Type Bounds")
  class ShoppingCart {
    def addCartItem[I >: VanillaDonut](item: I): Unit = {
      println(s"Adding $item to shopping cart")
      println(item.getClass.getSimpleName)
    }
  }


  val shoppingCart = new ShoppingCart()
  shoppingCart.addCartItem(vanillaDonut)
  shoppingCart.addCartItem(glazedDonut)
  shoppingCart.addCartItem(lollipop)
  shoppingCart.addCartItem("oops something is not right!")
}
