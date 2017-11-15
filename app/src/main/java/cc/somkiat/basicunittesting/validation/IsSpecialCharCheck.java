package cc.somkiat.basicunittesting.validation;


public class IsSpecialCharCheck {
    public boolean isSpecialCharCheck(String name){
        String regExp = "^[^<>{}\"/|;:.,~!?@#$%^=&*\\]\\\\()\\[¿§«»ω⊙¤°℃℉€¥£¢¡®©0-9_+]*$";
        if (name.matches(regExp)){
            return true;
        }
        return false;
    }
}
