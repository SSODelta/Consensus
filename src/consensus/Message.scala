package consensus

import consensus.processes.Process
/**
  * Created by nikol on 16/02/2018.
  */
class Message(sender:Process, recipient:Process, contents:Value = null) {

  def getContents = contents
  def getSender = sender
  def getRecipient = recipient

}
