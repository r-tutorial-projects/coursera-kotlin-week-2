fun main() {
    val numbers = 1..10
    val (evenNumbers, notEvenNumbers) = numbers.partition { it % 2 == 0 }
    println(evenNumbers)
    println(notEvenNumbers)
}
