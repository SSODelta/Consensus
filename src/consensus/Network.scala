package consensus

import consensus.processes.{ByzantineProcess, CrashProcess, HonestProcess, Process}
import consensus.protocols.Protocol

import scala.collection.mutable

/**
  * Created by nikol on 16/02/2018.
  */
class Network(n:Int, c:Int, t:Int, protocol:Protocol) {

  var live_processes = mutable.MutableList[Process]()
  val dead_processes = mutable.MutableList[Process]()
  var map = mutable.HashMap[Process, MessageSet]()

  for(i <- 1 to n)
    live_processes += new HonestProcess(this)
  for(i <- 1 to c)
    live_processes += new CrashProcess(this)
  for(i <- 1 to t)
  live_processes += new ByzantineProcess(this)

  def terminate(p:Process){
    live_processes = live_processes.filter(q => q != p);
    dead_processes += p
  }

  def getValues():List[Value] = dead_processes.map(p => p.x).toList

  def getProcesses() = live_processes

  def live() = live_processes.nonEmpty

  def step = {

    val newmap = mutable.HashMap[Process, MessageSet]()
    for(p <- live_processes)
      newmap.put(p, new MessageSet)
    for(p <- live_processes){
      val output: MessageSet = p.execute(protocol, map.getOrElse(p, new MessageSet()));
      for(m <- output){
        newmap.getOrElse(m.getRecipient, new MessageSet()).put(p, output.get(m.getRecipient))
      }
    }

    map = newmap
  }

}
