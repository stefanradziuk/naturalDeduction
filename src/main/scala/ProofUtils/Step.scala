package ProofUtils

import Formulae.Formula

trait Step {
  val symbol: String

  def requirements: Set[Formula]

  def result: Formula

  override def toString: String = {
    String.format("%s\t%s(%s)", result.toString, symbol, requirements.mkString(", "))
  }
}
