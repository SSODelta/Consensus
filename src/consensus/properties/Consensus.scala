package consensus.properties
import consensus.Value

/**
  * Created by nikol on 16/02/2018.
  */
object Consensus extends Property {
  override def holds(honestValues: List[Value]): Boolean = {
    var allSame = true
    var sameval:Value = null
    for(v <- honestValues){
      if(sameval == null){sameval = v}
      allSame = allSame & v==sameval
    }
    allSame & sameval != Value.ERROR
  }
}
