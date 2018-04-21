package ru.zhenik.scala.alg

/**
  * algdat
  * NIK on 20/04/2018
  */
object App extends App {

  println("\n\nFACTORIALS")
  println(Algorithms.rFactorial(5))
  println(Algorithms.rFactorialTailRec(5,1))

  println("\n\nFIBONACCI")
  Algorithms.fibFrom(1,2).takeWhile(_<10).foreach(println(_))

  println("\n\nGCD")
  println(Algorithms.gcd(8, 12))
}
