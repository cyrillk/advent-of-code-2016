package challenges

import java.io.InputStream

import org.scalatest.{FeatureSpec, Matchers}

class Day3SquaresWithThreeSidesSpec extends FeatureSpec with Matchers {

  feature("Part 1") {
    scenario("Scenario 1") {
      val actualInput =
        """
          |5 10 25
        """.stripMargin

      Day3SquaresWithThreeSides.partOne(actualInput) should be(0)
    }

    scenario("Scenario 2") {
      val actualInput =
        """
          |2 3 4
        """.stripMargin

      Day3SquaresWithThreeSides.partOne(actualInput) should be(1)
    }

    scenario("Scenario 3") {
      val actualInput =
        """
          |5 10 25
          |2 3 4
        """.stripMargin

      Day3SquaresWithThreeSides.partOne(actualInput) should be(1)
    }

    scenario("Result") {
      val stream: InputStream = getClass.getResourceAsStream("/Day3SquaresWithThreeSides.txt")
      val actualInput = scala.io.Source.fromInputStream(stream).getLines().toList.mkString("\n")
      val result = Day3SquaresWithThreeSides.partOne(actualInput)
      println(s"Day 3 Part 1: $result")
    }
  }

  feature("Part 2") {
    scenario("Scenario 1") {
      val actualInput =
        """
          |101 301 501
          |102 302 502
          |103 303 503
          |201 401 601
          |202 402 602
          |203 403 603
        """.stripMargin

      Day3SquaresWithThreeSides.partTwo(actualInput) should be(6)
    }

    scenario("Result") {
      val stream: InputStream = getClass.getResourceAsStream("/Day3SquaresWithThreeSides.txt")
      val actualInput = scala.io.Source.fromInputStream(stream).getLines().toList.mkString("\n")
      val result = Day3SquaresWithThreeSides.partTwo(actualInput)
      println(s"Day 3 Part 2: $result")
    }
  }
}
