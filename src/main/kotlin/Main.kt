import kotlin.math.ln
import kotlin.math.round
import kotlin.math.abs
fun task1(symbolsArray: CharArray) {
    var count = 1
    for (i in 0 until symbolsArray.size) {
        if (i < symbolsArray.size - 1 && symbolsArray[i] == symbolsArray[i + 1]) {
            count++
        } else {
            print(symbolsArray[i])
            if (count > 1) {
                print(count)
            }
            count = 1
        }
    }
}
fun task2(symbolsArray: CharArray) {
    val sorted = symbolsArray.clone()
    sorted.sort()
    println()
    var count = 1
    for (i in 0 until sorted.size) {
        if (i < sorted.size - 1 && sorted[i] == sorted[i + 1]) {
            count++
        } else {
            print("${sorted[i]} - $count\n")
            count = 1
        }
    }
}
fun task3(number: Int) {
    val result = ArrayList<Int>()
    var dividedNumber = number
    do {
        result.add(dividedNumber % 2)
        dividedNumber /= 2
    } while (dividedNumber > 0)

    for (i in result.size - 1 downTo 0) print(result[i])
}
fun task4(n1: Double?, n2: Double?, symbol: Char?) {
    if (n1 == null || n2 == null) {
        println("Неверный тип данных!")
        return
    }

    val result = when (symbol) {
        '+' -> n1 + n2
        '-' -> n1 - n2
        '*' -> n1 * n2
        '/' -> {
            if (n2 == 0.0) {
                println("Деление на нуль!")
                return
            }
            n1 / n2
        }
        else -> {
            println("Неизвестная операция '$symbol'")
            return
        }
    }

    println("Ответ: $result")
}
fun task5(x: Double?, n: Double?) {
    if (x == null || n == null) {
        println("Неверный тип данных")
        return
    }

    if (x == 1.0 || x <= 0 || n <= 0) {
        println("Данные не удовлетворяют ОДЗ")
        return
    }

    var y = ln(n) / ln(x)
    var roundedY = round(y)

    if (abs(y - roundedY) < 1e-10) {
        var check = Math.pow(x, roundedY)
        if (abs(check - n) < 1e-10) {
            println("Результат: y = $roundedY")
        } else {
            println("Целочисленный показатель не существует")
        }
    } else {
        println("Целочисленный показатель не существует")
    }
}
fun main(args: Array<String>) {
    println("Выберите действие, которое будет делать программа.\n"
            + "1) Алгоритм сжатия RLE (Run-Length Encoding);\n"
            + "2) Приложение, которое подсчитывает количество различных символов во введённой строке. Символы выводятся в алфавитном порядке;\n"
            + "3) Приложение, которое преобразует введенное  натуральное число из 10-ичной системы в двоичную;\n"
            + "4) Приложение, которое запрашивает у пользователя два числа и символ операции, и она даёт ответ. Символы операции: / — деление, * — умножение, + — сложение, - — вычитание;\n"
            + "5) Приложение, которое запрашивает у пользователя два целых числа: x - основание степени и n. Оно показывает, существует ли целочисленный  показатель y, для которого выполняется равенство x^y = n. В случае, если показатель существует – он вычисляется и выводится на экран. В противном случае, появляется сообщение – «Целочисленный показатель не существует;\n"
            + "6) .")
    print("Выбор: ")
    val choice = readln().toIntOrNull()
    when (choice) {
        1 -> {
            val str = "AAADSSSRRTTHAAAA"
            val symbolsArray = str.toCharArray()
            print("Исходная строка: ")

            for (i in symbolsArray) print(i)
            println()
            print("RLE сжатие: ")
            task1(symbolsArray)
        }
        2 -> {
            val str = "AASADDSS"
            val symbolsArray = str.toCharArray()
            print("Исходная строка: ")
            for (i in symbolsArray) print(i)
            println()
            print("Результат: ")
            task2(symbolsArray)
        }
        3 -> {
            print("Введите натуральное число: ")
            var number = readln()?.toIntOrNull() ?: 0 // ?. оператор безопасного вызова
            print("Двоичная запись числа: ")
            task3(number)
        }
        4 -> {
            print("Введите первое число: ")
            var n1 = readln().toDoubleOrNull()

            print("Введите второе число: ")
            var n2 = readln().toDoubleOrNull()

            print("Введите математическую операцию (+, -, *, /): ")
            var symbol = readln().trim().firstOrNull()
            task4(n1, n2, symbol)
        }
        5 -> {
            print("Введите x: ")
            var x = readln().toDoubleOrNull()

            print("Введите n: ")
            var n = readln().toDoubleOrNull()

            task5(x, n)
        }

        else -> println("Такого пункта нет")
    }
}