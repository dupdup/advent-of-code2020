import scala.io.Source
import scala.language.postfixOps

object aoc3 extends App {
  val xs = for (
    (line, i) <- Source.fromFile("input/in3").getLines.zipWithIndex
    if (line.split("")((i * 3) % 31) == "#")
  ) yield (line, i)
  print(xs.toList.size)
}
