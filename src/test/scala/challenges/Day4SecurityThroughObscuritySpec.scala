package challenges

import org.scalatest.{FeatureSpec, Matchers}

class Day4SecurityThroughObscuritySpec extends FeatureSpec with Matchers with BunnySuite {

  feature("Part 1") {
    scenario("Scenario 1") {
      val actualInput =
        """
          |aaaaa-bbb-z-y-x-123[abxyz]
          |a-b-c-d-e-f-g-h-987[abcde]
          |not-a-real-room-404[oarel]
          |totally-real-room-200[decoy]
        """.stripMargin

      Day4SecurityThroughObscurity.partOne(actualInput) should be(1514)
    }

    scenario("Basic Scenario when valid") {
      val actualInput =
        """
          |aaaaa-bbb-z-y-x-123[abxyz]
        """.stripMargin

      Day4SecurityThroughObscurity.partOne(actualInput) should be(123)
    }

    scenario("Basic Scenario when not valid") {
      val actualInput =
        """
          |totally-real-room-200[decoy]
        """.stripMargin

      Day4SecurityThroughObscurity.partOne(actualInput) should be(0)
    }

    scenario("Result") {
      val actualInput = readInput("Day4SecurityThroughObscurity.txt")
      val result = Day4SecurityThroughObscurity.partOne(actualInput)
      println(s"Day 4 Part 1: $result")
    }
  }

  feature("Part 2") {
    scenario("Scenario 1") {
      val actualInput =
        """
          |qzmt-zixmtkozy-ivhz-343[zimth]
        """.stripMargin

      Day4SecurityThroughObscurity.partTwo(actualInput, "very encrypted name") should be(343)
    }

    scenario("Result") {
      val actualInput = readInput("Day4SecurityThroughObscurity.txt")
      val result = Day4SecurityThroughObscurity.partTwo(actualInput, "pole")
      println(s"Day 4 Part 2: $result")
    }
  }
}
