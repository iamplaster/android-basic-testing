package cc.somkiat.basicunittesting.validation;


import cc.somkiat.basicunittesting.MyValidation;

public class IsNullCheck implements MyValidation{
    @Override
    public boolean isValid(String input) {
        return !(input == null);
    }

    @Override
    public String getErrorMessage() {
        return "It's null";
    }
}
