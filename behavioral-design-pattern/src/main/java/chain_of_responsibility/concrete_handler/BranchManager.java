package chain_of_responsibility.concrete_handler;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import chain_of_responsibility.dto.Loan;
import chain_of_responsibility.handler.BaseLoanApprovalHandler;
import chain_of_responsibility.handler.LoanApprovalHandler;

public class BranchManager extends BaseLoanApprovalHandler {

	private LoanApprovalHandler approvalHandler;

	public BranchManager(LoanApprovalHandler approvalHandler) {
		super("Branch Manager");
		this.approvalHandler = approvalHandler;
	}

	@Override
	public Loan processLoanApplication(Loan loan) {
		System.out.println("Processing loan applicant request of : " + loan.getApplicantName());
		if (loan.getAmount().compareTo(BigDecimal.valueOf(8000000.0)) > 0) {
			System.out.println("'" + this.getDesignation() + "' cannot approve ₹" + loan.getAmount() + ". Passing to '"
					+ ((BaseLoanApprovalHandler) approvalHandler).getDesignation() + "' for further approval");
			return approvalHandler.processLoanApplication(loan);
		}
		loan = Loan.builder().applicantName(loan.getApplicantName()).approvedBy(this.getDesignation())
				.isloanApproved(true).loanAppovalTime(LocalDateTime.now()).status("Approved").amount(loan.getAmount())
				.build();
		return loan;
	}
}