package com.allaboutscala.learn.scala.seven.days.day.two


/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Learn How To Define And Use Case Class
  *
  * [[http://allaboutscala.com/tutorials/chapter-3-beginner-tutorial-using-classes-scala/scala-tutorial-learn-define-use-case-class/ Tutorial]]
  *
  * Tutorial: Learn How To Use Type Alias: Type Aliasing Versus Case Class
  *
  * [[http://allaboutscala.com/tutorials/chapter-3-beginner-tutorial-using-classes-scala/scala-tutorial-learn-use-type-alias-versus-case-class/ Tutorial]]
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
object Tutorial_10_CaseClassAndTypeAlias extends App {

  println("Step 1: How to define a case class to represent a Donut object")
  case class Donut(name: String, price: Double, productCode: Option[Long] = None)



  println("\nStep 2: How to create instances or objects for the Donut case class")
  val vanillaDonut = Donut("Vanilla Donut", 1.50)
  val glazedDonut = Donut("Glazed Donut", 2.0)
  println(s"Vanilla Donut = $vanillaDonut")
  println(s"Glazed Donut = $glazedDonut")



  println("\nStep 3: How to access fields of the Donut object")
  println(s"Vanilla Donut name field = ${vanillaDonut.name}")
  println(s"Vanilla Donut price field = ${vanillaDonut.price}")
  println(s"Vanilla Donut productCode field = ${vanillaDonut.productCode}")



  println("\nStep 4: How to modify or update fields of the Donut object")
//   vanillaDonut.name = "vanilla donut" // compiler error. fields are immutable by default.
  val vanillaDonut2 = vanillaDonut.copy(name = "vanilla donut 2")
  println(s"Name of vanillaDonut2 = ${vanillaDonut2.name}")



  println("\nStep 5: How to define the hashCode and equals method for Donut object")
  println(s"vanillaDonut hashCode = ${vanillaDonut.hashCode()}")
  println(s"Does vanillaDonut == glazedDonut? ${vanillaDonut.equals(glazedDonut)}")
  println(s"Does vanillaDonut == vanillaDonut? ${vanillaDonut.equals(vanillaDonut)}")
  println(s"Does vanillaDonut == vanillaDonut2? ${vanillaDonut.equals(vanillaDonut2)}")

  val shoppingCart: Map[Donut, Int] = Map(vanillaDonut -> 4, glazedDonut -> 3)
  println(s"All items in shopping cart = $shoppingCart")
  println(s"Quantity of vanilla donuts in shopping cart = ${shoppingCart(vanillaDonut)}")
  println(s"Quantity of glazed donuts in shopping cart = ${shoppingCart(glazedDonut)}")



  println("\nStep 6: How to use type alias to name a Tuple2 pair into a domain type called CartItem")
  type CartItem[Donut, Int] = Tuple2[Donut, Int]



  println("\nStep 7: How to create instances of the aliased typed CartItem")
  val cartItem = new CartItem(vanillaDonut, 4)
  println(s"cartItem = $cartItem")
  println(s"cartItem first value = ${cartItem._1}")
  println(s"cartItem second value = ${cartItem._2}")



  println("\nStep 8: How to use an aliased typed into a function parameter")
  def calculateTotal(shoppingCartItems: Seq[CartItem[Donut, Int]]): Double = {
    shoppingCartItems.foreach { cartItem =>
      println(s"CartItem donut = ${cartItem._1}, quantity = ${cartItem._2}")
    }
    10 // some random total cost
  }



  println("\nStep 9: How to use a case class instead of an aliased typed")
  case class ShoppingCartItem(donut: Donut, quantity: Int)

  val shoppingItem = ShoppingCartItem(Donut("Glazed Donut", 2.50), 10)
  println(s"shoppingItem donut = ${shoppingItem.donut}")
  println(s"shoppingItem quantity = ${shoppingItem.quantity}")

  def calculateTotal2(shoppingCartItems: Seq[ShoppingCartItem]): Double = {
    shoppingCartItems.foreach { shoppingCartItem =>
      println(s"ShoppingCartItem donut = ${shoppingCartItem.donut}, quantity = ${shoppingCartItem.quantity}")
    }
    10 // some random total cost
  }



  println("\nTip: Case classes and Pattern Matching")
  val donuts = List(glazedDonut, vanillaDonut)
  donuts.foreach { {
      case Donut("Vanilla Donut", 1.50, _) => println(s"Found vanilla donut")
      case Donut(donutName, price, _) => println(s"Found donutName = $donutName, price = $price")
    }
  }
}
