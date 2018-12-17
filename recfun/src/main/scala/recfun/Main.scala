package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if (c == 0 || c == r) 1
      else pascal(c - 1, r - 1) + pascal(c, r - 1)
    }
  
  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def findMatch(remainingChars: List[Char], requiredMatches: Int): Boolean = {
      // Fail: No matches and reached end of chars
      if (remainingChars.isEmpty && requiredMatches > 0) false
      // Success: carry on with rest of the characters
      else if (requiredMatches == 0) balance(remainingChars)
      else if (remainingChars.head == ')') findMatch(remainingChars.tail, requiredMatches - 1)
      else if (remainingChars.head == '(') findMatch(remainingChars.tail, requiredMatches + 1)
      // Keep going
      else findMatch(remainingChars.tail, requiredMatches)
    }
    // Finish with no problems
    if (chars.isEmpty) true
    // Try finding matching bracket (may require recursion)
    else if (chars.head == '(') findMatch(chars.tail, 1)
    // An opening ) cannot be matched
    else if (chars.head == ')') false
    // Character not interesting: keep going
    else balance(chars.tail)
  }

  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if (coins.isEmpty || money < 0) 0
      else if (money == 0) 1
      else countChange(money - coins.head, coins) + countChange(money, coins.tail)
    }

}
