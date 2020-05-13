package Formulae

case class Conjunction(leftConjunct: Formula, rightConjunct: Formula) extends Formula {
  override def getAtoms: Set[Atom] = leftConjunct.getAtoms ++ rightConjunct.getAtoms

  override def stringRepresentation: String = String.format("(%s ∧ %s)", leftConjunct.toString, rightConjunct.toString)
}
