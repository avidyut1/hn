object Function{
  def main(args: Array[String]): Unit = {
    var tc: Int = readInt()
    for (t <- 1 to tc) {
      var ans: Boolean = true
      var n = readInt()
      var map = Map[Int, Int]()
      for (nc <- 1 to n) {
        var inp:Array[String] = readLine().split(" ");
        var i: Int = Integer.parseInt(inp(0))
        var j: Int = Integer.parseInt(inp(1))
        if (map.contains(i)) {
          if (map(i) != j) {
            ans = false
          }
        }
        else {
          map += (i -> j)
        }
      }
      if (ans) {
        println("YES")
      }
      else
        println("NO")
    }
  }
}