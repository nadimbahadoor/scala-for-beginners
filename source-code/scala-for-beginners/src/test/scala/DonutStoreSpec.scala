import com.allaboutscala.learn.scala.seven.days.day.six.DonutStore
import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.time.{Millis, Seconds, Span}

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: ScalaTest
  *
  * [[http://allaboutscala.com/scala-cheatsheet/#scalatest-introduction Tutorial]]
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
class DonutStoreSpec extends FlatSpec with Matchers with ScalaFutures {

  behavior of "DonutStore class"

  "Dummy boolean test" should "be true" in {
    "DonutStore" shouldEqual "DonutStore"
  }

  val donutStore = new DonutStore()


  "favorite donut" should "match vanilla donut" in {
    donutStore.favoriteDonut() shouldEqual "vanilla donut"
    donutStore.favoriteDonut() === "vanilla donut"
    donutStore.favoriteDonut() should not equal "plain donut"
    donutStore.favoriteDonut() should not be "plain donut"
    donutStore.favoriteDonut() !== "Plain donut"
  }


  "Length and size of donuts" should "be equal to 3" in {
    val donuts = donutStore.donuts()
    donuts should have size 3
    donuts should have length 3
  }


  "Examples of boolean assertions" should "be valid" in {
    val donuts = donutStore.donuts()
    donuts.nonEmpty shouldEqual true
    donuts.size === 3
    donuts.contains("chocolate donut") shouldEqual false
    donuts should not be empty
    donutStore.favoriteDonut() should not be empty
  }


  "Examples of collection assertions" should "be valid" in {
    val donuts = donutStore.donuts()
    donuts should contain ("plain donut")
    donuts should not contain "chocolate donut"
    donuts shouldEqual Seq("vanilla donut", "plain donut", "glazed donut")
  }


  "Examples of type assertions" should "be valid" in {
    donutStore shouldBe a [DonutStore]
    donutStore.favoriteDonut() shouldBe a [String]
    donutStore.donuts() shouldBe a [Seq[_]]
  }


  "Method DonutStore.printName()" should "throw IllegalStateException" in {
    intercept[java.lang.IllegalStateException] {
      donutStore.printName()
    }
  }


  "Exception thrown by method printName()" should "contain message Some Error" in {
    val exception = the [java.lang.IllegalStateException] thrownBy {
      donutStore.printName()
    }
    // here we verify that the exception class and the internal message
    exception.getClass shouldEqual classOf[java.lang.IllegalStateException]
    exception.getMessage should include ("Some Error")
  }


  "Exception thrown by method printName()" should "contain message Some Error using ScalaTest should have message methods" in {
    the [java.lang.IllegalStateException] thrownBy {
      donutStore.printName()
    } should have message "Some Error"
  }


  an [java.lang.IllegalStateException] should be thrownBy {
    donutStore.printName()
  }


  "Example of testing private method" should "be valid" in {
    val priceWithDiscount = donutStore.donutPrice("vanilla donut")
    priceWithDiscount shouldEqual Some(1.6)

    // test the private method discountByDonut()
    import org.scalatest.PrivateMethodTester._
    val discountByDonutMethod = PrivateMethod[Double]('discountByDonut)
    val vanillaDonutDiscount = donutStore invokePrivate discountByDonutMethod("vanilla donut")
    vanillaDonutDiscount shouldEqual 0.2
  }


  implicit override val patienceConfig: PatienceConfig =
    PatienceConfig(timeout = Span(5, Seconds), interval = Span(500, Millis))

  "Example of testing asynchronous futures" should "be valid" in {
    val donutSalesTaxFuture = donutStore.donutSalesTax("vanilla donut")

    whenReady(donutSalesTaxFuture) { salesTaxForVanillaDonut =>
      println(salesTaxForVanillaDonut)
      salesTaxForVanillaDonut shouldEqual 0.15
    }
  }
}
