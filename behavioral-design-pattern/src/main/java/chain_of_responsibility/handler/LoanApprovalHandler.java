package chain_of_responsibility.handler;

import chain_of_responsibility.dto.LoanRequest;

public abstract class LoanApprovalHandler {

	protected LoanApprovalHandler nextHandler; // Next handler in the chain

	// Method to set the next handler in the chain
	public void setNextHandler(LoanApprovalHandler nextHandler) {
		this.nextHandler = nextHandler;
	}

	// Abstract method to handle loan request
	public abstract void processLoanRequest(LoanRequest request);
}
