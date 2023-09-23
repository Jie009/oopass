package com.mycompany.oop;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.text.SimpleDateFormat;

public class OOP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SlotBooking[] sb = new SlotBooking[100];
        Slot[] slot = new Slot[50];
        Payment[] payment = new Payment[100];
        String speaker = "John Smith";
        List<Slot> availableSlots = new ArrayList<>();        
        
        availableSlots.add(new Slot("SMK Bunga", "Secondary school hall", "8:00am", "12:00pm", "13/10/2023", 400, 350));
        availableSlots.add(new Slot("Dewan Kulia", "Taman Kulia hall", "10:00am", "5:00pm", "20/10/2023", 250, 275));
        availableSlots.add(new Slot("Dataran Murni", "Indoor hall", "8:00am", "3:00pm", "10/10/2023", 500, 600));
        availableSlots.add(new Slot("SMK Kawi", "Secondary school hall", "8:00am", "11:00am", "30/10/2023", 200, 150));
        availableSlots.add(new Slot("Dewan Wangsa Maju", "Wangsa Maju hall", "3:00pm", "7:00pm", "26/10/2023", 200, 220));

        
        eventBooking(scanner, speaker, sb, payment, availableSlots);
        System.out.println("Quit ");
    }
    
    public static void eventBooking(Scanner scanner, String speaker, SlotBooking[] sb, Payment[] payment, List<Slot> availableSlots){
        
        while(true){
            clScr();
            System.out.println("\nEvent Booking");
            System.out.println("--------------");
            System.out.println("1. Slot available");
            System.out.println("2. Booking slot");
            System.out.println("3. Slot management");
            System.out.println("\n0. Quit");
            int choice = 0;       
            try{
                System.out.print("Your Choice: ");
                choice = scanner.nextInt();
            }
            catch (InputMismatchException e) {
                scanner.nextLine();
            }
            
            if (choice == 1){
                bookingDetails(scanner, speaker, sb, payment, availableSlots);
            }    

            else if (choice == 2){
                contBooking(scanner, speaker, sb, payment, availableSlots);
            }

            else if (choice == 3){
                choiceBookingManagement(scanner, speaker, sb, availableSlots, payment);
                break;
            }

            else if (choice == 0){
                System.exit(0);
            }

            else
                System.out.println("Invalid choice. Please try again");               
        }
    }
    public static void bookingDetails(Scanner scanner, String speaker, SlotBooking[] sb, Payment[] payment, List<Slot> availableSlots){
        clScr();
        boolean continueBooking = true;
        Comparator<Slot> currentComparator = new SlotDateComparator();
        while(continueBooking){
            int choice5 = 0;
            System.out.println("Filter Options in Ascending:");
            System.out.println("-----------------------------");            
            System.out.println("1. Sort by Date");
            System.out.println("2. Sort by Price");
            System.out.println("3. Continue booking");
            System.out.println("\n0. Quit");

            try {
                System.out.print("Your Choice: ");
                choice5 = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
            }
            if (choice5 == 1){
                currentComparator = new SlotDateComparator();
            }
            else if (choice5 == 2){
                currentComparator = new SlotPriceComparator();
            }
            else if (choice5 == 3){
                contBooking(scanner, speaker, sb, payment, availableSlots);
                continueBooking = false;
            }  
            else if (choice5 == 0){
                eventBooking(scanner, speaker, sb, payment, availableSlots);
                continueBooking = false;
            }
            else{
                System.out.println("Invalid Choice. Please try again");
            }

            int choice3 =0;   
            if (choice5 == 1 || choice5 == 2) {
                clScr();
                availableSlots.sort(currentComparator);
                for (int i = 0; i < availableSlots.size(); i++) {
                    Slot slotToDisplay = availableSlots.get(i);
                    System.out.println((i + 1) + ". " + slotToDisplay.toString());
                }

                System.out.println("\n1. Continue booking");
                System.out.println("0. Quit");
                try{
                    System.out.print("Your Choice: ");
                    choice3 = scanner.nextInt();
                }
                catch (InputMismatchException e) {
                    scanner.nextLine();
                }
                if (choice3 == 1){
                    contBooking(scanner, speaker, sb, payment, availableSlots);
                    continueBooking = false;
                }
                else if(choice3 == 0){
                    continueBooking = false;
                }
                else{
                    System.out.println("Invalid Choice. Please try again");
                }
            } 
        }
    }
    
    public static void contBooking(Scanner scanner, String speaker, SlotBooking[] sb, Payment[] payment, List<Slot> availableSlots){
        clScr();
        boolean indicate = true;
        while(indicate){
            System.out.println("Event Booking");
            System.out.println("--------------");
            System.out.println("Which slots you prefer:");
            int numOfSlot = 0;

            for (int i = 0; i < availableSlots.size(); i++) {
                Slot slotToDisplay = availableSlots.get(i);
                System.out.println((i + 1) + ". " + slotToDisplay.getVenue());
                numOfSlot++;
            }

            int quit = numOfSlot + 1;
            System.out.println("\n0. Quit");
            int choice2 = 0;
            try{
                System.out.print("Your Choice: ");
                choice2 = scanner.nextInt();
            }
            catch (InputMismatchException e) {
                scanner.nextLine();
            }
            if (choice2 > 0 && choice2<quit){
                choice2 -=1 ;
                Slot chosenSlot = availableSlots.get(choice2);
                double slotPrice = chosenSlot.getPrice();
                if(eventPayment(scanner, payment, slotPrice)){
                    int numOfBooking = SlotBooking.getNumOfBooking();
                    int numOfPayment = Payment.getNumOfPayment();
                    sb[numOfBooking] = new SlotBooking(speaker, chosenSlot, payment[numOfPayment-1]);
                    clScr();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String formattedDate = dateFormat.format(payment[numOfPayment-1].getDate());
                    System.out.println("Receipt\t\t\t\t    "+ formattedDate);
                    System.out.println("-----------");                    
                    System.out.print(sb[numOfBooking].toString());
                    
                    System.out.println("\nPress any key to continue...");
                    scanner.nextLine();
                    scanner.nextLine();
                    
                    availableSlots.remove(choice2);

                }
                else{
                    System.out.println("Payment canceled. Returning to booking...");
                }
                break;
            }
            else if (choice2 == quit){
                System.out.print("Test ");
                break;
            }
            else
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public static boolean eventPayment(Scanner scanner, Payment[] payment, double price){
        clScr();
        int numOfPayment = Payment.getNumOfPayment();
        while (true){
            System.out.println("Payment Page");
            System.out.println("---------------");
            System.out.println("Payment method:");
            System.out.println("1. Credit Card");
            System.out.println("2. Online banking");
            System.out.println("3. Touch & Go");
            System.out.println("4. Cash");
            System.out.println("\n0. Quit");  
            int choice3 = 0;
            try{
                System.out.print("Your Choice: ");
                choice3 = scanner.nextInt();
            }
            catch (InputMismatchException e) {
                scanner.nextLine();
            }
            String method = "";
            if (choice3 >0 && choice3 <5){
                switch (choice3){
                case 1:
                    method = "Credit Card";
                    break;
                case 2:
                    method = "Online banking";
                    break;
                case 3:
                    method = "Touch & Go";
                    break;
                case 4:
                    method = "Cash";
                    break;
                }
                System.out.println(numOfPayment);
                payment[numOfPayment] = new Payment(method, price);
                return true;    
            }
            else if (choice3 == 0) {
                System.out.println("Payment canceled.");
                return false;
            } 
            else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        
    }
    
    public static void choiceBookingManagement(Scanner scanner,String speaker,SlotBooking[] sb, List<Slot> availableSlots, Payment[] payment){
        clScr();
        System.out.println("\nBooking Management");
        System.out.println("---------------------");
        System.out.println("1. Booked event");
        System.out.println("2. Refund");
        System.out.println("\n0. Quit");
        int choice = 0;
        try{
                System.out.print("Your Choice: ");
                choice = scanner.nextInt();
            }
        catch (InputMismatchException e) {
            scanner.nextLine();
        }
        if (choice == 1){
            viewBookedEvents(scanner,speaker,sb, availableSlots, payment);
        }
        
        else if (choice == 2) {
            cancelBookedEvents(scanner,speaker,sb, availableSlots, payment);
        }
        
        else if (choice == 0) {
            eventBooking(scanner,speaker,sb, payment, availableSlots);
        }
        
        else{
            System.out.println("Invalid choice. Please try again");
        }
    }
    
    public static void viewBookedEvents(Scanner scanner,String speaker,SlotBooking[] sb, List<Slot> availableSlots, Payment[] payment) {
        clScr();
        System.out.println("\nBooked Events");
        System.out.println("---------------");
        int num = 1;
        int[] venueNum = new int[100];
        for (int i = 0; i < sb.length; i++) {
            if (sb[i] != null && sb[i].getSpeaker().equals(speaker)) {
                System.out.println(num + ". " + sb[i].getVenue());
                venueNum[num-1]= i;
                num ++;
            }
        }
        System.out.println("\n0. Quit");
        int choice5 = 0;
        try{
                System.out.print("Your Choice: ");
                choice5 = scanner.nextInt();
            }
        catch (InputMismatchException e) {
            scanner.nextLine();
        }
        if (choice5 == 0) {
            choiceBookingManagement(scanner, speaker, sb, availableSlots, payment);
        }
        else if (choice5 >0 && choice5 <= num){
            int num1 = venueNum[choice5-1];
             System.out.println(sb[num1].toString());
             
            System.out.println("\nPress any key to continue...");
            scanner.nextLine();
            scanner.nextLine();
            
            choiceBookingManagement(scanner, speaker, sb, availableSlots, payment);               
                     
        }
        else
            System.out.println("Invalid choice. Please try again");
    }

    public static void cancelBookedEvents(Scanner scanner,String speaker,SlotBooking[] sb, List<Slot> availableSlots, Payment[] payment) {
        clScr();
        while(true){
            System.out.println("\nBooked Events");
            System.out.println("---------------");

            for (int i = 0; i < sb.length; i++) {
                if (sb[i] != null && sb[i].getSpeaker().equals(speaker)) {
                    System.out.println((i+1) + ". " + sb[i].getVenue());
                    System.out.println("RM" + sb[i].getPrice());                    
                }
            }
            System.out.println("\n0. Quit");
            int eventNumber = 0;        
            try{
                    System.out.print("Enter the number of the event to refund: ");
                    eventNumber = scanner.nextInt();
                }
            catch (InputMismatchException e) {
                scanner.nextLine();
            }

            if (eventNumber >= 1 && eventNumber <= sb.length && sb[eventNumber - 1] != null
                    && sb[eventNumber - 1].getSpeaker().equals(speaker)) {            
                Slot canceledSlot = sb[eventNumber - 1].getSlot();
                double refund = sb[eventNumber - 1].getPrice();
                availableSlots.add(canceledSlot);
                sb[eventNumber - 1] = null;

                System.out.println("Event canceled successfully.");
                System.out.println("RM" + refund + " is refund successfully. ");
                System.out.println("\nPress any key to continue...");
                scanner.nextLine();
                scanner.nextLine();

                choiceBookingManagement(scanner, speaker, sb, availableSlots, payment);

            } 
            else if (eventNumber == 0){
                choiceBookingManagement(scanner, speaker, sb, availableSlots, payment);
            }
            else {
                System.out.println("Invalid event number or not your event. Please try again.");
            }
        }
        
    }
    
    public static void clScr(){
        for (int i = 0; i < 40; i++) {
            System.out.println(); 
        }
    }
}
