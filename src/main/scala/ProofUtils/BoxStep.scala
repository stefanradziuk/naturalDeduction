package ProofUtils

import Formulae.{Formula, Implication, Top}

import scala.collection.mutable.ListBuffer

trait BoxStep extends Proof with Step {
  val assumption: Formula
  val objective: Formula
  val parentProof: Proof
  override val premises: List[Formula] = List(assumption)
  override var steps: ListBuffer[Step]

  override def requirements: Set[Formula]

  final override def result: Formula = if (isComplete) expectedResult else Top

  protected def expectedResult: Formula

  final override def stepsPrintable: String = {
    steps.zipWithIndex.map {
      case (step, i) => String.format("%d. %s", i + 1, step)
    }.mkString("\n┌────────────────┐\n", "\n", "\n└────────────────┘\n")
  }

  override def toString: String = stepsPrintable + result + "\t" + symbol

  final override def alreadyProven(formula: Formula): Boolean = {
    steps.map(_.result).contains(formula) || parentProof.alreadyProven(formula)
  }
}
