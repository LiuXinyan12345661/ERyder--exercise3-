public class RegisteredUsers {
    private String fullName;
    private String emailAddress;
    private String dateOfBirth;
    private String cardNumber;
    private String cardExpiryDate;
    private String cardProvider;
    private String cvv;
    private String userType;
    private String[] lastThreeTrips;

    public RegisteredUsers(String fullName, String emailAddress, String dateOfBirth,
                           String cardNumber, String cardExpiryDate, String cardProvider,
                           String cvv, String userType, String[] lastThreeTrips) {
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.dateOfBirth = dateOfBirth;
        this.cardNumber = cardNumber;
        this.cardExpiryDate = cardExpiryDate;
        this.cardProvider = cardProvider;
        this.cvv = cvv;
        this.userType = userType;
        this.lastThreeTrips = lastThreeTrips;
    }

    public String getFullName() { return fullName; }
    public String getEmailAddress() { return emailAddress; }
    public String getDateOfBirth() { return dateOfBirth; }
    public String getCardNumber() { return cardNumber; }
    public String cardExpiryDate() { return cardExpiryDate; }
    public String getCardProvider() { return cardProvider; }
    public String getCvv() { return cvv; }
    public String getUserType() { return userType; }
    public String[] getLastThreeTrips() { return lastThreeTrips; }


    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; }
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }
    public void setCardExpiryDate(String cardExpiryDate) { this.cardExpiryDate = cardExpiryDate; }
    public void setCardProvider(String cardProvider) { this.cardProvider = cardProvider; }
    public void setCvv(String cvv) { this.cvv = cvv; }
    public void setUserType(String userType) { this.userType = userType; }
    public void setLastThreeTrips(String[] lastThreeTrips) { this.lastThreeTrips = lastThreeTrips; }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Registered User Info ===");
        sb.append("\nFull Name: ").append(fullName);
        sb.append("\nEmail: ").append(emailAddress);
        sb.append("\nDate of Birth: ").append(dateOfBirth);
        sb.append("\nCard Number: ").append(cardNumber);
        sb.append("\nCard Expiry: ").append(cardExpiryDate);
        sb.append("\nCard Provider: ").append(cardProvider);
        sb.append("\nCVV: ").append(cvv);
        sb.append("\nUser Type: ").append(userType);
        sb.append("\n--- Last Three Trips ---");

        if (lastThreeTrips != null) {
            for (int i = 0; i < lastThreeTrips.length; i++) {
                sb.append("\nTrip ").append(i + 1).append(": ").append(lastThreeTrips[i]);
            }
        } else {
            sb.append("\nNo trips yet.");
        }
        sb.append("\n===========================\n");
        return sb.toString();
    }







}
