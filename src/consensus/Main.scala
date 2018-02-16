package consensus

import consensus.properties.Consensus
import consensus.protocols.NaiveProtocol

/**
  * Created by nikol on 16/02/2018.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val n = new Network(10, 0, 0, new NaiveProtocol)
    var t = 0;
    while(n.live()){
      n.step
      t += 1
    }

    if(Consensus.holds(n.getValues())){
      println(s"satisfies consensus")
    } else println("does not satisfy consensus")

    println(s"Terminated in $t steps");
  }

}
