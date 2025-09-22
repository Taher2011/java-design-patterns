package chain_of_responsibility.handler;

import chain_of_responsibility.dto.Loan;

public interface LoanApprovalHandler {
	Loan processLoanApplication(Loan loan);
}
