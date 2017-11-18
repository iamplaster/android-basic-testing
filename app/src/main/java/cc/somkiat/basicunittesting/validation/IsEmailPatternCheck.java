package cc.somkiat.basicunittesting.validation;

import cc.somkiat.basicunittesting.MyValidation;

public class IsEmailPatternCheck implements MyValidation{
    String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Override
    public boolean isValid(String input) {
        if(input.matches(emailPattern)){
            return true;
        }
        return false;
    }

    @Override
    public String getErrorMessage() {
        return "It's invalid email";
    }
}
