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

	private Employeee successor;

	protected Employeee(Employeee successor) {
		this.successor = successor;
	}

	protected abstract boolean handleRequest(LeaveApplication leaveApplication);

}

// concrete handler
class LeadEmployeeHandler extends Employeee {

	public LeadEmployeeHandler(Employeee successor) {
		super(successor);
	}

	@Override
	public boolean handleRequest(LeaveApplication leaveApplication) {
		long between = Duration.between(leaveApplication.getFrom(), leaveApplication.getTo()).toDays();
		if (leaveApplication.getType().equals("Sick") && between <= 2) {
			leaveApplication.setApprover("Lead");
			System.out.println("request approved by " + leaveApplication.getApprover());
			return true;
		} else {
			return this.getSuccessor().handleRequest(leaveApplication);
		}
	}

}

//concrete handler
class ManagerEmployeeHandler extends Employeee {

	public ManagerEmployeeHandler(Employeee successor) {
		super(successor);
	}

	@Override
	public boolean handleRequest(LeaveApplication leaveApplication) {
		long between = Duration.between(leaveApplication.getFrom(), leaveApplication.getTo()).toDays();
		if ((leaveApplication.getType().equals("Sick") || leaveApplication.getType().equals("PTO")) && between <= 5) {
			leaveApplication.setApprover("Manager");
			System.out.println("request approved by " + leaveApplication.getApprover());
			return true;
		} else {
			return this.getSuccessor().handleRequest(leaveApplication);
		}
	}

}

//concrete handler
class DirectorEmployeeHandler extends Employeee {

	public DirectorEmployeeHandler(Employeee successor) {
		super(successor);
	}

	@Override
	public boolean handleRequest(LeaveApplication leaveApplication) {
		long between = Duration.between(leaveApplication.getFrom(), leaveApplication.getTo()).toDays();
		if ((leaveApplication.getType().equals("PTO") || leaveApplication.getType().equals("LWP")) && between <= 10) {
			leaveApplication.setApprover("Director");
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

		Employeee directroHandler = new DirectorEmployeeHandler(null);
		Employeee managerHandler = new ManagerEmployeeHandler(directroHandler);
		Employeee leadHandler = new LeadEmployeeHandler(managerHandler);
		leadHandler.handleRequest(leaveApplication);
		System.out.print(" for leave type " + leaveApplication.getType() + " for "
				+ Duration.between(leaveApplication.getFrom(), leaveApplication.getTo()).toDays() + " days");
	}

}
