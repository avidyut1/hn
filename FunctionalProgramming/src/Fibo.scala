object Fibo {
  def main(args: Array[String]): Unit = {
    val MOD:Int = 100000007
    val tc:Int = readInt()
    var fib:Array[Int] = new Array[Int](10004)
    fib(0) = 0
    fib(1) = 1
    for (i <- 2 to 10003){
      fib(i) = (fib(i - 1) % MOD + fib(i - 2) % MOD) % MOD
//      println(fib(i))
    }
    for(i <- 1 to tc) {
      var j = readInt()
      println(fib(j))
    }
  }
}
