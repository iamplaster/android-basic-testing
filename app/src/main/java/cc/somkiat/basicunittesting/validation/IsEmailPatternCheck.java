package cc.somkiat.basicunittesting.validation;

public class IsEmailPatternCheck {
    String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public boolean isEmailPatternCheck(String email){
        if(email.matches(emailPattern)){
            return true;
        }
        return false;
    }
}
