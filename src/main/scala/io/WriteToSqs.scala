package io

import cats.effect.{IO, Timer}

import scala.concurrent.duration._

object WriteToSqs {
  def apply(message: String)(implicit timer: Timer[IO]): IO[Unit] = {
    IO.sleep(1000.milliseconds).flatMap { _ =>
      IO {
        println(s"Sending to SQS $message")
      }
    }
  }
}
