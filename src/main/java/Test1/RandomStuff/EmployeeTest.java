package Test1.RandomStuff;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeeTest {

    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(5, "Frank", 28));
        employeeList.add(new Employee(1, "Jorge", 19));
        employeeList.add(new Employee(6, "Bill", 34));
        employeeList.add(new Employee(3, "Michel", 10));
        employeeList.add(new Employee(7, "Simpson", 8));
        employeeList.add(new Employee(4, "Clerk",16 ));
        employeeList.add(new Employee(8, "Lee", 40));
        employeeList.add(new Employee(2, "Mark", 30));

        //There are different ways in which you could use a Comparator

        //First way is to create a new class that implements the Comparator interface
        //Note how CompareEmployeeByName is being passed
        employeeList.sort(new CompareEmployeeByName());

        //Else, you could make use of Lambda Expressions instead of writing a new class
        //Sorts in ascending order of names
        System.out.println("\nAscending order using Lambda Expressions");
        employeeList.sort((emp1, emp2) -> {
            if (emp1.getName().compareTo(emp2.getName()) > 0) {
                return 1;
            } else if (emp1.getName().compareTo(emp2.getName()) < 0) {
                return -1;
            } else {
                return 0;
            }
        });
        System.out.println(employeeList);

        //Sorts in descending order of names
        System.out.println("\nDescending order using Lambda Expressions");
        employeeList.sort((emp1, emp2) -> {
            if (emp1.getName().compareTo(emp2.getName()) > 0) {
                return -1;
            } else if (emp1.getName().compareTo(emp2.getName()) < 0) {
                return 1;
            } else {
                return 0;
            }
        });
        System.out.println(employeeList);

        //Sort in ascending order
        System.out.println("\nAscending order using Integer.compare");
        employeeList.sort((emp1, emp2) -> Integer.compare(emp1.getName().compareTo(emp2.getName()), 0));
        System.out.println(employeeList);

        //Sort in descending order
        System.out.println("\nDescending order using Integer.compare");
        employeeList.sort((emp1, emp2) -> Integer.compare(0, emp1.getName().compareTo(emp2.getName())));
        System.out.println(employeeList);

    }

}

//This Comparator class will sort the Employees in the ascending order of their names
class CompareEmployeeByName implements Comparator<Employee>{

    @Override
    public int compare(Employee emp1, Employee emp2) {

        if (emp1.getName().compareTo(emp2.getName()) > 0) {
            return 1;
        } else if (emp1.getName().compareTo(emp2.getName()) < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}

//This Comparator class will sort the Employees in the descending order of their names
class CompareEmployeeByNameReversed implements Comparator<Employee>{

    @Override
    public int compare(Employee emp1, Employee emp2) {

        if (emp2.getName().compareTo(emp1.getName()) > 0) {
            return 1;
        } else if (emp2.getName().compareTo(emp1.getName()) < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
