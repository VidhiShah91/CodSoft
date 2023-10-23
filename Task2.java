import java.util.*;

class Task2
{
	public static void main(String args[])
	{
		Scanner obj=new Scanner(System.in);

		System.out.println("Enter the Name of the Student: ");
		String sName=obj.next();
		System.out.println();
			
		System.out.println("Enter the no. of Subjects: ");
		int n=obj.nextInt();
		System.out.println();
			
		int marks[] = new int[n];
		int sum=0;
		int i;
		char grade;
		
		for(i=0;i<n;i++)
		{
			System.out.println("Enter Your marks for the Subject " + (i+1) + ": ");
			marks[i]=obj.nextInt();
			sum+=marks[i];
			System.out.println();
		}
		
		int avg=sum/n;
		
		
       		if(avg>=80)
      		{
           		grade='A';
        	}
        	else if(avg>=60 && avg<80)
      		{
           		grade='B';
        	} 
        	else if(avg>=40 && avg<60)
        	{
            		grade='C';
        	}
        	else
        	{
           		grade='D';
        	}
				
			String sName1=(sName.toUpperCase());
			System.out.println();
			System.out.println(sName1 + " has scored Total: '" + sum + "' with an Average of: '" + avg + "' . ");
			System.out.println("Thus, the Grade obtained is: " + grade);
		
		
		
	}	
}