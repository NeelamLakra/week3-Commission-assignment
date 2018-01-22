package edu.knoldus

import CommisionEvaluation._

import scala.reflect.runtime.universe._

class TotalCommission {
  def getTotalCommission[A <: Commission : TypeTag](commission_list: List[A]): String = {
commission_list.totalDisplayCommission
  }
}


