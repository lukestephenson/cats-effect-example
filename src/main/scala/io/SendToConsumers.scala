package io

import cats.effect.IO
import cats.implicits._

object SendToConsumers {
  def writeToConsumers(consumerIds: List[String]): IO[Unit] = {
    consumerIds.traverse_(id => WriteToSqs(s"Hello cats-effect $id"))
  }
}
