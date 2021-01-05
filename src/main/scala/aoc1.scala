import scala.io.Source

object aoc1 extends App {
  val xs = Source.fromFile("input/in1").getLines.map(_.toInt).toList
  val ys = for(
    a<- xs.view;
    b<- xs.view;
    c<- xs.view
    if(a+b+c == 2020)
    ) yield (a*b*c)
  println(ys.toList)
}
