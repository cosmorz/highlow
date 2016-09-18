import scala.util.Random

/**
  * Created by kota on 2016/09/17.
  */
object HighLow {
  def main(args: Array[String]): Unit = {
    val cards: List[Card] = Random.shuffle((1 to 13).map(n => Card(n))).toList

    val currentCard = cards.head
    val deck = cards.tail
    println("場のカードは" + currentCard.number)

    println("high / low")
    val input = scala.io.StdIn.readLine

    val nextCard = deck.head
    println("Next Card is " + nextCard.number)

    val judge = input match {
      case "high" => higher(nextCard, currentCard)
      case "low" => higher(currentCard, nextCard)
      case _ => false
    }

    if (judge) {
      println("Bingo!")
    } else {
      println("Wrong...")
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
