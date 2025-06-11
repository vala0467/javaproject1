package com.vr.Task;

public class CardEligibilityApp {
public static void main(String[] args) {
	 Customer1class c1 = new Customer1class("yaswanth",23,850);
	 cardService cs=new cardService();
	 cs.displayCustomerCard(c1);
	 System.out.println("----------------------------");
	 System.out.println();
	 Customer1class c2=new Customer1class("kumar",20,650);
	 cardService cs2=new cardService();
	 cs2.displayCustomerCard(c2);
	 
}
}
