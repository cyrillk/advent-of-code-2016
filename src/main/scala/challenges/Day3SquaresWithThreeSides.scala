package challenges

/**
  * http://adventofcode.com/2016/day/3
  */
object Day3SquaresWithThreeSides {

  case class Triangle(a: Int, b: Int, c: Int)

  def partOne(input: String): Int = {
    val candidates = prepare(input).map(s => Triangle(s(0), s(1), s(2)))
    candidates.count(valid)
  }

  def partTwo(input: String): Int = {
    val candidates = prepare(input).grouped(3).map(_.transpose).flatten.map(s => Triangle(s(0), s(1), s(2)))
    candidates.count(valid)
  }

  private def prepare(input: String) = {
    input.lines.map(_.trim).filterNot(_.isEmpty).map(_.split("""\s+""").map(_.toInt))
  }

  private def valid(item: Triangle) = {
    item.a + item.b > item.c && item.a + item.c > item.b && item.b + item.c > item.a
  }
}
