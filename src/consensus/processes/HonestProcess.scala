package consensus.processes

import consensus.protocols.Protocol
import consensus.{MessageSet, Network}

/**
  * Created by nikol on 16/02/2018.
  */
class HonestProcess(nw:Network) extends Process(nw) {
  override def execute(p: Protocol, ms:MessageSet): Unit = p.step(nw, this, ms)
}
