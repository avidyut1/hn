object RemoveDups {
  def main(args: Array[String]): Unit = {
    var s:Set[Char] = Set()
    var st:String = readLine();
    var ans = ""
    for(i <- 0 to st.length - 1) {
      var c:Char = st(i)
      if (s.contains(c)) {

      }
      else {
        s = s + c
        ans += c
      }
    }
    println(ans)
  }
}
