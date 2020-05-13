package ProofUtils

import Formulae.{Bottom, Formula, Negation}

import scala.collection.mutable.ListBuffer

case class NegationIntroduction(override val parentProof: Proof
                                , override val assumption: Formula) extends BoxStep {
  override val objective: Formula = Bottom
  override var steps: ListBuffer[Step] = ListBuffer(Premise(assumption))

  override def requirements: Set[Formula] = Set.empty

  override def expectedResult: Formula = Negation(assumption)

  override val symbol: String = "¬I"
}
