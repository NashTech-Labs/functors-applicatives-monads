
List(1, 2).map (_ + 8)
Some(4) map (_ + 1) map (_ * 3)


/*trait Functor[M[_]] {
  def map[A, B](f: A ⇒ B): M[A] ⇒ M[B]
}

implicit object OptionFunctor extends Functor[Option] {
  def map[A, B](f: A ⇒ B): Option[A] ⇒ Option[B]
  = option ⇒ option map f
}

implicit object ListFunctor extends Functor[List] {
  def map[A, B](f: A ⇒ B): List[A] ⇒ List[B]
  = list ⇒ list map f
}*/


/*import cats._
implicit val optionFunctor: Functor[Option] = new Functor[Option] {
  def map[A,B](fa: Option[A])(f: A => B) = fa map f
}

implicit val listFunctor: Functor[List] = new Functor[List] {
  def map[A,B](fa: List[A])(f: A => B) = fa map f
}

