package ProofUtils

import Formulae.{Formula, Implication}

import scala.collection.mutable.ListBuffer

case class ImplicationIntroduction(parentProof: Proof
                                   , assumption: Formula
                                   , objective: Formula) extends BoxStep {
  //assumption takes on the role of an antecedent, objective is the consequent
  //todo abstract out the box functionality?

  override val premises: List[Formula] = List(assumption)
  override var steps: ListBuffer[Step] = ListBuffer(Premise(assumption))

  override val symbol: String = "→I"

  override def requirements: Set[Formula] = Set.empty

  override def result: Formula = Implication(antecedent = assumption, consequent = objective)

  override def toString: String = stepsPrintable + result + "\t" + symbol

  override def alreadyProven(formula: Formula): Boolean = {
    steps.map(_.result).contains(formula) || parentProof.alreadyProven(formula)
  }
}
