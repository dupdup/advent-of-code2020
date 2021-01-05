import scala.io.Source
import scala.language.postfixOps

object aoc8 extends App {
  val xs = Source.fromFile("input/in8").getLines.toList
  val start = System.nanoTime();
  var acc =  0;
  var i = 0;
  var ts = Set[Int]()
  var tries = xs.zipWithIndex.filter(_._1.startsWith("jmp")).map(_._2)
  while(i!=626){
    ts+=i
    val tuple = xs(i).split(" ")
    (tuple(0),Integer.parseInt(tuple(1))) match {
      case ("acc",arg:Int) => acc = acc + arg; i = i + 1;
      case ("jmp",arg:Int) => if(tries.head == i) i= i+1 else i = i + arg
      case ("nop",arg:Int) => i = i + 1
    }
    if(ts.contains(i)){
      i = 0;
      acc = 0;
      ts= Set.empty
      tries = tries.drop(1)
    }
  }
  println(System.nanoTime()-start)
  println(acc)
}
