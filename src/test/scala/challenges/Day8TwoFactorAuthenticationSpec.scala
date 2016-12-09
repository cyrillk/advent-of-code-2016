package challenges

import org.scalatest.{FeatureSpec, Matchers}

class Day8TwoFactorAuthenticationSpec extends FeatureSpec with Matchers with BunnySuite {

  feature("Part 1") {
    scenario("Scenario 1") {
      val actualInput =
        """
          |rect 3x2
        """.stripMargin

      Day8TwoFactorAuthentication.partOne(actualInput) should be(6)
    }

    scenario("Scenario 2") {
      val actualInput =
        """
          |rect 3x2
          |rotate column x=1 by 1
        """.stripMargin

      Day8TwoFactorAuthentication.partOne(actualInput) should be(6)
    }

    scenario("Scenario 3") {
      val actualInput =
        """
          |rect 3x2
          |rotate column x=1 by 1
          |rotate row y=0 by 4
          |rotate column x=1 by 1
        """.stripMargin

      Day8TwoFactorAuthentication.partOne(actualInput) should be(6)
    }

    scenario("Result") {
      val actualInput = readInput("Day8TwoFactorAuthentication.txt")
      val result = Day8TwoFactorAuthentication.partOne(actualInput)
      println(s"Day 8 Part 1: $result")
    }
  }

  feature("Part 2") {
    scenario("Result") {
      val actualInput = readInput("Day8TwoFactorAuthentication.txt")
      val result = Day8TwoFactorAuthentication.partTwo(actualInput)
      println(s"Day 9 Part 2: $result")
    }
  }
}
