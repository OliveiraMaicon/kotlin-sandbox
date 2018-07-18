package sandbox


data class HighOrderFunctions(var name: String)



fun main(args: Array<String>){

    example()
}

fun example(){

    val hof = HighOrderFunctions("splashy")

    with(hof.name){
        println(capitalize())
    }


    myWith(hof.name){
        println(capitalize())
    }

    //withou inline an object is created every call to myWith
    myWith(hof.name, object: Function1<String,Unit>{
        override fun invoke(name: String) {
            println(name.capitalize())
        }

    })

    //with inline no object is created,and lambda body is inlined here
    hof.name.capitalize()

    //best practice to populate object
    hof.apply { name = "Sharky" }
    println(hof.name)

    //execute stuff and return result of the block function
    println(hof.run { name + "aaaa"})
    println(hof.name)

    //apply return object applied with new entries | common pattern to initialize objects
    println(hof.apply{})

    hof.apply { name = "bob" }

    val hof2 = HighOrderFunctions(name = "new").apply { name = "know" }
    println(hof2.name)

    //let return a copy of the changed object

    println(hof2.let { it.name.capitalize() }
            .let { it + "test" }
            .let { it.length }
            .let { it + 10 })

}

inline fun myWith(name: String, block: String.() -> Unit){
    name.block()
}