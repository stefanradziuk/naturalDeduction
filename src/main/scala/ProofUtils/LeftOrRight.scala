package ProofUtils

object LeftOrRight {
  sealed trait Side
  case object Left extends Side
  case object Right extends Side
}
