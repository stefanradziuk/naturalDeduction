package Formulae

case class Atom(name: String) extends Formula {
  override def getAtoms: Set[Atom] = Set(this)

  override def stringRepresentation: String = name
}
