

public class ERyder {
    private String bikeID;
    private int batteryLevel;
    public boolean isAvailable;
    public float kmDriven;
    public static final double BASE_FARE = 1.0;
    public static final double PER_MINUTE_FARE = 0.5;
    private final String LINKED_ACCOUNT;
    private final String LINKED_PHONE_NUMBER;

    private int totalUsageInMinutes;
    private double totalFare;


public ERyder(){
    this.bikeID = "bike1";
    this.batteryLevel = 100;
    this.isAvailable = true;
    this.kmDriven = 0.0f;
    this.LINKED_ACCOUNT= "AS43500N09";
    this.LINKED_PHONE_NUMBER = "1234567890L";
    this.totalUsageInMinutes = 0;
    this.totalFare = 0.0;

}
public ERyder(String bikeID,int batteryLevel,boolean isAvailable,float kmDriven){
    this.bikeID = bikeID;
    this.batteryLevel = batteryLevel;
    this.isAvailable = isAvailable;
    this.kmDriven = kmDriven;
    this.LINKED_ACCOUNT= "AS43500N09";
    this.LINKED_PHONE_NUMBER = "1234567890L";
    this.totalUsageInMinutes = 0;
    this.totalFare = 0.0;

}

    public ERyder(String bikeID,int batteryLevel,boolean isAvailable,float kmDriven,String linkedAccount,String linkedPhoneNumber,int totalUsageInMinutes,int totalFare){
    this.bikeID = bikeID;
    this.batteryLevel =batteryLevel;
    this.isAvailable = isAvailable;
    this.kmDriven = kmDriven;
    this.LINKED_ACCOUNT= linkedAccount;
    this.LINKED_PHONE_NUMBER = linkedPhoneNumber ;
    this.totalUsageInMinutes = totalUsageInMinutes;
    this.totalFare = totalFare;
    

}

   

public void ride(){
    if(batteryLevel>0 && isAvailable){
        System.out.println("The bike is available");
    }else{
        System.out.println("The bike is not available");
    }
}

public void setBatterLevel(int batteryLevel){
    if ((batteryLevel>0 && batteryLevel<=100)) {
        this.batteryLevel = batteryLevel;
    }else{
        this.batteryLevel =0;
        System.out.println("Invaild batterylevel");
    }
}

public void setAvailable(boolean available){
    this.isAvailable = available;
}

public void printBikeDetails(){
    System.out.println("Bike ID:"+bikeID);
    System.out.println("Battery Level:"+batteryLevel+"%");
    System.out.println("Is Available:" + isAvailable);
    System.out.println("Total KM Driven: " + kmDriven + "km");

}
public void printRideDetails(int usageInMinutes) {
        this.totalFare = calculateFare(usageInMinutes);
        this.totalUsageInMinutes = usageInMinutes;
        System.out.println("Linked Account: " + LINKED_ACCOUNT);
        System.out.println("Linked Phone Number: " + LINKED_PHONE_NUMBER);
        System.out.println("Bike ID: " + bikeID);
        System.out.println("Ride Usage Minutes: " + totalUsageInMinutes + "mins");
        System.out.println("Total Fare: $" + String.format("%.2f", totalFare)); 
    }
    private double calculateFare(int usageInMinutes) {
        totalFare =  BASE_FARE + (PER_MINUTE_FARE * usageInMinutes);
        return totalFare;
    }

    

}


