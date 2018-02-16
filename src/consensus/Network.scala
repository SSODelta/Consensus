package consensus

import consensus.processes.Process
import consensus.protocols.Protocol
import scala.collection.mutable

/**
  * Created by nikol on 16/02/2018.
  */
class Network(protocol:Protocol) {

  val live_processes = mutable.MutableList[Process]()
  val dead_processes = mutable.MutableList[Process]()
  var map = mutable.HashMap[Process, MessageSet]()

  def terminate(p:Process){
    live_processes.filter(q => q != p);
    dead_processes += p
  }

  def step = {

    val newmap = mutable.HashMap[Process, MessageSet]()
    for(p <- live_processes)
      newmap.put(p, new MessageSet(p))
    for(p <- live_processes){
      val output: MessageSet = p.execute(protocol, map.getOrElse(p, new MessageSet(p)));
      for(m <- output){
        newmap.getOrElse(m.getRecipient, new MessageSet(p)).put(p, output.get(m.getRecipient))
      }
    }

    map = newmap
  }

}
