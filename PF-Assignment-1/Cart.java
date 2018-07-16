
public class Cart {
	
	String item;
	int price;
	int quantity;
	
	public void setItem(String item){
		this.item=item;
		//System.out.println(item);
	}
	
	public String getItem()
	{
		return item;
	}
	
	public void setQuantity(int quantity)
	{
		this.quantity=quantity;
	}
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public void setPrice(int price){
		this.price=price;
		//System.out.println(price);
	}
	
	public int getPrice()
	{
		return price;
	}

}




