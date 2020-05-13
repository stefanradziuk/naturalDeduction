package Formulae

case class Disjunction(leftDisjunct: Formula, rightDisjunct: Formula) extends Formula {
  override def getAtoms: Set[Atom] = leftDisjunct.getAtoms ++ rightDisjunct.getAtoms

  override def stringRepresentation: String = String.format("(%s ∨ %s)", leftDisjunct.toString, rightDisjunct.toString)
}
