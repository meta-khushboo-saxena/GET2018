package Shoppingcartdetail;

public enum PromotionEnum {

	Enum1("ABCD", "12-01-2018", "12-10-2018"), 
	Enum2("EFGH", "12-02-2018", "12-09-2018"), 
	Enum3("IJKL", "12-04-2018", "12-09-2018"), 
	Enum4("MNOP", "12-05-2018", "12-09-2018");

	private String code;
	private String startDate;
	private String endDate;

	private PromotionEnum(String code, String startDate, String endDate) {
		this.code = code;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getCode() {
		return code;
	}

	public String getStartDate() {
		return startDate;
	}
	
	public String getEndDate() {
		return endDate;
	}

}
