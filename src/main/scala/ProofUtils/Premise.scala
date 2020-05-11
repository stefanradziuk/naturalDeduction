package ProofUtils
import Formulae.Formula

case class Premise(formula: Formula) extends Step {
  override val symbol: String = "Premise"

  override def requirements: Set[Formula] = Set.empty

  override def result: Formula = formula
}
