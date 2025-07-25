package client;

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

interface LeaveHandler {

	void processLeave(LeaveApplication leaveApplication);
}

abstract class Employee implements LeaveHandler {

	@Override
	public abstract void processLeave(LeaveApplication leaveApplication);

}

public class ChainOfResponsibilityClient {

	public static void main(String[] args) {

	}

}
