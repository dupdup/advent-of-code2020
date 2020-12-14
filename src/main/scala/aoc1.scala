import scala.io.Source

object aoc1 extends App {

  val filename = "input/in1"
  val xs = for (
    line <- Source.fromFile(filename).getLines
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
