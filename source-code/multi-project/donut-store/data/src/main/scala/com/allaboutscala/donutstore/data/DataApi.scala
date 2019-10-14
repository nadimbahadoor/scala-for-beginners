package com.allaboutscala.donutstore.data


import com.allaboutscala.donutstore.common.{Donut, Donuts}
import com.typesafe.scalalogging.LazyLogging

import scala.collection.concurrent.TrieMap
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorials and feedback from readers at http://allaboutscala.com.
  *
  * - The trait [[DataApi]] displays the Create Read Update and Delete (CRUD) operations for our Donut API, and
  *   the class [[DonutDao]] is naturally the concrete implementation.
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

trait DataApi {
  def createDonut(query: Donut): Future[String]

  def fetchDonuts(): Future[Donuts]

  def updateDonutIngredients(donut: Donut): Future[String]

  def deleteDonut(donutName: String): Future[String]
}


class DonutDao extends DataApi with LazyLogging {
  /**
    * For convenience, we are using scala.collection.concurrent.TrieMap to simulate the Donut data points being
    * stored within an external data source.
    */
  private val donutDatabase = TrieMap.empty[String, Donut]

  override def createDonut(donut: Donut): Future[String] = Future {
    logger.info(s"Create donut = $donut")
    val donutExists = donutDatabase.putIfAbsent(donut.name, donut)
    donutExists match {
      case Some(d) => s"${d.name} already exists in database."
      case None => s"${donut.name} has been added to the database."
    }
  }

  override def fetchDonuts(): Future[Donuts] = Future {
    logger.info("Fetching all donuts")
    Donuts(donutDatabase.values.toSeq)
  }

  override def updateDonutIngredients(donut: Donut): Future[String] = Future {
    logger.info(s"Updating ingredients = ${donut.ingredients} for donutName = ${donut.name}")
    val someDonut = donutDatabase.get(donut.name)
    someDonut match {
      case Some(d) =>
        donutDatabase.replace(d.name, donut)
        s"Updated donut ingredients for donutName = ${donut.name}"

      case None =>
        s"Donut ${donut.name} does not exist in database. The update operation was not run."
    }
  }

  override def deleteDonut(donutName: String): Future[String] = Future {
    logger.info("Deleting donut = $donutName")
    val someDonut = donutDatabase.get(donutName)
    someDonut match {
      case Some(d) =>
        donutDatabase.remove(d.name)
        s"Deleted ${d.name} from database."

      case None =>
        s"$donutName does not exist in database. The delete operation was not run."
    }
  }
}

