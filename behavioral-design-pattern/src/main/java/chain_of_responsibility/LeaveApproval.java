package chain_of_responsibility;

import java.time.Duration;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
class LeaveApplication {
	private String type;
	private String status;
	private LocalDateTime to;
	private LocalDateTime from;
	private String approver;
}

// handler
@Getter
abstract class Employeee {

	private String roleName;

	private Employeee successor;

	protected Employeee(String roleName, Employeee successor) {
		this.roleName = roleName;
		this.successor = successor;
	}

	public boolean approveLeaveApplicationRequest(LeaveApplication leaveApplication) {
		if (!handleRequest(leaveApplication) && successor != null) {
			successor.approveLeaveApplicationRequest(leaveApplication);
		}
		System.out.println();
		return false;
	}

	protected abstract boolean handleRequest(LeaveApplication leaveApplication);

}

// concrete handler
class LeadEmployeeHandler extends Employeee {

	public LeadEmployeeHandler(String roleName, Employeee successor) {
		super(roleName, successor);
	}

	@Override
	public boolean handleRequest(LeaveApplication leaveApplication) {
		long between = Duration.between(leaveApplication.getFrom(), leaveApplication.getTo()).toDays();
		if (leaveApplication.getType().equals("Sick") && between <= 2) {
			leaveApplication.setApprover(getRoleName());
			System.out.println("request approved by " + leaveApplication.getApprover());
			return true;
		} else {
			this.getSuccessor().handleRequest(leaveApplication);
		}
		return false;
	}

}

//concrete handler
class ManagerEmployeeHandler extends Employeee {

	public ManagerEmployeeHandler(String roleName, Employeee successor) {
		super(roleName, successor);
	}

	@Override
	public boolean handleRequest(LeaveApplication leaveApplication) {
		long between = Duration.between(leaveApplication.getFrom(), leaveApplication.getTo()).toDays();
		if ((leaveApplication.getType().equals("Sick") || leaveApplication.getType().equals("PTO")) && between <= 5) {
			leaveApplication.setApprover(getRoleName());
			System.out.println("request approved by " + leaveApplication.getApprover());
			return true;
		} else {
			this.getSuccessor().handleRequest(leaveApplication);
		}
		return false;
	}

}

//concrete handler
class DirectorEmployeeHandler extends Employeee {

	public DirectorEmployeeHandler(String roleName, Employeee successor) {
		super(roleName, successor);
	}

	@Override
	public boolean handleRequest(LeaveApplication leaveApplication) {
		long between = Duration.between(leaveApplication.getFrom(), leaveApplication.getTo()).toDays();
		if ((leaveApplication.getType().equals("PTO") || leaveApplication.getType().equals("LWP")) && between <= 10) {
			leaveApplication.setApprover(getRoleName());
			System.out.print("request approved by " + leaveApplication.getApprover());
			return true;
		}
		return false;
	}

}

public class LeaveApproval {

	public static void main(String[] args) {
		LeaveApplication leaveApplication = LeaveApplication.builder().type("LWP").from(LocalDateTime.now())
				.to(LocalDateTime.of(2025, 07, 23, 0, 0)).build();

		Employeee directroHandler = new DirectorEmployeeHandler("Director", null);
		Employeee managerHandler = new ManagerEmployeeHandler("Manager", directroHandler);
		Employeee leadHandler = new LeadEmployeeHandler("Lead", managerHandler);
		leadHandler.handleRequest(leaveApplication);
		System.out.print(" for leave type " + leaveApplication.getType() + " for "
				+ Duration.between(leaveApplication.getFrom(), leaveApplication.getTo()).toDays() + " days");
	}

}
