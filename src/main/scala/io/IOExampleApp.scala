package io

import cats.effect.{ExitCode, IO, IOApp}

object IOExampleApp extends IOApp {
  private val consumers: List[String] = (1 to 100).map(_.toString).toList

  override def run(args: List[String]): IO[ExitCode] = {
    val job = WriteToSqs("hello world")

    val manyConsumersJob = SendToConsumers.writeToConsumers(consumers)

//    val repeatingJob = IORepeater.repeat(job, 10.seconds)

    manyConsumersJob.map(_ => ExitCode.Success)
  }
}
