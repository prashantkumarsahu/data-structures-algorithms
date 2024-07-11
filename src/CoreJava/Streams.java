package CoreJava;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.BaseStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Student{
    int roll;
    int marks;
    String name;

    Student(int r, int m, String n){
        roll = r;
        marks = m;
        name = n;
    }
    int getRoll(){return roll;}
    int getMarks(){return marks;}
    String getName(){return name;}

}
public class Streams {

    public static void main(String[] args) {

        // BaseStream

        Stream.iterate(1, x->x+1)
                .filter(x -> x.toString().contains("3"))
                .limit(100).forEach(System.out::println);

        Student[] students = {
                new Student(110,70,"abc"),
                new Student(120, 80,"def"),
                new Student(130,70,"ghi")
        };

        Map<Integer,String> map =
                Arrays.stream(students)
                .collect(Collectors.toMap(Student::getRoll, Student:: getName));

        for(Map.Entry<Integer,String> e: map.entrySet()){
            System.out.println(e.getKey() + " " + e.getValue());
        }


    }
}
