package chain_of_responsibility.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Loan {
	private BigDecimal amount;
	private String applicantName;
	private LocalDateTime loanApplyTime;
	private String approvedBy;
	private String rejectedBy;
	private boolean isloanApproved;
	private String status;
	private LocalDateTime loanAppovalTime;
}
