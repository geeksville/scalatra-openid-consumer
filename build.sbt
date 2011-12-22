resolvers ++= Seq(
  "Guice Maven" at "http://guice-maven.googlecode.com/svn/trunk" // required for openid dependency
)

libraryDependencies ++= Seq(
  "javax.servlet" % "servlet-api" % "2.5" % "provided",
  "org.scalatra" %% "scalatra" % "2.0.1",
  "org.openid4java" % "openid4java-consumer" % "0.9.6"
)

publishArtifact := true

organization := "com.gu"

name := "scalatra-openid-consumer"

version in ThisBuild := "0.1.1-SNAPSHOT"

publishTo <<= (version) { version: String =>
    val publishType = if (version.endsWith("SNAPSHOT")) "snapshots" else "releases"
    Some(
        Resolver.file(
            "guardian github " + publishType,
            file(System.getProperty("user.home") + "/guardian.github.com/maven/repo-" + publishType)
        )
    )
}