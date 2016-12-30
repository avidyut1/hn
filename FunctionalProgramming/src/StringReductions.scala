object StringReductions {
  def main(args: Array[String]): Unit = {
    var car:Array[Char] = (readLine()).toCharArray()
    var set:Set[Char] = Set();
    for(i <- 0 until car.length){
      if (!set.contains(car(i))) {
        set = set + car(i)
        print(car(i))
      }
    }

  }
}
