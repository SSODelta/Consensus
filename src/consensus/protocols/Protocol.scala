package consensus.protocols

import consensus.processes.Process
import consensus.{Message, MessageSet, Network}

/**
  * Created by nikol on 16/02/2018.
  */
trait Protocol {

  def step(nw:Network, p:Process, ms:MessageSet): Message

}
