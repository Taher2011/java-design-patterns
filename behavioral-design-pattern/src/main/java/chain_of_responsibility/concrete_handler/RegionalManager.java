package chain_of_responsibility.concrete_handler;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import chain_of_responsibility.dto.Loan;
import chain_of_responsibility.handler.BaseLoanApprovalHandler;

public class RegionalManager extends BaseLoanApprovalHandler {

	public RegionalManager() {
		super("Regional Manager");
	}

	@Override
	public Loan processLoanApplication(Loan loan) {
		System.out.println("Processing loan applicant request of : " + loan.getApplicantName());
		if (loan.getAmount().compareTo(BigDecimal.valueOf(20000000.0)) > 0) {
			System.out.println("'" + this.getDesignation() + "' cannot approve ₹" + loan.getAmount()
					+ ". Hence rejecting loan request");
			loan = Loan.builder().rejectedBy(designation).applicantName(loan.getApplicantName()).isloanApproved(false)
					.status("Rejected").amount(loan.getAmount()).build();
			return loan;
		}
		loan = Loan.builder().applicantName(loan.getApplicantName()).approvedBy(this.getDesignation())
				.isloanApproved(true).loanAppovalTime(LocalDateTime.now()).status("Approved").amount(loan.getAmount())
				.build();
		return loan;
	}
}