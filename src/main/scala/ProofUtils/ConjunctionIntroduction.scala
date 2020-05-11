package ProofUtils
import Formulae.{Conjunction, Formula}

case class ConjunctionIntroduction(leftConjunct: Formula, rightConjunct: Formula) extends Step {
  override val symbol: String = "∧I"

  override def requirements: Set[Formula] = Set(leftConjunct, rightConjunct)

  override def result: Formula = Conjunction(leftConjunct, rightConjunct)
}
