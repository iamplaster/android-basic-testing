package cc.somkiat.basicunittesting;

import org.junit.Before;
import org.junit.Test;

import cc.somkiat.basicunittesting.model.User;
import cc.somkiat.basicunittesting.validation.IsEmailPatternCheck;
import cc.somkiat.basicunittesting.validation.IsEmptyCheck;
import cc.somkiat.basicunittesting.validation.IsInRangeCheck;
import cc.somkiat.basicunittesting.validation.IsNullCheck;
import cc.somkiat.basicunittesting.validation.IsSpecialCharCheck;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertFalse;

public class NameValidationTest {
    private IsEmptyCheck isEmptyCheck;
    private IsNullCheck isNullCheck;
    private IsInRangeCheck isInRangeCheck;
    private IsSpecialCharCheck isSpecialCharCheck;
    private IsEmailPatternCheck isEmailPatternCheck;
    private User user;

    @Before
    public void before(){
        isEmptyCheck = new IsEmptyCheck();
        isNullCheck = new IsNullCheck();
        isInRangeCheck = new IsInRangeCheck();
        isSpecialCharCheck = new IsSpecialCharCheck();
        isEmailPatternCheck = new IsEmailPatternCheck();
        user = new User();
    }

    @Test
    public void nameIsEmpty(){
        user.setName("");
        boolean result = isEmptyCheck.isValid(user.getName());
        assertFalse("Not correct, It's Empty", result);
        assertEquals("It's Empty", isEmptyCheck.getErrorMessage());
    }
    @Test
    public void nameIsNotEmpty() {
        user.setName("Hello");
        boolean result = isEmptyCheck.isValid(user.getName());
        assertTrue("It's not Empty", result);
    }

    @Test
    public void nameIsNull(){
        user.setName(null);
        boolean result = isNullCheck.isValid(user.getName());
        assertFalse("Not correct, It's Null", result);
        assertEquals("It's null", isNullCheck.getErrorMessage());
    }
    @Test
    public void nameIsNotNull(){
        user.setName("helloagain");
        boolean result = isNullCheck.isValid(user.getName());
        assertTrue("It's not Null", result);
    }

    @Test
    public void lengthInTwoToTwenty(){
        user.setName("Teejuta");
        boolean result = isInRangeCheck.isValid(user.getName());
        assertTrue("Correct, It's right length!", result);
    }

    @Test
    public void lengthLessThanTwo(){
        user.setName("H");
        boolean result = isInRangeCheck.isValid(user.getName());
        assertFalse("Not Correct, It's less than two character", result);
        assertEquals("It's invalid input length", isInRangeCheck.getErrorMessage());
    }

    @Test
    public void lengthMoreThanTwenty(){
        user.setName("Helloworldmynameisteejuta");
        boolean result = isInRangeCheck.isValid(user.getName());
        assertFalse("Not Correct, It's more than twenty character", result);
        assertEquals("It's invalid input length", isInRangeCheck.getErrorMessage());
    }

    @Test
    public void nameHasSpecialCharacter(){
        user.setName("Teejuta!");
        boolean result = isSpecialCharCheck.isValid(user.getName());
        assertFalse("Not Correct, It has special character", result);
        assertEquals("Name should not contain with special character", isSpecialCharCheck.getErrorMessage());
    }

    @Test
    public void nameNotHasSpecialCharacter(){
        user.setName("Somkiet");
        boolean result = isSpecialCharCheck.isValid(user.getName());
        assertTrue("Correct, It not has special character", result);
    }
}
