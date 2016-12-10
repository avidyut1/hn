object ex {
  def main(args: Array[String]): Unit = {
    var fact = new Array[Int](11);
    fact(0) = 1
    for(i <- 1 until 11) {
      fact(i) = fact(i - 1) * i
    }
    var n = readInt()
    for (tc <- 1 to n) {
      var x:Double = readDouble();
      var sum = 0d
      for(i <- 0 until 10) {
        sum += (math.pow(x, i) / fact(i))
      }
      println(sum)
    }
  }
}
