package cc.somkiat.basicunittesting.validation;

import cc.somkiat.basicunittesting.MyValidation;

public class IsInRangeCheck implements MyValidation{

    @Override
    public boolean isValid(String input) {
        return !(input.length() <= 1 || input.length() > 20);
    }

    @Override
    public String getErrorMessage() {
        return "It's invalid input length";
    }
}
