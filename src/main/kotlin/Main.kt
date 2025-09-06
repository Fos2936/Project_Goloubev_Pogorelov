fun main(args: Array<String>) {
    val str = "A"
    val symbolsArray = str.toCharArray()

    for (i in symbolsArray) print(i)
    println()
    var count = 1
    for (i in 0 .. symbolsArray.size - 1) {
        if (i == symbolsArray.size - 1) {
            print(symbolsArray[i])
            print(count)
            break;
        }
        if (symbolsArray[i] == symbolsArray[i + 1]) {
            count++
        }
        else {
            print(symbolsArray[i])
            if (count == 1) {
                continue
            }
            print(count)
            count = 1
        }
    }
}