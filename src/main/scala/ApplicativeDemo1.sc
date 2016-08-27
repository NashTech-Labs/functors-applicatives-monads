class Applicative[T](val value: T) {

  def apply[A, B](b: Applicative[A => B]): Applicative[A] => Applicative[B] = {
    (a: Applicative[A]) => new Applicative[B](b.value(a.value))
  }
}

val stringContainer: Applicative[String] = new Applicative("Knoldus Software LLP")

def rawLengthOfString(str: String): Int = str.length

val lengthOf: Applicative[String => Int] = new Applicative(rawLengthOfString _)

def transformedLength = stringContainer.apply(lengthOf)

val result: Applicative[Int] = transformedLength(stringContainer)

result.value



























/*
trait Applicative[F[_]] {
  def apply[A, B](f: F[A => B]): F[A] => F[B]
}

 */