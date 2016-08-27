//FUNCTOR
class Functor[T](val value: T) {
  def map[A, B](rawFunc: A => B): Functor[A] => Functor[B] = {
    (a: Functor[A]) => new Functor(rawFunc(a.value))
  }
}

/*
Apply Some Transformation on the value type in the Container
without leaving the Container. Some other type shall also be in Container.
Eg.
Functor[String]=>Functor[Int]

We need :
def lengthOfString(str:Functor[String]):Functor[Int]
*/
//Application 1
def rawLengthOfString(str: String): Int = str.length
val stringContainer: Functor[String] = new Functor("Knoldus Software LLP")
val transformedLength = stringContainer.map(rawLengthOfString)
val result: Functor[Int] = transformedLength(stringContainer)
result.value

//Application 2
def rawIntConversion(num:Int):String=num.toString
val intContainer:Functor[Int]= new Functor(100)
val transformedInt=intContainer.map(rawIntConversion)
val res:Functor[String]=transformedInt(intContainer)
res.value.length

//Application 3
class Book(bookName:String,bookPrice:Double,bookAuthor:String){
  var name:String=bookName
  var price:Double=bookPrice
  var author:String=bookAuthor
}
class LibraryBook(bookName:String,bookPrice:Double,bookAuthor:String){
  var name:String=bookName
  var price:Double=bookPrice
  var author:String=bookAuthor
  var ispn:Option[String]=None

  def ispn(cat:String): String ={
    val generatedIspn=cat+"-"+this.author+"-"+scala.util.Random.nextInt()
    ispn=Some(generatedIspn)
    generatedIspn
  }
}
val userContainer:Functor[Book]=new Functor(new Book("Scala",2000.12,"Martin Odersky"))
def conversion(book:Book):LibraryBook= {
  val generateBook=new LibraryBook(book.name,book.price,book.author)
  generateBook.ispn("Fiction")
  generateBook
}
val transformation=userContainer.map(conversion)
val transformedResult=transformation(userContainer)

val newBook=transformedResult.value.ispn






