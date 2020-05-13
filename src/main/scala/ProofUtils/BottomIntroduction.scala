package ProofUtils
import Formulae.{Bottom, Formula, Negation}

case class BottomIntroduction(formula: Formula) extends Step {
  //also referred to as negation elimination
  override val symbol: String = "⊥I"

  override def requirements: Set[Formula] = Set(formula, Negation(formula))

  override def result: Formula = Bottom
}
