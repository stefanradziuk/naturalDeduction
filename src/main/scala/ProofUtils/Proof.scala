package ProofUtils

import Formulae.Formula

import scala.collection.mutable.ListBuffer

trait Proof {

  val premises: List[Formula]
  val objective: Formula

  protected var steps: ListBuffer[Step]

  def addStep(step: Step): Unit = {
    if (step.requirements forall alreadyProven) {
      steps += step
    } else {
      //todo come up with functional error handling
      throw new IllegalArgumentException(s"Invalid step $step in proof [$this]")
    }
  }

  def isComplete: Boolean = alreadyProven(objective)

  def alreadyProven(formula: Formula): Boolean

  protected def stepsPrintable: String
}
