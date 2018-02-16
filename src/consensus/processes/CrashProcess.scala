package consensus.processes

import consensus.{MessageSet, Network, Util}
import consensus.protocols.Protocol

/**
  * Created by nikol on 16/02/2018.
  */
class CrashProcess(nw:Network) extends Process(nw) {

  def crash_chance = 50

  override def execute(p: Protocol, ms: MessageSet): MessageSet = {
    if(Util.getRandom.nextInt(100) < crash_chance){
      nw.terminate(this)
      new MessageSet
    } else {
      p.step(nw, this, ms)
    }
  }
}
