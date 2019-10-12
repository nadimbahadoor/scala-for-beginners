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


// PROJECT or PROJECTS
lazy val donutStore = (project in file("."))
  .settings(name:= "donut-store")
  .settings(commonSettings: _*)
  .settings(testSettings: _*)
  .settings(libraryDependencies ++= artifacts.scalaLogging ++ artifacts.akkaHttp ++ artifacts.pureconfig)
  .settings(resolvers += Resolver.sonatypeRepo("releases"))
  .settings(resolvers += Resolver.sonatypeRepo("snapshots"))