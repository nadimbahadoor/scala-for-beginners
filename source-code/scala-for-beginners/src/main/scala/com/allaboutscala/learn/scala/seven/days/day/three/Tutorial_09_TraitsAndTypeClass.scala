package com.allaboutscala.learn.scala.seven.days.day.three

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  *  Tutorial: Learn How To Use Implicit Class - Extension Methods
  *
  *  http://allaboutscala.com/tutorials/chapter-3-beginner-tutorial-using-classes-scala/scala-tutorial-learn-use-implicit-class-extension-methods/
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
object Tutorial_09_TraitsAndTypeClass extends App {

  // Step 1: Define some custom types to model your particular domain
  case class Donut(name: String, price: Double, productCode: Option[Long] = None)
  case class Cupcake(name: String)



  // Step 2: Use a trait as the contract for a given feature
  trait UniversalId[T] {
    def uuid(t: T): String
  }



  // Step 3: Create the Companion Object and apply() method for the trait
  object UniversalId {
    def apply[T](implicit id: UniversalId[T]): UniversalId[T] = id

    // Step 4: Create implicit instances for your relevant types
    object instances {
      def instance[T](func: T => String): UniversalId[T] =
        new UniversalId[T] {
          override def uuid(t: T): String = func(t)
        }

      implicit val donutId: UniversalId[Donut] =
        instance(donut => s"${donut.name} - ${donut.name.hashCode}")

      implicit val cupcakeId: UniversalId[Cupcake] =
        instance(cupcake => s"${cupcake.name} - ${cupcake.name.hashCode}")
    }

    // Step 5: Use an Implicit Class to wire the uuid method from Step 2
    object ops {
      implicit class UniversalIdOps[T: UniversalId](t: T) {
        def uniqueId = UniversalId[T].uuid(t)
      }
    }
  }


  // 6: Type Class in action
  import UniversalId.ops._
  import UniversalId.instances._

  val plainDonut = Donut("Plain Donut", 1.50)
  println(plainDonut.uniqueId)

  val cupcake = Cupcake("Vanilla Cupcake")
  println(cupcake.uniqueId)



  // Tip
  implicit val stringId: UniversalId[String] =
    new UniversalId[String] {
      override def uuid(s: String) = s"$s - ${s.hashCode}"
    }

  val someString = "Awesome Donut"
  println(someString.uniqueId)
}
