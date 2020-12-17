import scala.io.Source
import scala.language.postfixOps

object aoc6 extends App {
  val xs = Source.fromFile("input/in6").getLines.mkString("\t").split("\t\t")
  val dis = xs.map(_.distinct).map(_.replaceAll("\t","")).map(_.length)
  println(dis.sum)
  print(xs.map(_.replaceAll("\t"," ").split(" ").reduce(_.intersect(_))).map(_.length).sum)

}
