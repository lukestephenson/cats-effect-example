package io

import cats.effect.{IO, Timer}

import scala.concurrent.duration.FiniteDuration

object IORepeater {
  def repeat[T](job: IO[T], retryInterval: FiniteDuration)(implicit timer: Timer[IO]) : IO[T] = {
    def run(): IO[T] = {
      def runAgain(): IO[T] = IO.sleep(retryInterval).flatMap(_ => run())

      job.attempt.flatMap {
        case Right(_) => runAgain()
        case Left(error) =>
          IO(println(s"Job returned error: ${error.getMessage}")).flatMap(_ => runAgain)
      }
    }

    run()
  }
}
