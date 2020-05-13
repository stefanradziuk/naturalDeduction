package ProofUtils
import Formulae.{Formula, Implication}

case class ImplicationElimination(antecedent: Formula, consequent: Formula) extends Step {
  override val symbol: String = "→I"

  override def requirements: Set[Formula] = Set(antecedent)

  override def result: Formula = Implication(antecedent, consequent)
}
