package cc.somkiat.basicunittesting.validation;


import cc.somkiat.basicunittesting.MyValidation;

public class IsSpecialCharCheck implements MyValidation{
    String regExp = "^[^<>{}\"/|;:.,~!?@#$%^=&*\\]\\\\()\\[¿§«»ω⊙¤°℃℉€¥£¢¡®©0-9_+]*$";

    @Override
    public boolean isValid(String input) {
        return (input.matches(regExp));
    }

    @Override
    public String getErrorMessage() {
        return "Name should not contain with special character";
    }
}
