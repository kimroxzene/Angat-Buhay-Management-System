package AngatBuhay;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ViewDashboard viewDashboard = new ViewDashboard();  

        while (true) {
            System.out.println("==========================================================================");
            System.out.println("\t\t\tAngat Buhay Donation Tracker");
            System.out.println("\t\tcontact us: info@angatbuhay.ph | 09695718211");
            System.out.println("==========================================================================");
            System.out.println("  ---\t\t\t\t\t ---");
            System.out.println("   1\tDonate\t\t\t\t  3\tActivity Dashboard");
            System.out.println("  ---\t\t\t\t\t ---");
            System.out.println("  ---\t\t\t\t\t ---");
            System.out.println("   2\tUpdate Donation\t\t\t  4\tExit");
            System.out.println("  ---\t\t\t\t\t ---");
            System.out.println("==========================================================================");

            System.out.print("Choose an option: ");
            int choice = getValidatedInteger(scanner);
            scanner.nextLine(); // Clear newline

            switch (choice) {
                case 1:
                    donate(scanner, viewDashboard);
                    break;
                case 2:
                    Update.updateDonation(scanner, viewDashboard);
                    break;
                case 3:
                    viewDashboard.displayAllDonations();  
                    break;
                case 4:
                    System.out.println("Thank you for supporting Angat Buhay Donation!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void donate(Scanner scanner, ViewDashboard viewDashboard) {
        System.out.println("==========================================================================");
        System.out.println("\t\t\t  SELECT FOR A CAUSE");
        System.out.println("==========================================================================");
        System.out.println("| 1. | Climate Action Sustainability");
        System.out.println("| 2. | Nutrition and Food Security");
        System.out.println("| 3. | Public Education");
        System.out.println("--------------------------------------------------------------------------");
        System.out.print("Select a Cause: ");
        int causeChoice = getValidatedInteger(scanner);
        scanner.nextLine(); // Clear newline

        String cause;
        switch (causeChoice) {
            case 1:
                cause = "Climate Action Sustainability";
                System.out.println("==========================================================================");
                System.out.println("\t\t  CLIMATE ACTION AND SUSTAINABILITY");
                System.out.println("==========================================================================");
                displayClimateOptions(scanner, viewDashboard, cause);
                break;
            case 2:
                cause = "Nutrition and Food Security";
                System.out.println("==========================================================================");
                System.out.println("\t\t\tNUTRITION AND FOOD SECURITY");
                System.out.println("==========================================================================");
                displayFoodSecurityOptions(scanner, viewDashboard, cause);
                break;
            case 3:
                cause = "Public Education";
                System.out.println("==========================================================================");
                System.out.println("\t\t\t  PUBLIC EDUCATION");
                System.out.println("==========================================================================");
                displayEducationOptions(scanner, viewDashboard, cause);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                return;
        }
    }

    private static void displayClimateOptions(Scanner scanner, ViewDashboard viewDashboard, String cause) {
        System.out.println("\tA. Food Donation\t\tD. Monetary Donation");
        System.out.println("\tB. Water Donation\t\tE. Toiletries Donation");
        System.out.println("\tC. Clothes Donation");
        System.out.println("--------------------------------------------------------------------------");
        System.out.print("Select Donation Type (A-E): ");
        
        char donationType = scanner.nextLine().toUpperCase().charAt(0);

        System.out.print("Enter Donor Name: ");
        String donorName = scanner.nextLine();

        switch (donationType) {
            case 'A':
                handleFoodDonation(donorName, viewDashboard, scanner, cause);
                break;
            case 'B':
                handleWaterDonation(donorName, viewDashboard, scanner, cause);
                break;
            case 'C':
                handleClothesDonation(donorName, viewDashboard, scanner, cause);
                break;
            case 'D':
                handleMonetaryDonation(donorName, viewDashboard, scanner, cause);
                break;
            case 'E':
                handleToiletriesDonation(donorName, viewDashboard, scanner, cause);
                break;
            default:
                System.out.println("Invalid donation type. Please try again.");
        }
    }

    private static void displayFoodSecurityOptions(Scanner scanner, ViewDashboard viewDashboard, String cause) {
        System.out.println("\tA. Food Donation\t\tC. Monetary Donation");
        System.out.println("\tB. Water Donation");
        System.out.println("--------------------------------------------------------------------------");
        System.out.print("Select Donation Type (A-C): ");
        char donationType = scanner.nextLine().toUpperCase().charAt(0);

        System.out.print("Enter Donor Name: ");
        String donorName = scanner.nextLine();

        switch (donationType) {
            case 'A':
                handleFoodDonation(donorName, viewDashboard, scanner, cause);
                break;
            case 'B':
                handleWaterDonation(donorName, viewDashboard, scanner, cause);
                break;
            case 'C':
                handleMonetaryDonation(donorName, viewDashboard, scanner, cause);
                break;
            default:
                System.out.println("Invalid donation type. Please try again.");
        }
    }

    private static void displayEducationOptions(Scanner scanner, ViewDashboard viewDashboard, String cause) {
        System.out.println("\tA. Book Donation\t\tC. Monetary Donation");
        System.out.println("\tB. School Supplies Donation");
        System.out.println("--------------------------------------------------------------------------");
        System.out.print("Select Donation Type (A-C): ");
        char donationType = scanner.nextLine().toUpperCase().charAt(0);

        System.out.print("Enter Donor Name: ");
        String donorName = scanner.nextLine();

        switch (donationType) {
            case 'A':
                handleBookDonation(donorName, viewDashboard, scanner, cause);
                break;
            case 'B':
                handleSchoolSuppliesDonation(donorName, viewDashboard, scanner, cause);
                break;
            case 'C':
                handleMonetaryDonation(donorName, viewDashboard, scanner, cause);
                break;
            default:
                System.out.println("Invalid donation type. Please try again.");
        }
    }

    // Methods with Cause Parameter
    private static void handleFoodDonation(String donorName, ViewDashboard viewDashboard, Scanner scanner, String cause) {
        System.out.print("Enter Food Type: ");
        String foodType = scanner.nextLine();
        System.out.print("Enter Unit (kg / pcs): ");
        String foodUnit = scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int foodQuantity = getValidatedInteger(scanner);

        viewDashboard.addDonation(new Donation.FoodDonation(donorName, foodQuantity, foodType, foodUnit, cause));
        System.out.println("Donation added successfully!");
    }

    private static void handleWaterDonation(String donorName, ViewDashboard viewDashboard, Scanner scanner, String cause) {
        System.out.print("Enter Water Type (bottled / gallon): ");
        String waterType = scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int waterQuantity = getValidatedInteger(scanner);

        viewDashboard.addDonation(new Donation.WaterDonation(donorName, waterQuantity, waterType, cause));
    }

    private static void handleMonetaryDonation(String donorName, ViewDashboard viewDashboard, Scanner scanner, String cause) {
        System.out.print("Enter Cash Amount: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid amount:");
            scanner.next();
        }
        double amount = scanner.nextDouble();
        scanner.nextLine();

        viewDashboard.addDonation(new Donation.MonetaryDonation(donorName, amount, cause));
    }    

    private static void handleClothesDonation(String donorName, ViewDashboard viewDashboard, Scanner scanner, String cause) {
        System.out.print("Enter Clothes Type (shirt / pants / others): ");
        String clothesType = scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int clothesQuantity = getValidatedInteger(scanner);

        viewDashboard.addDonation(new Donation.ClothesDonation(donorName, clothesQuantity, clothesType, cause));
    }

    private static void handleToiletriesDonation(String donorName, ViewDashboard viewDashboard, Scanner scanner, String cause) {
        System.out.print("Enter Toiletry Type (shampoo / soap / others): ");
        String toiletryType = scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int toiletriesQuantity = getValidatedInteger(scanner);

        viewDashboard.addDonation(new Donation.ToiletriesDonation(donorName, toiletriesQuantity, toiletryType, cause));
    }

    private static void handleBookDonation(String donorName, ViewDashboard viewDashboard, Scanner scanner, String cause) {
        System.out.print("Enter Book Type: ");
        String bookType = scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int bookQuantity = getValidatedInteger(scanner);

        viewDashboard.addDonation(new Donation.BookDonation(donorName, bookQuantity, bookType, cause));
    }

    private static void handleSchoolSuppliesDonation(String donorName, ViewDashboard viewDashboard, Scanner scanner, String cause) {
        System.out.print("Enter School Supplies Type: ");
        String suppliesType = scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int suppliesQuantity = getValidatedInteger(scanner);

        viewDashboard.addDonation(new Donation.SchoolSuppliesDonation(donorName, suppliesQuantity, suppliesType, cause));
    }

    private static int getValidatedInteger(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
