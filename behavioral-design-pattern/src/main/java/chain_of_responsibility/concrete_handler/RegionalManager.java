package chain_of_responsibility.concrete_handler;

import java.time.LocalDateTime;

import chain_of_responsibility.dto.LoanRequest;
import chain_of_responsibility.handler.LoanApprovalHandler;

public class RegionalManager extends LoanApprovalHandler {
	@Override
	public void processLoanRequest(LoanRequest request) {
		if (request.getAmount() <= 5000000) {
			System.out.println("Regional Manager approved loan of ₹" + request.getAmount() + " for "
					+ request.getApplicantName() + " on " + LocalDateTime.now().withNano(0));
		} else {
			System.out.println(
					"Regional Manager cannot approve ₹" + request.getAmount() + " for " + request.getApplicantName()
							+ ". Hence loan application rejected on " + LocalDateTime.now().withNano(0));
		}
	}
}