package org.atp.exceptions;

public class Main {
    public static void main(String[] args) {
        ExceptionExample1 exceptionExample1 = new ExceptionExample1();
        ExceptionExample2 exceptionExample2 = new ExceptionExample2();
        ExceptionExample3 exceptionExample3 = new ExceptionExample3();
        NpeExceptionHandler npeExceptionHandler = new NpeExceptionHandler();

        exceptionExample1.foo();
        // если запустить код, то получим:
        //   Exception in thread "main" java.lang.ArithmeticException: / by zero
        //   at org.atp.exceptions.ErrorExample1.foo(ErrorExample1.java:5)
        //   at org.atp.exceptions.Main.main(Main.java:6)
        exceptionExample2.foo();
        // если запустить код, то получим:
//           Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 3
//           at org.atp.exceptions.ErrorExample2.foo(ErrorExample2.java:6)
//           at org.atp.exceptions.Main.main(Main.java:12)
        exceptionExample3.foo();
        // если запустить код, то получим:
//            Exception in thread "main" java.lang.NullPointerException: Cannot invoke "org.atp.exceptions.Viewer.show()" because "this.viewer" is null
//            at org.atp.exceptions.ErrorExample3.foo(ErrorExample3.java:7)
//            at org.atp.exceptions.Main.main(Main.java:18)

        npeExceptionHandler.foo();
        // если запустить код, то получим:
        // деление на ноль!!!
        // Null pointer
    }
}
