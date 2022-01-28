import java.sql.Struct

/*
It supports basic definition, default methods and properties
 */

// All is public by default (interface, classes, method, attributes, etc)
interface TestTimeInterface {
    fun setTime(hours: Int, mins: Int = 0, secs: Int = 0)

    // Defining default method implementation in the interface
    fun setTime(time: PingoTime) = setTime(time.hours)
}

interface BreakingTimeInterface {
    fun setTime(time: PingoTime)
}

class PingoTime {
    var hours: Int = 0
    var minutes: Int = 0
    var seconds: Int = 0
}

// Kotlin does not have implements nor extends keywords
class YetiTime : TestTimeInterface {
    override fun setTime(hours: Int, mins: Int, secs: Int) {
        TODO("Not yet implemented")
    }
}

// Implements 2 interfaces
class DualYetiTime : TestTimeInterface, BreakingTimeInterface {
    override fun setTime(hours: Int, mins: Int, secs: Int) {
        TODO("Not yet implemented")
    }

    // We can use specific implementation from the interface doing this
    override fun setTime(time: PingoTime) {
        super<TestTimeInterface>.setTime(time)
    }
}

// Sealed classes (I require more explanation)
sealed class PersonEvent {
    class Awake : PersonEvent()
    class Asleep : PersonEvent()
    class Eating(val food: String) : PersonEvent()
}

fun handlePersonEvent(event: PersonEvent) {
    when (event) {
        is PersonEvent.Awake -> println("Awake")
        is PersonEvent.Asleep -> println("Asleep")
        is PersonEvent.Eating -> println(event.food)
    }
}

// Constructor
// v1
abstract class Person(var firstName: String, var lastName: String) {
    open fun getName(): String = "$firstName $lastName"
    abstract fun getAddress(): String

}


// Check how to extend a class with constructor arguments
class ExtendClassWithConstructor(firstName: String, lastName: String, _id: Int) :
    Person(firstName, lastName) {
    val id: Int
    var tutor: String

    // Primary constructor (see tutor)
    init {
        this.id = _id
        this.tutor = ""
    }

    // Secondary constructor (see tutor)
    constructor(firstName: String, lastName: String, _id: Int, tutor: String) : this(firstName, lastName, _id, ) {
        this.tutor = tutor
    }

    override fun getAddress(): String {
        return ""
    }

}

// Data class - have special methods like equals, toString and copy
fun useDataClass() {
    var kevin = MyDataClass(1, "Kevin")
    var jones = MyDataClass(1, "Kevin")

    // This is true because the equals method in the data classes compare values not
    // memory address
    if (kevin == jones) {
        println("EQUALS")
    }

    var newKevin = kevin.copy(name = "Robert")
    println(newKevin)
}


data class MyDataClass(val id: Int, val name: String) {

}