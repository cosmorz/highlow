import scala.util.Random

/**
  * HIGH&LOW ゲーム
  */
object HighLow {
  def main(args: Array[String]): Unit = {

    val cards: List[Card] = Random.shuffle((1 to 13).map(n => Card(n))).toList

    if (game(cards.head, cards.tail, 5)) {
      println("You win!")
    } else {
      println("You lose...")
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

    println("Next Card is " + deck.head.number + "\n")

    (judge(card, deck.head, input), count) match {
      case (false, _) => false
      case (true, 1) => true
      case (true, _) => game(deck.head, deck.tail, count - 1)
    }
  }

  /**
    * カード比較処理
    *
    * @param card  場札
    * @param head  比較札
    * @param input 入力文字列
    * @return 比較結果
    */
  def judge(card: Card, head: Card, input: String): Boolean = {
    input match {
      case "high" => head.number > card.number
      case "low" => card.number > head.number
      case _ => false
    }
  }
}

/**
  * カード クラス
  *
  * @param number
  */
case class Card(number: Int)
