package Shoppingcartdetail;

import java.util.Date;
import java.text.SimpleDateFormat;

public class FixedOrderPromotion implements Promotion{
	
	private int discount;
    private int minPrice;
    PromotionEnum promotionenum = new PromotionEnum();
    
    public void setFixedDiscount(int discount) {
		this.discount = discount;
	}

	public void setMinimumPrice(int minPrice) {
	    this.minPrice = minPrice;	
	}
	
	public int getFixedDiscount() {
	return this.discount;
	}

	public int getMinimumPrice() {
	 return this.minPrice;	
	}

	public boolean isPromotionApplicable(String code,Date currentDate) {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		long start = 0;
		long end = 0;
		long current = 0;
		
		  try{
	             Date startDate = (Date) simpleDateFormat.parse(promotionenum.StartDate);
	             Date endDate = (Date) simpleDateFormat.parse(promotionenum.EndDate);
	
	             start = startDate.getTime();
                 end = endDate.getTime();
                 current = currentDate.getTime();
	
	            }catch(Exception e){
		         e.printStackTrace();
	            }
		  
		if(promotionenum.FixedOrderPromotionCode.equals(code) && current < end && current > start)
		{
			//System.out.println("Promocode applied on order");
			return true;
		}
		
		return false;	
		
	}
}
