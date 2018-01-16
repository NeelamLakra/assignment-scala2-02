package edu.knoldus

import org.apache.log4j.Logger
import scala.util.Random

abstract class PersonClassification
case class Gamer(dicerollcount:Int) extends PersonClassification
case class Trainer(attendance:Int) extends PersonClassification
case class Blogger(blogList: Map[String,Int], numberOfBlogs: Int) extends PersonClassification

object Operation extends PersonClassification with App{
  val log = Logger.getLogger(this.getClass)


  def response(person:PersonClassification):String ={
    person match{
      case Gamer(dicerollcount)=>
      case Trainer(attendance:Int)=>
      case Blogger(blogList: Map[String,Int], numberOfBlogs: Int)=>
    }
  }


}
