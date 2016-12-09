package challenges

/**
  * http://adventofcode.com/2016/day/1
  */
object Day1NoTimeForTaxicab {

  case class Point(x: Int, y: Int)

  sealed trait Direction

  object North extends Direction

  object South extends Direction

  object West extends Direction

  object East extends Direction

  sealed trait Face

  object Right extends Face

  object Left extends Face

  case class Move(face: Face, steps: Int)

  def partOne(input: String): Int = {

    val moves = parseMoves(input)

    val end = moves.foldLeft[(Point, Direction)]((Point(0, 0), North)) {
      case ((p, North), Move(Right, n)) => (Point(p.x + n, p.y), East)
      case ((p, North), Move(Left, n)) => (Point(p.x - n, p.y), West)

      case ((p, East), Move(Right, n)) => (Point(p.x, p.y - n), South)
      case ((p, East), Move(Left, n)) => (Point(p.x, p.y + n), North)

      case ((p, West), Move(Right, n)) => (Point(p.x, p.y + n), North)
      case ((p, West), Move(Left, n)) => (Point(p.x, p.y - n), South)

      case ((p, South), Move(Right, n)) => (Point(p.x - n, p.y), West)
      case ((p, South), Move(Left, n)) => (Point(p.x + n, p.y), East)
    }

    Math.abs(end._1.x) + Math.abs(end._1.y)
  }

  def partTwo(input: String): Int = {

    val moves = parseMoves(input)

    val start: (Seq[Point], Direction) = (Point(0, 0) :: Nil, North)

    val route = moves.foldLeft(start) {
      case ((p, North), Move(Right, n)) => (p ++ (1 to n).map(z => Point(p.last.x + z, p.last.y)), East)
      case ((p, North), Move(Left, n)) => (p ++ (1 to n).map(z => Point(p.last.x - z, p.last.y)), West)

      case ((p, East), Move(Right, n)) => (p ++ (1 to n).map(z => Point(p.last.x, p.last.y - z)), South)
      case ((p, East), Move(Left, n)) => (p ++ (1 to n).map(z => Point(p.last.x, p.last.y + z)), North)

      case ((p, West), Move(Right, n)) => (p ++ (1 to n).map(z => Point(p.last.x, p.last.y + z)), North)
      case ((p, West), Move(Left, n)) => (p ++ (1 to n).map(z => Point(p.last.x, p.last.y - z)), South)

      case ((p, South), Move(Right, n)) => (p ++ (1 to n).map(z => Point(p.last.x - z, p.last.y)), West)
      case ((p, South), Move(Left, n)) => (p ++ (1 to n).map(z => Point(p.last.x + z, p.last.y)), East)
    }

    val steps = route._1

    val duplicates = steps.foldRight((Set.empty[Point], Seq.empty[Point])) { case (cur, (seen, dups)) =>
      if (seen(cur)) (seen, dups :+ cur) else (seen + cur, dups)
    }._2

    Math.abs(duplicates.last.x) + Math.abs(duplicates.last.y)
  }

  private def parseMoves(input: String) = {
    input.split(",").map(_.trim).map {
      case s if s.startsWith("R") => Move(Right, steps(s))
      case s if s.startsWith("L") => Move(Left, steps(s))
      case _ => throw new Exception("Unsupported move")
    }
  }

  private def steps(s: String) = s.substring(1).toInt
}
