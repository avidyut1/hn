object Bunny {
  def main(args: Array[String]): Unit = {
    var n:Int = readInt()
    var sar:Array[String] = (readLine()).split(" ")
    var ar:Array[Int] = new Array[Int](n)
    var i:Int = 0
    for (s <- sar) {
      ar(i) = Integer.parseInt(s)
      i += 1
    }
    var lcmar:Long = 1.toLong
    for (i <- ar) {
      lcmar = lcm(lcmar, i)
    }
    println(lcmar)
  }
  def lcm(a:Long, b: Long): Long = {
    val prod:Long = a.toLong * b
    return prod / gcd(a, b)
  }
  def gcd(a:Long, b:Long): Long = {
    if (a == 0 || b == 0) {
      return a + b
    }
    return gcd(b, a % b)
  }
}
