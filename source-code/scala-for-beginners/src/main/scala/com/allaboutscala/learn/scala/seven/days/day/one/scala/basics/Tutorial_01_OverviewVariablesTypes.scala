package com.allaboutscala.learn.scala.seven.days.day.one.scala.basics

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Scala Basic Tutorial – How To Declare Variables And Types
  *
  * [[http://allaboutscala.com/tutorials/chapter-2-learning-basics-scala-programming/scala-basic-tutorial-declare-variables-types/ Tutorial]]
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
object Tutorial_01_OverviewVariablesTypes extends App {

  println("Step 1: Immutable values")
  val donutsToBuy: Int = 5

//  donutsToBuy = 10 // you will get compile error because donutToBuy is immutable



  println("\nStep 2: Mutable variables")
  var favoriteDonut: String = "Glazed Donut"
  favoriteDonut = "Vanilla Donut"



  println("\nStep 3: Declare a variable without a default value")
  var leastFavoriteDonut: String = _
  leastFavoriteDonut = "Plain Donut"



  println("\nStep 4: lazy initialization")
  lazy val donutService = "initialize some donut service"



  println("\nStep 5: Scala supported types")
  val boolEatingDonut: Boolean = true
  val donutsBought: Int = 5
  val bigNumberOfDonuts: Long = 100000000L
  val smallNumberOfDonuts: Short = 1
  val priceOfDonut: Double = 2.50
  val donutPrice: Float = 2.50f
  val donutStoreName: String = "Allaboutscala Donut Store"
  val donutByte: Byte = 0xa
  val donutFirstLetter: Char = 'D'
  val nothing: Unit = ()
}
