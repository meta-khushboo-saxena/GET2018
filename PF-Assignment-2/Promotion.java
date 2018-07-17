package Shoppingcartdetail;

import java.util.Date;

public interface Promotion {
	
	void setMinimumPrice(int minPrice);
	void setFixedDiscount(int discount);
	int getFixedDiscount();
	int getMinimumPrice();
	boolean isPromotionApplicable(String code, Date currentDate);
	
}
