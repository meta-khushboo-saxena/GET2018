import java.util.Scanner;

/**
 * Creates a class for stack operations
 */
public class Stack {
final int max=10;
int stack[]=new int[max];
int top=-1;
/**
 * operation for inserting value into stack
 * @param x element to be inserted 
 */
public void push(int x)
	{ 
		if(top==max-1)
		{
			System.out.println("Stack Overflow");
		}
		else{
			top++;
			stack[top]=x;
			return;
		}
	}
/**
 * operation for removing value from stack
 */
public void pop()
{ 
	if(top==-1)
	{
		System.out.println("Stack Underflow");
	}
	else{
		top--;
		return;		
	}
}
/**
 * operation for displaying value in the stack
 */
public void show()
{ 
	int var=top;
	if(var==-1)
	{
		System.out.println("Stack is empty");
		return;
	}
	System.out.println("Elements in the stack are:");
	while(var!=-1)
	{
		System.out.println(stack[var]);
		var--;
	}
}
public static void main(String arg[])
{
	int choice;
	Stack st=new Stack();
	do{
	System.out.println("1. Push Element into stack");
	System.out.println("2. Pop Element from stack");
	System.out.println("3. Display Elements of stack");
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter your choice:");
	choice=sc.nextInt();
	switch(choice)
	{
	case 1:{
		System.out.println("Enter the element to be pushed:");
		//sc.nextInt();
		st.push(sc.nextInt());
		break;
	}
	case 2:{
		st.pop();
		break;
	}
	case 3:{
		st.show();
		break;
	}
	default:
	System.out.println("Enter the valid choice:");
	}
	}while(true);
}
}
