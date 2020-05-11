package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun main(args: Array<String>) {
    val s1: String? = null
    val s2: String? = ""
    println("" + s1.isEmptyOrNull() + " eq true")
    println("" + s2.isEmptyOrNull() + " eq true")

    val s3 = "   "
    println("" + s3.isEmptyOrNull() + " eq false")
}

fun String?.isEmptyOrNull(): Boolean = this == null || this.isEmpty()

fun evaluateGuess(secret: String, guess: String): Evaluation {
    // count 1-4 in SECRET, count 1-4 in GUESS
    // Wrong position = COUNT - rightPosition

    val s1: String? = null
    s1!!.length

    val rightPosition = secret.zip(guess).count {
        it.first == it.second
    }
    val wrongPosition = "ABCDEF".sumBy { ch ->
        secret.count { it == ch }.coerceAtMost(guess.count { it == ch })
    } - rightPosition
    return Evaluation(rightPosition, wrongPosition)
}

private fun String.getMatches(guess: String): Int {
    var result = 0
    val guessFoundList = mutableListOf<Int>()
    val secretFoundList = mutableListOf<Int>()
    for ((ic, c) in this.withIndex()) {
        for ((ig, g) in guess.withIndex()) {
            when {
                !guessFoundList.contains(ig) && !secretFoundList.contains(ic) && c == g -> {
                    guessFoundList.add(ig)
                    secretFoundList.add(ic)
                    result++
                }
            }
        }
    }
    return result
}
