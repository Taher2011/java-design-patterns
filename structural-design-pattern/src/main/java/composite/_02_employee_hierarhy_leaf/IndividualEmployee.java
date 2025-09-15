package composite._02_employee_hierarhy_leaf;

import composite._02_employee_hierarhy_component.Employee;
import composite._02_employee_hierarhy_composite.EmployeeGroup;

public class IndividualEmployee implements Employee {

	private String designation;

	public IndividualEmployee(String designation) {
		this.designation = designation;
	}

	@Override
	public void display() {
		System.out.println(" ".repeat(EmployeeGroup.counter) + this.designation);
	}
}
