package dto;

public class LoanRequest {

	private double amount;
	private String applicantName;

	public LoanRequest(double amount, String applicantName) {
		this.amount = amount;
		this.applicantName = applicantName;
	}

	public double getAmount() {
		return amount;
	}

	public String getApplicantName() {
		return applicantName;
	}
}
