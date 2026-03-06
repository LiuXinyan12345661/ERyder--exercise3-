public class ERyder {
    private String bikeID;
    private int batteryLevel;
    public boolean isAvailable;
    public float kmDriven;
}

public ERyder(){

}

    public ERyder(String bikeID,int batteryLevel,boolean isAvailable,float kmDriven){
    this.bikeID = bikeID;
    this.setBatterLevel(batteryLevel);
    this.isAvailable = isAvailable;
    this.kmDriven = kmDriven;
}

public void ride(){
    if(batteryLevel>0 && isAvailable){
        System.out.println("The bike is available")
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

public void printBikeDetails(){
    System.out.println("Bike ID:"+bikeID);
    System.out.println("Battery Level:"+batteryLevel+"%");
    System.out.println("Is Available:" + isAvailable);

}