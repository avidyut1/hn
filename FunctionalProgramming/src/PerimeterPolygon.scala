import math._
object PerimeterPolygon {
  def main(args: Array[String]): Unit = {
    var n:Int = readInt()
    var ar = new Array[Array[Int]](n)
    for (i <- 0 to n - 1) {
      ar(i) = new Array[Int](2)
      var st: Array[String] = readLine().split(" ");
      ar(i)(0) = Integer.parseInt(st(0))
      ar(i)(1) = Integer.parseInt(st(1))
    }
    var ans:Double = distance(ar(0)(0), ar(0)(1), ar(n - 1)(0), ar(n - 1)(1))
    for(i <- 0 to n - 2) {
      ans += distance(ar(i)(0), ar(i)(1), ar(i + 1)(0), ar(i + 1)(1));
    }
    println(ans)
  }
  def distance(x1: Int, y1: Int, x2: Int, y2: Int) :Double = {
    return math.sqrt(math.pow((x1 - x2), 2.0d) + math.pow((y1 - y2), 2.0d))
  }
}
