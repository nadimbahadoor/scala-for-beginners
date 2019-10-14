package com.allaboutscala.donutstore.data

import com.allaboutscala.donutstore.common.{Donut, Donuts}
import org.scalatest._
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.time._


/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorials and feedback from readers at http://allaboutscala.com.
  *
  * - Test class to validate the Create Read Update and Delete (CRUD) operations as exposed by the [[DonutDao]]
  *   and [[DataApi]] operations.
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

class DonutDaoTest
  extends WordSpec
    with Matchers
    with BeforeAndAfterAll
    with ScalaFutures {

  private var dataApi: DataApi = _
  private val plainDonut = Donut("plain donut", List("sugar", "flour"))
  implicit override val patienceConfig: PatienceConfig =
    PatienceConfig(timeout = Span(5, Seconds), interval = Span(500, Millis))

  /** You would typically have to initialize a session versus some storage layer **/
  override def beforeAll(): Unit = {
    dataApi = new DonutDao()
  }



  "DonutDao CRUD operation" can {
    "Create a new donut" in {
      whenReady(dataApi.createDonut(plainDonut)) { donutCreated  =>
        donutCreated shouldEqual "plain donut has been added to the database."
      }
    }

    "Read donuts" in {
      whenReady(dataApi.fetchDonuts()) { donuts =>
        donuts shouldEqual Donuts(Seq(plainDonut))
      }
    }

    "Update ingredients of donut" in {
      val updatedPlainDonut = plainDonut.copy(ingredients = List("sugar", "flour", "syrup"))
      whenReady(dataApi.updateDonutIngredients(updatedPlainDonut)) { updatedMsg =>
        updatedMsg shouldEqual "Updated donut ingredients for donutName = plain donut"
      }

      whenReady(dataApi.fetchDonuts()) { donuts =>
        donuts shouldEqual Donuts(Seq(updatedPlainDonut))
      }
    }

    "Delete donut" in {
      whenReady(dataApi.deleteDonut("plain donut")) { deletedMsg =>
        println(deletedMsg)
        deletedMsg shouldEqual "Deleted plain donut from database."
      }

      whenReady(dataApi.fetchDonuts()) { donuts =>
        donuts shouldEqual Donuts(List())
      }
    }
  }



  /** You would typically have to close the given session with the storage layer **/
  override def afterAll(): Unit = {
    // For example, you may have a method such as: dataApi.close()
  }
}
