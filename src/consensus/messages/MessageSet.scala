package consensus.messages

import consensus.processes.Process

import scala.collection.mutable

/**
  * Created by nikol on 16/02/2018.
  */
class MessageSet() extends Iterable[Message] {

  val map = new mutable.HashMap[Int, Message]

  def get(p:Process): Message = map.getOrElseUpdate(p.id, new Message(p,null))

  def put(p:Process, msg:Message) = map += (p.id -> msg)

  override def iterator: Iterator[Message] = map.values.iterator
}
