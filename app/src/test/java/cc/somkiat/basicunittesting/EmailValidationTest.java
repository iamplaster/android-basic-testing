package cc.somkiat.basicunittesting;


import org.junit.Before;
import org.junit.Test;

import cc.somkiat.basicunittesting.model.User;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertFalse;

public class EmailValidationTest {
    private EmailValidation emailValidation;
    private User user;

    @Before
    public void before(){
        emailValidation = new EmailValidation();
        user = new User();
    }

    @Test
    public void emailIsEmpty(){
        user.setEmail("");
        boolean result = emailValidation.isEmptyCheck(user.getEmail());
        assertFalse("Not correct, It's Empty", result);
    }

    @Test
    public void emailIsNull(){
        user.setEmail(null);
        boolean result = emailValidation.isNullCheck(user.getEmail());
        assertFalse("Not correct, It's Null", result);
    }

    @Test
    public void emailNotRightPattern(){
        user.setEmail("hello world");
        boolean result = emailValidation.isEmailPatternCheck(user.getEmail());
        assertFalse("It's not right email pattern", result);
    }

    @Test
    public void emailRightPattern(){
        user.setEmail("hello@gmail.com");
        boolean result = emailValidation.isEmailPatternCheck(user.getEmail());
        assertTrue("It's right email pattern", result);
    }
}
