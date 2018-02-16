package consensus.processes

import consensus.protocols.Protocol
import consensus._
import consensus.messages.{Message, MessageSet, Value}

/**
  * Created by nikol on 16/02/2018.
  */
class ByzantineProcess(nw:Network) extends Process(nw) {

  def crash_chance = 50

  override def execute(p: Protocol, ms: MessageSet): MessageSet = {
    val ms = new MessageSet
    for(p <- nw.getProcesses)
      ms.put(p, new Message(this, p, if(Util.getRandom.nextInt(2)==0) Value.ONE else Value.ZERO))
    nw.terminate(this)
    ms
  }
}
