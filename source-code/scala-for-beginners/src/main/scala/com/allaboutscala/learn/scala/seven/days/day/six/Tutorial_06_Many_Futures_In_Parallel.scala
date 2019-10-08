package com.allaboutscala.learn.scala.seven.days.day.six

import scala.util.{Failure, Success}

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Future sequence
  *
  * [[http://allaboutscala.com/tutorials/chapter-9-beginner-tutorial-using-scala-futures/#future-sequence Tutorial]]
  *
  * Tutorial: Future foldLeft
  *
  * [[http://allaboutscala.com/tutorials/chapter-9-beginner-tutorial-using-scala-futures/#future-foldLeft Tutorial]]
  *
  * Tutorial: Future reduceLeft
  *
  * [[http://allaboutscala.com/tutorials/chapter-9-beginner-tutorial-using-scala-futures/#future-reduceLeft Tutorial]]
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
object Tutorial_06_Many_Futures_In_Parallel extends App {

  println("Step 1: Define a method which returns a Future Option of Int")
  import scala.concurrent.ExecutionContext.Implicits.global
  import scala.concurrent.Future
  def donutStock(donut: String): Future[Option[Int]] = Future {
    println("checking donut stock ... sleep for 2 seconds")
    Thread.sleep(2000)
    if(donut == "vanilla donut") Some(10) else None
  }



  println("\nStep 2: Define another method which returns a Future[Boolean]")
  def buyDonuts(quantity: Int): Future[Boolean] = Future {
    println(s"buying $quantity donuts ... sleep for 3 seconds")
    Thread.sleep(3000)
    if(quantity > 0) true else false
  }



  println("\nStep 3: Define another method for processing payments and returns a Future[Unit]")
  def processPayment(): Future[Unit] = Future {
    println("processPayment ... sleep for 1 second")
    Thread.sleep(1000)
  }



  println("\nStep 4: Combine future operations into a List")
  val futureOps: List[Future[Any]] = List(donutStock("vanilla donut"), buyDonuts(10), processPayment())
  Thread.sleep(3000)



  println(s"\nStep 5: Call Future.sequence to run the future operations in parallel")
  val futureSequenceResults = Future.sequence(futureOps)
  futureSequenceResults.onComplete {
    case Success(results) => println(s"Results $results")
    case Failure(e)       => println(s"Error processing future operations, error = ${e.getMessage}")
  }

  Thread.sleep(2000)



  println(s"\nStep 6: Create a List of future operations")
  val futureOps2 = List(
    donutStock("vanilla donut"),
    donutStock("plain donut"),
    donutStock("chocolate donut"),
    donutStock("vanilla donut")
  )


  println(s"\nStep 7: Call Future.foldLeft to fold over futures results from left to right")
  val futureFoldLeft = Future.foldLeft(futureOps2)(0){ case (acc, someQty) =>
    acc + someQty.getOrElse(0)
  }
  futureFoldLeft.onComplete {
    case Success(results) => println(s"Results $results")
    case Failure(e)       => println(s"Error processing future operations, error = ${e.getMessage}")
  }

  Thread.sleep(3000)



  println(s"\nStep 8: Call Future.reduceLeft to fold over futures results from left to right")
  val futureReduceLeft = Future.reduceLeft(futureOps2){ case (acc, someQty) =>
    acc.map(qty => qty + someQty.getOrElse(0))
  }
  futureReduceLeft.onComplete {
    case Success(results) => println(s"Results $results")
    case Failure(e)       => println(s"Error processing future operations, error = ${e.getMessage}")
  }

  Thread.sleep(3000)
}
