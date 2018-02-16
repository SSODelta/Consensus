package consensus.protocols
import consensus.{MessageSet, Network}
import consensus.processes.Process

/**
  * Created by nikol on 16/02/2018.
  */
class TrivialProtocol extends Protocol {
  override def step(nw: Network, p: Process, input: MessageSet): MessageSet = {
    nw.terminate(p)
    new MessageSet
  }
}
