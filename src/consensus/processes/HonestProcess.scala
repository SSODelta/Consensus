package consensus.processes

import consensus.protocols.Protocol
import consensus.messages.MessageSet

/**
  * Created by nikol on 16/02/2018.
  */
final class HonestProcess(nw:Network) extends Process(nw) {
  override def execute(p: Protocol, ms:MessageSet): MessageSet = p.step(nw, this, ms)
}
