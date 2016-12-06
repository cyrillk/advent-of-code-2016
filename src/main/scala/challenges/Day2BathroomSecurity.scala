package challenges

/**
  * http://adventofcode.com/2016/day/2
  */
object Day2BathroomSecurity {

  case class Point(x: Int, y: Int)

  def partOne(input: String): String = {

    val a = Array.ofDim[String](3, 3)

    // rows, columns
    a(0)(0) = "1"
    a(0)(1) = "2"
    a(0)(2) = "3"
    a(1)(0) = "4"
    a(1)(1) = "5"
    a(1)(2) = "6"
    a(2)(0) = "7"
    a(2)(1) = "8"
    a(2)(2) = "9"

    val ready = input.lines.toList.map(_.trim).filterNot(_.isEmpty)

    val start = Point(1, 1)

    val result = ready.foldLeft(("", start)) { case ((acc, where), line) =>
      val stop = line.toCharArray.foldLeft(where) {
        case (p, 'U') if p.y > 0 => Point(p.x, p.y - 1)
        case (p, 'D') if p.y < 2 => Point(p.x, p.y + 1)
        case (p, 'L') if p.x > 0 => Point(p.x - 1, p.y)
        case (p, 'R') if p.x < 2 => Point(p.x + 1, p.y)
        case (p, _) => p
      }
      (acc.concat(a(stop.y)(stop.x)), stop)
    }

    result._1
  }

  def partTwo(input: String): String = {

    val a = Array.ofDim[String](5, 5)

    // rows, columns
    a(0)(0) = ""
    a(0)(1) = ""
    a(0)(2) = "1"
    a(0)(3) = ""
    a(0)(4) = ""
    a(1)(0) = ""
    a(1)(1) = "2"
    a(1)(2) = "3"
    a(1)(3) = "4"
    a(1)(4) = ""
    a(2)(0) = "5"
    a(2)(1) = "6"
    a(2)(2) = "7"
    a(2)(3) = "8"
    a(2)(4) = "9"
    a(3)(0) = ""
    a(3)(1) = "A"
    a(3)(2) = "B"
    a(3)(3) = "C"
    a(3)(4) = ""
    a(4)(0) = ""
    a(4)(1) = ""
    a(4)(2) = "D"
    a(4)(3) = ""
    a(4)(4) = ""

    val ready = input.lines.toList.map(_.trim).filterNot(_.isEmpty)

    val start = Point(0, 2)

    val result = ready.foldLeft(("", start)) { case ((acc, where), line) =>
      val stop = line.toCharArray.foldLeft(where) {
        case (p, 'U') if p.y > 0 && a(p.y - 1)(p.x) != "" => Point(p.x, p.y - 1)
        case (p, 'D') if p.y < 4 && a(p.y + 1)(p.x) != "" => Point(p.x, p.y + 1)
        case (p, 'L') if p.x > 0 && a(p.y)(p.x - 1) != "" => Point(p.x - 1, p.y)
        case (p, 'R') if p.x < 4 && a(p.y)(p.x + 1) != "" => Point(p.x + 1, p.y)
        case (p, _) => p
      }
      (acc.concat(a(stop.y)(stop.x)), stop)
    }

    result._1
  }
}
