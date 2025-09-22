package chain_of_responsibility.handler;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseLoanApprovalHandler implements LoanApprovalHandler {

	protected String designation;

	protected BaseLoanApprovalHandler(String designation) {
		this.designation = designation;
	}

}
