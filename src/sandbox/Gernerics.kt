package sandbox


fun main (args: Array<String>){
    genericsExample()

}

open class WaterSupply(var needProcessed: Boolean)


class TapWater : WaterSupply(true){
    fun addChemicalCleaners() = apply { needProcessed = true }
}

class FishStoreWater : WaterSupply(false)

class LakeWater :  WaterSupply(true){
    fun filter() = apply { needProcessed = false }
}

//Out types
class Aquarium<out T: WaterSupply>(val waterSupply: T){

    fun addWater(cleaner: Cleaner<T>){

        if (waterSupply.needProcessed){
            cleaner.clean(waterSupply)
        }
        /*check(!waterSupply.needProcessed) {"water supply need processed"}*/

        println("adding water from $waterSupply")
    }

   //inline fun <reified R: WaterSupply> hasWaterSupplyOfType() = waterSupply is R
}

inline fun <reified R: WaterSupply> Aquarium<*>.hasWaterSupplyOfType()= waterSupply is R

fun <T: WaterSupply>isWaterClean(aquarium: Aquarium<T>){
    println("aquarium water is clean: ${aquarium.waterSupply.needProcessed}")
}

inline fun <reified T: WaterSupply> WaterSupply.isOfType() = this is T


//In types

interface Cleaner<in T: WaterSupply>{
    fun clean(waterSupply: T)
}

class TapWaterCleaner: Cleaner<TapWater>{

    override fun clean(waterSupply: TapWater) {
        waterSupply.addChemicalCleaners()
    }

}


fun genericsExample(){

    val aquarium: Aquarium<TapWater> = Aquarium(TapWater())

    //Example IN
    val cleaner = TapWaterCleaner()
    aquarium.addWater(cleaner)


    //Example Generics functions 1
    isWaterClean(aquarium)
    println(aquarium.hasWaterSupplyOfType<TapWater>())
    println(aquarium.hasWaterSupplyOfType<FishStoreWater>())

    //Example Generics functions 2
    println(aquarium.waterSupply.isOfType<TapWater>())
    println(aquarium.waterSupply.isOfType<FishStoreWater>())
}