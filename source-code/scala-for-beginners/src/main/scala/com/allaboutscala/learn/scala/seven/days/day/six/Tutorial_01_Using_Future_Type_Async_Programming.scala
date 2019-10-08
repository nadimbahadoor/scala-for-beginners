package com.allaboutscala.learn.scala.seven.days.day.six

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Method with future as return type
  *
  * [[http://allaboutscala.com/tutorials/chapter-9-beginner-tutorial-using-scala-futures/#method-future-return-type Tutorial]]
  *
  * Tutorial: Non blocking future result
  *
  * [[http://allaboutscala.com/tutorials/chapter-9-beginner-tutorial-using-scala-futures/#non-blocking-future-result Tutorial]]
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
object Tutorial_01_Using_Future_Type_Async_Programming extends App {

  println("Step 1: Define a method which returns a Future")
  import scala.concurrent.Future
  import scala.concurrent.ExecutionContext.Implicits.global
  import scala.language.postfixOps

  def donutStock(donut: String): Future[Int] = Future {
    // assume some long running database operation
    println("checking donut stock")
    10
  }



  println("\nStep 2: Call a method which returns a Future")
  import scala.concurrent.Await
  import scala.concurrent.duration._
  val vanillaDonutStock = Await.result(donutStock("vanilla donut"), 5 seconds)
  println(s"Stock of vanilla donut = $vanillaDonutStock")



  println("\nStep 3: Define other methods which returns a Future")
  def donutStock2(donut: String): Future[Option[Int]] = Future {
    println("checking donut stock")
    if(donut == "vanilla donut") Some(10) else None
  }

  def processPayment(): Future[Unit] = Future {
    println("processPayment ... sleep for 1 second")
    Thread.sleep(1000)
  }



  println("\nStep 4: Non-blocking future result or callback")
  import scala.util.{Failure, Success}
  donutStock("vanilla donut").onComplete {
    case Success(stock) => println(s"Stock for vanilla donut = $stock")
    case Failure(e) => println(s"Failed to find vanilla donut stock, exception = $e")
  }


  // TIP
  def futureOp(): Future[Unit] = Future {
    println("Future operation will only run from an explicit method call of futureOp()")
    Thread.sleep(3000)
  }

  val futureOp2: Future[Unit] = Future {
    println("Future operation is running")
    Thread.sleep(3000)
  }

  Thread.sleep(3000)
}
