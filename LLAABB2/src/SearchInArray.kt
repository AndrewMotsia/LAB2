// Перевірити, чи є в масиві задане число.

fun main() {
    val numbers = arrayOf(3, 7, 9, 12)
    val target = 9
    if (target in numbers) {
        println("Число $target є в масиві")
    } else {
        println("Число $target не знайдено")
    }
}