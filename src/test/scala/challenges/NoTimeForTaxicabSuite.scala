package challenges

import org.scalatest.{FunSuite, Matchers}

class NoTimeForTaxicabSuite extends FunSuite with Matchers {

  test("Part 1 - Scenario simple 1") {
    val actualInput = "R2"

    NoTimeForTaxicab.first(actualInput) should be (2)
  }

  test("Part 1 - Scenario simple 2") {
    val actualInput = "L3"

    NoTimeForTaxicab.first(actualInput) should be (3)
  }

  test("Part 1 - Scenario 1") {
    val actualInput = "R2, L3"

    NoTimeForTaxicab.first(actualInput) should be (5)
  }

  test("Part 1 - Scenario 2") {
    val actualInput = "R2, R2, R2"

    NoTimeForTaxicab.first(actualInput) should be (2)
  }

  test("Part 1 - Scenario 3") {
    val actualInput = "R5, L5, R5, R3"

    NoTimeForTaxicab.first(actualInput) should be (12)
  }

  test("Part 1 - Calculate") {
    val actualInput = "R3, R1, R4, L4, R3, R1, R1, L3, L5, L5, L3, R1, R4, L2, L1, R3, L3, R2, R1, R1, L5, L2, L1, R2, L4, R1, L2, L4, R2, R2, L2, L4, L3, R1, R4, R3, L1, R1, L5, R4, L2, R185, L2, R4, R49, L3, L4, R5, R1, R1, L1, L1, R2, L1, L4, R4, R5, R4, L3, L5, R1, R71, L1, R1, R186, L5, L2, R5, R4, R1, L5, L2, R3, R2, R5, R5, R4, R1, R4, R2, L1, R4, L1, L4, L5, L4, R4, R5, R1, L2, L4, L1, L5, L3, L5, R2, L5, R4, L4, R3, R3, R1, R4, L1, L2, R2, L1, R4, R2, R2, R5, R2, R5, L1, R1, L4, R5, R4, R2, R4, L5, R3, R2, R5, R3, L3, L5, L4, L3, L2, L2, R3, R2, L1, L1, L5, R1, L3, R3, R4, R5, L3, L5, R1, L3, L5, L5, L2, R1, L3, L1, L3, R4, L1, R3, L2, L2, R3, R3, R4, R4, R1, L4, R1, L5"

    println(s"Part 1 result: ${NoTimeForTaxicab.first(actualInput)}")
  }

  test("Part 2 - Scenario 1") {
    val actualInput = "R8, R4, R4, R8"

    NoTimeForTaxicab.second(actualInput) should be (4)
  }

  test("Part 2 - Calculate") {
    val actualInput = "R3, R1, R4, L4, R3, R1, R1, L3, L5, L5, L3, R1, R4, L2, L1, R3, L3, R2, R1, R1, L5, L2, L1, R2, L4, R1, L2, L4, R2, R2, L2, L4, L3, R1, R4, R3, L1, R1, L5, R4, L2, R185, L2, R4, R49, L3, L4, R5, R1, R1, L1, L1, R2, L1, L4, R4, R5, R4, L3, L5, R1, R71, L1, R1, R186, L5, L2, R5, R4, R1, L5, L2, R3, R2, R5, R5, R4, R1, R4, R2, L1, R4, L1, L4, L5, L4, R4, R5, R1, L2, L4, L1, L5, L3, L5, R2, L5, R4, L4, R3, R3, R1, R4, L1, L2, R2, L1, R4, R2, R2, R5, R2, R5, L1, R1, L4, R5, R4, R2, R4, L5, R3, R2, R5, R3, L3, L5, L4, L3, L2, L2, R3, R2, L1, L1, L5, R1, L3, R3, R4, R5, L3, L5, R1, L3, L5, L5, L2, R1, L3, L1, L3, R4, L1, R3, L2, L2, R3, R3, R4, R4, R1, L4, R1, L5"

    println(s"Part 2 result: ${NoTimeForTaxicab.second(actualInput)}")
  }
}