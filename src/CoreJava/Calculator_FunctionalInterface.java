package CoreJava;


@java.lang.FunctionalInterface
public interface Calculator_FunctionalInterface {

    int result = 0;

    abstract int calculate(int a, int b); // by default method is abstract

    //int multiply (int a, int b);

    static void SetAndPrintResult() {
        System.out.println(result);
    }

    default void printName(){
        System.out.println("Hello");
    }
}

