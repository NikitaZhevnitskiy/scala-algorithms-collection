name := "algdat"
organization := "ru.zhenik.scala.alg"
version := "1.0.0"
scalaVersion := "2.12.4"

libraryDependencies ++= {
  val scalaTestV = "3.0.4"
  Seq(
    "org.scalatest" %% "scalatest" % scalaTestV % Test
  )
}