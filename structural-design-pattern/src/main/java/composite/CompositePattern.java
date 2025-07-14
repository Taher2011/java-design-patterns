
import java.util.ArrayList;
import java.util.List;

interface Employee {
	void display();
}

class IndividualEmployee implements Employee {

	private String designation;

	public IndividualEmployee(String designation) {
		this.designation = designation;
	}

	@Override
	public void display() {
		System.out.println(" ".repeat(EmployeeGroup.counter) + this.designation);
	}
}

class EmployeeGroup implements Employee {

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

public class CompositePattern {

	public static void main(String[] args) {
		EmployeeGroup director = new EmployeeGroup("Director");

		EmployeeGroup projectManager = new EmployeeGroup("ProjectManager");
		director.addEmployee(projectManager);

		EmployeeGroup techLeadProjMngr = new EmployeeGroup("TechLead");
		projectManager.addEmployee(techLeadProjMngr);

		EmployeeGroup techManager = new EmployeeGroup("TechManager");
		director.addEmployee(techManager);

		EmployeeGroup techLeadTechMngr = new EmployeeGroup("TechLead");
		techManager.addEmployee(techLeadTechMngr);

		Employee softEng = new IndividualEmployee("SoftwareEng");
		techLeadTechMngr.addEmployee(softEng);

		Employee qa = new IndividualEmployee("QA");
		techLeadProjMngr.addEmployee(qa);

		director.display();
	}

}
