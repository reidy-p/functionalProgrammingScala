import objsets.{Tweet, TweetSet, Empty, NonEmpty, GoogleVsApple}

object test extends App{

  val tweeta = new Tweet("a", "a body", 20)
  val tweetb = new Tweet("b", "b body", 25)
  val tweetc = new Tweet("c", "c body", 7)
  val tweetd = new Tweet("d", "d body", 9)
  val set1 = new Empty
  val set2 = set1.incl(tweeta)
  val set3 = set1.incl(tweeta).incl(tweetb)
  val set4 = set1.incl(tweeta).incl(tweetb).incl(tweetc)
  val set5 = set1.incl(tweeta).incl(tweetb).incl(tweetc).incl(tweetd)

  set5.union(set2).foreach(println)
  println()
  set3.union(set2).foreach(println)
  println()
  set2.union(set3).foreach(println)
  println()
  set1.union(set4).foreach(println)
  println()
  println(set5.mostRetweeted)
  println()
  println(set5.descendingByRetweet.foreach(println))

  println(GoogleVsApple.googleTweets.foreach(println))
}
