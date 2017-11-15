package cc.somkiat.basicunittesting.validation;

public class IsInRangeCheck {
    public boolean isInRangeCheck(String name){
        if(name.length() <= 1 || name.length() > 20){
            return false;
        }
        return true;
    }
}
