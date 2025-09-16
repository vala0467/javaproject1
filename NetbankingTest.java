/*package com.vr.netbanking_pwdvalidation;
import java.util.*;
public class NetbankingTest {
 

private static final double wd = 0;

public static void main(String[] args  ) {
	Scanner sc=new Scanner(System.in);
	//bank will provide cust id/PWD
	String cid="220904";
	char[] password = {'Y', 'a', 's', 'w', 'a', 'n', 't', 'h', '@', '1','4','3','8'};
	int pin=1438;
	//create Bankatm object with password and customer ID
	Netbanking hdfc=new Netbanking("Yaswanth", cid,password);
	System.out.println("\t\t\t Welcome to HDFC NetBanking \n\n\n");
	System.out.println("Login to Netbanking\n");
	System.out.println("Customer ID/User ID:");
	String id =sc.nextLine();
	if(id.length()<4 || id.length()>10 || !id.matches("\\d+")) {
		System.err.println("Customer ID length should be min of 4 characters.");
		return;
	}
	//Read password as car array
	System.out.println("Enter your password: ");
	String passwordInput =sc.nextLine();
	char[] enteredPassword = passwordInput.toCharArray();
	//validate login
	//System.out.println(cid+" "+String.valueOf(enteredPassword));
	if(hdfc.validateCustomer(cid, enteredPassword)) {
		System.out.println("\n\n Login successful");
		System.out.println("Welcome to HDFC Bank"+hdfc.getAccountHoldername()+".");
		//Enter PIN for operations
		System.out.println("Enter your PIN: ");
		int enteredPin=sc.nextInt();
		if(enteredPin==pin) {
			System.out.println("\n--------MENU--------");
			System.out.println("1. Check Balance");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Exit");
			System.out.println(" Choose your option between 1-4:");
			int choice =sc.nextInt();
			switch(choice) {
			case 1 -> hdfc.checkBalance();
			case 2 ->{
				System.out.println("Enter amount to deposit:");
				double dep =sc.nextDouble();
				hdfc.deposit(dep);
			}
			case 3 ->{
				System.out.println("Enter amount to deposit:");
				double dep =sc.nextDouble();
				hdfc.withdraw(wd);
			}
			case 4 ->{
				System.out.println("Thank you for using HDFC NetBanking.");
				 System.exit(0);
			}
			default -> System.out.println("Invalid option.Try again.");
			}
		}
		else 
		{
			System.err.println("Invalid PIN.Access Denied.");
		}
	}
	else 
	{
		System.err.println("Invalid Customer ID/Password.");
	}
	sc.close();
}
}*/
/*package com.vr.netbanking_pwdvalidation;

import java.util.Scanner;

public class NetbankingTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Bank provides these
        String cid = "220904";
        char[] password = {'Y', 'a', 's', 'w', 'a', 'n', 't', 'h', '@', '1', '4', '3', '8'};

        // Create object
        Netbanking hdfc = new Netbanking("Yaswanth", cid, password);

        System.out.println("\t\t\t Welcome to HDFC NetBanking \n\n\n");
        System.out.println("Login to Netbanking\n");

        System.out.print("Customer ID/User ID: ");
        String id = sc.nextLine();

        if (id.length() < 4 || id.length() > 10 || !id.matches("\\d+")) {
            System.err.println("Customer ID length should be min of 4 characters.");
            sc.close();
            return;
        }

        System.out.print("Enter your password: ");
        String passwordInput = sc.nextLine();
        char[] enteredPassword = passwordInput.toCharArray();

        if (hdfc.validateCustomer(id, enteredPassword)) {
            System.out.println("\n\nLogin successful");
            System.out.println("Welcome to HDFC Bank, " + hdfc.getAccountHoldername() + ".");

            System.out.print("Enter your PIN: ");
            int enteredPin = sc.nextInt();

            if (enteredPin == hdfc.getPin()) {
                System.out.println("\n--------MENU--------");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Generate New PIN");
                System.out.println("5. Exit");
                System.out.print("Choose your option between 1-5: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> hdfc.checkBalance();
                    case 2 -> {
                        System.out.print("Enter amount to deposit: ");
                        double dep = sc.nextDouble();
                        hdfc.deposit(dep);
                    }
                    case 3 -> {
                        System.out.print("Enter amount to withdraw: ");
                        double amt = sc.nextDouble();
                        hdfc.withdraw(amt);
                    }
                    case 4 -> {
                        System.out.print("Enter new 4-digit PIN: ");
                        int newPin = sc.nextInt();
                        System.out.print("Confirm new PIN: ");
                        int confirmPin = sc.nextInt();
                        if (newPin == confirmPin && String.valueOf(newPin).length() == 4) {
                            hdfc.setPin(newPin);
                            System.out.println("PIN updated successfully.");
                            System.out.println("Thank you for using HDFC NetBanking.");
                        } else {
                            System.err.println("PINs do not match or not 4 digits. Try again.");
                        }
                    }
                    case 5 -> {
                        System.out.println("Thank you for using HDFC NetBanking.");
                        sc.close();
                        System.exit(0);
                    }
                    default -> System.err.println("Invalid option. Try again.");
                }
            } else {
                System.err.println("Invalid PIN. Access Denied.");
            }
        } else {
            System.err.println("Invalid Customer ID/Password.");
        }

        sc.close();
    }
}*/
package com.vr.netbanking_pwdvalidation;

import java.util.Scanner;

public class NetbankingTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Bank provides these
        String cid = "220904";
        char[] password = {'Y', 'a', 's', 'w', 'a', 'n', 't', 'h', '@', '1', '4', '3', '8'};

        // Create object
        Netbanking hdfc = new Netbanking("Yaswanth", cid, password);

        System.out.println("\t\t\t Welcome to HDFC NetBanking \n");

        boolean loggedIn = false;

        // Login loop
        while (!loggedIn) {
            System.out.println("Login to Netbanking\n");

            System.out.print("Customer ID/User ID: ");
            String id = sc.nextLine();

            if (id.length() < 4 || id.length() > 10 || !id.matches("\\d+")) {
                System.err.println("Customer ID length should be min of 4 digits and numeric only.\n");
                continue;
            }

            System.out.print("Enter your password: ");
            String passwordInput = sc.nextLine();
            char[] enteredPassword = passwordInput.toCharArray();

            if (hdfc.validateCustomer(id, enteredPassword)) {
                loggedIn = true;
                System.out.println("\nLogin successful");
                System.out.println("Welcome to HDFC Bank, " + hdfc.getAccountHoldername() + ".");

                System.out.print("Enter your PIN: ");
                int enteredPin = sc.nextInt();
                sc.nextLine(); // consume newline

                if (enteredPin == hdfc.getPin()) {
                    // Menu loop
                    boolean exit = false;
                    while (!exit) {
                        System.out.println("\n--------MENU--------");
                        System.out.println("1. Check Balance");
                        System.out.println("2. Deposit");
                        System.out.println("3. Withdraw");
                        System.out.println("4. Generate New PIN");
                        System.out.println("5. Exit");
                        System.out.print("Choose your option (1-5): ");
                        int choice = sc.nextInt();

                        switch (choice) {
                            case 1 -> hdfc.checkBalance();
                            case 2 -> {
                                System.out.print("Enter amount to deposit: ");
                                double dep = sc.nextDouble();
                                hdfc.deposit(dep);
                            }
                            case 3 -> {
                                System.out.print("Enter amount to withdraw: ");
                                double amt = sc.nextDouble();
                                hdfc.withdraw(amt);
                            }
                            case 4 -> {
                                System.out.print("Enter new 4-digit PIN: ");
                                int newPin = sc.nextInt();
                                System.out.print("Confirm new PIN: ");
                                int confirmPin = sc.nextInt();
                                if (newPin == confirmPin && String.valueOf(newPin).length() == 4) {
                                    hdfc.setPin(newPin);
                                    System.out.println("PIN updated successfully.");
                                } else {
                                    System.err.println("PINs do not match or not 4 digits. Try again.");
                                }
                            }
                            case 5 -> {
                                System.out.println("Thank you for using HDFC NetBanking.");
                                exit = true;
                            }
                            default -> System.err.println("Invalid option. Try again.");
                        }
                    }
                } else {
                    System.err.println("Invalid PIN. Access Denied.");
                    loggedIn = false;
                }
            } else {
                System.err.println("Invalid Customer ID/Password.\n");
            }
        }

        sc.close();
    }
}


 