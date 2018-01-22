package edu.knoldus

import org.apache.log4j.Logger

object Application extends App {val log = Logger.getLogger(this.getClass)
  val one = 1
  val two = 2
  val five = 5
  val seven = 7
  val list = List(one, two, five, seven)

  val totalCommission = new TotalCommission
  val clientsidecommission_1 = ClientSideCommission(five)
  val clientsidecommission_2 =ClientSideCommission(five)
  val clientcommsionlist = List(clientsidecommission_1, clientsidecommission_2)
  val clientcommission = totalCommission.getTotalCommission[ClientSideCommission](clientcommsionlist)

  val streetsidecommission_1 =StreetSideCommission(two)
  val streetsidecommission_2 = StreetSideCommission(seven)
  val streetcommissinlist = List(streetsidecommission_1, streetsidecommission_2)
  val streetcommission = totalCommission.getTotalCommission[StreetSideCommission](streetcommissinlist)

  val combinedcommission = List(clientsidecommission_1, streetsidecommission_2)
  val normalcommission = totalCommission.getTotalCommission[Commission](combinedcommission)

  log.info(s" \n $clientcommission")
  log.info(s"\n $streetcommission")
  log.info(s"\n $normalcommission")

}
