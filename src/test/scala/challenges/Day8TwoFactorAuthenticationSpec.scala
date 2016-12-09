package challenges

import org.scalatest.{FeatureSpec, Matchers}

class Day8TwoFactorAuthenticationSpec extends FeatureSpec with Matchers with BunnySuite {

  feature("Part 1") {
    scenario("Scenario 1") {
      val actualInput =
        """
        """.stripMargin

      Day8TwoFactorAuthentication.partOne(actualInput) should be("")
    }

    scenario("Result") {
      val actualInput = readInput("Day8TwoFactorAuthentication.txt")
      val result = Day7InternetProtocolVersion7.partTwo(actualInput)
      println(s"Day 8 Part 1: $result")
    }
  }

  feature("Part 2") {
    scenario("Scenario 1") {
      val actualInput =
        """
        """.stripMargin

      Day8TwoFactorAuthentication.partTwo(actualInput) should be("")
    }

    scenario("Result") {
      val actualInput = readInput("Day8TwoFactorAuthentication.txt")
      val result = Day7InternetProtocolVersion7.partTwo(actualInput)
      println(s"Day 9 Part 2: $result")
    }
  }
}
