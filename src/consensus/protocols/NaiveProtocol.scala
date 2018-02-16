package consensus.protocols
import consensus.messages.{Message, MessageSet, Value}
import consensus.processes.{Network, Process}

/**
  * Created by nikol on 16/02/2018.
  */
class NaiveProtocol extends Protocol {
  override def step(nw: Network, p: Process, input: MessageSet): MessageSet = {
    if(input.isEmpty){
      val ms = new MessageSet
      for(q <- nw.getProcesses())
        ms.put(q, new Message(p, q, p.x))
      ms
    } else {
      var map = Map[Value, Int]()
      for(m <- input){
        val c = m.getContents
        map = map + (c -> (1 + map.getOrElse(c, 0)))
      }
      p.x = if(map.getOrElse(Value.ONE, 0) > map.getOrElse(Value.ZERO, 0)) Value.ONE else Value.ZERO
      nw.terminate(p)
      new MessageSet
    }
  }
}
