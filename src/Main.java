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



        String sent1 = "I was very satisfied with the service.";
        String sent2 = "The e-Bike is quite comfortable to ride.";
        String sent3 = "The battery life of the e-Bike is impressive.";
        String sent4 = "The customer support was helpful and responsive.";
        String sent5 = "I would recommend this e-Bike to my friends and family.";


        Feedback userFeedback = new Feedback("Xinyan", "Liu", "3377627793@qq.com");


        userFeedback.analyseFeedback(false, sent1, sent2, sent3, sent4, sent5);
        System.out.println(userFeedback);




        UserRegistration userReg = new UserRegistration();
        userReg.registration();
        System.out.println("\n" + userReg);




        AdminPanel adminPanel = new AdminPanel();
        adminPanel.userManagementOptions();




    }
}
