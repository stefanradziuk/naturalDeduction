package ProofUtils

import Formulae.Formula

import scala.collection.mutable.ListBuffer

case class Proof(premises: List[Formula], objective: Formula) {
  var steps: ListBuffer[Step] = ListBuffer()
  premises.foreach(steps += Premise(_))

  def addStep(step: Step): Unit = {
    //todo check if the step reqs are met
    steps += step
  }

  def isComplete: Boolean = steps.map(_.result) contains objective

  private def printableSteps: String = steps.zipWithIndex.map(_.swap).map {
    case (i, step) => String.format("%d. %s", i + 1, step)
   }.mkString("\n")

  override def toString: String = {
    printableSteps + (if (isComplete) "\nObjective proven!")
  }
}
