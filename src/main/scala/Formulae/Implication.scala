package Formulae

case class Implication(antecedent: Formula, consequent: Formula) extends Formula {
  override def getAtoms: Set[Atom] = antecedent.getAtoms ++ consequent.getAtoms

  override def toString: String = String.format("(%s → %s)", antecedent.toString, consequent.toString)
}
