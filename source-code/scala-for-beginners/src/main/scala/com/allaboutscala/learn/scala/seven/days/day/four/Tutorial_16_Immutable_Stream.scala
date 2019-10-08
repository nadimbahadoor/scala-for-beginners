package com.allaboutscala.learn.scala.seven.days.day.four

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Learn How To Use Scala's Immutable Stream
  *
  * [[http://allaboutscala.com/tutorials/chapter-6-beginner-tutorial-using-scala-immutable-collection/scala-tutorial-learn-use-immutable-stream/ Tutorial]]
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
object Tutorial_16_Immutable_Stream extends App {

  println("Step 1: How to create a Stream with 3 numbers using #::")
  val stream1 = 1 #:: 2 #:: 3 #:: LazyList.empty[Int]
  println(s"Elements of stream1 = $stream1")



  import scala.collection.immutable.LazyList.cons
  println("\nStep 2: How to create a Stream with 3 numbers using Stream.cons")
  val stream2 = cons(1, cons(2, cons(3, LazyList.empty) ) )
  println(s"Elements of stream2 = $stream2")



  println("\nStep 3: How to print all 3 numbers from stream2 using the take function")
  print("Take first 3 numbers from stream2 = ")
  stream2 take 3 foreach println

  print("\nTake first 10 numbers from stream2 = ")
  stream2 take 10 foreach println



  println("\n\nStep 4: How to define an infinite Stream using LazyList.from")
  println("Take only the first 20 numbers from the infinite number stream = ")
  val stream3 = LazyList.from(1)
  stream3 take 20 foreach println



  println("\n\nStep 5: How to define an infinite number stream with 2 increments using LazyList.from")
  val stream4 = LazyList.from(1, 2)
  println("Take only the first 20 numbers from the infinite number stream of 2 increments = ")
  stream4 take 20 foreach println



  println("\n\nStep 6: How to initialize an empty stream")
  val emptyStream = LazyList.empty[Int]
  println(s"Empty stream = $emptyStream")
}
