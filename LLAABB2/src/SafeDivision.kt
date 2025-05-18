// Обробити ділення на нуль через try-catch

fun main() {
    try {
        print("Введи перше число (ділене): ")
        val a = readln().toInt()

        print("Введи друге число (дільник): ")
        val b = readln().toInt()

        val result = a / b
        println("Результат: $result")
    } catch (e: ArithmeticException) {
        println("Помилка: Ділення на нуль")
    } catch (e: NumberFormatException) {
        println("Помилка: Треба вводити тільки числа")
    }
}