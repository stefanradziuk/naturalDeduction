package ProofUtils

import Formulae.{Disjunction, Formula}

case class DisjunctionElimination(leftDisjunct: Formula, rightDisjunct: Formula, side: LeftOrRight.Side) extends Step {
  override val symbol: String = "∨E"

  override def requirements: Set[Formula] = Set(Disjunction(leftDisjunct, rightDisjunct))

  override def result: Formula = side match {
    case LeftOrRight.Left => leftDisjunct
    case LeftOrRight.Right => rightDisjunct
  }
}
