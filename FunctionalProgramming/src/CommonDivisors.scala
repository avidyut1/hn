object CommonDivisors {
  def main(args: Array[String]): Unit = {
    var tc:Int = readInt()
    for (i <- 0 until tc) {
      val lm:Array[String] = readLine().split(' ')
      var l:Int = lm(0).toInt
      var m:Int = lm(1).toInt
      var j: Int = 1
      var setm:Set[Int] = Set()
      while(j <= math.sqrt(m)) {
        if (m % j == 0) {
          setm += j
          setm += m / j
        }
        j += 1
      }
      var ans:Int = 0
      j = 1
      while(j <= math.sqrt(l)) {
        if (l % j == 0) {
          if (setm.contains(j)) {
            ans += 1
          }
          if (l / j != j && setm.contains(l / j)) {
            ans += 1
          }
        }
        j += 1
      }
      println(ans)
    }
  }
}
