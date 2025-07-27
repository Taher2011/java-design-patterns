package concrete_handler;

import dto.LoanRequest;
import handler.LoanApprovalHandler;

public class Manager extends LoanApprovalHandler {
	@Override
	public void processLoanRequest(LoanRequest request) {
		if (request.getAmount() <= 500000) {
			System.out
					.println("Manager approved loan of ₹" + request.getAmount() + " for " + request.getApplicantName());
		} else if (nextHandler != null) {
			System.out.println("Manager cannot approve ₹" + request.getAmount() + ". Passing to next handler.");
			nextHandler.processLoanRequest(request);
		} else {
			System.out.println(
					"No handler available to approve ₹" + request.getAmount() + " for " + request.getApplicantName());
		}
	}
}