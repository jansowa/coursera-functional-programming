package example

object Factorial {
  def factorial(n: Int): Int = {
    def factorialHelper(currentProduct: Int, n: Int): Int =
      if (n == 0) currentProduct
      else factorialHelper(currentProduct * n, n - 1)

    factorialHelper(1, n)
  }

  def main(args: Array[String]): Unit = {
    println(factorial(5))
    println(factorial(10))
  }
}
