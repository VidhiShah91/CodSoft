import java.util.Scanner;

public class Task3
{
    		public static void main(String args[])
		{
        	
			Scanner obj = new Scanner(System.in);
        		BankAccount userAccount = new BankAccount(1000); // Initial balance $1000

       	 		System.out.println();
			System.out.println("Welcome to the ATM!");
        		boolean isRunning = true;

        		while (isRunning)
		 	{
            		System.out.println("\nOptions:");
            		System.out.println("1. Withdraw");
            		System.out.println("2. Deposit");
            		System.out.println("3. Check Balance");
            		System.out.println("4. Exit");
					System.out.println();
            		System.out.print("Enter your choice: ");

            		int choice = obj.nextInt();

            			switch (choice) 
				{
                	
				case 1:
                    		System.out.print("Enter the amount to withdraw: ");
                    		double withdrawAmount = obj.nextDouble();
                    		if (userAccount.withdraw(withdrawAmount)) 
							{
                        		System.out.println("Withdrawal successful.");
                    		} 
				else 
				{
                        		System.out.println("Insufficient balance or invalid amount.");
                   		}
                    		break;
		
                		case 2:
                    		System.out.print("Enter the amount to deposit: ");
                    		double depositAmount = obj.nextDouble();
                    		if (userAccount.deposit(depositAmount)) 
				{
                       			System.out.println("Deposit successful.");
                    		}
				else
				{
                        		System.out.println("Invalid amount.");
                    		}
                    		break;
                
				case 3:
                    		System.out.println("Your account balance is: $" + userAccount.getBalance());
                    		break;
                
				case 4:
                    		isRunning = false;
                    		System.out.println("Thank you for using the ATM. Goodbye!");
                    		break;
	
                		default:
                    		System.out.println("Invalid choice. Please try again.");
            		
				}
       		    	}
   	        }
  }

class BankAccount
{
    	private double balance;

    	public BankAccount(double initialBalance) 
    	{
        	balance = initialBalance;
    	}

    	public boolean withdraw(double amount) 
    	{
        	if (amount > 0 && amount <= balance)
		{
            		balance -= amount;
            		return true;
       		}
        	return false;
    	}

    	public boolean deposit(double amount) 
	{
        	if (amount > 0) 
		{
            		balance += amount;
            		return true;
        	}
        	return false;
    	}

    	public double getBalance()
	{
        	return balance;
    	}
}