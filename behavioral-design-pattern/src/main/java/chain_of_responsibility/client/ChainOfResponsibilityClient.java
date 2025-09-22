package chain_of_responsibility.client;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import chain_of_responsibility.concrete_handler.AssistantManager;
import chain_of_responsibility.concrete_handler.BranchManager;
import chain_of_responsibility.concrete_handler.RegionalManager;
import chain_of_responsibility.dto.Loan;
import chain_of_responsibility.handler.LoanApprovalHandler;

public class ChainOfResponsibilityClient {

	public static void main(String[] args) {
		LoanApprovalHandler regionalLoanApprovalHandler = new RegionalManager();
		LoanApprovalHandler branchLoanApprovalHandler = new BranchManager(regionalLoanApprovalHandler);
		LoanApprovalHandler assistantLoanApproval = new AssistantManager(branchLoanApprovalHandler);

		Loan startupLoan = assistantLoanApproval.processLoanApplication(Loan.builder().amount(new BigDecimal(2000000.0))
				.applicantName("Raj Enterprises").loanApplyTime(LocalDateTime.now()).build());
		System.out.println("'" + startupLoan.getApprovedBy() + "' approved loan of ₹" + startupLoan.getAmount()
				+ " for applicant '" + startupLoan.getApplicantName() + "' on " + LocalDateTime.now()
				+ " and loan status '" + startupLoan.getStatus() + "'");

		Loan corporateLoan = assistantLoanApproval
				.processLoanApplication(Loan.builder().amount(new BigDecimal(5000000.0))
						.applicantName("Raj Enterprises").loanApplyTime(LocalDateTime.now()).build());
		System.out.println("'" + corporateLoan.getApprovedBy() + "' approved loan of ₹" + corporateLoan.getAmount()
				+ " for applicant '" + corporateLoan.getApplicantName() + "' on " + LocalDateTime.now()
				+ " and loan status '" + corporateLoan.getStatus() + "'");

		Loan industryLoan = assistantLoanApproval
				.processLoanApplication(Loan.builder().amount(new BigDecimal(10000000.0))
						.applicantName("Raj Enterprises").loanApplyTime(LocalDateTime.now()).build());
		System.out.println("'" + industryLoan.getApprovedBy() + "' approved loan of ₹" + industryLoan.getAmount()
				+ " for applicant '" + industryLoan.getApplicantName() + "' on " + LocalDateTime.now()
				+ " and loan status '" + industryLoan.getStatus() + "'");

		Loan infraLoan = assistantLoanApproval.processLoanApplication(Loan.builder().amount(new BigDecimal(30000000.0))
				.applicantName("Raj Enterprises").loanApplyTime(LocalDateTime.now()).build());
		if (infraLoan.getApprovedBy() == null) {
			System.out.println("'" + infraLoan.getRejectedBy() + "' rejected loan of ₹" + infraLoan.getAmount()
					+ " for applicant '" + infraLoan.getApplicantName() + "' on " + LocalDateTime.now()
					+ " and loan status '" + infraLoan.getStatus() + "'");
		} else {
			System.out.println("'" + infraLoan.getApprovedBy() + "' approved loan of ₹" + infraLoan.getAmount()
					+ " for applicant '" + infraLoan.getApplicantName() + "' on " + LocalDateTime.now()
					+ " and loan status '" + infraLoan.getStatus() + "'");
		}

	}

}
