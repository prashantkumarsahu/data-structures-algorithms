package CoreJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class JavaIO {

    public static void main(String[] args) throws IOException {
        // In BufferedReader All data types are accepted as String
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the number or string: ");

        // Scanner has different input Modes for different datatypes
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Integer i = sc.nextInt();
        Float f = sc.nextFloat();

       // String a = br.readLine();

        System.out.println("You entered: " + s); // auto converts other datatypes into string if not explicitly done
        System.out.format("Value of float f = %.3f\n", f);
        System.out.printf("x = %d, y = %f", i, f); // %d = integer
    }
}
