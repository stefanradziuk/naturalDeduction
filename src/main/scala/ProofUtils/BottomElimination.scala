package ProofUtils
import Formulae.Formula

case class BottomElimination(formula: Formula) extends Step {
  override val symbol: String = "⊥E"

  override def requirements: Set[Formula] = Set.empty

  override def result: Formula = formula
}
