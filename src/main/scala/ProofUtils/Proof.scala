package ProofUtils

import Formulae.Formula

import scala.collection.mutable.ListBuffer

case class Proof(premises: List[Formula], objective: Formula) {
  var steps: ListBuffer[Step] = ListBuffer()
  premises.foreach(steps += Premise(_))

  def addStep(step: Step): Unit = {
    if (step.requirements forall hasShown) {
      steps += step
    } else {
      throw new IllegalArgumentException(s"Invalid step $step in proof [$this]")
    }
  }

  def isComplete: Boolean = hasShown(objective)

  private def hasShown: Formula => Boolean = steps.map(_.result) contains _

  private def printableSteps: String = steps.zipWithIndex.map {
    case (step, i) => String.format("%d. %s", i + 1, step)
  }.mkString("\n")

  override def toString: String = {
    printableSteps + (if (isComplete) "\nObjective proven!")
  }
}
