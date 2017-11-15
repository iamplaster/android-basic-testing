package cc.somkiat.basicunittesting;

import org.junit.Before;
import org.junit.Test;

import cc.somkiat.basicunittesting.model.User;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertFalse;

public class NameValidationTest {
    private NameValidation nameValidation;
    private User user;

    @Before
    public void before(){
        nameValidation = new NameValidation();
        user = new User();
    }

    @Test
    public void nameIsEmpty(){
        user.setName("");
        boolean result = nameValidation.isEmptyCheck(user.getName());
        assertFalse("Not correct, It's Empty", result);
    }

    @Test
    public void nameIsNull(){
        user.setName(null);
        boolean result = nameValidation.isNullCheck(user.getName());
        assertFalse("Not correct, It's Null", result);
    }

    @Test
    public void lengthInTwoToTwenty(){
        user.setName("Teejuta");
        boolean result = nameValidation.isInRangeCheck(user.getName());
        assertTrue("Correct, It's right length!", result);
    }

    @Test
    public void lengthLessThanTwo(){
        user.setName("H");
        boolean result = nameValidation.isInRangeCheck(user.getName());
        assertFalse("Not Correct, It's less than two character", result);
    }

    @Test
    public void lengthMoreThanTwenty(){
        user.setName("Helloworldmynameisteejuta");
        boolean result = nameValidation.isInRangeCheck(user.getName());
        assertFalse("Not Correct, It's more than twenty character", result);
    }

    @Test
    public void nameHasSpecialCharacter(){
        user.setName("Teejuta!");
        boolean result = nameValidation.isSpecialCharCheck(user.getName());
        assertFalse("Not Correct, It has special character", result);
    }

    @Test
    public void nameNotHasSpecialCharacter(){
        user.setName("Somkiet");
        boolean result = nameValidation.isSpecialCharCheck(user.getName());
        assertTrue("Correct, It not has special character", result);
    }
}
