package com.allaboutscala.learn.scala.seven.days.day.one.scala.basics

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Scala – How To Escape Characters And Create Multi-line String
  *
  * [[http://allaboutscala.com/tutorials/chapter-2-learning-basics-scala-programming/scala-escape-characters-create-multi-line-string/ Tutorial]]
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
object Tutorial_05_CommentsEscapingCharsAndMultiLine extends App {

  println("Step 1: Create single line comments")
  // This is a single line comment



  println("\nStep 2: Create multi-line comments")
  /**
   * This
   * is
   * a
   * multi-line
   * comment.
   */


  println("\nStep 3: Add code block in multi-line comment")
  /**
    * Define a type alias for a ShoppingCartItem.
    *
    * {{{
    *   type ShoppingCartItem[Donut, Int] = (Donut, Int)
    *   val vanillaDonut = Donut("Vanilla Donut", 1.50)
    *   val cartItem = new ShoppingCartItem(vanillaDonut, 4)
    * }}}
    *
    */


  println("\nStep 4: How to escape a Json String")
//    val donutJson ="{"donut_name":"Glazed Donut","taste_level":"Very Tasty","price":2.50}"



  println("\nStep 5: Using backslash to escape quotes")
  val donutJson2 = "{\"donut_name\":\"Glazed Donut\",\"taste_level\":\"Very Tasty\",\"price\":2.50}"
  println(s"donutJson2 = $donutJson2")



  println("\nStep 6: Using triple quotes \"\"\" to escape characters")
  val donutJson3 = """{"donut_name":"Glazed Donut","taste_level":"Very Tasty","price":2.50}"""
  println(s"donutJson3 = $donutJson3")



  println("\nStep 7: Creating multi-line text using stripMargin")
  val donutJson4 =
    """
      |{
      |"donut_name":"Glazed Donut",
      |"taste_level":"Very Tasty",
      |"price":2.50
      |}
    """.stripMargin
  println(s"donutJson4 = $donutJson4")



  println("\nStep 8: String interpolation and multi-line text")
  val donutName = "Glazed Donut"
  val tasteLevel = "Very Tasty"
  val price = 2.50
  val donutJson5 =
    s"""
      |{
      |"donut_name":"$donutName",
      |"taste_level":"$tasteLevel",
      |"price":$price
      |}
    """.stripMargin
  println(s"donutJson5 = $donutJson5")



  println("\nTip: stripMargin using a different character")
  val donutJson6 =
    """
      #{
      #"donut_name":"Glazed Donut",
      #"taste_level":"Very Tasty",
      #"price":2.50
      #}
    """.stripMargin('#')
  println(s"donutJson6 = $donutJson6")
}
