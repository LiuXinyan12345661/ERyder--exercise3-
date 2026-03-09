public class Main {
    public static void main(String[] args) {
        ERyder bike1 = new ERyder();
        System.out.println("Details of bike1:");
        bike1.printBikeDetails();
    

    
        ERyder bike2 = new ERyder("12345",80,false,120.5f);
        System.out.println("Details of bike2:");
        bike2.printBikeDetails();

}
}
