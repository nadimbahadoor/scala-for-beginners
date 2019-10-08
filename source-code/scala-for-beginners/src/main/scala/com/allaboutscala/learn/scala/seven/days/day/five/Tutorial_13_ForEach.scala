package com.allaboutscala.learn.scala.seven.days.day.five

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Learn How To Use Foreach Function With Examples
  *
  * [[http://allaboutscala.com/tutorials/chapter-8-beginner-tutorial-using-scala-collection-functions/scala-foreach-example/ Tutorial]]
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
object Tutorial_13_ForEach extends App {

  println("Step 1: How to initialize a Sequence of donuts")
  val donuts = Seq("Plain Donut", "Strawberry Donut", "Glazed Donut")
  println(s"Elements of donuts = $donuts")



  println("\nStep 2: How to loop through all the elements in the sequence using the foreach function")
  donuts.foreach(println(_))



  println("\nStep 3: How to loop through and access all the elements in the sequence using the foreach function")
  donuts.foreach(donutName => println(s"donutName = $donutName"))



  println("\nStep 4: How to declare a value function to format a donut names into upper case format")
  val uppercase: String => Unit = s => {
    val upper = s.toUpperCase
    println(upper)
  }



  println("\nStep 5: How to format all donuts to uppercase using value function from Step 4")
  donuts.foreach(uppercase)
}
