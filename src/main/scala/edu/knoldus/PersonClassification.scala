package edu.knoldus

import org.apache.log4j.Logger
import scala.util.Random

abstract class PersonClassification

case class Gamer() extends PersonClassification

case class Trainer() extends PersonClassification

case class Blogger(blogList: Map[String, Int], numberOfBlogs: Int) extends PersonClassification

object Operation extends PersonClassification with App {

  val log = Logger.getLogger(this.getClass)

  def response(person: PersonClassification): String = {
    person match {
      case g: Gamer => gamer()
      case t: Trainer => trainer()
      //case b: Blogger =>blogger()
      case _ => "no such person exist"
    }
  }

  def gamer(): String = {
    def diceCount(count: Int): String = {
      if (count > 0 && count <= 3) {
        val randomNumber = scala.util.Random
        val diceNum = Constants.ZERO + randomNumber.nextInt(Constants.SIX)
        diceNum match {
          case Constants.ONE | Constants.SIX => if (count == 0) "person is winner \n" else diceCount(count - 1)
          case _ => "person is looser \n"
        }
      }
      else {
        " please roll the dice atleast once \n"
      }
    }

    diceCount(0)
  }

  def trainer(): String = {
    val strength = scala.util.Random
    s" attendance is: ${strength.nextInt(Constants.FIFTYONE)}"
  }

  /*def blogger(blogList: Map[String, Int], numberOfBlogs: Int) :String = {

  }*/

  log.info(response(Gamer()))
  log.info(response(Trainer()))

}

