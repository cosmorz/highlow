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

    if (input == "high") {
      if (currentCard < deck.head) {
        println("Bingo!")
      } else {
        println("Wrong...")
      }
    } else {
      if (currentCard > deck.head) {
        println("Bingo!")
      } else {
        println("Wrong...")
      }
    }
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
