package challenges

/**
  * http://adventofcode.com/2016/day/4
  */
object Day4SecurityThroughObscurity {

  case class Record(name: String, sector: Int, checksum: String)

  case class Group(char: Char, size: Int)

  implicit val order = new Ordering[Group] {
    def compare(self: Group, that: Group): Int =
      that.size compare self.size match {
        case 0 => self.char compare that.char
        case c => c
      }
  }

  private val pattern = """([\w-]+)-(\d+)\[([\w-]+)\]""".r

  def partOne(input: String): Int = {
    val data = filter(clean(input).map(parse).toList.flatten)
    data.map(_.sector).sum
  }

  def partTwo(input: String, f: String): Int = {
    val data = filter(clean(input).map(parse).toList.flatten)

    val rooms = data.map { rec =>
      val room = rec.name.toList.map {
        case '-' => ' '
        case ch => ((ch.toInt - 97 + rec.sector) % 26 + 97).toChar
      }.mkString

      Record(room, rec.sector, rec.checksum)
    }

    rooms.find(_.name.contains(f)).map(_.sector).getOrElse(0)
  }

  private def parse(line: String) = {
    pattern.findAllIn(line).matchData map { m =>
      Record(m.group(1), m.group(2).toInt, m.group(3))
    }
  }

  private def filter(data: List[Record]) = {
    data.filter { s =>
      val groups = s.name.replaceAll("-", "").toList.groupBy(s => s).map(s => Group(s._1, s._2.size)).toList
      val sum = groups.sorted.take(5).map(_.char).mkString
      s.checksum == sum
    }
  }

  private def clean(input: String) = {
    input.lines.map(_.trim).filter(_.nonEmpty)
  }
}
