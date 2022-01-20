@file:JvmName("KotlinFunctions")

import java.math.BigInteger

fun funcs(args: Array<String>) {
    // Function as expression
    println("The max value is ${max(5, 40)}")

    // Default parameters
    log("Something to log")
    log("some other log message", 3)

    // Named parameters (once you name one, you have to name all)
    // note that the order can be any
    nameParams(thisChange = "CHANGE", message = "Some new message")

    // Extension functions
    val someString: String = "some     stuff    with several    whitespaces"
    println(someString.replaceWhiteSpaces())

    // InFix functions
    val sc1 = SomeClass("Hello ")
    val sc2 = SomeClass("World!")
    val sc3 = SomeClass(" from operator")
    val sc4 = sc1 suma sc2
    println(sc4.name)
    // This can be done because I added the operator reserve word
    // this overload the "plus" operator
    val sc5 = sc4 + sc3
    println(sc5.name)

    // Tail recursive
    println(fib(100000, BigInteger("1"), BigInteger("0")))
}


// Function expression
// (since the if can also be an expression, this works
fun max(a: Int, b: Int): Int = if (a > b) a else b

// Import kotlin to java classes
fun displaySomething() {
    println("This function is from Kotlin")
}

// Default parameters
/*
The JvmOverloads allow the use of default values when we
use this kotlin function in java. It will output two methods,
one with and another without the second parameter
 */
@JvmOverloads
fun log(message: String, logLevel: Int = 1) {
    println("[LOG] - $message - level: $logLevel")
}

// Named params
fun nameParams(message: String, alwaysDefault: Int = 1, thisChange: String = "This hasn't change") {
    println("Message: $message - Default: $alwaysDefault - Change: $thisChange")
}

// Extension functions (kind like prototype)
fun String.replaceWhiteSpaces(): String {
    val regex = Regex("\\s+")
    // this will be the 'receiver' or value of the parameter in a normal function
    return regex.replace(this, " ")
}

// Infix functions
/*
this functions are member or extension functions
have a single parameter
 */
class SomeClass(var name: String) {}

infix fun SomeClass.suma(other: SomeClass): SomeClass {
    return SomeClass(this.name + other.name)
}

infix operator fun SomeClass.plus(other: SomeClass): SomeClass {
    return this suma other
}

// Tail recursive
// This will behave more like a loop, so you don't get a stack overflow in this
// situations
tailrec fun fib(n: Int, a: BigInteger, b: BigInteger): BigInteger {
    return if (n == 0) b else fib(n - 1, a + b, a)
}