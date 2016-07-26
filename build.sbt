name := """gatlingSamples"""

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.2.0",
  "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.2.0" % "test",
  "io.gatling"            % "gatling-test-framework"    % "2.2.0" % "test",
  "org.scalatest" %% "scalatest" % "2.2.4" % "test"
)

enablePlugins(GatlingPlugin)