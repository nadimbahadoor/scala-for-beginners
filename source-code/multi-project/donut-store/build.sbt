// ARTIFACTS or DEPENDENCIES
lazy val artifacts = new {

  // artifacts versions
  val scalaV            = "2.13.0"
  val donutStoreV       = "1.0"
  val akkaActorV        = "2.5.23"
  val akkaHttpV         = "10.1.8"
  val akkaHttpTestkitV  = "10.1.8"
  val scalaLoggingV     = "3.9.2"
  val logbackV          = "1.2.3"
  val scalaTestV        = "3.0.8"
  val pureconfigV       = "0.11.1"


  // artifacts
  val akkaHttp = Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaActorV,
    "com.typesafe.akka" %% "akka-stream" % akkaActorV,
    "com.typesafe.akka" %% "akka-http" % akkaHttpV,
    "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpV,
    "com.typesafe.akka" %% "akka-testkit" % akkaActorV % "test",
    "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpTestkitV % "test"
  )

  val scalaLogging = Seq(
    "com.typesafe.scala-logging" %% "scala-logging" % scalaLoggingV,
    "ch.qos.logback" % "logback-classic" % logbackV
  )

  val scalatest = Seq("org.scalatest" %% "scalatest" % scalaTestV % "test")
  val pureconfig = Seq("com.github.pureconfig" %% "pureconfig" % pureconfigV)
}



// SETTINGS
lazy val commonSettings = Seq(
  organization          := "com.allaboutscala.donutstore",
  scalaVersion          := artifacts.scalaV,
  version               := artifacts.donutStoreV,
  logLevel              := Level.Info,

  scalacOptions ++= Seq(
    "-encoding", "UTF-8",
    "-Xfatal-warnings",
    "-deprecation",
    "-feature",
    "-unchecked",
    "-language:implicitConversions",
    "-language:higherKinds",
    "-language:existentials",
    "-language:postfixOps",
    "-Ywarn-dead-code"
  )
)

lazy val testSettings = Seq(
  fork in Test := false,
  parallelExecution in Test := false,
  libraryDependencies ++= artifacts.scalatest
)


// PROJECTS
lazy val donutStore = project
  .in(file("."))
  .settings(commonSettings: _*)
  .settings(testSettings: _*)
  .aggregate(common, config, data, httpClient, httpServer)

lazy val common = (project in file("common"))
  .settings(commonSettings: _*)
  .settings(libraryDependencies ++= artifacts.akkaHttp)

lazy val config = (project in file("config"))
  .settings(commonSettings: _*)
  .settings(testSettings: _*)
  .settings(libraryDependencies ++= artifacts.pureconfig)
  .dependsOn(common)

lazy val data = (project in file("data"))
  .settings(commonSettings: _*)
  .settings(testSettings: _*)
  .settings(libraryDependencies ++= artifacts.scalaLogging)
  .dependsOn(common)

lazy val httpClient = (project in file("httpClient"))
  .settings(commonSettings: _*)
  .settings(libraryDependencies ++= artifacts.akkaHttp)
  .dependsOn(common)


lazy val httpServer = (project in file("httpServer"))
  .settings(commonSettings: _*)
  .settings(testSettings: _*)
  .settings(libraryDependencies ++= artifacts.akkaHttp ++ artifacts.scalaLogging)
  .dependsOn(common, config, data)