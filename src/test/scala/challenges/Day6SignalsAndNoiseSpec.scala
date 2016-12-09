package challenges

import org.scalatest.{FeatureSpec, Matchers}

class Day6SignalsAndNoiseSpec extends FeatureSpec with Matchers with BunnySuite {

  feature("Part 1") {
    scenario("Scenario 1") {
      val actualInput =
        """
          |eedadn
          |drvtee
          |eandsr
          |raavrd
          |atevrs
          |tsrnev
          |sdttsa
          |rasrtv
          |nssdts
          |ntnada
          |svetve
          |tesnvt
          |vntsnd
          |vrdear
          |dvrsen
          |enarar
        """.stripMargin

      Day6SignalsAndNoise.partOne(actualInput) should be("easter")
    }

    scenario("Result") {
      val actualInput = readInput("Day6SignalsAndNoise.txt")
      val result = Day6SignalsAndNoise.partOne(actualInput)
      println(s"Day 6 Part 1: $result")
    }
  }

  feature("Part 2") {
    scenario("Scenario 1") {
      val actualInput =
        """
          |eedadn
          |drvtee
          |eandsr
          |raavrd
          |atevrs
          |tsrnev
          |sdttsa
          |rasrtv
          |nssdts
          |ntnada
          |svetve
          |tesnvt
          |vntsnd
          |vrdear
          |dvrsen
          |enarar
        """.stripMargin

      Day6SignalsAndNoise.partTwo(actualInput) should be("advent")
    }

    scenario("Result") {
      val actualInput = readInput("Day6SignalsAndNoise.txt")
      val result = Day6SignalsAndNoise.partTwo(actualInput)
      println(s"Day 6 Part 2: $result")
    }
  }
}
