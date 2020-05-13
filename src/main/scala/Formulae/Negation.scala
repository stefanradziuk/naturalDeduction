package Formulae

case class Negation(innerFormula: Formula) extends Formula {
  override def getAtoms: Set[Atom] = innerFormula.getAtoms

  override def stringRepresentation: String = String.format(innerFormula match {
    case _: Atom => "¬%s"
    case _ => "¬(%s)"
  }, innerFormula.toString)

}
