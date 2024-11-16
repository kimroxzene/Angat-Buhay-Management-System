package AngatBuhay;

public abstract class Donation {
    private String donorName;
    private int quantity;
    private String unit;
    private String details;
    private String cause;

    // Constructor
    public Donation(String donorName, int quantity, String cause) {
        this.donorName = donorName;
        this.quantity = quantity;
        this.cause = cause;
    }

    public String getDonorName() {
        return donorName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getCause() {
        return cause;
    }

    // New method to update the cause
    public void setCause(String cause) {
        this.cause = cause;
    }

    // Abstract method for subclass-specific donation details
    public abstract String getDonationType();

    // Subclasses with the updated cause parameter in constructors
    public static class FoodDonation extends Donation {
        private String foodType;
        private String unit;

        public FoodDonation(String donorName, int quantity, String foodType, String unit, String cause) {
            super(donorName, quantity, cause);
            this.foodType = foodType;
            this.unit = unit;
        }

        @Override
        public String getUnit() {
            return unit;
        }

        @Override
        public void setUnit(String unit) {
            this.unit = unit;
        }

        @Override
        public void setDetails(String details) {
            this.foodType = details;
        }

        @Override
        public String getDetails() {
            return foodType;
        }

        @Override
        public String getDonationType() {
            return "Food Donation";
        }
    }

    public static class WaterDonation extends Donation {
        private String waterType;

        public WaterDonation(String donorName, int quantity, String waterType, String cause) {
            super(donorName, quantity, cause);
            this.waterType = waterType;
        }

        @Override
        public String getUnit() {
            return "pcs";
        }

        @Override
        public void setDetails(String details) {
            this.waterType = details;
        }

        @Override
        public String getDetails() {
            return waterType;
        }

        @Override
        public String getDonationType() {
            return "Water Donation";
        }
    }

    public static class ClothesDonation extends Donation {
        private String clothesType;

        public ClothesDonation(String donorName, int quantity, String clothesType, String cause) {
            super(donorName, quantity, cause);
            this.clothesType = clothesType;
        }

        @Override
        public String getUnit() {
            return "pcs"; 
        }

        @Override
        public void setDetails(String details) {
            this.clothesType = details;
        }

        @Override
        public String getDetails() {
            return clothesType;
        }

        @Override
        public String getDonationType() {
            return "Clothes Donation";
        }
    }

    public static class MonetaryDonation extends Donation {
        private double amount;

        public MonetaryDonation(String donorName, double amount, String cause) {
            super(donorName, 1, cause); // Quantity set to 1 for monetary donations
            this.amount = amount;
        }

        @Override
        public String getUnit() {
            return "PHP";
        }

        @Override
        public String getDetails() {
            return String.format("%.2f", amount);
        }

        @Override
        public String getDonationType() {
            return "Monetary Donation";
        }

        public double getAmount() {
            return amount;
        }
    }

    public static class ToiletriesDonation extends Donation {
        private String toiletryType;

        public ToiletriesDonation(String donorName, int quantity, String toiletryType, String cause) {
            super(donorName, quantity, cause);
            this.toiletryType = toiletryType;
        }

        @Override
        public String getUnit() {
            return "pcs"; // Assuming toiletries are counted in pieces
        }

        @Override
        public void setDetails(String details) {
            this.toiletryType = details;
        }

        @Override
        public String getDetails() {
            return toiletryType;
        }

        @Override
        public String getDonationType() {
            return "Toiletries Donation";
        }
    }

    public static class BookDonation extends Donation {
        private String bookType;

        public BookDonation(String donorName, int quantity, String bookType, String cause) {
            super(donorName, quantity, cause);
            this.bookType = bookType;
        }

        @Override
        public String getUnit() {
            return "pcs"; // Assuming books are counted in pieces
        }

        @Override
        public void setDetails(String details) {
            this.bookType = details;
        }

        @Override
        public String getDetails() {
            return bookType;
        }

        @Override
        public String getDonationType() {
            return "Book Donation";
        }
    }

    public static class SchoolSuppliesDonation extends Donation {
        private String suppliesType;

        public SchoolSuppliesDonation(String donorName, int quantity, String suppliesType, String cause) {
            super(donorName, quantity, cause);
            this.suppliesType = suppliesType;
        }

        @Override
        public String getUnit() {
            return "pcs"; // Assuming supplies are counted in pieces
        }

        @Override
        public void setDetails(String details) {
            this.suppliesType = details;
        }

        @Override
        public String getDetails() {
            return suppliesType;
        }

        @Override
        public String getDonationType() {
            return "School Supplies Donation";
        }
    }
}
