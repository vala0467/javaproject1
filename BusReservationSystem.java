package com.vr.busrb;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BusReservationSystem {

    private static final Object lock = new Object();
    private static final double FARE = 780.00;
    private static final String BUS_NAME = "Amaravathi";
    private static final int TOTAL_SEATS = 30;

    private static final boolean[] seats = new boolean[TOTAL_SEATS];
    private static final Random rand = new Random();
    private static final Scanner scanner = new Scanner(System.in);

    // Booking record: ticketNo -> Booking
    private static final Map<String, Booking> bookings = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Bus Reservation Menu ---");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int ch = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (ch) {
                case 1 -> bookTickets();
                case 2 -> cancelTicket();
                case 3 -> {
                    System.out.println("Thank you for using our service!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    static class Booking {
        String ticketNumber;
        String seatNumber;
        String name;
        String from;
        String to;
        String date;
        String time;

        Booking(String ticketNumber, String seatNumber, String name, String from, String to, String date, String time) {
            this.ticketNumber = ticketNumber;
            this.seatNumber = seatNumber;
            this.name = name;
            this.from = from;
            this.to = to;
            this.date = date;
            this.time = time;
        }
    }

    public static void bookTickets() {
        System.out.print("Leaving From   : ");
        String from = scanner.nextLine();

        System.out.print("Going To       : ");
        String to = scanner.nextLine();

        System.out.print("Passenger Name : ");
        String name = scanner.nextLine();

        System.out.print("Select Seats   : ");
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            new Thread(() -> bookTicket(from, to, name)).start();
        }
    }

    public static void bookTicket(String from, String to, String name) {
        synchronized (lock) {
            int seatIndex = -1;
            for (int i = 0; i < TOTAL_SEATS; i++) {
                if (!seats[i]) {
                    seats[i] = true;
                    seatIndex = i + 1;
                    break;
                }
            }

            if (seatIndex == -1) {
                System.out.println("❌ No seats available.");
                return;
            }

            String ticketNumber = "A" + (100000 + rand.nextInt(900000));
            String seatNumber = "R" + seatIndex;
            LocalDateTime now = LocalDateTime.now();

            String date = now.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
            String time = now.format(DateTimeFormatter.ofPattern("hh:mm a"));

            // Save booking
            Booking booking = new Booking(ticketNumber, seatNumber, name, from, to, date, time);
            bookings.put(ticketNumber, booking);

            // Print ticket
            System.out.println("\n-----------------------------------");
            System.out.println("        Your Booking is confirmed !");
            System.out.println("Date           : " + date);
            System.out.println("Time           : " + time);
            System.out.println("From           : " + from);
            System.out.println("To             : " + to);
            System.out.println("Passenger Name : " + name);
            System.out.println("Ticket Number  : " + ticketNumber);
            System.out.println("Seat Number    : " + seatNumber);
            System.out.println("Fare           : ₹" + FARE);
            System.out.println("BUS Name       : " + BUS_NAME);
            System.out.println("-----------------------------------\n");
        }
    }

    public static void cancelTicket() {
        System.out.print("Enter your Ticket Number: ");
        String ticketNo = scanner.nextLine();

        synchronized (lock) {
            Booking booking = bookings.get(ticketNo);

            if (booking == null) {
                System.out.println("❌ Booking not found for Ticket No: " + ticketNo);
                return;
            }

            // Mark seat as available
            int seatIndex = Integer.parseInt(booking.seatNumber.substring(1)) - 1;
            seats[seatIndex] = false;
            bookings.remove(ticketNo);

            System.out.println("\n✅ Ticket Cancelled Successfully!");
            System.out.println("Passenger  : " + booking.name);
            System.out.println("Seat No.   : " + booking.seatNumber);
            System.out.println("Ticket No. : " + ticketNo);
        }
    }
}
