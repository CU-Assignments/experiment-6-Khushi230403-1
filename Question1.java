import java.util.*;

class Employee {
    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }
    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", salary=" + salary + "}";
    }
}

public class EmployeeSortExample {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("John", 25, 50000),
            new Employee("Alice", 30, 70000),
            new Employee("Bob", 28, 45000),
            new Employee("Diana", 35, 80000),
            new Employee("Charlie", 23, 60000)
        );
        System.out.println("Sorting by Age:");
        employees.sort((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));
        employees.forEach(System.out::println);
        System.out.println("\nSorting by Salary:");
        employees.sort((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        employees.forEach(System.out::println);
        System.out.println("\nSorting by Name:");
        employees.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));
        employees.forEach(System.out::println);
    }
}
