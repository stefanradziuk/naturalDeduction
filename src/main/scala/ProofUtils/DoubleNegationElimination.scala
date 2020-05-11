package ProofUtils

import Formulae.{Formula, Negation}

case class DoubleNegationElimination(formula: Formula) extends Step {
  override val symbol: String = "¬¬E"

  override def requirements: Set[Formula] = Set(Negation(Negation(formula)))

  override def result: Formula = formula
}
