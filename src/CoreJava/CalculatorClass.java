package CoreJava;

public class CalculatorClass {

    int a,b;

    CalculatorClass(int a, int b){
        a = a;
        b=b;
    }

    public static void main(String[] args) {

        Calculator_FunctionalInterface add = (a,b) -> a+b;
        Calculator_FunctionalInterface subtract = (a,b) -> a-b;

        int res1 = add.calculate(2,3);
        int res2 = subtract.calculate(3,3);

        System.out.println(res2);
    }
}
