package _02_employee_hierarhy_client;

import _02_employee_hierarhy_component.Employee;
import _02_employee_hierarhy_composite.EmployeeGroup;
import _02_employee_hierarhy_leaf.IndividualEmployee;

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
