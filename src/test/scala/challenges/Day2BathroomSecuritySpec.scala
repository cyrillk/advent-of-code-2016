package challenges

import org.scalatest.{FeatureSpec, Matchers}

class Day2BathroomSecuritySpec extends FeatureSpec with Matchers with BunnySuite {

  feature("Part 1") {
    scenario("Basic Scenario 1") {
      val actualInput =
        """
          |ULL
        """.stripMargin

      Day2BathroomSecurity.partOne(actualInput) should be("1")
    }

    scenario("Scenario 1") {
      val actualInput =
        """
          |ULL
          |RRDDD
          |LURDL
          |UUUUD
        """.stripMargin

      Day2BathroomSecurity.partOne(actualInput) should be("1985")
    }

    scenario("Result") {
      val actualInput = readInput("Day2BathroomSecurity.txt")
      val result = Day2BathroomSecurity.partOne(actualInput)
      println(s"Day 2 Part 1: $result")
    }
  }

  feature("Part 2") {
    scenario("Basic Scenario 1") {
      val actualInput =
        """
          |ULL
        """.stripMargin

      Day2BathroomSecurity.partTwo(actualInput) should be("5")
    }

    scenario("Basic Scenario 2") {
      val actualInput =
        """
          |RRDDD
        """.stripMargin

      Day2BathroomSecurity.partTwo(actualInput) should be("D")
    }

    scenario("Scenario 1") {
      val actualInput =
        """
          |ULL
          |RRDDD
          |LURDL
          |UUUUD
        """.stripMargin

      Day2BathroomSecurity.partTwo(actualInput) should be("5DB3")
    }

    scenario("Result") {
      val actualInput = readInput("Day2BathroomSecurity.txt")
      val result = Day2BathroomSecurity.partTwo(actualInput)
      println(s"Day 2 Part 2: $result")
    }
  }
}