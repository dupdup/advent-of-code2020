import scala.io.Source

object aoc1 extends App {
  val xs = for (
    line <- Source.fromFile("input/in1").getLines
  ) yield line.toInt
  val ts = xs.toList;
  val ys = for(
    a<- ts.view;
    b<- ts.view;
    c<-ts.view
    if(a+b+c == 2020)
    ) yield (a*b*c)
  println(ys.toList)
}
