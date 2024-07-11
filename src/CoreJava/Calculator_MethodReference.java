package CoreJava;

public class Calculator_MethodReference {

    public static Integer multiplyNums(int a, int b){
        return a*b;
    }

    public Integer divideNums(int a, int b){
        return a/b;
    }

    public static void main(String[] args) {

        Calculator_FunctionalInterface multiply = Calculator_MethodReference::multiplyNums;
        // instead of writing method logic as LE, we assign a MR, which will call the method
        // static method can be directly called

        Calculator_MethodReference obj = new Calculator_MethodReference();
        Calculator_FunctionalInterface divide = obj::divideNums;
        // non-static method need an object

        Calculator_FunctionalInterface compare = Integer::compare; // any random method can also be referred

       // Calculator_FunctionalInterface factory = CalculatorClass::new;

     //   int res0 = factory.calculate(5,6);

        int res1 = multiply.calculate(2,4);
        int res2 = divide.calculate(10,2);
        int res3 = compare.calculate(2,3);

     //   System.out.println(res0);
    }
}
