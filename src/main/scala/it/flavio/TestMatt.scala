package it.flavio

object TestMatt {

  def main(args: Array[String]): Unit = {
    sealed trait Colour
    object Colour {
      case object Red extends Colour
      case object Blue extends Colour
    }

    val foo: Colour = Colour.Red
    def checkColour: String = foo match {
      case Colour.Red => "Red"
      case Colour.Blue => "Blue"
    }
    print(checkColour)

    val part1: Int => Int = i => i * 2
    val part2: Int => Int = i => i * 3
    val part3: Int => Int = i => i * 4

    val test = part1 andThen part2 andThen part3
    val res = test(2)
    println(res)

    //def add(n1: Int, n2: Int): Int = n1 + n2

    case class Number(value: Int) {
      def add(otherNumber: Number): Number = Number((this.value + otherNumber.value))
    }

    Number(2).add(Number(7))
    val sum = Number(2) add Number(7)
    println(sum)

    val t2: (Int, String) = (1, "yes")
    println(t2)
    println(t2._1)
    println(t2._2)

    val testMap: Map[Int, String] = Map(1 -> "yes", 2 -> "no")
    val testMap2: Map[Int, String] = Map(1 -> "true", 2 -> "false", 3 -> "true")
    println(testMap2.zip(testMap))

    case class Person(name: String, age: Int)
    val l1 = Seq(Person("Matt", 42), Person("Flavio", 35))
    val l2 = Seq(Person("Flavio", 35))
    println(l1)
    println(l2)

    case class Shoe(name: String, discount: Option[Int])
    val s1 = Shoe("blue shoe", None)
    val s2 = Shoe("green shoe", Some(2))
    val shoes = Seq(s1, s2)
    println(shoes)

    val flattened = shoes.flatMap(_.discount)
    println(flattened)

    /*
    shoes.map(c => c.discount match {
      case Some(d) => (c, s"£$d")
    })
     */
  }

}
