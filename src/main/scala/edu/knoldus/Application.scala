package edu.knoldus

import org.apache.log4j.Logger

abstract class PaymentMode
  case class Paytm() extends PaymentMode
  case class Freecharge() extends PaymentMode
  case class NetBanking() extends PaymentMode
  case class CardPayment() extends PaymentMode
  case class Cash() extends PaymentMode

object TiffinProblem extends PaymentMode with App{
  val log = Logger.getLogger(this.getClass)
  def payment(mode: PaymentMode, amount: Int): Double= {
    mode match {
      case a: Paytm =>amount + amount * 2 / 100
      case b: Freecharge => amount + amount * 2 / 100
      case c: NetBanking => amount + 5
      case d: CardPayment => amount + 1.5
      case e: Cash => amount
    }
  }
  val amount1 = 500
  log.info("Paytm: amount to pay is =>"+payment(Paytm(),amount1) +"\n")
  log.info("Freecharge: amount to pay is =>"+payment(Freecharge(),amount1) +"\n")
  log.info("NetBanking: amount to pay is =>"+payment(NetBanking(),amount1) +"\n")
  log.info("CardPayment : amount to pay is =>"+payment(CardPayment(),amount1) + "\n")
  log.info("Cash: amount to pay is =>"+payment(Cash(),amount1))
}
