public class Feedback {
    private String firstName;
    private String lastName;
    private String email;
    private String completeFeedback;
    private String reviewID;
    private boolean longFeedback;

    public Feedback(String firstName,String lastName,String email){

    }
    

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }


    public String getEmail(){
        return email;
    }

    public void analyseFeedback(boolean isConcatenation,String sent1,String sent2,String sent3,String sent4,String sent5){
        if(isConcatenation){
            completeFeedback = feedbackUsingConcatenation(sent1,sent2,sent3,sent4,sent5);
            checkFeedbackLength(completeFeedback);
            createReviewID(firstName,lastName,completeFeedback);
        }else{
            completeFeedback = feedbackUsingStringBuilder(sent1,sent2,sent3,sent4,sent5).toString();
            checkFeedbackLength(completeFeedback);
            createReviewID(firstName,lastName,completeFeedback);
        }

        }


    private String feedbackUsingConcatenation(String sent1,String sent2,String sent3,String sent4,String sent5){
        String concatenatedFeedback="";
        concatenatedFeedback += sent1;
        concatenatedFeedback += sent2;
        concatenatedFeedback += sent3;
        concatenatedFeedback += sent4;
        concatenatedFeedback += sent5;

        return concatenatedFeedback;

    }

    private String feedbackUsingStringBuilder(String sent1,String sent2,String sent3,String sent4,String sent5){
             StringBuilder sb = new StringBuilder();
             sb.append(sent1);
             sb.append(sent2);
             sb.append(sent3);
             sb.append(sent4);
             sb.append(sent5);

        return sb.toString();
    }


    private boolean checkFeedbackLength(String feedback){
        if (feedback.length() > 500) {
            longFeedback = true;
            return longFeedback;

        }else{
            longFeedback = false;
            return longFeedback;

        }
    }


    private String createReviewID(String firstName,String lastName,String feedback){

        reviewID = ((firstName+lastName).toUpperCase().substring(2,6)+completeFeedback.substring(10,15).toLowerCase()+completeFeedback.length()+"_"+System.currentTimeMillis()).replace("","");

return reviewID;

    }


    public String toString(){
        return "Feedback Information:\n" +
                "First Name: " + firstName + "\n" +
                "Last Name: " + lastName + "\n" +
                "Email: " + email + "\n" +
                "Complete Feedback: " + completeFeedback + "\n" +
                "Is Long Feedback (＞500 chars): " + longFeedback + "\n" +
                "Unique Review ID: " + reviewID;

    }



        
    

    }


