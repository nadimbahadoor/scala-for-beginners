package com.allaboutscala.learn.scala.seven.days.day.three

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Learn How To Create And Use Enumerations (enum)
  *
  * [[http://allaboutscala.com/tutorials/chapter-2-learning-basics-scala-programming/learn-to-create-use-enumerations/ Tutorial]]
  *
  * Tutorial: Akka Tutorials
  *
  * [http://allaboutscala.com/scala-frameworks/akka/ Tutorial]
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
object Tutorial_07_EnumsAndADT extends App {

  println("Step 1: How to create and use an enumeration")
  object Donut extends Enumeration {
    type Donut = Value

    val Glazed      = Value("Glazed")
    val Strawberry  = Value("Strawberry")
    val Plain       = Value("Plain")
    val Vanilla     = Value("Vanilla")
  }

  println(s"Vanilla Donut string value = ${Donut.Vanilla}")
  println(s"Vanilla Donut's id = ${Donut.Vanilla.id}")



  println("\nStep 2: Defining Algebraic Data Types using sealed traits")
  sealed trait BakingEvents
  final case object BakeDonut extends BakingEvents
  final case object AddTopping extends BakingEvents
  final case object StopBaking extends BakingEvents


  def prettyPrintBakingEvent(bakingEvent: BakingEvents): Unit = bakingEvent match {
    case BakeDonut => println("BakeDonut event was used in Pattern Matching")
    case AddTopping => println("AddTopping event was used in Pattern Matching")
    case StopBaking => println("StopBaking event was used in Pattern Matching")
  }

  prettyPrintBakingEvent(BakeDonut)
}
