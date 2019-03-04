package io

import cats.effect.{ExitCode, IO, IOApp}

object IOExampleApp extends IOApp {
  private val consumers: List[String] = (1 to 10).map(_.toString).toList

  override def run(args: List[String]): IO[ExitCode] = {
    val job = WriteToSqs("hello world")

    job.map(_ => ExitCode.Success)
  }
}
