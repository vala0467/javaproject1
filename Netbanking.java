/*package com.vr.netbanking_pwdvalidation;

import java.util.Arrays;
import java.util.Objects;

public class Netbanking {
//Fileds for account details
	private String accountHolderName;
	private double balance =20000;
	private String customerId;
	private char[] password;
	private int pin;
	//constructor to initialize account details
 
	public Netbanking(String accountHolderName, String customerId, char[] password) {
		 
		this.accountHolderName = accountHolderName;
		this.balance = balance;
		this.customerId = customerId;
		this.password = password;
		this.pin=pin;
		
	}
	  // PIN Getter
    public int getPin() {
        return pin;
    }

    // PIN Setter
    public void setPin(int pin) {
        this.pin = pin;
    }

    // Getter for account holder name
    public String getAccountHoldername1() {
        return accountHolderName;
    }
	//compare entered password with the stored password.
	public boolean validatePassword(char[] enteredPassword) {
		if(enteredPassword.length != password.length) return false;
		for(int i=0;i<password.length;i++) {
			if(enteredPassword[i]!= password[i]) {
				return false;
			}
		}
		return true;
	}
 //TO get holder name
	public String getAccountHoldername() {
		return accountHolderName;
	}
	//validates passsword rules
	//must contain at least one uppercase,one lowercasse,one digit,and one special charater.
 public boolean validatepasswordRules(char[] enteredPassword) {
	 boolean hasUpper =false,hasLower =false,hasDigit =false, hasSpecial =false;
	 for(char ch: enteredPassword) {
		 if(Character.isUpperCase(ch)) hasUpper =true;
		 else if(Character.isLowerCase(ch)) hasLower =true;
		 else if(Character.isDigit(ch) ) hasDigit =true;
		 else if("@#$%!&*".indexOf(ch)>=0) hasSpecial =true;
		 
	 }
	 return hasUpper && hasLower && hasDigit && hasSpecial;
 }
 public boolean validateCustomer(String cid,char[] pwd) {
	// System.out.println(customerId.equals(cid) && validatePassword(pwd) && validatepasswordRules(pwd));
	 return customerId.equals(cid) && validatePassword(pwd) && validatepasswordRules(pwd);
 }
 //Displays the current available balance.
 public void checkBalance() {
	 System.out.println("Avaliable Balance:₹"+balance);
 }
 //Deposit
 public void deposit(double amount) {
	 if(amount>0) {
		 balance+=amount;
		 System.out.println("After deposit your balance:₹"+balance);
		 }
	 else {
		 System.err.println("Zero amount can't be deposit");
	 }
 }
 //withdraw
 public void withdraw(double amount) {
	 if(amount > 0 && amount<=balance) {
		 balance-=amount;
		 System.out.println("After withdraw your balance:₹"+balance);
		 
	 }
	 else {
		 System.err.println("Insufficient balance");
	 }
 }
 // PIN Setter
 public void setPin1(int pin) {
     this.pin = pin;
 }

 // Getter for account holder name
 public String getAccountHoldername11() {
     return accountHolderName;
 }
public int getPin1() {
	// TODO Auto-generated method stub
	return 0;
}
}*/
package com.vr.netbanking_pwdvalidation;

import java.util.Arrays;

public class Netbanking {
    private String accountHolderName;
    private String customerId;
    private char[] password;
    private double balance = 20000;
    private int pin = 1438; // default PIN

    public Netbanking(String accountHolderName, String customerId, char[] password) {
        this.accountHolderName = accountHolderName;
        this.customerId = customerId;
        this.password = password;
    }

    public boolean validateCustomer(String id, char[] enteredPassword) {
        return this.customerId.equals(id) && Arrays.equals(this.password, enteredPassword);
    }

    public String getAccountHoldername() {
        return this.accountHolderName;
    }

    public void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited. New Balance: ₹" + balance);
        } else {
            System.err.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn. New Balance: ₹" + balance);
        } else {
            System.err.println("Insufficient balance or invalid amount.");
        }
    }

    public int getPin() {
        return this.pin;
    }

    public void setPin(int newPin) {
        this.pin = newPin;
    }
}

