package com.allaboutscala.learn.scala.seven.days.day.six

import scala.util.{Failure, Success}

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Future firstCompletedOf
  *
  * [[http://allaboutscala.com/tutorials/chapter-9-beginner-tutorial-using-scala-futures/#future-firstCompletedOf Tutorial]]
  *
  * Tutorial: Future zip
  *
  * [[http://allaboutscala.com/tutorials/chapter-9-beginner-tutorial-using-scala-futures/#future-zip Tutorial]]
  *
  * Tutorial: Future zipWith
  *
  * [[http://allaboutscala.com/tutorials/chapter-9-beginner-tutorial-using-scala-futures/#future-zipWith Tutorial]]
  *
  * Tutorial: Future andThen
  *
  * [[http://allaboutscala.com/tutorials/chapter-9-beginner-tutorial-using-scala-futures/#future-andThen Tutorial]]
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
object Tutorial_07_Useful_Future_Functions extends App {

  println("Step 1: Define a method which returns a Future Option")
  import scala.concurrent.ExecutionContext.Implicits.global
  import scala.concurrent.Future
  def donutStock(donut: String): Future[Option[Int]] = Future {
    println("checking donut stock")
    if(donut == "vanilla donut") Some(10) else None
  }



  println(s"\nStep 2: Create a List of future operations")
  val futureOps = List(
    donutStock("vanilla donut"),
    donutStock("plain donut"),
    donutStock("chocolate donut"),
    donutStock("vanilla donut")
  )


  println(s"\nStep 3: Call Future.firstCompletedOf to get the results of the first future that completes")
  val futureFirstCompletedResult = Future.firstCompletedOf(futureOps)
  futureFirstCompletedResult.onComplete {
    case Success(results) => println(s"Results $results")
    case Failure(e)       => println(s"Error processing future operations, error = ${e.getMessage}")
  }

  Thread.sleep(3000)



  println(s"\nStep 4: Define a method which returns a Future Double for donut price")
  def donutPrice(): Future[Double] = Future.successful(3.25)



  println(s"\nStep 5: Zip the values of the first Future with the second Future")
  val donutStockAndPriceOperation = donutStock("vanilla donut") zip donutPrice()
  donutStockAndPriceOperation.onComplete {
    case Success(results) => println(s"Results $results")
    case Failure(e)       => println(s"Error processing future operations, error = ${e.getMessage}")
  }

  Thread.sleep(3000)



  println(s"\nStep 6: Define a value function to convert Tuple (Option[Int], Double) to Tuple (Int, Double)")
  val qtyAndPriceF: (Option[Int], Double) => (Int, Double) = (someQty, price) => (someQty.getOrElse(0), price)



  println(s"\nStep 7: Call Future.zipWith and pass-through function qtyAndPriceF")
  val donutAndPriceOperation = donutStock("vanilla donut").zipWith(donutPrice())(qtyAndPriceF)
  donutAndPriceOperation.onComplete {
    case Success(result) => println(s"Result $result")
    case Failure(e)      => println(s"Error processing future operations, error = ${e.getMessage}")
  }

  Thread.sleep(3000)



  println(s"\nStep 8: Call Future.andThen with a PartialFunction")
  val donutStockOperation = donutStock("vanilla donut")
  donutStockOperation.andThen { case stockQty => println(s"Donut stock qty = ${stockQty.getOrElse(0)}")}

  Thread.sleep(3000)
}
