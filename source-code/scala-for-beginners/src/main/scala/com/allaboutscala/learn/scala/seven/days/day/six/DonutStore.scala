package com.allaboutscala.learn.scala.seven.days.day.six

import scala.concurrent.Future

class DonutStore {

  def favoriteDonut(): String = "vanilla donut"

  def donuts(): Seq[String] = Seq("vanilla donut", "plain donut", "glazed donut")

  def printName(): Unit = {
    throw new IllegalStateException("Some Error")
  }

  def donutPrice(donut: String): Option[Double] = {
    val prices = Map(
      "vanilla donut" -> 2.0,
      "plain donut" -> 1.0,
      "glazed donut" -> 3.0
    )
    val priceOfDonut = prices.get(donut)
    priceOfDonut.map { price => price * (1 - discountByDonut(donut)) }
  }

  private def discountByDonut(donut: String): Double = {
    val discounts = Map(
      "vanilla donut" -> 0.2,
      "plain donut" -> 0.1,
      "glazed donut" -> 0.3
    )
    discounts.getOrElse(donut, 0)
  }

  import scala.concurrent.ExecutionContext.Implicits.global
  def donutSalesTax(donut: String): Future[Double] = Future {
    Thread.sleep(3000) // assume an external call to calculate sales tax
    0.15
  }
}
