package com.allaboutscala.learn.scala.seven.days.day.one.scala.basics

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
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
object Tutorial_13_JavaWithScala extends App {
  println("Step 1: Create a Java class in your Scala IntelliJ project")



  println("\nStep 2: Create an instance of DonutJ Java class")
  import com.allaboutscala.learn.scala.seven.days.day.java._
  val glazedDonutName = "Glazed Donut"
  val glazedDonutProductCode = 1111L
  val glazedDonut = new DonutJ(glazedDonutName, glazedDonutProductCode)



  println("\nStep 3: Access DonutJ Java class get and set methods")
  glazedDonut.setProductCode(1010L)
  println(s"Glazed Donut product code = ${glazedDonut.getProductCode}")



  println("\nStep 4: Call DonutJ Java class print() method")
  glazedDonut.print()



  println("\nStep 5: Import and use java.util.HashMap")
  import java.util.HashMap
  val javaHashMap: java.util.HashMap[Long, String] = new HashMap[Long, String]()
  javaHashMap.put(glazedDonut.getProductCode, glazedDonut.getName)
  println(javaHashMap)

//  import scala.collection.JavaConverters._ // deprecated as of Scala 2.13.0
  import scala.jdk.CollectionConverters._
  val scalaMap: scala.collection.mutable.Map[Long, String] = javaHashMap.asScala
  println(scalaMap)

  val backToJavaHashMap: java.util.Map[Long, String] = scalaMap.asJava
  println(backToJavaHashMap)
}
