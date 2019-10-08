package com.allaboutscala.learn.scala.seven.days.day.three

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Learn How To Use Traits For Dependency Injection
  *
  * [[http://allaboutscala.com/tutorials/chapter-5-traits/scala-traits-depedency-injection/]]
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
object Tutorial_04_TraitDependencyInjection extends App {

  println("Step 1: Create a trait which knows how to do create, read, update and delete operations CRUD to a given database")
  trait DonutDatabase[A] {
    def addOrUpdate(donut: A): Long

    def query(donut: A): A

    def delete(donut: A): Boolean
  }


  println("\nStep 2: Create a CRUD class for Apache Cassandra as the storage layer")
  class CassandraDonutStore[A] extends DonutDatabase[A] {
    override def addOrUpdate(donut: A): Long = {
      println(s"CassandraDonutDatabase-> addOrUpdate method -> donut: $donut")
      1
    }

    override def query(donut: A): A = {
      println(s"CassandraDonutDatabase-> query method -> donut: $donut")
      donut
    }

    override def delete(donut: A): Boolean = {
      println(s"CassandraDonutDatabase-> delete method -> donut: $donut")
      true
    }
  }


  println("\nStep 3: Create a Data Access Layer which requires dependency injection of type DonutDatabase")
  trait DonutShoppingCartDao[A] {
    val donutDatabase: DonutDatabase[A] // dependency injection

    def add(donut: A): Long = {
      println(s"DonutShoppingCartDao-> add method -> donut: $donut")
      donutDatabase.addOrUpdate(donut)
    }

    def update(donut: A): Boolean = {
      println(s"DonutShoppingCartDao-> update method -> donut: $donut")
      donutDatabase.addOrUpdate(donut)
      true
    }

    def search(donut: A): A = {
      println(s"DonutShoppingCartDao-> search method -> donut: $donut")
      donutDatabase.query(donut)
    }

    def delete(donut: A): Boolean = {
      println(s"DonutShoppingCartDao-> delete method -> donut: $donut")
      donutDatabase.delete(donut)
    }
  }



  println("\nStep 4: Create an inventory service which require dependency injection of type DonutDatabase")
  trait DonutInventoryService[A] {
    val donutDatabase: DonutDatabase[A]  // dependency injection

    def checkStockQuantity(donut: A): Int = {
      println(s"DonutInventoryService-> checkStockQuantity method -> donut: $donut")
      donutDatabase.query(donut)
      1
    }
  }



  println("\nStep 5: Create a Facade that injects a DonutDatabase implementation - a CassandraDonutStore")
  trait DonutShoppingCartServices[A] extends DonutShoppingCartDao[A] with DonutInventoryService[A] {
    override val donutDatabase: DonutDatabase[A] = new CassandraDonutStore[A]()
  }



  println("\nStep 6: Create a class to interact with the Facade")
  class DonutShoppingCart[A] extends DonutShoppingCartServices[A] {

  }



  println("\nStep 7: Create an instance of DonutShoppingCart and call the add, update, search and delete methods")
  val donutShoppingCart = new DonutShoppingCart[String]()
  donutShoppingCart.add("Vanilla Donut")
  donutShoppingCart.update("Vanilla Donut")
  donutShoppingCart.search("Vanilla Donut")
  donutShoppingCart.delete("Vanilla Donut")



  println("\nStep 8: Call the checkStockQuantity method")
  donutShoppingCart.checkStockQuantity("Vanilla Donut")
}
