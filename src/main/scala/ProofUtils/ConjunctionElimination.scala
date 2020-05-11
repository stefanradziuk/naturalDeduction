package ProofUtils

import Formulae.{Conjunction, Formula}

case class ConjunctionElimination(leftConjunct: Formula, rightConjunct: Formula, picker: LeftOrRight.Side) extends Step {
  override val symbol: String = "∧E"

  override def requirements: Set[Formula] = Set(Conjunction(leftConjunct, rightConjunct))

  override def result: Formula = picker match {
    case LeftOrRight.Left => leftConjunct
    case LeftOrRight.Right => rightConjunct
  }
}
