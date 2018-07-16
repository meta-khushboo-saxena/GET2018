import java.util.*;

//Class to add Items details in the cart
public class Shopping {
	static int i=0;
	static Scanner sc=new Scanner(System.in);
	ArrayList<Cart> list = new ArrayList<Cart>();

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
		    System.out.println(i+++""+" "+product.item+" "+product.price+" "+product.quantity);  
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
	int generateCartBill(){
 	   Iterator<Cart> iterator= list.iterator(); 
 	   int i=0,totalAmount=0;
 	   while(iterator.hasNext()){
 		
 		  Cart product = (Cart)list.get(i);
 		  
 		  totalAmount += (product.getPrice())*(product.getQuantity());
 		  i++;
 		  iterator.next();
 	   }
 	return totalAmount;   
    }
	
	public static void main(String arg[])
	{ 
		Shopping sh =new Shopping();
		 
		 int choice;
		
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
					int totalAmountInCart = sh.generateCartBill();
					System.out.println("Total Amount of Cart is : "+totalAmountInCart);
					break;
				}	
				}
					  
			}while(true);
		
		
	}

}
