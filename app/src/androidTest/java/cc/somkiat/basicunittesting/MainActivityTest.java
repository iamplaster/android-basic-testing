package cc.somkiat.basicunittesting;


import android.os.SystemClock;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void InputWithRight(){
        onView(withId(R.id.userNameInput)).perform(replaceText("somkiet"), closeSoftKeyboard());
        onView(withId(R.id.emailInput)).perform(replaceText("somkiet@gmail.com"), closeSoftKeyboard());
        onView(withId(R.id.saveButton)).perform(click());
        onView(withText("COMPLETE")).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
        SystemClock.sleep(1000);
    }



    @Test
    public void InputWithWrongName(){
        onView(withId(R.id.userNameInput)).perform(replaceText(""), closeSoftKeyboard());
        onView(withId(R.id.emailInput)).perform(replaceText("teejuta@gmail.com"), closeSoftKeyboard());
        onView(withId(R.id.saveButton)).perform(click());
        onView(withText("It's Empty")).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
        SystemClock.sleep(3000);
    }

    @Test
    public void InputWithWrongEmail(){
        onView(withId(R.id.userNameInput)).perform(replaceText("teejuta"), closeSoftKeyboard());
        onView(withId(R.id.emailInput)).perform(replaceText("teejuta"), closeSoftKeyboard());
        onView(withId(R.id.saveButton)).perform(click());
        onView(withText("It's invalid email")).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
        SystemClock.sleep(1000);
    }

    @Test
    public void RevertClick(){
        onView(withId(R.id.revertButton)).perform(click());
        onView(withId(R.id.userNameInput)).check(matches(withText("")));
        onView(withId(R.id.emailInput)).check(matches(withText("")));
    }




    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
