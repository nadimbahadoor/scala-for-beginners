package com.allaboutscala.learn.scala.seven.days.day.three

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Learn How To Use Traits For Dependency Injection Part 2 - Avoid Cake Pattern
  *
  * [[http://allaboutscala.com/tutorials/chapter-5-traits/scala-traits-depedency-injection-avoid-cake-pattern/]]
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
object Tutorial_05_TraitDependencyInjectionSingleFacade extends App {

  println("Step 1: How to encapsulate various services into corresponding classes")
  class DonutInventoryService[T] {
    def checkStock(donut: T): Boolean = {
      println("DonutInventoryService->checkStock")
      true
    }
  }



  class DonutPricingService[T] {
    def calculatePrice(donut: T): Double = {
      println("DonutPricingService->calculatePrice")
      2.50
    }
  }



  class DonutOrderService[T] {
    def createOrder(donut: T, quantity: Int, price: Double): Int = {
      println(s"Saving donut order to database: donut = $donut, quantity = $quantity, price = $price")
      100
    }
  }



  println("\nStep 2: How to define a class to encapsulate shopping cart services")
  class DonutShoppingCartService[T] (
    donutInventoryService: DonutInventoryService[T],
    donutPricingService: DonutPricingService[T],
    donutOrderService: DonutOrderService[T]) {

    def bookOrder(donut: T, quantity: Int): Option[Int] = {
      println("DonutShoppingCartService->bookOrder")

      donutInventoryService.checkStock(donut) match {
        case true =>
          val price = donutPricingService.calculatePrice(donut)
          val donutId = donutOrderService.createOrder(donut, quantity, price)
          Some(donutId)

        case false =>
          println(s"Sorry donut $donut is out of stock!")
          None
      }
    }
  }



  println("\nStep 3: How to define a trait to encapsulate all the services for Donut store")
  trait DonutStoreServices {
    lazy val donutInventoryService = new DonutInventoryService[String]
    lazy val donutPricingService = new DonutPricingService[String]
    lazy val donutOrderService = new DonutOrderService[String]
    lazy val donutShoppingCartService = new DonutShoppingCartService(donutInventoryService, donutPricingService, donutOrderService)
  }



  println("\nStep 4: How to define a facade to expose functionality of DonutStoreServices")
  trait DonutStoreAppController {
    this: DonutStoreServices =>

    def bookOrder(donut: String, quantity: Int): Option[Int] = {
      println("DonutStoreAppController->bookOrder")
      donutShoppingCartService.bookOrder(donut, quantity)
    }
  }


  println("\nStep 5: Using mixin to inject the DonutStoreServices into DonutStoreAppController Facade")
  object DonutStoreApp extends DonutStoreAppController with DonutStoreServices
  DonutStoreApp.bookOrder("Vanilla Donut", 10)



  println("\nStep 6: Test DonutStoreApp by injecting a mocked version of DonutStoreServices")
  trait MockedDonutStoreServices extends DonutStoreServices {
    override lazy val donutInventoryService: DonutInventoryService[String] = ???
    override lazy val donutPricingService: DonutPricingService[String] = ???
    override lazy val donutOrderService: DonutOrderService[String] = ???
    override lazy val donutShoppingCartService: DonutShoppingCartService[String] = new DonutShoppingCartService[String](
      donutInventoryService, donutPricingService, donutOrderService)
  }

  object MockedDonutStoreApp extends DonutStoreAppController with MockedDonutStoreServices
}
