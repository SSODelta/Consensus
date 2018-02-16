package consensus.protocols

import consensus.processes.{Network, Process}
import consensus.messages.MessageSet

/**
  * Created by nikol on 16/02/2018.
  */
trait Protocol {

  def step(nw:Network, p:Process, input:MessageSet): MessageSet

}
