package com.allaboutscala.learn.scala.seven.days.day.six

import scala.util.{Failure, Success}

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Future recover
  *
  * [[http://allaboutscala.com/tutorials/chapter-9-beginner-tutorial-using-scala-futures/#future-recover Tutorial]]
  *
  * Tutorial: Future recoverWith
  *
  * [[http://allaboutscala.com/tutorials/chapter-9-beginner-tutorial-using-scala-futures/#future-recoverWith Tutorial]]
  *
  * Tutorial: Future fallbackTo
  *
  * [[http://allaboutscala.com/tutorials/chapter-9-beginner-tutorial-using-scala-futures/#future-fallbackTo Tutorial]]
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
object Tutorial_03_Handling_Failures extends App {

  println("Step 1: Define a method which returns a Future")
  import scala.concurrent.ExecutionContext.Implicits.global
  import scala.concurrent.Future
  def donutStock(donut: String): Future[Int] = Future {
    if(donut == "vanilla donut") 10
    else throw new IllegalStateException("Out of stock")
  }



  println("\nStep 2: Execute donutStock() future operation")
  donutStock("vanilla donut")
    .onComplete {
      case Success(donutStock)  => println(s"Results $donutStock")
      case Failure(e)           => println(s"Error processing future operation, error = ${e.getMessage}")
    }

  donutStock("unknown donut")
    .onComplete {
      case Success(donutStock)  => println(s"Results $donutStock")
      case Failure(e)           => println(s"Error processing future operation, error = ${e.getMessage}")
    }

  Thread.sleep(3000)



  println("\nStep 3: Call Future.recover to recover from a known exception")
  donutStock("unknown donut")
    .recover { case e: IllegalStateException if e.getMessage == "Out of stock" => 0 }
    .onComplete {
      case Success(donutStock)  => println(s"Results $donutStock")
      case Failure(e)           => println(s"Error processing future operation, error = ${e.getMessage}")
    }

  Thread.sleep(3000)




  println("\nStep 4: Call Future.recoverWith to recover from a known exception")
  donutStock("unknown donut")
    .recoverWith { case e: IllegalStateException if e.getMessage == "Out of stock" => Future.successful(0) }
    .onComplete {
      case Success(donutStock)  => println(s"Results $donutStock")
      case Failure(e)           => println(s"Error processing future operation, error = ${e.getMessage}")
    }

  Thread.sleep(3000)




  println("\nStep 5: Define another method which returns a Future to match a similar donut stock")
  def similarDonutStock(donut: String): Future[Int] = Future {
    println(s"replacing donut stock from a similar donut = $donut")
    if(donut == "vanilla donut") 20 else 5
  }



  println("\nStep 6: Call Future.fallbackTo")
  val donutStockOperation = donutStock("plain donut")
    .fallbackTo(similarDonutStock("vanilla donut"))
    .onComplete {
      case Success(donutStock)  => println(s"Results $donutStock")
      case Failure(e)           => println(s"Error processing future operation, error = ${e.getMessage}")
    }

  Thread.sleep(3000)
}
