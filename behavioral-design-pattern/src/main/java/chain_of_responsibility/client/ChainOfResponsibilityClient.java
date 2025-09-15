package chain_of_responsibility.client;

import chain_of_responsibility.concrete_handler.Clerk;
import chain_of_responsibility.concrete_handler.Director;
import chain_of_responsibility.concrete_handler.Manager;
import chain_of_responsibility.dto.LoanRequest;
import chain_of_responsibility.handler.LoanApprovalHandler;

public class ChainOfResponsibilityClient {

	public static void main(String[] args) { // Create handlers
		LoanApprovalHandler clerk = new Clerk();
		LoanApprovalHandler manager = new Manager();
		LoanApprovalHandler director = new Director();

		// Set up the chain: Clerk -> Manager -> Director
		clerk.setNextHandler(manager);
		manager.setNextHandler(director);

		// Test different loan requests
		LoanRequest request1 = new LoanRequest(20000, "Taher-1");
		LoanRequest request2 = new LoanRequest(200000, "Taher-2");
		LoanRequest request3 = new LoanRequest(2000000, "Taher-3");
		LoanRequest request4 = new LoanRequest(6000000, "Taher-4");

		System.out.println("Processing Taher-1 request:");
		clerk.processLoanRequest(request1);

		System.out.println("\nProcessing Taher-2 request:");
		clerk.processLoanRequest(request2);

		System.out.println("\nProcessing Taher-3 request:");
		clerk.processLoanRequest(request3);

		System.out.println("\nProcessing Taher-4 request:");
		clerk.processLoanRequest(request4);
	}

}
