package io

import cats.effect.{ContextShift, IO, Timer}
import cats.implicits._

object SendToConsumers {
  def writeToConsumers(consumerIds: List[String])(implicit contextShift: ContextShift[IO], timer: Timer[IO]): IO[Unit] = {
    consumerIds.parTraverse_(id => WriteToSqs(s"Hello $id"))
  }
}
