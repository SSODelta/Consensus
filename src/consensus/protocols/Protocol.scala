package consensus.protocols

import consensus.processes.Process
import consensus.{MessageSet, Network}

/**
  * Created by nikol on 16/02/2018.
  */
trait Protocol {

  def step(nw:Network, p:Process, input:MessageSet): MessageSet

}
