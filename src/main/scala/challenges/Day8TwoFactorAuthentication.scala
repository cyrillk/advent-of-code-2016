package challenges

import scala.collection.mutable.ArrayBuffer

/**
  * http://adventofcode.com/2016/day/8
  */
object Day8TwoFactorAuthentication {

  private val rect = """rect (\d+)x(\d+)""".r
  private val column = """rotate column x=(\d+) by (\d+)""".r
  private val row = """rotate row y=(\d+) by (\d+)""".r

  private val yLength = 6
  private val xLength = 50

  private def moveRight(arr: ArrayBuffer[Int]) {
    val last = arr.last
    arr.prepend(last)
    arr.remove(arr.length - 1)
  }

  private def dump(arr: Seq[Seq[Int]]): Unit = {
    arr.foreach(s => println(s.map{
      case 0 => " "
      case 1 => "#"
      case _ => "ERROR"
    }.mkString(" ")))
    println
  }

  def partOne(input: String): Int = {
    val lines = clean(input)

    val result = lines.foldLeft(ArrayBuffer.fill(yLength, xLength)(0)) {
      case (screen, rect(x, y)) =>
        for (j <- 0 until y.toInt) {
          for (i <- 0 until x.toInt) {
            screen(j)(i) = 1
          }
        }
        screen
      case (screen, column(x, v)) =>
        val col = ArrayBuffer.fill(yLength)(0)

        for (j <- 0 until yLength) {
          col(j) = screen(j)(x.toInt)
        }

        for (_ <- 0 until v.toInt) {
          moveRight(col)
        }

        for (j <- 0 until yLength) {
          screen(j)(x.toInt) = col(j)
        }
        screen
      case (screen, row(y, v)) =>
        for (_ <- 0 until v.toInt) {
          moveRight(screen(y.toInt))
        }
        screen
      case (screen, _) =>
        println("no match")
        screen
    }

    dump(result)

    result.flatten.count(_ == 1)
  }

  def partTwo(input: String): Int = {
    partOne(input)
  }

  private def clean(input: String) = {
    input.lines.map(_.trim).filterNot(_.isEmpty)
  }
}
