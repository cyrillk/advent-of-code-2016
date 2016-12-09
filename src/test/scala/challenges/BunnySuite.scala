package challenges

import scala.io.Source

trait BunnySuite {

  protected def readInput(filename: String): String = {
    val stream = getClass.getResourceAsStream(s"/$filename")
    Source.fromInputStream(stream).getLines().toList.mkString("\n")
  }
}
