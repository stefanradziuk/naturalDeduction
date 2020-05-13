package ProofUtils

import Formulae.Formula

import scala.collection.mutable.ListBuffer

case class Proof(premises: List[Formula], objective: Formula) extends ProofTrait {
  //todo make proofs immutable? (addStep: Proof)
  //todo refer to steps by their index

  override var steps: ListBuffer[Step] = ListBuffer()
  private var header: String = premises.mkString(", ") + s" ⊢ $objective\n"
  premises foreach (steps += Premise(_))

  override def alreadyProven(formula: Formula): Boolean = steps.map(_.result) contains formula

  override def toString: String = {
    header + stepsPrintable + (if (isComplete) "\nObjective proven!" else "\nObjective not yet proven")
  }

  override def stepsPrintable: String = steps.zipWithIndex.map {
    case (step, i) => String.format("%d. %s", i + 1, step)
  }.mkString("\n")
}
