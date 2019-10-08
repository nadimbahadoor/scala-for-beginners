package com.allaboutscala.learn.scala.seven.days.day.two

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Learn How To Create Variable Argument Function
  *
  * [[http://allaboutscala.com/tutorials/chapter-3-beginner-tutorial-using-functions-scala/scala-tutorial-learn-create-variable-argument-function/ Tutorial]]
  *
  * Tutorial: Learn How To Create Functions As Symbols
  *
  * [[http://allaboutscala.com/tutorials/chapter-3-beginner-tutorial-using-functions-scala/scala-tutorial-learn-create-functions-symbols/ Tutorial]]
  *
  * Tutorial: Learn How To Create Nested Function
  *
  * [[http://allaboutscala.com/tutorials/chapter-3-beginner-tutorial-using-functions-scala/scala-tutorial-learn-create-nested-function/ Tutorial]]
  *
  * Tutorial: Learn How To Create Function Currying With Parameter Groups
  *
  * [[http://allaboutscala.com/tutorials/chapter-3-beginner-tutorial-using-functions-scala/scala-tutorial-create-function-currying-parameter-groups/ Tutorial]]
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
object Tutorial_02_FunctionsFun extends App {

  println("Step 1: How to define a function which takes variable number of arguments")
  def printReport(donutNames: String*): Unit = {
    println(s"""Donut Report = ${donutNames.mkString(", ")}""")
  }



  println("\nStep 2: How to a call function which takes variable number of arguments")
  printReport("Glazed Donut", "Strawberry Donut", "Vanilla Donut")
  printReport("Chocolate Donut")
  printReport()



  println("\nStep 3: How to pass-through a List, Sequence or an Array to a function with variable number of arguments")
  val listDonuts = List("Glazed Donut", "Strawberry Donut", "Vanilla Donut")
  printReport(listDonuts: _*)

  val seqDonuts = Seq("Chocolate Donut", "Plain Donut")
  printReport(seqDonuts: _*)

  import scala.collection.immutable.ArraySeq
  val arrDonuts = Array("Coconut Donut")
  printReport(ArraySeq.unsafeWrapArray(arrDonuts): _*)





  println("\nStep 4: Create a GraphNode class with a function as symbol using -->")
  class GraphNode(val name: String) {
    def createDirectedEdge(other: GraphNode): Unit = {
      println(s"Creating an edge between node = $name with ${other.name}")
    }

    def -->(other: GraphNode): Unit = {
      println(s"Creating an edge between node = $name with ${other.name}")
    }
  }


  println("\nStep 5: How to call a function --> which was defined as symbol")
  val nodeVanilla = new GraphNode("vanilla donut")
  val nodePlain = new GraphNode("plain donut")

  nodeVanilla.createDirectedEdge(nodePlain)
  nodeVanilla --> nodePlain



  println("\nStep 6: Method to check donut stock for a particular donut")
  def checkDonutAvailability(donutName: String): Boolean = {
    val listDonutsFromStock = List("Vanilla Donut", "Strawberry Donut", "Plain Donut", "Glazed Donut")
    val isDonutInStock = (donutName.nonEmpty && donutName.length > 0) && (listDonutsFromStock contains donutName)
    isDonutInStock
  }



  println("\nStep 7: How to define and call a Nested Function")
  def checkDonutAvailabilityWithNestedFunction(donutName: String): Boolean = {
    val listDonutsFromStock = List[String]("Vanilla Donut", "Strawberry Donut", "Plain Donut", "Glazed Donut")

    def validateDonutName = donutName.nonEmpty && donutName.length > 0
    def isDonutInStock(stock: List[String]): Boolean = stock.contains(donutName)

    validateDonutName && isDonutInStock(listDonutsFromStock)
  }

  println(s"Using checkDonutAvailabilityWithNestedFunction with Vanilla Donut = ${checkDonutAvailabilityWithNestedFunction("Vanilla Donut")}")



  println("\nStep 8: How to define function with curried parameter groups")
  def totalCost(donutName: String)(quantity: Int)(percentDiscount: Double): Double = {
    println(s"Calculating total cost for $quantity $donutName with ${percentDiscount * 100}% percentDiscount")
    val donutPrice = 2.50
    val totalCost = donutPrice * quantity
    totalCost - (totalCost * percentDiscount)
  }



  println("\nStep 9: How to call a function with curried parameter groups")
  println(s"Total cost = ${totalCost("Glazed Donut")(10)(0.1)}")



  println("\nStep 10: How to create a partially applied function from a function with curried parameter groups")
  val totalCostForGlazedDonuts = totalCost("Glazed Donut") _
  println(s"Total cost for Glazed Donuts ${totalCostForGlazedDonuts(10)(0.1)}")
}