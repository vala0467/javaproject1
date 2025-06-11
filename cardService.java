 package com.vr.Task;

public class cardService {
 public String getCardType(int cibilScore) {
	 if(cibilScore>=750) {
		 return "platinum card";
	 }
	 else if(cibilScore>=650) {
		 return "Gold card";
	 }
	 else if(cibilScore>=550) {
		 return "Silver card";
	 }
	 else {
		 return "No Eligible card";
	 }
 }
	public boolean isEmiEligible(int cibilScore) {
		 return cibilScore>=650;
	 
	}
	public void displayCustomerCard(Customer1class cobj) {
		 String cardType=getCardType(cobj.getCIBILscore());
		 boolean emiEligible=isEmiEligible(cobj.getCIBILscore());
		  System.out.println("Customer Name:"+cobj.getName());
		  System.out.println(" Customer Age:" +cobj.getAge());
		  System.out.println("CIBIL Score:"+cobj.getCIBILscore());
		  System.out.println("Card Type:" +cardType); 
		  System.out.println("EMI Eligibility:"+(emiEligible ? "yes":"No"));
	}
 }