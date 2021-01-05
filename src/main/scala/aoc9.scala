import scala.io.Source
import scala.language.postfixOps

object aoc9 extends App {
  val xs = Source.fromFile("input/in9").getLines.toList.map(_.toLong).view
  def f(i:Int) = {
    val ts = xs.slice(i, i + 25)
    val res =  for {
      a <- ts
      b <- ts
    } yield (a + b)
    !res.find(_==xs(i+25)).isEmpty
  }
  val t = 25 to 975 find(!f(_))
  private val first: Long = xs(t.get + 25)
  println(first)
  val st= System.nanoTime();
  def g() = {
    val res = for {
      i <- 0 to 565
      d <- 2 to 30
    } yield xs.slice(i,i+d)
    res.find(_.sum==first).getOrElse(List.empty)
  }
  var res2 = g()
  println(System.nanoTime()-st)
  print(res2.max+res2.min)
 }
