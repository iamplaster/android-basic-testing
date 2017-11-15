package cc.somkiat.basicunittesting;

import cc.somkiat.basicunittesting.validation.IsEmptyCheck;
import cc.somkiat.basicunittesting.validation.IsInRangeCheck;
import cc.somkiat.basicunittesting.validation.IsSpecialCharCheck;

public class NameValidation {

    public boolean isEmptyCheck(String text){
        return new IsEmptyCheck().isEmptyCheck(text);
    }
    public boolean isNullCheck(String text){
        return new IsEmptyCheck().isNullCheck(text);
    }
    public boolean isInRangeCheck(String name){
        return new IsInRangeCheck().isInRangeCheck(name);
    }
    public boolean isSpecialCharCheck(String name){
        return new IsSpecialCharCheck().isSpecialCharCheck(name);
    }
    public boolean includeAllCheck(String name){
        return new IsEmptyCheck().isEmptyCheck(name) && new IsEmptyCheck().isNullCheck(name)
                && new IsInRangeCheck().isInRangeCheck(name) && new IsSpecialCharCheck().isSpecialCharCheck(name);
    }
}
