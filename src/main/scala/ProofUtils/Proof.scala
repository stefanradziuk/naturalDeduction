package ProofUtils

import Formulae.Formula

import scala.collection.mutable.ListBuffer

case class Proof(premises: List[Formula], objective: Formula) extends ProofTrait {
  //todo make proofs immutable? (addStep: Proof)

  override var steps: ListBuffer[Step] = ListBuffer()
  premises.foreach(steps += Premise(_))

  override def alreadyProven(formula: Formula): Boolean = steps.map(_.result) contains formula

  override def toString: String = {
    premises.mkString(", ") + s" ⊢ $objective\n" + stepsPrintable + (if (isComplete) "\nObjective proven!")
  }

  override def stepsPrintable: String = steps.zipWithIndex.map {
    case (step, i) => String.format("%d. %s", i + 1, step)
  }.mkString("\n")
}
