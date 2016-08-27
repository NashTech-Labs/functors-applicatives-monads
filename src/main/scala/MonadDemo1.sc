
class Monad[T](val value: T) {

  def flatMap[A, B](func: A => Monad[B]): Monad[A] => Monad[B] = {
    (a: Monad[A]) => func(a.value)
  }
}


val stringContainer: Monad[String] = new Monad("Knoldus Software LLP")

def lengthOf(str: String) = new Monad(str.length)

val transformedLength = stringContainer.flatMap(lengthOf)

val result: Monad[Int] = transformedLength(stringContainer)

result.value










































//Treat generic monad as interface and concrete monad as implementation

trait M[A] {
  def flatMap[B](f: A => M[B]): M[B]
  //	def flatMap[A,B](f:A =>M[B]):M[A]=>M[B]
}


























/*
Unit performs the wrapping part, defined it outside because we don't want to
invoke it upon existing monadic object. So create it as standalone static
method
 */
//def unit[A](x: A): M[A]
//val f=(i:Int)=>List("prev="+(i-1),"curr="+i,"fwd="+(i+1))
//val list=List(9,10,11)
//list.flatMap(f)