object StringMingling {
  def main(args: Array[String]): Unit = {
    var f:String = readLine()
    var s:String = readLine()
    var res: Array[Char] = new Array[Char](f.length + s.length)
    var b:Boolean = true
    var fi = 0
    var si = 0
    for (i <- 0 to res.length - 1){
      if (b) {
        res(i) = f(fi); fi+=1
      }
      else {
        res(i) = s(si); si+=1
      }
      b = !b
    }
    for (i <- 0 to res.length - 1)
      print(res(i))
  }
}
