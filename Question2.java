import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    double marks;

  
    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

   
    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return name + " - " + marks + "%";
    }
}

public class StudentFilterSortExample {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 82.5),
            new Student("Bob", 65.0),
            new Student("Charlie", 92.0),
            new Student("David", 55.0),
            new Student("Eve", 78.5),
            new Student("Frank", 88.0)
        );

       
        students.stream()
                .filter(s -> s.getMarks() > 75) // Filter students with marks above 75%
                .sorted((s1, s2) -> Double.compare(s2.getMarks(), s1.getMarks())) // Sort by marks (descending)
                .map(Student::getName) // Extract names of students
                .forEach(System.out::println); // Display names
    }
}
