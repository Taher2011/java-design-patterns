package _02_employee_hierarhy_composite;

import java.util.ArrayList;
import java.util.List;

import _02_employee_hierarhy_component.Employee;

public class EmployeeGroup implements Employee {

	private String designation;

	public static int counter = 0;

	List<Employee> employees = new ArrayList<>();

	public EmployeeGroup(String designation) {
		this.designation = designation;
	}

	public String getDesignation() {
		return designation;
	}

	@Override
	public void display() {
		System.out.println(" ".repeat(counter) + "+" + this.designation);
		counter++;
		for (Employee employee : employees) {
			employee.display();
		}
		counter--;
	}

	public void addEmployee(Employee employee) {
		employees.add(employee);
	}
}
