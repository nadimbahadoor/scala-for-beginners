package com.allaboutscala.learn.scala.seven.days.day.three


/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Traits, Companion Object, Factory Pattern
  *
  * [[http://allaboutscala.com/tutorials/chapter-5-traits/scala-traits-companion-object-factory-pattern/]]
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
object Tutorial_08_TraitFactoryPattern extends App {

  // Step 1: Define a top-level closure to hold various types of cakes
  object Cakes {
    // Step 2: Define a base trait to represent a Cake
    sealed trait Cake {
      def name: String
    }

    // Step 3: Define sub-types of Cake
    final case class UnknownCake() extends Cake {
      override def name: String = "Unknown Cake ... but still delicious!"
    }

    final case class Cupcake() extends Cake {
      override def name: String = "Cupcake"
    }

    final case class Donut() extends Cake {
      override def name: String = "Donut"
    }
  }



  // Step 4: The Factory Pattern in action to create various types of cake")
  object CakeFactory {
    import Cakes._
    def apply(cake: String): Cake = {
      cake match {
        case "cupcake" => new Cupcake
        case "donut" => new Donut
        case _ => new UnknownCake
      }
    }
  }


  // Step 5: Call the CakeFactory
  println(s"A cupcake = ${CakeFactory("cupcake").name}")
  println(s"A donut = ${CakeFactory("donut").name}")
  println(s"Unknown cake = ${CakeFactory("coconut tart").name}")
}
