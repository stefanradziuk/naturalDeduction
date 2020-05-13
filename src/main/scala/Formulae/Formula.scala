package Formulae

trait Formula {
  def getAtoms: Set[Atom]

  def stringRepresentation: String

  override def toString: String = stringRepresentation
}
