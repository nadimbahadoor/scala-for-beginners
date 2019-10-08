package com.allaboutscala.learn.scala.seven.days.day.four

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Learn How To Use Scala's Immutable BitSet
  *
  * [[http://allaboutscala.com/tutorials/chapter-6-beginner-tutorial-using-scala-immutable-collection/scala-tutorial-learn-use-immutable-bitset/ Tutorial]]
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
object Tutorial_14_Immutable_BitSet extends App {

  import scala.collection.immutable.BitSet
  println("Step 1: How to initialize a BitSet with 3 elements")
  val bitSet1 = BitSet(3, 2, 0)
  println(s"Elements of bitSet1 = $bitSet1")



  println("\nStep 2: How to check specific elements in BitSet")
  println(s"Element 0 = ${bitSet1(0)}")
  println(s"Element 2 = ${bitSet1(2)}")
  println(s"Element 3 = ${bitSet1(3)}")



  println("\nStep 3: How to add elements in BitSet using +")
  val bitSet2 = bitSet1 + 13 + 13
  println(s"Adding elements to BitSet using + = $bitSet2")
  // NOTE: we only have one 13 element and not two as BitSet is distinct



  println("\nStep 4: How to add two BitSets together using ++")
  val bitSet3 = bitSet1 ++ BitSet(13, 14, 15, 16, 17)
  println(s"Add two BitSets together using ++ = $bitSet3")



  println("\nStep 5: How to remove element in BitSet using -")
  val bitSet4 = bitSet1 - 0
  println(s"BitSet without element 0 = $bitSet4")



  println("\nStep 6: How to find the intersection between two BitSets using &")
  val bitSet5 = BitSet(0, 2, 4)
  println(s"Intersection of bitSet1 and bitSet5 = ${bitSet1 & bitSet5}")



  println("\nStep 7: How to find the difference between two BitSets using &~")
  println(s"Difference of bitSet1 and bitSet5 = ${bitSet1 &~ bitSet5}")



  println("\nStep 8: How to initialize an empty BitSet")
  val emptyBitSet = BitSet.empty
  println(s"Empty BitSet = $emptyBitSet")



  println("\nStep 9: XOR using BitSet")
  val bitset1 = BitSet(1, 2, 3, 4, 5)
  val bitset2 = BitSet(1, 3, 5)
  val xor = bitset1 ^ bitset2
  println(s"XOR between bitset1 and bitset2 = $xor")
}
