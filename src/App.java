
public class App {
    public static void main(String[] args) {
        /*
         We can call kotlin functions from java.
         The convention is to use filename for the class follow by Kt
         In this example I am accessing funcs.kt file and using the method
            funcs from that file.
                FuncsKY.displaySomething();
         BUT we can change that with @file:JvmName annotation, hence the KotlinFunctions
           @see: Funcs.kt file
         */
        KotlinFunctions.displaySomething();
    }
}
