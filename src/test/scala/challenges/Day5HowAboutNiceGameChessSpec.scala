package challenges

import org.scalatest.{FeatureSpec, Matchers}

class Day5HowAboutNiceGameChessSpec extends FeatureSpec with Matchers {

  feature("Part 1") {
    scenario("Scenario 1") {
      val actualInput =
        """
          |abc
        """.stripMargin

      Day5HowAboutNiceGameChess.partOne(actualInput, 3231000) should be("18f47a30")
    }

    scenario("Result") {
      val actualInput =
        """
          |ojvtpuvg
        """.stripMargin

      val result = Day5HowAboutNiceGameChess.partOne(actualInput)
      println(s"Day 5 Part 1: $result")
    }
  }

  feature("Part 2") {
    scenario("Scenario 1") {
      val actualInput =
        """
          |abc
        """.stripMargin

      Day5HowAboutNiceGameChess.partTwo(actualInput, 3231000) should be("05ace8e3")
    }

    scenario("Result") {
      val actualInput =
        """
          |ojvtpuvg
        """.stripMargin

      val result = Day5HowAboutNiceGameChess.partTwo(actualInput)
      println(s"Day 5 Part 2: $result")
    }
  }
}
