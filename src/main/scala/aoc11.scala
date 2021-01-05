import aoc8.i

import scala.collection.mutable
import scala.io.Source

object aoc11 extends App {
  val xs = Source.fromFile("input/in11").getLines.mkString.replaceAll("L","1").replaceAll("\\.","2").split("").map(_.toInt);
  val row = 90
  val col = 95
  def f(ys:List[Int]): Int ={
    val ts = (0 to ((row*col)-1) ).map(x=>
    {
      if (ys(x) == 0 &&  oc(x,ys) == 0) 1
      else if (ys(x) == 1 &&  oc(x, ys)> 3) 0
      else ys(x)
    }).toList
    if(ys.count(_==1) == ts.count(_==1)) ts.count(_==1)
    else {
      println(ts.count(_==1))
      f(ts)
    }
  }
  println(f(xs.toList))
  //println(adj(10))
  def oc(pos:Int,ys:List[Int]) = adj(pos).count(ys(_) == 1)
  lazy val adj :  Int => List[Int] = memoize((i:Int)=>{
    var ts = List[Int]();
    if(i/col != 0)  {ts =  ts :+ i-col; if(i%col != col-1) ts = ts :+ i-(col-1); if(i%col != 0) ts = ts :+ i-(col+1);}
    if(i/col != row-1) {ts =  ts :+ i+col; if(i%col != col-1) ts = ts :+ i+(col+1); if(i%col != 0) ts = ts :+ i+(col-1);}
    if(i%col != col-1) ts =  ts :+ i+1
    if(i%col != 0)  ts =  ts :+ i-1
    ts
  })
  def memoize[I, O](f: I => O): I => O = new mutable.HashMap[I, O]() {
    override def apply(key: I) = getOrElseUpdate(key, f(key))
  }
}
