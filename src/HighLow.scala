import scala.util.Random

/**
  * Created by kota on 2016/09/17.
  */
object HighLow {
  def main(args: Array[String]): Unit = {

    val cards: List[Card] = Random.shuffle((1 to 13).map(n => Card(n))).toList

    val result = game(cards.head, cards.tail, 5)

    if (result) {
      println("Clear!")
    } else {
      println("Wrong...")
    }
  }

  def game(card: Card, deck: List[Card], count: Int): Boolean = {
    println("Game Count: " + count)

    println("Current Card is " + card.number)

    println("input: high / low")
    val input = scala.io.StdIn.readLine

    println("Next Card is " + deck.head.number)

    val judge = input match {
      case "high" => higher(deck.head, card)
      case "low" => higher(card, deck.head)
      case _ => false
    }

    println("")

    (judge, count) match {
      case (false, _) => false
      case (true, 1) => true
      case (true, _) => game(deck.head, deck.tail, count - 1)
    }
  }

  def higher(c1: Card, c2: Card): Boolean = {
    c1.number > c2.number
  }
}

case class Card(number: Int) {
  def <(card: Card): Boolean = {
    this.number < card.number
  }

  def >(card: Card): Boolean = {
    this.number > card.number
  }
}
