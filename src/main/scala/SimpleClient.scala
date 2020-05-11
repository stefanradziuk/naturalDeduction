import Formulae._
import ProofUtils._

object SimpleClient {
  def main(args: Array[String]): Unit = {
    val p: Atom = Atom("p")
    val q: Atom = Atom("q")

    val dis1: Disjunction = Disjunction(p, Negation(q))
    val con1: Conjunction = Conjunction(dis1, p)

    printf("The atoms in con1 %s are %s\n", con1, con1.getAtoms)

    val proof1: Proof = Proof(List(p, q), Conjunction(p, q))
    proof1.addStep(ConjunctionIntroduction(p, q))
    println(proof1)
  }
}
