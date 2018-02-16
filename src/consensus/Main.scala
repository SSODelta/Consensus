package consensus

/**
  * Created by nikol on 16/02/2018.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val n = new Network(new TrivialProtocol())
  }

}
