package io

import cats.effect.IO

object WriteToSqs {
  def apply(message: String): IO[Unit] = {
    IO {
      Thread.sleep(1000)
      println(s"Sending to SQS $message")
    }
  }
}
