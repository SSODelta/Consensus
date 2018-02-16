package consensus.processes

import consensus._
import consensus.protocols.Protocol

/**
  * Created by nikol on 16/02/2018.
  */
abstract class Process(nw:Network) {

  var x = if(Util.getRandom.nextInt(2) == 0) Value.ZERO else Value.ONE
  val id = Util.getRandom.nextInt
  val pk = Util.getRandom.nextInt

  def execute(p: Protocol, ms:MessageSet) : MessageSet

}
