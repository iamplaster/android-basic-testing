package cc.somkiat.basicunittesting.validation;


import cc.somkiat.basicunittesting.MyValidation;

public class IsEmptyCheck implements MyValidation{

    @Override
    public boolean isValid(String input) {
        return !input.isEmpty();
    }

    @Override
    public String getErrorMessage() {
        return "It's Empty";
    }
}
