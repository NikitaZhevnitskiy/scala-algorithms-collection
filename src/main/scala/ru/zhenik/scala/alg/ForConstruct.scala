package ru.zhenik.scala.alg


/**
  *
  * for(x <- c1; y <- c2; z <-c3) {...} translated to
  * c1.foreach(x => c2.foreach(y => c3.foreach(z => {...})))
  *
  * for(x <- c1; y <- c2; z <- c3) yield {...} translated to
  * c1.flatMap(x => c2.flatMap(y => c3.map(z => {...})))
  *
  * for(x <- c; if cond) yield {...} translated to
  * * c.withFilter(x => cond).map(x => {...})
  *
  * for(x <- c; y = ...) yield {...}
  * c.map(x => (x, ...)).map((x,y) => {...})
  *
  * */
object ForConstruct {

  def forLoop() = for(i <- 1 to 10) yield i

  def forFilter() = {
    for( a <- 1 to 10
         if a != 3
         if a < 8 ){
      println( "Value of a: " + a )
    }
  }

  def forYield() = {
    for(a <- 1 to 10
        if a%2==0
    ) yield a
  }
  def forYieldComplex() = {
    def foo(n: Int, v: Int) =
      for (i <- 0 until n; j <- i until n if i + j == v) yield (i, j)

    foo(10, 10) foreach {
      case (i, j) =>
        println(s"($i, $j) ")  // prints (1, 9) (2, 8) (3, 7) (4, 6) (5, 5)
    }
  }



  // Compare elements
  def compareElements() = {
    val list = 1 to 3
    for {
      i1 <- list
      i2 <- list if i1!=i2
    } println(s"compare [$i1 : $i2]")

  }

  // Compare elements complex
  def compareElements_complex() = {
    case class Claim(id: Int, value: Int)
    val list = Seq(
      Claim(1, 1),
      Claim(2, 6),
      Claim(3, 4),
      Claim(4, 4))

    val sameValue =
      for {
        i1 <- list
        i2 <- list
        // dont compare claims with same id
        if i1.id!=i2.id && i1.value==i2.value
      } yield (i1.id, (i1,i2))

    println(sameValue)

  }


  def main(args: Array[String]): Unit = {
    //    forFilter()
    //    println(forYield())
    //    println(forLoop())
    //    compareElements()
        compareElements_complex()
  }


}
