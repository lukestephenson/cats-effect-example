package monix

import cats.effect.ExitCode
import monix.eval.{Task, TaskApp}

object TaskExampleApp extends TaskApp {
  private val consumers: List[String] = (1 to 10).map(_.toString).toList

  override def run(args: List[String]): Task[ExitCode] = {
    val job = WriteToSqs("hello world")

    job.map(_ => ExitCode.Success)
  }
}
