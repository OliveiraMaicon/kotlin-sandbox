package sandbox

fun main(array: Array<String>) {

    val list = mutableListOf(11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1)

    println(reverseList(list))
    println(reverseListAgain(list))

    list()
    map()

}

fun labelLoops() {

    loop@ for (i in 1..100) {
        for (j in 1..100) {
            if (i > 10) break@loop
        }
    }

}

fun reverseList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (i in 0 until list.size) {
        result.add(list[list.size - i - 1])

    }
    return result
}

fun reverseListAgain(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (i in list.size - 1 downTo 0) {
        result.add(list[i])

    }
    return result
}


fun list() {

    val symptons = mutableListOf("white spots", "red spots", "not eating", "bloated", "belly up")
    symptons.add("white fungus")
    symptons.remove("white fungus")

    println(symptons.contains("red"))
    println(symptons.contains("red spots"))

    println(symptons.subList(3, symptons.size))

    println(listOf(1, 4, 5, 6).sum())


    println(listOf("a", "b", "cc").sumBy { it.length })


}

fun map() {

    val cures = mapOf("white spots" to "ich", "red sores" to "hole disease")

    println(cures.get("white spots"))
    println(cures["white spots"])

    println(cures.getOrDefault("bloating", "sorry i don't know"))

    cures.getOrElse("bloating") { "no cure for this" }

    val invetory = mutableMapOf("fish net" to 1)
    //invetory.put("tank scrubber",2)
    invetory["tank scrubber"] = 2
    invetory.remove("fish net")
}