package AngatBuhay;

import java.util.Scanner;

public class Update {

    public static void updateDonation(Scanner scanner, ViewDashboard viewDashboard) {
        // Display the current donations in the dashboard
        viewDashboard.displayAllDonations();

        System.out.print("Please enter the number of the donation to update: ");
        int donationIndex = getValidatedInteger(scanner) - 1;  // Adjust to 0-based index

        if (donationIndex < 0 || donationIndex >= viewDashboard.getDonationCount()) {
            System.out.println("Invalid donation number. Please try again.");
            return;
        }

        Donation donationToUpdate = viewDashboard.getDonation(donationIndex);  // Get the selected donation

        System.out.println("Select what you want to update:");
        System.out.println("1. Cause");
        System.out.println("2. Quantity");
        System.out.println("3. Unit");
        System.out.println("4. Donation Details");
        System.out.print("Please select an option (1-4): ");

        int updateOption = getValidatedInteger(scanner);
        
        // Consume the newline character after the integer input
        scanner.nextLine();  // To clear the buffer before nextLine() call

        switch (updateOption) {
            case 1:  // Update Cause
                System.out.print("Enter the new cause: ");
                String newCause = scanner.nextLine();  // Use nextLine() to capture entire input
                if (newCause.trim().isEmpty()) {
                    System.out.println("Cause cannot be empty. Please try again.");
                    return;
                }
                donationToUpdate.setCause(newCause);  // Update the cause of the donation
                break;

            case 2:  // Update Quantity
                System.out.print("Enter the new quantity: ");
                int newQuantity = getValidatedInteger(scanner);
                // Consume the newline character again after nextInt()
                scanner.nextLine();  // Clear the buffer after reading the integer input
                donationToUpdate.setQuantity(newQuantity);  // Update the quantity of the donation
                break;

                case 3:  // Update Unit
                System.out.print("Enter the new unit: ");
                String newUnit = scanner.nextLine();  // Use nextLine() to capture entire input
                if (newUnit.trim().isEmpty()) {
                    System.out.println("Unit cannot be empty. Please try again.");
                    return;
                }
                donationToUpdate.setUnit(newUnit);  // Update the unit of the donation
                System.out.println("Updated unit: " + donationToUpdate.getUnit());  // Debugging line
                break;
            

            case 4:  // Update Donation Details
                System.out.print("Enter the new donation details: ");
                String newDetails = scanner.nextLine();  // Use nextLine() to capture entire input
                if (newDetails.trim().isEmpty()) {
                    System.out.println("Details cannot be empty. Please try again.");
                    return;
                }
                donationToUpdate.setDetails(newDetails);  // Update the details of the donation
                break;

            default:
                System.out.println("Invalid selection. Please try again.");
                return;
        }

        // Show the updated dashboard
        System.out.println("Donation updated successfully! Here's the updated dashboard:");
        viewDashboard.displayAllDonations();
    }

    // Define the getValidatedInteger method here
    private static int getValidatedInteger(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
