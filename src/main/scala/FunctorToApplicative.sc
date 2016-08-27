import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

def f (x: Int)(y: Int):Int= x + y
/*map() takes a function of only one parameter,
 so using currying we can transform any function to one
 parameter function */
val result :Future[Int => Int]= Future(42).map(f)
/*
 result is Future(x => x + 42)
 Problem : map() doesn’t know how to work
 with a function wrapped inside a future.

 Solution :Applicative Functors
  */

val num1 = Future(3)
val num2 = Future(4)
val num3 = Future(5)
val calculate = ( (num1:Int, num2:Int, num3:Int) => num1 + num2 + num3 ).curried
val zipped = num1.zip(num2).zip(num3)
val res=zipped.map { case ((num1, num2), num3) => calculate(num1)(num2)(num3) }

/*
Zips the values of multiple future,
and creates a new future holding the tuple of their results.
 */

