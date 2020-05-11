package ProofUtils

import Formulae.{Disjunction, Formula}

case class DisjunctionIntroduction(leftDisjunct: Formula, rightDisjunct: Formula, side: LeftOrRight.Side) extends Step {
  override val symbol: String = "∨I"

  override def requirements: Set[Formula] = side match {
    case LeftOrRight.Left => Set(leftDisjunct)
    case LeftOrRight.Right => Set(rightDisjunct)
  }

  override def result: Formula = Disjunction(leftDisjunct, rightDisjunct)
}
