import scala.io.Source
import scala.language.postfixOps

object aoc7 extends App {
  val xs = Source.fromFile("input/in7").getLines.toList
  def f(s:String): List[String] ={
    val r = xs.filter(_.contains(s)).map(_.split(" bags contain").head).filterNot(_==s)
    if(r.isEmpty) List(s)
    else r++r.flatMap(f(_))
  }
  def g(s:String):Int= {
    val conStr = xs.find(_.startsWith(s)).get.split(" contain ").tail.head
    if(conStr.contains("no other")) 1
    else {
      val ts = conStr.split(", ").map(_.split(" bag").head).map(x=>{val s"$count $bag_name"=x;(count.toInt,bag_name)})
      val res = ts.map((b)=>  b._1 * g(b._2) )
      res.sum + 1
    }
  }
  println(f("shiny gold").distinct.size)
  println(g("shiny gold")-1)

}
