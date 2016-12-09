package challenges

import org.scalatest.{FeatureSpec, Matchers}

class Day7InternetProtocolVersion7Spec extends FeatureSpec with Matchers with BunnySuite {

  feature("Part 1") {
    scenario("Scenario 1") {
      val actualInput =
        """
          |abba[mnop]qrst
          |abcd[bddb]xyyx
          |aaaa[qwer]tyui
          |ioxxoj[asdfgh]zxcvbn
        """.stripMargin

      Day7InternetProtocolVersion7.partOne(actualInput) should be(2)
    }

    scenario("Scenario 2") {
      val actualInput =
        """
          |aaaa[qwer]ioxxoj[asdfgh]ioxxoj[asdfgh]zxcvbn
          |aaaa[qwer]abcdjj[asdfgh]abcdjj[asdfgh]zxcvbn
        """.stripMargin

      Day7InternetProtocolVersion7.partOne(actualInput) should be(1)
    }

    scenario("Result") {
      val actualInput = readInput("Day7InternetProtocolVersion7.txt")
      val result = Day7InternetProtocolVersion7.partOne(actualInput)
      println(s"Day 7 Part 1: $result")
    }
  }

  feature("Part 2") {
    scenario("Scenario 1") {
      val actualInput =
        """
          |aba[bab]xyz
          |xyx[xyx]xyx
          |aaa[kek]eke
          |zazbz[bzb]cdb
        """.stripMargin

      Day7InternetProtocolVersion7.partTwo(actualInput) should be(3)
    }

    scenario("Result") {
      val actualInput = readInput("Day7InternetProtocolVersion7.txt")
      val result = Day7InternetProtocolVersion7.partTwo(actualInput)
      println(s"Day 7 Part 2: $result")
    }
  }
}
