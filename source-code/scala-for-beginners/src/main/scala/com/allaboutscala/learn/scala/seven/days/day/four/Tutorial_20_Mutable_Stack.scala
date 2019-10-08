package com.allaboutscala.learn.scala.seven.days.day.four

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Learn How To Use Scala's Mutable ArrayStack
  *
  * [[http://allaboutscala.com/tutorials/chapter-7-beginner-tutorial-using-scala-mutable-collection/scala-tutorial-learn-use-mutable-arraystack/ Tutorial]]
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
object Tutorial_20_Mutable_Stack extends App {

  import scala.collection.mutable.Stack
  println("Step 1: How to initialize a Stack with 3 elements")


  val stack = Stack("Plain Donut", "Strawberry Donut", "Chocolate Donut")
  println(s"Elements of stack = $stack")



  println("\nStep 2: How to check elements at specific index of a Stack")
  println(s"Element at index 0 = ${stack(0)}")
  println(s"Element at index 1 = ${stack(1)}")
  println(s"Element at index 2 = ${stack(2)}")



  println("\nStep 3: How to add elements to a Stack using +=")
  stack += "Vanilla Donut"
  println(s"Elements of stack = $stack")



  println("\nStep 4: How to add elements from a List to a Stack using ++=")
  stack ++= List("Glazed Donut", "Krispy creme")
  println(s"Elements of stack = $stack")



  println("\nStep 5: How to take an element from a Stack using pop method")
  println(s"Pop element from stack  = ${stack.pop}")
  println(s"Elements of stack = $stack")



  println("\nStep 6: How to push one element at the top of the a Stack using push method")
  stack.push("Krispy Creme")
  println(s"Elements after push = $stack")



  println("\nStep 7: How to initialize an empty Stack")
  val emptyStack = Stack.empty
  println(s"Empty Stack = $emptyStack")
}
