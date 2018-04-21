package ru.zhenik.scala.alg

import scala.annotation.tailrec

/**
  * akka-http-rest
  * NIK on 20/04/2018
  */
object Algorithms {

  // computation starts when last element rich, not safe because of stack overflow
  def rFactorial(i: Int):Int = {
    if(i<=0) 1
    else i*rFactorial(i-1)
  }

  // computation for each step -> result is input for next call
  @tailrec
  def rFactorialTailRec(i: Int, acc: Int):Int = {
    if (i<=0) acc
    else rFactorialTailRec(i-1, i*acc)
  }

  // NB! next element in stream is lazy evaluated
  def fibFrom(a: Int, b: Int): Stream[Int] = a #:: fibFrom(b, a+b)

  // greatest common divisor (gcd)
  @tailrec
  def gcd(a: Int, b: Int): Int = {
    if (a == b) a
    else if (a > b) gcd(a-b,b)
    else gcd(a, b-a)
  }
}
