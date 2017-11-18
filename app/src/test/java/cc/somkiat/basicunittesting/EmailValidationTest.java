package cc.somkiat.basicunittesting;


import org.junit.Before;
import org.junit.Test;

import cc.somkiat.basicunittesting.model.User;
import cc.somkiat.basicunittesting.validation.IsEmailPatternCheck;
import cc.somkiat.basicunittesting.validation.IsEmptyCheck;
import cc.somkiat.basicunittesting.validation.IsNullCheck;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertFalse;

public class EmailValidationTest {
    private IsEmptyCheck isEmptyCheck;
    private IsNullCheck isNullCheck;
    private IsEmailPatternCheck isEmailPatternCheck;
    private User user;

    @Before
    public void before(){
        isEmptyCheck = new IsEmptyCheck();
        isNullCheck = new IsNullCheck();
        isEmailPatternCheck = new IsEmailPatternCheck();
        user = new User();
    }

    @Test
    public void emailIsEmpty(){
        user.setEmail("");
        boolean result = isEmptyCheck.isValid(user.getEmail());
        assertFalse("Not correct, It's Empty", result);
    }

    @Test
    public void nameIsNotEmpty() {
        user.setEmail("Hello@gmail.com");
        boolean result = isEmptyCheck.isValid(user.getEmail());
        assertTrue("It's not Empty", result);
    }

    @Test
    public void emailIsNull(){
        user.setEmail(null);
        boolean result = isNullCheck.isValid(user.getEmail());
        assertFalse("Not correct, It's Null", result);
    }

    @Test
    public void nameIsNotNull(){
        user.setEmail("helloagain@gmail.com");
        boolean result = isNullCheck.isValid(user.getEmail());
        assertTrue("It's not Null", result);
    }

    @Test
    public void emailNotRightPattern(){
        user.setEmail("hello world");
        boolean result = isEmailPatternCheck.isValid(user.getEmail());
        assertFalse("It's not right email pattern", result);
        assertEquals("It's invalid email", isEmailPatternCheck.getErrorMessage());
    }

    @Test
    public void emailRightPattern(){
        user.setEmail("hello@gmail.com");
        boolean result = isEmailPatternCheck.isValid(user.getEmail());
        assertTrue("It's right email pattern", result);
    }
}
