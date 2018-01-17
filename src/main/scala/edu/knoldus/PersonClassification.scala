package edu.knoldus

import org.apache.log4j.Logger
import scala.util.Random

abstract class PersonClassification
case class Gamer() extends PersonClassification
case class Trainer() extends PersonClassification
case class Blogger() extends PersonClassification

object Operation extends PersonClassification with App {
  val log = Logger.getLogger(this.getClass)

  def response(person: PersonClassification): String = {
    person match {
      case g: Gamer => gamer()
      case t: Trainer =>trainer()
      //case b: Blogger =>
      case _=>"no such person exist"
    }
  }

  def gamer(): String = {
    def diceCount(count: Int): String = {
      val ran = scala.util.Random
      val diceNum = 1 + ran.nextInt(6)

      diceNum match {

        case 1 | 6 if (count != 0) => diceCount(count - 1)
        case 1 | 6 if (count == 0) => "person is winner \n "
        case _ => "person is looser \n"
      }
    }
    diceCount(2)
  }

  def trainer(): String ={
      val strength = scala.util.Random
     s" attendance is: ${strength.nextInt(50)}"
    }

  def blogger()

  log.info(response(Gamer()))
  log.info(response(Trainer()))
}