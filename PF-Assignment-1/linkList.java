import java.util.Scanner;


//Linked list representation of Stack

/**
 * Creates a New Node for Linked List
 */
class Node{
	int data;
	Node next;
}
public class linkList {
	Node Top=null;
	/**
	 *Operation push(element)
	 *@param element to be pushed into stack
	 */
		void push(int element){
			
			try{
				
			   Node newNode = new Node();
			   newNode.data = element;
			   newNode.next = Top;
			   Top = newNode;
			   System.out.println("Element Pushed into Stack --> "+newNode.data);
			
			}catch(Exception e){
			e.printStackTrace();	
			}
		}
		
	/**
	 * Operation pop()
	 * @return delete
	 */
	   Node pop(){
		   
		   Node delete = null;
		   
		   try{
			   
		        if(Top == null){
			    System.out.println("Stack UnderFlow");   
		        }else{
		        delete = Top;
		        Top = Top.next;
		        System.out.println("Stack element Poped !!");  
		        }
		        
		   }catch(Exception e){
			 e.printStackTrace();
		   }
		   
		   return delete;
	   }
	  
	/**
	 * Operation to show elements in Stack 
	 * Operation to check wether stack is Empty    
	 */
	   void show(){
		  try{
		         if(Top == null){
			     System.out.println("Stack is Empty");
		         }
		         
		    Node traverse = Top;
		    
		        while(traverse != null){
			      System.out.println("Stack Element --> "+traverse.data);
			      traverse=traverse.next;
		        }
		        
		  }catch(Exception e){
			   e.printStackTrace();
		  }
		  
	   }
	   
		public static void main(String args[]){
			linkList stack = new linkList();
			Scanner sc = new Scanner(System.in);
			int choice;
			
			do{
				System.out.println("1. Push(element)");
				System.out.println("2. Pop()");
				System.out.println("3. show() or check stack isEmpty()");
				System.out.println("4. EXIT");
				
				System.out.println("Enter your choice:");
				choice = sc.nextInt();
				
				switch(choice)
				{
				case 1:{
					System.out.println("Enter the element to be pushed : ");
					stack.push(sc.nextInt());
					break;
				}
				case 2:{
					stack.pop();
					break;
				}
				case 3:{
					stack.show();
					break;
				}
				case 4:{
					System.exit(0);
				}
				default:
				System.out.println("Enter the valid choice:");
				}
			}while(true);
			
			
		}
}
