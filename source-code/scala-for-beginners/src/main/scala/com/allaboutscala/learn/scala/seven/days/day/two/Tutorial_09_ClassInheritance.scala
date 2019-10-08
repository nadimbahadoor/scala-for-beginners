package com.allaboutscala.learn.scala.seven.days.day.two

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Learn How To Use Companion Objects' Apply Method As A Factory (Class Hierarchy Via Inheritance)
  *
  * [[http://allaboutscala.com/tutorials/chapter-3-beginner-tutorial-using-classes-scala/scala-tutorial-learn-companion-objects-factory-apply-method-inheritance/ Tutorial]]
  *
  * Tutorial: Learn How To Declare Values And Fields In Companion Object
  *
  * [[http://allaboutscala.com/tutorials/chapter-3-beginner-tutorial-using-classes-scala/scala-tutorial-learn-declare-value-fields-companion-object/ Tutorial]]
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
object Tutorial_09_ClassInheritance extends App {

  println("Step 1: How to define a simple class to represent a donut object")
  class Donut(name: String) {
    def printName(): Unit = println(s"Donut name = $name")
  }

  val glazedDonut = new Donut("Glazed Donut")
  glazedDonut.printName()



  println("\nStep 2: How to declare the donut Companion Object")
  object Donut {
    val A = "A"
    val B = "B"
    val C = "C"

    def apply(name: String): Donut = new Donut(name)
  }

  val vanillaDonut = Donut("Vanilla Donut")
  vanillaDonut.printName()
  println(s"Access global values akin to static ones in Java = ${Donut.A} ${Donut.B} ${Donut.C}")



  println("\nStep 3: Class with public fields, and overloaded apply() method in companion object")
  class Donut1(val name: String, val productCode: Option[Long] = None) {
    def printName(): Unit = println(s"Donut name = $name, productCode = ${productCode.getOrElse(0)}")
  }

  object Donut1 {
    def apply(name: String, productCode: Long): Donut1 = new Donut1(name, Some(productCode))

    def apply(name: String): Donut1 = new Donut1(name)
  }

  val glazedDonut1 = Donut1("Glazed Donut", 12345)
  glazedDonut1.printName()
  val vanillaDonut1 = Donut1("Vanilla Donut")

  // fields are now accessible on the object
  println(s"name = ${glazedDonut1.name}, productCode = ${glazedDonut1.productCode}")



  println("\nStep 4: Visibility of fields and methods")
  class Donut2(private val name: String, val productCode: Option[Long] = None) {
    private val UUID = 12345

    import Donut2._
    def printName(): Unit = nameBuilder(name, productCode.getOrElse(0))
  }

  object Donut2 {
    def apply(name: String, productCode: Long): Donut2 = new Donut2(name, Some(productCode))

    def apply(name: String): Donut2 = {
      val donut2 = new Donut2(name)
      println(s"private val UUID = ${donut2.UUID}") // companion object can access the private UUID field
      donut2
    }

    private def nameBuilder(name: String, productCode: Long): Unit =
      println(s"Donut name = $name, productCode = $productCode")
  }

  val glazedDonut2 = Donut2("Glazed Donut")
//  glazedDonut2.name // compiler error because the name property was marked as private
//  glazedDonut2.nameBuilder() // not accessible as it was marked private



  println("\nStep 5: Class inheritance and companion object as factory")
  class Donut3(val name: String, val productCode: Option[Long] = None) {

    def printName(): Unit = println(s"Donut name = $name, productCode = ${productCode.getOrElse(0)}")
  }

  // extend Donut3
  class GlazedDonut(name: String) extends Donut3(name)
  class VanillaDonut(name: String) extends Donut3(name)

  // Donut3 apply() method as a factory
  object Donut3 {
    def apply(name: String): Donut3 = {
      name match {
        case "Glazed Donut" => new GlazedDonut(name)
        case "Vanilla Donut" => new VanillaDonut(name)
        case _ => new Donut3(name)
      }
    }
  }

  val glazedDonut3 = Donut3("Glazed Donut")
  println(s"The class type of glazedDonut3 = ${glazedDonut3.getClass}") // notice the class name
  glazedDonut3.printName()

  val vanillaDonut3 = Donut3("Vanilla Donut")
  println(s"The class type of vanillaDonut3 = ${vanillaDonut3.getClass}") // notice the class name
  vanillaDonut3.printName()



  println("\nstep 6: Understand linearization when using class inheritance")
  class Donut4(name: String) {
    def printName(): Unit = println("I'm Donut4")
  }

  class GlazedDonut4(name: String) extends Donut4(name) // class does not override printName method

  class VanillaDonut4(name: String) extends Donut4(name) { // this class overrides the printName method
    override def printName() = println("I'm Vanilla Donut")
  }

  new GlazedDonut4("glazed").printName()
  new VanillaDonut4("vanilla").printName()



  println("Tip: Code smell for mutations by using var")
  class Donut5(var name: String) {
    def nameBuilder(): Unit = name = s"$name Donut"

    def printName(): Unit = println(s"name = $name")
  }

  val plainDonut = new Donut5("plain")
  plainDonut.printName()  // name before calling nameBuilder() method = plain
  plainDonut.nameBuilder()
  plainDonut.printName() // name after calling nameBuilder() method = plain Donut // we have internal mutation
}
