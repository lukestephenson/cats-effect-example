package monix

import cats.implicits._
import monix.eval.Task

object SendToConsumers {
  def writeToConsumers(consumerIds: List[String]): Task[Unit] = {
    consumerIds.traverse_(id => WriteToSqs(s"Hello Monix $id"))
  }
}
