name := "scala-for-beginners"

version := "0.1"

scalaVersion := "2.13.0"

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-parallel-collections" % "0.2.0",
  "org.scalatest" %% "scalatest" % "3.0.8" % Test
)