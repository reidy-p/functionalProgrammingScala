package funsets

object Main extends App {
  import FunSets._

  val negativeSet: Set = (x: Int) => x < 0
  val someNegativeSet: Set = (x: Int) => x > -10 && x < 0
  val positiveSet: Set = (x: Int) => x > 0

  println(contains(singletonSet(1), 1))
  println(contains(negativeSet, -1))

  println(contains(diff(negativeSet, someNegativeSet), -11))
  println(contains(diff(negativeSet, someNegativeSet), -1))
  println(filter(negativeSet, (x: Int) => x > - 10 && x < 0))

  //val somePositive: Int => Boolean = (x: Int) => x > 10
  //assert(!forall(positiveSet, somePositive))

  val even: Int => Boolean = (x: Int) => x % 2 == 0
  println(forall(positiveSet, even))

  printSet(positiveSet)
  printSet(map(positiveSet, (x: Int) => -x))
}
