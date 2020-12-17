import scala.io.Source
import scala.language.postfixOps

object aoc4 extends App {
  val xs = Source.fromFile("input/in4").getLines.mkString("\t").split("\t\t")
  val fs = List("byr","iyr","eyr","hgt","hcl","ecl","pid")
  val vs = xs filterNot (x=> fs.exists(!x.contains(_)))
  val res = vs filter rules
  println(res.size)

  def rules(s:String): Boolean ={
    def toIntOp(s:String) = s.toIntOption.getOrElse(0)
    val xs = s.replace("\t"," ").split(" ")
    xs.forall(x=>{
          x.split(":").toList match{
            case "byr" :: v :: Nil=> toIntOp(v) >= 1920 && toIntOp(v) <= 2002
            case "iyr" :: v :: Nil => toIntOp(v) >= 2010 && toIntOp(v) <= 2020
            case "eyr" :: v :: Nil => toIntOp(v) >= 2020 && toIntOp(v) <= 2030
            case "hgt" :: v :: Nil if(v.contains("in"))=> toIntOp(v.dropRight(2))>= 59 && toIntOp(v.dropRight(2)) <= 76
            case "hgt" :: v :: Nil if(v.contains("cm"))=> toIntOp(v.dropRight(2))>= 150 && toIntOp(v.dropRight(2)) <= 193
            case "hcl" :: v :: Nil => "#[a-f0-9]{6}$".r.matches(v)
            case "pid" :: v :: Nil => "[0-9]{9}$".r.matches(v)
            case "ecl" :: v :: Nil => List("amb","blu","brn","gry","grn","hzl","oth").contains(v)
            case "cid" :: v => true
            case _ => false
          }
    }
    )
  }
}
