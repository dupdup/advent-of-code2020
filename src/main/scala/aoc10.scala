import scala.io.Source
import scala.language.postfixOps

object aoc10 extends App {
  val xs = Source.fromFile("input/in10").getLines.toList.map(_.toInt).sorted
  val ts = (0+:xs).zip(xs :+ xs.last+3).map(x=>x._2-x._1).mkString.split("3").map(_.size).groupBy(_.hashCode)
  println((Math.pow(7,ts.get(4).get.size)*Math.pow(2,ts.get(3).get.size*2 + ts.get(2).get.size )).toLong)
}
