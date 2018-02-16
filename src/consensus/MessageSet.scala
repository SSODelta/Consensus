package consensus

import consensus.processes.Process

import scala.collection.mutable

/**
  * Created by nikol on 16/02/2018.
  */
class MessageSet {

  val map = new mutable.HashMap[Int, Message]

  def getMessage(p:Process): Message = map.getOrElseUpdate(p.id, new Message)

}
