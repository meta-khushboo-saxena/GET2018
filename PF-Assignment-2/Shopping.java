package Shoppingcartdetail;
import java.util.*;
import java.util.Date;

public class Shopping {
	static int i=0;
	Promotion promotion = new FixedProductPromotion();
	Promotion promotion2 = new FixedOrderPromotion();
	
	static Scanner sc=new Scanner(System.in);
	ArrayList<Cart> list = new ArrayList<Cart>();
	

	
	/**
	 * Function for setting Minimum price and Discount for each product        
	 */
	  void setMinPriceAndDiscountforProduct()
	  {  	  
	      System.out.println("Enter MinPrice for Discount on Product: ");
	      promotion.setMinimumPrice(sc.nextInt());
	    	  
	      System.out.println("Enter Discount : ");
	      promotion.setFixedDiscount(sc.nextInt());
	    	  
	   }
	  
	  /**
		 * Function for setting Minimum price and Discount for each product        
		 */
		  void setMinPriceAndDiscountforOrder()
		  {  	  
		      System.out.println("Enter MinPrice for Discount on Order: ");
		      promotion2.setMinimumPrice(sc.nextInt());
		    	  
		      System.out.println("Enter Discount : ");
		      promotion2.setFixedDiscount(sc.nextInt());
		    	  
		   }
	
	/**
	 * Function to add Item Details to Cart	
	 */
	  
	public void addItems()
	{
		Cart product=new Cart();
		System.out.println("Enter the item name");
		product.setItem(sc.next());
		System.out.println("Enter the item price");
		product.setPrice(sc.nextInt());
		System.out.println("Enter the item quantity");
		product.setQuantity(sc.nextInt());
		list.add(product);  
		return;
	}

	/**
	 * Function to remove Item details from Cart
	 * @param index
	 */
	
	public void removeItems(int index)
	{
		list.remove(index);
		System.out.println("Item removed");
	}
	
	/**
	 * Function to display Item with details
	 */
	
	public void showItems()
	{
		int i=0;
		for(Cart product:list)
		{  
		    System.out.println("Product Index:- "+i+++"\nProduct name:- "+product.item+"\nProduct Price:- "+product.price+"\nProduct Quantity:- "+product.quantity);
		    System.out.println();
		    
		    if(product.getPrice() >= promotion.getMinimumPrice()){
    			System.out.println("Discount on Product Given : "+promotion.getFixedDiscount());  
    		  }
		    System.out.println("\n");
		}
	}
	
	/**
	 * Function to update Item quantity
	 * @param index
	 */
	
	void updateQuantity(int index){
 	   Cart product = (Cart)list.get(index);
 	   
 	   System.out.println("Update item Quantity of "+product.getItem()+" : ");
 	   product.setQuantity(sc.nextInt());
 	   System.out.println("Quantity Updated");
    }
	
	/**
	 * Function to return total amount for cart items
	 * @return totalAmount      
	 */
	
	double generateCartBill(String promocode){
		
	   Date date=new Date();
	  
 	   Iterator<Cart> iterator= list.iterator(); 
 	   int i=0;
	   double totalAmount=0;
 	   while(iterator.hasNext()){
 		
 		Cart product = (Cart)list.get(i);
 		 
 	   if(promotion.isPromotionApplicable(promocode,date)==true && (product.getPrice() >= promotion.getMinimumPrice()))
 	   {
 		   
			totalAmount += (product.getPrice()-promotion.getFixedDiscount()) * (product.getQuantity());      			    
		        
 	   }
 	  else
 	   {
	        totalAmount += (product.getPrice()) * (product.getQuantity());	
	        
	   }
 	  
 		  i++;
 		  iterator.next();
 		  
 	   }
 	  if(promotion2.isPromotionApplicable(promocode,date)==true && (totalAmount >= promotion2.getMinimumPrice()))
	   {
 		  
 		 totalAmount = totalAmount-promotion2.getFixedDiscount();       			    
		        
	   }
 	   
 	return totalAmount;
 	
    }
	
	public static void main(String arg[])
	{ 
		Shopping sh =new Shopping();
		  System.out.println("Set Minimum Price and Discount:");
		  sh.setMinPriceAndDiscountforProduct();
		  sh.setMinPriceAndDiscountforOrder();
		 int choice;
		  String promocode;
		 do
		 {	
				System.out.println("1.Add Items");
				System.out.println("2.Remove Items");
				System.out.println("3.Show Cart");
				System.out.println("4.Change Item detail");
				System.out.println("5.Generate bill");
				System.out.println("Enter your choice:");
				choice=sc.nextInt();
				switch(choice){
				case 1:
				{
					sh.addItems();
					break;
				}
				case 2:
					{
						System.out.println("Enter the index of the item you want to remove");
						sh.removeItems(sc.nextInt());
						break;
					}
					
				case 3:
				{
					sh.showItems();
					break;
				}
				
				case 4:
				{
					System.out.println("Enter Item Index to Update quantity : ");
					sh.updateQuantity(sc.nextInt());
				}
				case 5:{
					System.out.println("Enter the Promocode to get the discount : ");
					promocode=sc.next();
					double totalAmountInCart = sh.generateCartBill(promocode);
					System.out.println("Total Amount of Cart is : "+totalAmountInCart);
					break;
				}	
				}
					  
			}while(true);
		
		
	}
}
