package cc.somkiat.basicunittesting;

import cc.somkiat.basicunittesting.validation.IsEmailPatternCheck;
import cc.somkiat.basicunittesting.validation.IsEmptyCheck;

public class EmailValidation {

    public boolean isEmailPatternCheck(String email){
        return new IsEmailPatternCheck().isEmailPatternCheck(email);
    }
    public boolean isEmptyCheck(String text){
        return new IsEmptyCheck().isEmptyCheck(text);
    }
    public boolean isNullCheck(String text){
        return new IsEmptyCheck().isNullCheck(text);
    }
    public boolean includeCheck(String email){
        return new IsEmailPatternCheck().isEmailPatternCheck(email) && new IsEmptyCheck().isEmptyCheck(email)
                && new IsEmptyCheck().isNullCheck(email);
    }
}
