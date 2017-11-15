package cc.somkiat.basicunittesting.validation;


public class IsEmptyCheck {
    public boolean isEmptyCheck(String text){
        if(text.isEmpty()){
            return false;
        }
        return true;
    }
    public boolean isNullCheck(String text){
        if(text == null){
            return false;
        }
        return true;
    }
}
