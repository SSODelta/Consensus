package consensus.protocols
import consensus.messages.MessageSet
import consensus.processes.{Network, Process}

/**
  * Created by nikol on 16/02/2018.
  */
class TrivialProtocol extends Protocol {
  override def step(nw: Network, p: Process, input: MessageSet): MessageSet = {
    nw.terminate(p)
    new MessageSet
  }
}
