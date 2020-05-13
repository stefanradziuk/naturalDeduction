package ProofUtils
import Formulae.{Formula, Implication}

case class ImplicationElimination(antecedent: Formula, consequent: Formula) extends Step {
  override val symbol: String = "→E"

  override def requirements: Set[Formula] = Set(Implication(antecedent, consequent))

  override def result: Formula = consequent
}
