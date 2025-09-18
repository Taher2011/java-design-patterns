package chain_of_responsibility.concrete_handler;

import java.time.LocalDateTime;

import chain_of_responsibility.dto.LoanRequest;
import chain_of_responsibility.handler.LoanApprovalHandler;

public class BranchManager extends LoanApprovalHandler {
	@Override
	public void processLoanRequest(LoanRequest request) {
		if (request.getAmount() <= 500000) {
			System.out.println("Branch Manager approved loan of ₹" + request.getAmount() + " for "
					+ request.getApplicantName() + " on " + LocalDateTime.now().withNano(0));
		} else if (nextHandler != null) {
			System.out.println(
					"Branch Manager cannot approve ₹" + request.getAmount() + ". Passing to Regional Manager.");
			nextHandler.processLoanRequest(request);
		} else {
			System.out.println(
					"No handler available to approve ₹" + request.getAmount() + " for " + request.getApplicantName());
		}
	}
}