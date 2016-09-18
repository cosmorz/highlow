import scala.util.Random

/**
  * HIGH&LOW ゲーム
  */
object HighLow {
  def main(args: Array[String]): Unit = {

    val cards: List[Card] = Random.shuffle((1 to 13).map(n => Card(n))).toList

    if (game(cards.head, cards.tail, 5)) {
      println("Clear!")
    } else {
      println("Wrong...")
    }
  }

  /**
    * HIGH&LOW 本体
    *
    * @param card  場札
    * @param deck  山札
    * @param count 残りゲーム回数
    * @return ゲーム結果
    */
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

  /**
    * カード比較処理
    *
    * @param c1 カード
    * @param c2 カード
    * @return 比較結果
    */
  def higher(c1: Card, c2: Card): Boolean = {
    c1.number > c2.number
  }
}

/**
  * カード クラス
  *
  * @param number
  */
case class Card(number: Int)
