import java.lang.NumberFormatException
import java.util.*

fun loops(args: Array<String>) {
    // Declare range
    var myValues = 1..10
    // Can also declare range over string
    var strRange = 'a'..'d'
    println("- for-in ------------------------------------")
    for(ch in strRange) {
        println(ch)
    }
    // For in
    println("- for-in with numbers ------------------------------------")
    for(i in myValues) {
        println(i)
    }
    println("- until ------------------------------------")
    // downTo (inverse loop)
    for(i in 1 until 10) {
        println(i)
    }
    println("- down-to ------------------------------------")
    // downTo (inverse loop)
    for(i in 10 downTo 1) {
        println(i)
    }
    println("- for-in with steps ------------------------------------")
    // With steps (all previous examples can have step)
    for(i in myValues step 2) {
        println(i)
    }
    println("- loop though list ------------------------------------")
    var numbers = listOf<Int>(1,2,3,4,5)
    for(i in numbers) {
        println(i)
    }
    println("- with Index ------------------------------------")
    for((index, element) in numbers.withIndex()) {
        println("Number on index $index is $element")
    }
    println("- loop though maps ------------------------------------")
    var ages = TreeMap<String, Int>()
    ages["kevin"] = 12
    ages["peter"] = 54
    ages["charlse"] = 25
    for(age in ages) {
        println(age)
    }
    for ((person, age) in ages) {
        println("$person is $age y/o")
    }

 }

