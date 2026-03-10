public class Main {
    public static void main(String[] args) throws Exception{
        ERyder bike1 = new ERyder();
        bike1.setBatterLevel(80);
        bike1.setAvailable(true);
        bike1.ride();
        System.out.println("Details of bike1:");
        bike1.printBikeDetails();
    

    
        ERyder bike2 = new ERyder("12345",80,false,120.5f);
        System.out.println("Details of bike2:");
        bike2.printBikeDetails();

}
}
