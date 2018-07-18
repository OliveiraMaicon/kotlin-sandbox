package sandbox

fun main(array: Array<String>) {

    { println("Hello fish") }()


    val waterFilter = { dirty: Int -> dirty / 2 }

    println(waterFilter(30))

    val myFish =  listOf(Fish("Flipper"),Fish("Moby Dick"),Fish("Dory"))
    val teste = myFish.filter{ it.name.contains("i")}.joinToString(" result "){it.name}
    println(teste)
}

data class Fish (val name: String)