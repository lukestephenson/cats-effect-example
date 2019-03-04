package monix

import monix.eval.Task

object WriteToSqs {
  def apply(message: String): Task[Unit] = {
    Task {
      Thread.sleep(1000)
      println(s"Sending to SQS $message")
    }
  }
}
