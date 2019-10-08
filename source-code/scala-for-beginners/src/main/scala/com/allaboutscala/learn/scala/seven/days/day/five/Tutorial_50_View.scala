package com.allaboutscala.learn.scala.seven.days.day.five

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Learn How To Use View Function With Examples
  *
  * [[http://allaboutscala.com/tutorials/chapter-8-beginner-tutorial-using-scala-collection-functions/scala-view-example/ Tutorial]]
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
object Tutorial_50_View extends App {

  println("Step 1: How to create a large numeric range and take the first 10 odd numbers")
  val largeOddNumberList = (1 to 1000000).filter(_ % 2 != 0).take(10).toList
  println(s"First 100 odd numbers from largeOddNumberList = $largeOddNumberList")



  println(s"\nStep 2: How to lazily create a large numeric range and take the first 10 odd numbers")
  val lazyLargeOddNumberList = (1 to 1000000000).view.filter(_ % 2 != 0).take(10).toList
  println(s"Lazily take the first 100 odd numbers from lazyLargeOddNumberList = $lazyLargeOddNumberList")
}
