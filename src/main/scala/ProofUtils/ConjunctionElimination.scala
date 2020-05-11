package ProofUtils

import Formulae.{Conjunction, Formula}

case class ConjunctionElimination(leftConjunct: Formula, rightConjunct: Formula, side: LeftOrRight.Side) extends Step {
  override val symbol: String = "∧E"

  override def requirements: Set[Formula] = Set(Conjunction(leftConjunct, rightConjunct))

  override def result: Formula = side match {
    case LeftOrRight.Left => leftConjunct
    case LeftOrRight.Right => rightConjunct
  }
}
