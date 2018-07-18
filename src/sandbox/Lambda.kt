package sandbox

fun main(array: Array<String>) {

    { println("Hello fish") }()


    val waterFilter = { dirty: Int -> dirty / 2 }

    println(waterFilter(30))

    val myFish =  listOf(Fish("Flipper"),Fish("Moby Dick"),Fish("Dory"))
    val teste = myFish.filter{ it.name.contains("i")}.joinToString(" result "){it.name}
    println(teste)


    val operation = {list: List<Int> -> list.sorted()}

    val list = listOf(1,5,6,12,2,4,3)

    println(teste(list,operation))


    val list2 = listOf(1,25,45,12,2,6,3)
    println(teste(list2,::sort))

    println(teste(list2){ list -> list.asReversed()})
}

data class Fish (val name: String)


fun teste(list: List<Int>, operation: (List<Int>) ->List<Int>): List<Int> {
    return operation(list)
}

fun sort(list: List<Int>) = list.sorted()