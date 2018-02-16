package consensus.properties

import consensus.messages.Value

/**
  * Created by nikol on 16/02/2018.
  */
trait Property {

  def holds(honestValues:List[Value]): Boolean

}
