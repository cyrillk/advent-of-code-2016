package challenges

/**
  * http://adventofcode.com/2016/day/6
  */
object Day6SignalsAndNoise {

  case class Group(char: Char, size: Int)

  private val orderMin = new Ordering[Group] {
    def compare(self: Group, that: Group): Int =
      that.size compare self.size match {
        case 0 => self.char compare that.char
        case c => c
      }
  }

  private val orderMax = new Ordering[Group] {
    def compare(self: Group, that: Group): Int =
      self.size compare that.size match {
        case 0 => self.char compare that.char
        case c => c
      }
  }

  def partOne(input: String): String = {
    val data = clean(input).map(_.toCharArray).transpose
    val result = data.map(a => a.groupBy(s => s).map(s => Group(s._1, s._2.length))).map(s => s.max(orderMax))
    result.map(s => s.char).mkString
  }

  def partTwo(input: String): String = {
    val data = clean(input).map(_.toCharArray).transpose
    val result = data.map(a => a.groupBy(s => s).map(s => Group(s._1, s._2.length))).map(s => s.max(orderMin))
    result.map(s => s.char).mkString
  }

  private def clean(input: String) = {
    input.lines.map(_.trim).filterNot(_.isEmpty).toArray
  }
}
