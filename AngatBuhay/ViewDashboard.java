package AngatBuhay;

import java.util.ArrayList;
import java.util.List;

public class ViewDashboard {
    private List<Donation> donations = new ArrayList<>();

    // Adds a donation to the list
    public void addDonation(Donation donation) {
        donations.add(donation);
    }

    // Updates the quantity of a specific donation
    public void updateDonation(int index, int newQuantity) {
        if (index >= 0 && index < donations.size()) {
            donations.get(index).setQuantity(newQuantity);
        } else {
            System.out.println("Invalid donation index.");
        }
    }

    // Formats the class name to add a space between words (e.g., "FoodDonation" becomes "Food Donation")
    private String formatDonationType(String donationType) {
        return donationType.replaceAll("([a-z])([A-Z])", "$1 $2");
    }

    // Displays all donations in a table format with consistent alignment
    public void displayAllDonations() {
        if (donations.isEmpty()) {
            System.out.println("No donations available.");
        } else {
            // Print the table header with consistent spacing
            System.out.println("=============================================================================================================================================================");
            System.out.printf("%-6s %-35s %-40s %-25s %-14s %-12s %-30s\n","No.", "Donor", "Cause", "Donation Type", "Quantity", "Unit", "Donation Details");
            System.out.println("=============================================================================================================================================================");

            // Print each donation in a table row
            for (int i = 0; i < donations.size(); i++) {
                Donation donation = donations.get(i);
                String donorName = donation.getDonorName();
                String donationType = formatDonationType(donation.getClass().getSimpleName());
                String cause = donation.getCause();  // Assuming Donation class has a getCause() method
                int quantity = donation.getQuantity();
                String unit = donation.getUnit();
                String details = donation.getDetails();

                System.out.printf("%-6d %-35s %-40s %-25s %-14d %-12s %-30s\n", 
                (i + 1), donorName, cause, donationType, quantity, unit, details);
            }
            System.out.println("=============================================================================================================================================================");
        }
    }

    // Returns the total number of donations
    public int getDonationCount() {
        return donations.size();
    }

    // Returns a specific donation by index
    public Donation getDonation(int index) {
        if (index >= 0 && index < donations.size()) {
            return donations.get(index);
        } else {
            return null;
        }
    }
}