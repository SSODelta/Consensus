package consensus.processes

import consensus._
import consensus.protocols.Protocol

/**
  * Created by nikol on 16/02/2018.
  */
abstract class Process(nw:Network) {

  val x = if(Util.getRandom.nextInt(2) == 0) Values.ZERO else Values.ONE
  val id = Util.getRandom.nextInt
  val pk = Util.getRandom.nextInt

  def execute(p: Protocol, ms:MessageSet) : MessageSet

}
