package com.allaboutscala.learn.scala.seven.days.day.six

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Composing futures
  *
  * [[http://allaboutscala.com/tutorials/chapter-9-beginner-tutorial-using-scala-futures/#composing-futures Tutorial]]
  *
  * Tutorial: Chain futures using flatMap
  *
  * [[http://allaboutscala.com/tutorials/chapter-9-beginner-tutorial-using-scala-futures/#chain-futures-using-flatmap Tutorial]]
  *
  * Tutorial: Future option with for comprehension
  *
  * [[http://allaboutscala.com/tutorials/chapter-9-beginner-tutorial-using-scala-futures/#future-option-with-for-comprehension Tutorial]]
  *
  * Tutorial: Chain futures using for comprehension
  *
  * [[http://allaboutscala.com/tutorials/chapter-9-beginner-tutorial-using-scala-futures/#chain-futures-using-for-comprehension Tutorial]]
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
object Tutorial_05_Chaining_Future extends App {

  println("Step 1: Define a method which returns a Future Option")
  import scala.concurrent.Future
  import scala.concurrent.ExecutionContext.Implicits.global
  def donutStock(donut: String): Future[Option[Int]] = Future {
    // assume some long running database operation
    println("checking donut stock")
    if(donut == "vanilla donut") Some(10) else None
  }



  println("\nStep 2: Define another method which returns a Future")
  def buyDonuts(quantity: Int): Future[Boolean] = Future {
    println(s"buying $quantity donuts")
    if(quantity > 0) true else false
  }



  println(s"\nStep 3: Calling map() method over multiple futures")
  val resultFromMap: Future[Future[Boolean]] = donutStock("vanilla donut")
    .map(someQty => buyDonuts(someQty.getOrElse(0)))
  Thread.sleep(1000)



  println(s"\nStep 4: Calling flatMap() method over multiple futures")
  val resultFromFlatMap: Future[Boolean] = donutStock("vanilla donut")
    .flatMap(someQty => buyDonuts(someQty.getOrElse(0)))
  Thread.sleep(1000)



  println("\nStep 5: Chaining Future Option using for comprehension")
  for {
    someStock <- donutStock("vanilla donut")
    isSuccess <- buyDonuts(someStock.getOrElse(0))
  } yield println(s"Buying vanilla donut was successful = $isSuccess")

  Thread.sleep(3000)
}
