package edu.knoldus

import scala.reflect.runtime.universe._

abstract class Commission(val value: Int)

case class ClientSideCommission(override val value: Int) extends Commission(value)

case class StreetSideCommission(override val value: Int) extends Commission(value)

object CommisionEvaluation {

sealed trait CommissionDisplay {
    def totalDisplayCommission: String
  }

  implicit def calculateCommission[A <: Commission : TypeTag](commission_list: List[A]): String = {
    val sum = commission_list.map(_.value).sum
    typeOf[List[A]] match {
      case listType if listType =:= typeOf[List[ClientSideCommission]] => s"the total clientside commission is $sum"
      case listType if listType =:= typeOf[List[StreetSideCommission]] => s"the total streetside commission is $sum"
      case listType if listType =:= typeOf[List[Commission]] => s"the total normal commission is $sum"

    }
  }

 implicit class SubTraitClass[A <:Commission:TypeTag](commission_list:List[A]) extends CommissionDisplay {
   def totalDisplayCommission: String = {commission_list}
 }

}

