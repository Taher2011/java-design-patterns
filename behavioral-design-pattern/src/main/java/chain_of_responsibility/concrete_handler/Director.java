package concrete_handler;

import dto.LoanRequest;
import handler.LoanApprovalHandler;

public class Director extends LoanApprovalHandler {
	@Override
	public void processLoanRequest(LoanRequest request) {
		if (request.getAmount() <= 5000000) {
			System.out.println(
					"Director approved loan of ₹" + request.getAmount() + " for " + request.getApplicantName());
		} else if (nextHandler != null) {
			System.out.println("Director cannot approve ₹" + request.getAmount() + ". Passing to next handler.");
			nextHandler.processLoanRequest(request);
		} else {
			System.out.println(
					"No handler available to approve ₹" + request.getAmount() + " for " + request.getApplicantName());
		}
	}
}