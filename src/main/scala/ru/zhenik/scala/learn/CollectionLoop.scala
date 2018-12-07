package ru.zhenik.scala.learn

import scala.annotation.tailrec

object CollectionLoop {
  // or better even numbers
  case class Claim(id: Int, value: Int, processed:Boolean=false)
  val list = Vector(
    Claim(1, 1),
    Claim(2, 6),
    Claim(3, 4),
    Claim(4, 4)
  )




  def getEven(claims: Vector[Claim]): Int = claims.filter(_.value%2==0).map(_.value).sum

  def main(args: Array[String]): Unit = println(getEven(list))



}
