package week3.단일책임원칙;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void printEmployeeInfo() {
        System.out.println("name = " + name);
        System.out.println("salary = " + salary);
    }


}
class EmployeeSaver {
    public void saveEmployeeInfoToFile() {
        List<Employee> list = new ArrayList<>();
        //list.add();
        //작원 정보를 파일에 저장 -> 저장 로직
    }
}
