package com.allaboutscala.learn.scala.seven.days.day.four

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Learn How To Use Scala's Immutable Queue
  *
  * [[http://allaboutscala.com/tutorials/chapter-6-beginner-tutorial-using-scala-immutable-collection/scala-tutorial-learn-use-immutable-queue/ Tutorial]]
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
object Tutorial_08_Immutable_Queue extends App {

  import scala.collection.immutable.Queue
  println("Step 1: How to initialize a Queue with 3 elements")
  val queue1 = Queue("Plain Donut", "Strawberry Donut", "Chocolate Donut")
  println(s"Elements of queue1 = $queue1")
  // NOTE: FIFO



  println("\nStep 2: How to access elements at specific index in a Queue")
  println(s"Element at index 0 = ${queue1(0)}")
  println(s"Element at index 1 = ${queue1(1)}")
  println(s"Element at index 2 = ${queue1(2)}")



  println("\nStep 3: How to add elements in a Queue using :+")
  val queue2 = queue1 :+ "Glazed Donut"
  println(s"Elements of queue2 = $queue2")



  println("\nStep 4: How to add elements in Queue using enqueue method")
  val queue3 = queue1.enqueue("Vanilla Donut")
  println(s"Enqueue element Vanilla Donut onto queue1 = $queue3")



  println("\nStep 5: How to take the first element from the Queue using dequeue method")
  val dequeue: (String, Queue[String]) = queue1.dequeue
  println(s"First element dequeue = ${dequeue._1}")
  println(s"Remaining elements after dequeue = ${dequeue._2}")
  // NOTE: dequeue returns a pair (element, the remaining elements of the queue)



  println("\nStep 6: How to add two Queues together using ++")
  val queue4 = queue1 ++ Queue[String]("Glazed Donut", "Vanilla Donut")
  println(s"Elements in queue3 = $queue4")



  println("\nStep 7: How to initialize an empty Queue")
  val emptyQueue = Queue.empty[String]
  println(s"Empty Queue = $emptyQueue")
}
