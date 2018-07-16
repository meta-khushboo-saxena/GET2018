import java.util.Scanner;


public class Pallindrome {
	final int max=100;
	char stack[]=new char[max];
	int top=-1;
	void push(char a)
	{
		if(top==max-1)
		{
			System.out.println("Stack Overflow");
		}
		else{
			top++;
			stack[top]=a;
			return;
		}
	}
	
	char pop()
	{
		
		return stack[top--];
	
	}
	public static void main(String arg[])
	{
		Pallindrome pall=new Pallindrome();
		Scanner sc=new Scanner(System.in);
		String str1;
		String str2="";
		System.out.println("Enter the String:");
		str1=sc.next();
		for(int i=0;i < str1.length();i++)
		{
			pall.push(str1.charAt(i));
		}
		for(int j=0; j < str1.length();j++)
		{
			str2 =str2+pall.pop();
		}
		if(str2.equals(str1))
		{
			System.out.println("String is Pallindrome");
		}
		else{
			System.out.println("String is not Pallindrome");
		}
	}
}
