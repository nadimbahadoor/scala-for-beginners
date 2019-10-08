package com.allaboutscala.learn.scala.seven.days.day.four

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Learn How To Use Scala's Immutable Stack
  *
  * [[http://allaboutscala.com/tutorials/chapter-6-beginner-tutorial-using-scala-immutable-collection/scala-tutorial-learn-use-immutable-stack/ Tutorial]]
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
object Tutorial_15_Immutable_Stack extends App {

  println("\nStep 1: How to initialize a Stack using an Immutable List")
  val stack1 = List("Plain Donut","Strawberry Donut","Chocolate Donut")
  println(s"Using an Immutable List for stack, elements are = $stack1")



  println("\nStep 2: Push one element at the top of the stack using :: of Immutable List")
  val stack2 = "Vanilla Donut" :: stack1
  println(s"Using an Immutable List for stack, elements after push = $stack2")



  println("\nStep 3: Push N elements at the top of the stack using :: of Immutable List")
  val stack3 = "Glazed Donut" :: "Vanilla Donut" :: stack1
  println(s"Using an Immutable List for stack, elements after pushing N elements  = $stack3")



  println("\nStep 4: Pop element from the Stack using tail method of Immutable List")
  val stack4 = stack1.tail
  println(s"Using an Immutable List for stack, elements after tail method to simulate Stack pop = $stack4")



  println("\nStep 5: Capture the popped element")
  val popped :: stack = stack1
  println(s"Popped element = $popped, the stack after the pop operation = $stack")



  println("\nStep 6: How to initialize an empty Stack using Immutable List")
  val emptyStack = List.empty[String]
  println(s"Using an Immutable List for stack, the empty stack = $emptyStack")
}
