package ProofUtils

import Formulae.Formula

case class Tick(formula: Formula) extends Step {
  override val symbol: String = "✓"

  override def requirements: Set[Formula] = Set(formula)

  override def result: Formula = formula
}
