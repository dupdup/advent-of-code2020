import scala.io.Source

object aoc2 extends App {

  val filename = "input/in2"
  val xs = for (
    line <- Source.fromFile(filename).getLines
) yield line.split(" ").toList
  val res = xs.toList.filter(x=> {
    val ch =  "[a-z]".r.findFirstIn(x(1)).getOrElse("0").toCharArray.head
    x(2)(x(0).split("-")(0).toInt-1) == ch ^ x(2)(x(0).split("-")(1).toInt-1) == ch
  }
  )
  print(res.size)
}
