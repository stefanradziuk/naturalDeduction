package Formulae

case object Bottom extends Formula {
  override def getAtoms: Set[Atom] = Set.empty

  override def stringRepresentation: String = "⊥"
}
