package com.vr.hotel;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class Bill {
 
	    static String[] items = {"Idly", "Dosa", "Vada", "Puri"};
	    static double[] prices = {30.0, 40.0, 20.0, 50.0};

	    public static void main(String[] args) throws IOException {
	        Scanner sc = new Scanner(System.in);
	        int[] qty = new int[items.length];
	        double grandTotal = 0.0;
	        double roundOff = 0.0;

	        // Display menu
	        System.out.println("------- Welcome to Taj Hotel -------");
	        System.out.println("Here is the Menu:");
	        System.out.printf("%-3s %-10s %-7s\n", "No", "Item", "Price");
	        for (int i = 0; i < items.length; i++) {
	            System.out.printf("%-3d %-10s ₹%-7.2f\n", (i + 1), items[i], prices[i]);
	        }

	        System.out.print("\nHow many different items would you like to order: ");
	        int orderCount = sc.nextInt();

	        for (int i = 0; i < orderCount; i++) {
	            System.out.print("Enter item number [1-4]: ");
	            int itemNo = sc.nextInt();
	            System.out.print("Enter quantity: ");
	            int quantity = sc.nextInt();

	            // Switch case for item selection
	            switch (itemNo) {
	                case 1:
	                case 2:
	                case 3:
	                case 4:
	                    qty[itemNo - 1] += quantity;
	                    break;
	                default:
	                    System.out.println("Invalid Item Number! Skipped.");
	            }
	        }

	        // Date and Time
	        LocalDateTime now = LocalDateTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy @ HH:mm");
	        String formattedDate = now.format(formatter);

	        // Bill Number handling
	        int billNo = 1;
	        File billFile = new File("billNo.txt");

	        if (billFile.exists()) {
	            BufferedReader br = new BufferedReader(new FileReader(billFile));
	            String line = br.readLine();
	            if (line != null && !line.isEmpty()) {
	                billNo = Integer.parseInt(line.trim()) + 1;
	            }
	            br.close();
	        }

	        BufferedWriter bw = new BufferedWriter(new FileWriter(billFile));
	        bw.write(String.valueOf(billNo));
	        bw.close();

	        // Printing Bill
	        System.out.println("\n----------------------------------------");
	        System.out.println("               Taj Hotel");
	        System.out.println("            Customer Bill");
	        System.out.println("Date :" + formattedDate + "    Bill No :" + billNo);
	        System.out.println("----------------------------------------");
	        System.out.printf("%-3s %-10s %-5s %-7s %-7s\n", "Sl", "Item", "Qty", "Price", "Total");

	        int serial = 1;
	        double subTotal = 0.0;
	        for (int i = 0; i < items.length; i++) {
	            if (qty[i] > 0) {
	                double total = qty[i] * prices[i];
	                System.out.printf("%-3d %-10s %-5d %-7.2f %-7.2f\n", serial++, items[i], qty[i], prices[i], total);
	                subTotal += total;
	            }
	        }

	        // Round Off (optional - keeps ₹ total clean)
	        roundOff = Math.round(subTotal) - subTotal;

	        System.out.println("----------------------------------------");
	        System.out.printf("Subtotal   : ₹%.2f\n", subTotal);
	        System.out.printf("Round Off  : ₹%.2f\n", roundOff);
	        grandTotal = subTotal + roundOff;
	        System.out.printf("Grand Total: ₹%.2f\n", grandTotal);
	        System.out.println("\nPayment    : Cash");
	        System.out.println("----------------------------------------");
	        System.out.println("Thank You Visit Again to Taj Hotel!");
	    }
	}
