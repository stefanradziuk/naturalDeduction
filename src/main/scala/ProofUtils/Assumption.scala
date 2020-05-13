package ProofUtils

import Formulae.Formula

case class Assumption(formula: Formula) extends Step {
  override val symbol: String = "ass"

  override def requirements: Set[Formula] = Set.empty

  override def result: Formula = formula

  override def toString: String = String.format("%s\t%s", result.toString, symbol)
}
