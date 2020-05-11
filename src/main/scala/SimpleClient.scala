import Formulae._
import ProofUtils._

object SimpleClient {
  def main(args: Array[String]): Unit = {
    // checking formulae functionality
    val p: Atom = Atom("p")
    val q: Atom = Atom("q")

    val dis1: Disjunction = Disjunction(p, Negation(q))
    val con1: Conjunction = Conjunction(dis1, p)

    printf("The atoms in con1 %s are %s\n", con1, con1.getAtoms)

    // checking proof functionality
    println("----------")
    val proof1: Proof = Proof(List(p, q), Conjunction(p, q))
    proof1.addStep(ConjunctionIntroduction(p, q))
    println(proof1)

    println("----------")
    val proof2: Proof = Proof(List(Conjunction(p, q)), p)
    // taking an unnecessary step
    proof2.addStep(ConjunctionElimination(p, q, LeftOrRight.Right))
    proof2.addStep(ConjunctionElimination(p, q, LeftOrRight.Left))
    println(proof2)

    /*
        println("----------")
        println("Attempting illegal proof")
        val illegalProof1: Proof = Proof(List(p, q), Conjunction(Negation(p), q))
        illegalProof1.addStep(ConjunctionIntroduction(Negation(p), q))
        println(illegalProof1)
    */
  }
}
