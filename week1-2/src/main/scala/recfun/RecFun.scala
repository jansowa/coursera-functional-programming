package recfun

object RecFun extends RecFunInterface {

  def main(args: Array[String]): Unit = {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(s"${pascal(col, row)} ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int =
    if (c==0 || c==r) 1 else pascal(c-1, r-1) + pascal(c, r-1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def balanceHelper(chars: List[Char], openingParenth: Int): Boolean = {
      if (chars.isEmpty)
        if (openingParenth > 0) false else true
      else if (chars.head == '(')
        balanceHelper(chars.tail, openingParenth+1)
      else if (chars.head == ')')
        if (openingParenth==0) false
        else balanceHelper(chars.tail, openingParenth-1)
      else
        balanceHelper(chars.tail, openingParenth)
    }

    balanceHelper(chars, 0)
  }


  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    return 5;
  }
}
