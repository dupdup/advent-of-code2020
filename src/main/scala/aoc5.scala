import scala.io.Source
import scala.language.postfixOps

object aoc5 extends App {
  def toId(s:String) = (Integer.parseInt(s.take(7),2) * 8) + Integer.parseInt(s.takeRight(3),2)
  val xs = for (
    line <- Source.fromFile("input/in5").getLines
) yield line
    .replaceAll("B","1")
    .replaceAll("F","0")
    .replaceAll("L","0")
    .replaceAll("R","1")

  val t = xs map toId toList
  val sorted = t.sorted.drop(2).grouped(10)
  sorted foreach println

}
