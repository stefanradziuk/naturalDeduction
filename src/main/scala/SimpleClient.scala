import Formulae._
import ProofUtils.{LeftOrRight, _}

object SimpleClient {
  def main(args: Array[String]): Unit = {
    // checking formulae functionality
    val p: Atom = Atom("p")
    val q: Atom = Atom("q")

    val dis1: Disjunction = Disjunction(p, Negation(q))
    val con1: Conjunction = Conjunction(dis1, p)

    printf("The atoms in con1 %s are %s\n", con1, con1.getAtoms)

    // checking proof functionality
    println("\n----------\n")

    val proof1: Proof = Proof(List(p, q), Conjunction(p, q))
    proof1.addStep(ConjunctionIntroduction(p, q))
    println(proof1)

    println("\n----------\n")

    val proof2: Proof = Proof(List(Conjunction(p, q)), p)
    proof2.addStep(ConjunctionElimination(p, q, LeftOrRight.Left))
    println(proof2)

    /*
        println("\n----------")

        println("Attempting illegal proof")
        val illegalProof1: Proof = Proof(List(p, q), Conjunction(Negation(p), q))
        illegalProof1.addStep(ConjunctionIntroduction(Negation(p), q))
        println(illegalProof1)
    */

    println("\n----------\n")

    val boxProof: Proof = Proof(List.empty, Implication(p, p))
    val boxStep: ImplicationIntroduction = ImplicationIntroduction(boxProof, p, p)
    //note: the tick is not necessary
    boxStep.addStep(Tick(p))
    boxProof.addStep(boxStep)
    println(boxProof)

    println("\n----------\n")

    val bottomProof: Proof = Proof(List(p, Negation(p)), Bottom)
    bottomProof.addStep(BottomIntroduction(p))
    println(bottomProof)

    println("\n----------\n")

    val bottomProof2: Proof = Proof(List(Bottom), p)
    bottomProof2.addStep(BottomElimination(p))
    println(bottomProof2)

    println("\n----------\n")

    val negationProof: Proof = Proof(List(Implication(p, Bottom)), Negation(p))
    val negationBoxStep = NegationIntroduction(negationProof, p)
    negationBoxStep.addStep(ImplicationElimination(p, Bottom))
    negationProof.addStep(negationBoxStep)
    println(negationProof)

    println("\n----------\n")

    val r: Atom = Atom("r")

    val implicationProof: Proof = Proof(List(Implication(p, Implication(q, r))), Implication(Conjunction(p, q), r))
    val implicationBox = ImplicationIntroduction(implicationProof, Conjunction(p, q), r)
    implicationBox.addStep(ConjunctionElimination(p, q, LeftOrRight.Left))
    implicationBox.addStep(ImplicationElimination(p, Implication(q, r)))
    implicationBox.addStep(ConjunctionElimination(p, q, LeftOrRight.Right))
    implicationBox.addStep(ImplicationElimination(q, r))
    implicationProof.addStep(implicationBox)
    println(implicationProof)
  }
}
