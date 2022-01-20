import java.lang.NumberFormatException

fun basic(args: Array<String>) {
    println("Guachiturren")
    val q = Question()
    println(q.question)
    q.answer = "42"
    q.display()

    // String interpolation
    println("The answer is ${q.answer}")

    // if as an expression
    val message = if(q.answer == q.correctAnswer) {
        "You are correct"
    } else {
        "Try again maybe?"
    }
    println(message)
    println(" --- also --- ")
    // Use of when
    q.printResult()

    // use of try/catch (can also be an expression but is not needed)
    val number:Int? = try {
        Integer.parseInt(q.answer)
    } catch (e:NumberFormatException) {
        null
    }
    println("The number is $number")
}


class Question {
    // Allow null values
    var answer: String? = null
    val correctAnswer: String = "42"
    val question: String = "What is the answer to life, the universe and everything?"

    fun display() {
        println("You said $answer")
    }

    fun printResult() {
        when (answer) {
            correctAnswer -> println("You are correct")
            else -> println("Keep trying yo'")
        }
    }
}