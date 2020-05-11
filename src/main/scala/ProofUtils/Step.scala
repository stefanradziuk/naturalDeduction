package ProofUtils

import Formulae.Formula

abstract class Step {
  val symbol: String

  def requirements: Set[Formula]

  def result: Formula

  override def toString: String = String.format("%s\t%s", result.toString, symbol)
}
