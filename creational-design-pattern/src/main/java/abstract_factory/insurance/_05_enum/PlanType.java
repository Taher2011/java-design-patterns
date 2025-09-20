package abstract_factory.insurance._05_enum;

public enum PlanType {

	BASIC("basic"), PREMIUM("premium");

	private String plan;

	private PlanType(String plan) {
		this.plan = plan;
	}

	public String getPlan() {
		return plan;
	}

}
