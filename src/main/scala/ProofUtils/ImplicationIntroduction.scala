package ProofUtils

import Formulae.{Formula, Implication}

import scala.collection.mutable.ListBuffer

case class ImplicationIntroduction(parentProof: ProofTrait
                                   , assumption: Formula
                                   , objective: Formula) extends ProofTrait with Step {
  //todo abstract out the box functionality?

  override val premises: List[Formula] = List(assumption)
  override var steps: ListBuffer[Step] = ListBuffer(Premise(assumption))

  override val symbol: String = "→I"

  override def requirements: Set[Formula] = Set.empty

  override def result: Formula = Implication(assumption, objective)

  override def stepsPrintable: String = {
    steps.zipWithIndex.map {
      case (step, i) => String.format("%d. %s", i + 1, step)
    }.mkString("\n┌────────────────┐\n", "\n", "\n└────────────────┘\n")
  }

  override def toString: String = stepsPrintable + result + "\t" + symbol

  override def alreadyProven(formula: Formula): Boolean = {
    steps.map(_.result).contains(formula) || parentProof.alreadyProven(formula)
  }
}
