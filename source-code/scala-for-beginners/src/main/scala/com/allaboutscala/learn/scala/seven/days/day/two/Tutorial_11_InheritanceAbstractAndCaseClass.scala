package com.allaboutscala.learn.scala.seven.days.day.two

import com.allaboutscala.learn.scala.seven.days.day.two.Tutorial_10_CaseClassAndTypeAlias.{glazedDonut, vanillaDonut, vanillaDonut2}

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Learn How To Extend Class - Class Inheritance
  *
  * [[http://allaboutscala.com/tutorials/chapter-3-beginner-tutorial-using-classes-scala/scala-extend-class/ Tutorial]]
  *
  * Tutorial: Learn How To Extend Case Class - Case Class Inheritance
  *
  * [[http://allaboutscala.com/tutorials/chapter-3-beginner-tutorial-using-classes-scala/scala-extend-case-class/ Tutorial]]
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
object Tutorial_11_InheritanceAbstractAndCaseClass extends App {

  println("Step 1: How to define an abstract class called Donut")
  abstract class Donut(name: String) {
    def printName(): Unit // abstract method
  }



  println("\nStep 2: How to extend abstract class Donut and define a subclass of Donut called VanillaDonut")
  class VanillaDonut(name: String) extends Donut(name) {
    override def printName(): Unit = println(name)
  }

  object VanillaDonut {
    def apply(name: String): Donut = {
      new VanillaDonut(name)
    }
  }



  println("\nStep 3: How to extend abstract class Donut and define another sub-class of Donut called GlazedDonut")
  class GlazedDonut(name: String) extends Donut(name) {
    override def printName(): Unit = println(name)
  }

  object GlazedDonut {
    def apply(name: String): Donut = {
      new GlazedDonut(name)
    }
  }



  println("\nStep 4: How to instantiate Donut objects")
  val vanillaDonut: Donut = VanillaDonut("Vanilla Donut")
  vanillaDonut.printName()

  val glazedDonut: Donut = GlazedDonut("Glazed Donut")
  glazedDonut.printName()

  val donuts: List[Donut] = List(vanillaDonut, glazedDonut)
  donuts.foreach(_.printName())



  println("\nStep 5: How to extend abstract class from a case class")
  case class VanillaDonutCaseClass(name: String) extends Donut(name) {
    override def printName(): Unit = println(name)
  }

  case class GlazedDonutCaseClass(name: String) extends Donut(name) {
    override def printName(): Unit = println(name)
  }


  val vanillaDonut2: Donut = VanillaDonutCaseClass("Vanilla Donut")
  vanillaDonut2.printName()

  val glazedDonut2: Donut = GlazedDonutCaseClass("Glazed Donut")
  glazedDonut2.printName()

  val donuts2: List[Donut] = List(vanillaDonut2, glazedDonut2)
  donuts2.foreach(_.printName())
}
