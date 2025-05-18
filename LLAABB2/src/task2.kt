fun main() {
    print("Введіть кількість студентів: ")
    val n = readln().toIntOrNull() ?: 0

    val names = Array(n) { "" }
    val grades = Array(n) { 0 }

    for (i in 0 until n) {
        println("Студент №${i + 1}")


        print("Ім’я: ")
        val rawName: String? = readlnOrNull()
        val name = rawName?.takeIf { it.isNotBlank() } ?: "Unknown"
        names[i] = name


        var grade: Int
        while (true) {
            try {
                print("Оцінка (0-100): ")
                val input = readln()
                grade = input.toInt()
                if (grade !in 0..100) throw InvalidGradeException(grade)
                grades[i] = grade
                break
            } catch (e: NumberFormatException) {
                println("Помилка: введено не число.")
            } catch (e: InvalidGradeException) {
                println("Помилка: ${e.message}")
            }
        }
    }

    // Розрахунки оцінок
    val average = grades.average()
    val maxGrade = grades.maxOrNull() ?: 0
    val minGrade = grades.minOrNull() ?: 0
    val excellentStudents = names.zip(grades).filter { it.second >= 90 }.map { it.first }


    val level = when {
        average >= 90 -> "Високий рівень"
        average >= 70 -> "Середній рівень"
        else -> "Низький рівень"
    }


    println("\n=== Результати ===")
    println("Середня оцінка: %.2f".format(average))
    println("Максимальна оцінка: $maxGrade")
    println("Мінімальна оцінка: $minGrade")
    println("Відмінники: ${if (excellentStudents.isEmpty()) "немає" else excellentStudents.joinToString(", ")}")
    println("Рівень групи: $level")
}

// Власний виняток
class InvalidGradeException(grade: Int) : Exception("Недопустима оцінка: $grade")