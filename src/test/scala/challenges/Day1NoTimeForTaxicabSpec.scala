package challenges

import org.scalatest.{FeatureSpec, Matchers}

class Day1NoTimeForTaxicabSpec extends FeatureSpec with Matchers with BunnySuite {

  feature("Part 1") {

    scenario("Scenario simple 1") {
      val actualInput = "R2"
      Day1NoTimeForTaxicab.partOne(actualInput) should be(2)
    }

    scenario("Scenario simple 2") {
      val actualInput = "L3"
      Day1NoTimeForTaxicab.partOne(actualInput) should be(3)
    }

    scenario("Scenario 1") {
      val actualInput = "R2, L3"
      Day1NoTimeForTaxicab.partOne(actualInput) should be(5)
    }

    scenario("Scenario 2") {
      val actualInput = "R2, R2, R2"
      Day1NoTimeForTaxicab.partOne(actualInput) should be(2)
    }

    scenario("Scenario 3") {
      val actualInput = "R5, L5, R5, R3"
      Day1NoTimeForTaxicab.partOne(actualInput) should be(12)
    }
    scenario("Part 1 - Calculate") {
      val actualInput = readInput("Day1NoTimeForTaxicab.txt")
      val result = Day1NoTimeForTaxicab.partOne(actualInput)
      println(s"Day 1 Part 1: $result")
    }
  }

  feature("Part 2") {

    scenario("Scenario 1") {
      val actualInput = "R8, R4, R4, R8"
      Day1NoTimeForTaxicab.partTwo(actualInput) should be(4)
    }

    scenario("Calculate") {
      val actualInput = readInput("Day1NoTimeForTaxicab.txt")
      val result = Day1NoTimeForTaxicab.partTwo(actualInput)
      println(s"Day 1 Part 2: $result")
    }
  }
}