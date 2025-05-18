// Прийняти ім’я користувача (String?), вивести "Привіт, [ім’я]", або "Привіт, Anonymous" якщо null/порожнє.

fun main() {
    print("Введи своє ім’я: ")
    val name: String? = readlnOrNull()
    val displayName = if (name.isNullOrBlank()) "Anonymous" else name
    println("Привіт, $displayName")
}