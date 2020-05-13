package ProofUtils

import Formulae.{Formula, Implication}

import scala.collection.mutable.ListBuffer

case class ImplicationIntroduction(override val parentProof: Proof
                                   , override val assumption: Formula
                                   , override val objective: Formula) extends BoxStep {
  //assumption takes on the role of an antecedent, objective is the consequent

  override var steps: ListBuffer[Step] = ListBuffer(Premise(assumption))
  override val symbol: String = "→I"

  override def requirements: Set[Formula] = Set.empty

  override def expectedResult: Formula = Implication(antecedent = assumption, consequent = objective)

  override def toString: String = stepsPrintable + result + "\t" + symbol
}
