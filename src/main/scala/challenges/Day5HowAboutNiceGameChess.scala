package challenges

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

/**
  * http://adventofcode.com/2016/day/5
  */
object Day5HowAboutNiceGameChess {

  private val md5 = java.security.MessageDigest.getInstance("MD5")

  @tailrec
  private def calculate(prefix: String, index: Int): (String, Int) = {
    val hash = md5.digest(s"$prefix$index".getBytes)
    if (hash(0) == 0 && hash(1) == 0 && (hash(2) & 0xF0) == 0)
      (hash.map("%02x".format(_)).mkString, index)
    else
      calculate(prefix, index + 1)
  }

  def partOne(input: String, begin: Int = 0): String = {

    val str = prepare(input)

    @tailrec
    def process(index: Int)(acc: List[String]): String = {
      val (hash, num) = calculate(str, index)
      val list = acc :+ hash
      if (list.length < 8) process(num + 1)(list) else list.map(_.charAt(5)).mkString
    }

    process(begin)(List.empty[String])
  }

  def partTwo(input: String, begin: Int = 0): String = {

    val str = prepare(input)
    val ex = "[0-7]+".r

    @tailrec
    def process(index: Int)(acc: ArrayBuffer[Option[Char]]): String = {

      val (hash, num) = calculate(str, index)

      val result = for {
        position <- ex.findFirstIn(hash.charAt(5).toString).map(_.toInt)
        if acc.lift(position).flatten.isEmpty
      } yield {
        (position, hash.charAt(6))
      }

      result.foreach(r => acc.update(r._1, Option(r._2)))

      if (acc.filterNot(_.isEmpty).length < 8) process(num + 1)(acc) else acc.flatten.mkString
    }

    process(begin)(ArrayBuffer.fill[Option[Char]](8)(None))
  }

  private def prepare(input: String) = {
    input.lines.map(_.trim).filterNot(_.isEmpty).mkString
  }
}
