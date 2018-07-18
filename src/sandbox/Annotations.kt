package sandbox

import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.full.findAnnotation

@ImAPlant
class Plant {
    fun trim() {}
    fun fertilize() {}

    @get:OnGet
    val isGrowing : Boolean = true

    @set:OnSet
    var needsFood : Boolean = false
}

annotation class ImAPlant

@Target(AnnotationTarget.PROPERTY_GETTER)
annotation class OnGet

@Target(AnnotationTarget.PROPERTY_SETTER)
annotation class OnSet

fun reflection() {

    val classObejct = Plant::class

    for (annotation in classObejct.annotations) {
        println(annotation.annotationClass.simpleName)
    }

    val annotated = classObejct.findAnnotation<ImAPlant>()

    annotated?.apply { println("Found a plant annotation!") }
}

fun reflection1() {

    val classObejct = Plant::class

    for (method in classObejct.declaredMemberFunctions) {
        println(method.name)
    }
}