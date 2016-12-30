object StringCompress {
  def main(args: Array[String]): Unit = {
    var s:Array[Char] = readLine().toCharArray;
    var i = 0
    while(i < s.length) {
      var j = i + 1
      var count = 1
      while(j < s.length && s(j) == s(i)) {
        j+=1
        count+=1
      }
      if (count == 1) {
        print(s(i));
      }
      else{
        print(s(i) + "" + count)
      }
      i = j;
    }
  }
}
