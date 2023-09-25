
package com.mycompany.oop;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Time;
import java.sql.Date;

public class Advertisement extends Seminar{
    
    private String advertisementTitle;
    private String advertisementDescription;
    private double advertisementPrice;
    

    public Advertisement(String id, String desc, Date startDate, Date endDate, Time startTime, Time endTime, double price, String location, ArrayList<SeminarEnroll> enrollList,
            String advertisementTitle, String advertisementDescription, double advertisementPrice) {
        super(id, desc, startDate, endDate, startTime, endTime, price, location,enrollList);

        this.advertisementTitle = advertisementTitle;
        this.advertisementDescription = advertisementDescription;
        this.advertisementPrice = advertisementPrice;

    }

    // Getter methods
    public String getTitle() {
        return advertisementTitle;
    }

    public String getDescription() {
        return advertisementDescription;
    }

    public double getPrice() {
        return advertisementPrice;
    }
    
    public String getSeminarID(){
        
        return super.getID();
    }
    
    public String getSeminarDesc(){
        
        return super.getDesc();
    }

    
    public void setTitle(String title) {
        this.advertisementTitle = title;
    }

    public void setDescription(String description) {
        this.advertisementDescription = description;
    }

    public void setPrice(double price) {
        this.advertisementPrice= price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()); 
        sb.append("Advertisement Details\n");
        sb.append("--------------------\n");
        sb.append("Title: ").append(advertisementTitle).append("\n");
        sb.append("Description: ").append(advertisementDescription).append("\n");
        sb.append("Price: $").append(String.format("%.2f", advertisementPrice)).append("\n");

        return sb.toString();
    }

    public static void createAdvertisement(ArrayList<Advertisement> advertisements, Scanner scanner) {
        
        System.out.print("Enter seminar ID: ");
        String ID = scanner.nextLine();


        Date startDate = null;
        boolean startDateValid = false;
        while (!startDateValid) {
            try {
                System.out.print("Enter seminar start date (yyyy-MM-dd): ");
                String startDateStr = scanner.nextLine();
                startDate = Date.valueOf(startDateStr);
                startDateValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid date format. Please use yyyy-MM-dd format.");
            }
        }


        Date endDate = null;
        boolean endDateValid = false;
        while (!endDateValid) {
            try {
                System.out.print("Enter seminar end date (yyyy-MM-dd): ");
                String endDateStr = scanner.nextLine();
                endDate = Date.valueOf(endDateStr);
                endDateValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid date format. Please use yyyy-MM-dd format.");
            }
        }


        Time startTime = null;
        boolean startTimeValid = false;
        while (!startTimeValid) {
            try {
                System.out.print("Enter seminar start time (HH:mm:ss): ");
                String startTimeStr = scanner.nextLine();
                startTime = Time.valueOf(startTimeStr);
                startTimeValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid time format. Please use HH:mm:ss format.");
            }
        }


        Time endTime = null;
        boolean endTimeValid = false;
        while (!endTimeValid) {
            try {
                System.out.print("Enter seminar end time (HH:mm:ss): ");
                String endTimeStr = scanner.nextLine();
                endTime = Time.valueOf(endTimeStr);
                endTimeValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid time format. Please use HH:mm:ss format.");
            }
        }


        double price = 0.0;
        boolean priceValid = false;
        while (!priceValid) {
            try {
                System.out.print("Enter seminar price: ");
                price = Double.parseDouble(scanner.nextLine());
                priceValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid price format. Please enter a valid number.");
            }
        }

        System.out.print("Enter seminar location: ");
        String location = scanner.nextLine();

        System.out.print("Enter advertisement title: ");
        String advertisementTitle = scanner.nextLine();

        System.out.print("Enter advertisement description: ");
        String advertisementDescription = scanner.nextLine();


        double advertisementPrice = 0.0;
        boolean advertisementPriceValid = false;
        while (!advertisementPriceValid) {
            try {
                System.out.print("Enter advertisement price: ");
                advertisementPrice = Double.parseDouble(scanner.nextLine());
                advertisementPriceValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid advertisement price format. Please enter a valid number.");
            }
        }
        
        

        ArrayList<SeminarEnroll> enrollList = new ArrayList<>();
        Advertisement ad = new Advertisement(ID, "", startDate, endDate, startTime, endTime, price, location, enrollList, advertisementTitle, advertisementDescription, advertisementPrice);
        advertisements.add(ad);

        System.out.println("Advertisement created successfully.");
    }


    public static void viewAdvertisements(ArrayList<Advertisement> advertisements) {
        if (advertisements.isEmpty()) {
            System.out.println("No advertisements to display.");
        } else {
            System.out.println("Advertisements:");
            for (int i = 0; i < advertisements.size(); i++) {
                System.out.println((i + 1) + ". " + advertisements.get(i));
            }
        }
    }

    public static void updateAdvertisement(ArrayList<Advertisement> advertisements, Scanner scanner) {
        viewAdvertisements(advertisements);
        System.out.print("Enter the number of the advertisement to update: ");
        int adNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (adNumber >= 1 && adNumber <= advertisements.size()) {
            Advertisement ad = advertisements.get(adNumber - 1);

            System.out.println("Select the attribute to update:");
            System.out.println("1. Title");
            System.out.println("2. Description");
            System.out.println("3. Price");
            System.out.print("Enter your choice: ");
            int attributeChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (attributeChoice) {
                case 1:
                    System.out.print("Enter new title: ");
                    String newTitle = scanner.nextLine();
                    if (newTitle != null && !newTitle.trim().isEmpty()) {
                        ad.setTitle(newTitle);
                        System.out.println("Title updated successfully.");
                    } else {
                        System.out.println("Title cannot be empty. Update failed.");
                    }
                    break;
                case 2:
                    System.out.print("Enter new description: ");
                    String newDescription = scanner.nextLine();
                    if (newDescription != null && !newDescription.trim().isEmpty()) {
                        ad.setDescription(newDescription);
                        System.out.println("Description updated successfully.");
                    } else {
                        System.out.println("Description cannot be empty. Update failed.");
                    }
                    break;
                case 3:
                    System.out.print("Enter new price: ");
                    double newPrice = scanner.nextDouble();
                    if (newPrice > 0) {
                        ad.setPrice(newPrice);
                        System.out.println("Price updated successfully.");
                    } else {
                        System.out.println("Invalid price. Price must be greater than 0. Update failed.");
                    }
                    break;
                default:
                    System.out.println("Invalid attribute choice.");
            }
        } else {
            System.out.println("Invalid advertisement number.");
        }
    }


    public static void deleteAdvertisement(ArrayList<Advertisement> advertisements, Scanner scanner) {
        viewAdvertisements(advertisements);
        System.out.print("Enter the number of the advertisement to delete: ");
        int adNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (adNumber >= 1 && adNumber <= advertisements.size()) {
            Advertisement adToDelete = advertisements.get(adNumber - 1);

            System.out.print("Are you sure you want to delete this advertisement? (yes/no): ");
            String confirmation = scanner.nextLine().trim().toLowerCase();

            if (confirmation.equals("yes")) {
                advertisements.remove(adToDelete);
                System.out.println("Advertisement deleted successfully.");
            } else {
                System.out.println("Advertisement was not deleted.");
            }
        } else {
            System.out.println("Invalid advertisement number.");
        }
    }
}

    



    
    



