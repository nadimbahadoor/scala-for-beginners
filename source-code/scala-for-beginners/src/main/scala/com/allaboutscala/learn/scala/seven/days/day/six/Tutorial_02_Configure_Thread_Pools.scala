package com.allaboutscala.learn.scala.seven.days.day.six

import java.util.concurrent.atomic.AtomicLong
import java.util.concurrent.{Executors, ThreadFactory}

import scala.util.{Failure, Success}

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Future configure thread pool
  *
  * [[http://allaboutscala.com/tutorials/chapter-9-beginner-tutorial-using-scala-futures/#future-configure-threadpool Tutorial]]
  *
  * Tutorial: Akka default dispatcher
  * [[http://allaboutscala.com/scala-frameworks/akka/#akka-default-dispatcher Tutorial]]
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
object Tutorial_02_Configure_Thread_Pools extends App {

// Step 5: defining the custom thread factory
  val donutStockThreadFactory = new ThreadFactory {
    val counter = new AtomicLong()

    def newThread(r: Runnable): Thread = {
      val thread = new Thread(r)
      thread.setName(s"DonutStock Thread-${counter.incrementAndGet()}")
      thread.setPriority(Thread.MIN_PRIORITY)
      thread
    }
  }


  println("Step 1: Define an ExecutionContext")
  val executor = Executors.newSingleThreadExecutor()


  // Step: 4: Using a cached thread pool
//  val executor = Executors.newCachedThreadPool()


  // Step 5: Using a cached thread Pool with a custom thread Factory
//    val executor = Executors.newCachedThreadPool(donutStockThreadFactory)


  // Step 6: Using a fixed thread pool with a custom thread factory
//  val executor = Executors.newFixedThreadPool(2, donutStockThreadFactory)

  implicit val ec = scala.concurrent.ExecutionContext.fromExecutor(executor)



  println("\nStep 2: Define a method which returns a Future")
  import scala.concurrent.Future
  def donutStock(donut: String): Future[Int] = Future {
    // assume some long running database operation
    println(s"[Thread: ${Thread.currentThread().getName}] - checking donut stock for donut = $donut")
    Thread.sleep(500)
    10
  }



  println("\nStep 3: Fire 5 concurrent requests for the donutStock method")
  (1 to 5).map(i => donutStock(s"some donut name $i"))



  Thread.sleep(5000)


  executor.shutdownNow()
}
