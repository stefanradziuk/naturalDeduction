package Formulae

case object Top extends Formula {
  override def getAtoms: Set[Atom] = Set.empty

  override def stringRepresentation: String = "⊤"
}
