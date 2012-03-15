name := "anagram"

organization := "no.bouvet.bigone"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.9.1"

libraryDependencies := Seq(
  "org.specs2" %% "specs2" % "1.7.1" % "test"
)

initialCommands := "import no.bouvet.bigone.anagram._"
