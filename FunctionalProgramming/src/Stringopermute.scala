object Stringopermute {
  def main(args: Array[String]): Unit = {
    var tc = readInt();
    for(t <- 1 to tc) {
      var st: Array[Char]= readLine().toCharArray
      var i = 0;
      while(i < st.length) {
        var temp =  st(i + 1)
        st(i + 1) = st(i)
        st(i) = temp;
        i += 2;
      }
      println(new String(st))
    }
  }
}
