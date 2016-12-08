package challenges

/**
  * http://adventofcode.com/2016/day/7
  */
object Day7InternetProtocolVersion7 {

  def partOne(input: String): Int = {
    clear(input).foldLeft(0) { case (acc, str) =>
      if (hasABBAPalindromes(str)) acc + 1 else acc
    }
  }

  def partTwo(input: String): Int = {
    clear(input).foldLeft(0) { case (acc, str) =>
      if (hasABAPalindromes(str)) acc + 1 else acc
    }
  }

  private def hasABAPalindromes(str: String) = {
    val palindromes = str.split("""\[|\]""").zipWithIndex.foldLeft((Seq.empty[String], Seq.empty[String])) {
      case ((a, b), (s, n)) if n % 2 == 0 => (a ++: findABAPalindromes(s.toCharArray), b)
      case ((a, b), (s, _)) => (a, b ++: findABAPalindromes(s.toCharArray))
    }

    val supernet = palindromes._1
    val hypernet = palindromes._2.map(s => (s.charAt(1) :: s.charAt(0) :: s.charAt(1) :: Nil).mkString)

    supernet.exists(s => hypernet.contains(s))
  }

  private def findABAPalindromes(s: Array[Char]): Seq[String] = {
    if (s.length > 2) {
      (0 until s.length - 2).foldLeft(Seq.empty[String]) { (acc, n) =>
        if (s(n) == s(n + 2) && s(n) != s(n + 1))
          acc :+ (s(n) :: s(n + 1) :: s(n + 2) :: Nil).mkString
        else
          acc
      }
    } else
      Seq.empty[String]
  }

  private def hasABBAPalindromes(str: String) = {
    val palindromes = str.split("""\[|\]""").zipWithIndex.foldLeft((Seq.empty[String], Seq.empty[String])) {
      case ((a, b), (s, n)) if n % 2 == 0 => (a ++: findABBAPalindrome(s.toCharArray), b)
      case ((a, b), (s, _)) => (a, b ++: findABBAPalindrome(s.toCharArray))
    }

    val supernet = palindromes._1
    val hypernet = palindromes._2.map(s => (s.charAt(1) :: s.charAt(0) :: s.charAt(1) :: Nil).mkString)

    supernet.nonEmpty && hypernet.isEmpty
  }

  private def findABBAPalindrome(s: Array[Char]): Seq[String] = {
    if (s.length > 3) {
      (0 until s.length - 3).foldLeft(Seq.empty[String]) { (acc, n) =>
        if (s(n + 1) == s(n + 2) && s(n) == s(n + 3) && s(n) != s(n + 1))
          acc :+ (s(n) :: s(n + 1) :: s(n + 2) :: s(n + 3) :: Nil).mkString
        else
          acc
      }
    } else Seq.empty[String]
  }

  private def clear(input: String): Seq[String] = {
    input.lines.map(_.trim).filterNot(_.isEmpty).toList
  }
}
