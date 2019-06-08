package com.example.calculator;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.text.IsEmptyString;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.w3c.dom.Text;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.doubleClick;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.hasSibling;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;

// Espresso uses ViewMatchers, ViewActions and ViewAssertions

@RunWith(AndroidJUnit4.class)
@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() {
    }


    // ViewMatchers tests:
    @Test
    public void sevenButtonTextTest() {
        // Passes if button's text is 7.
        onView(withId(R.id.sevenButton)).check(matches(withText("7")));
    }

    @Test
    public void controlTextViewIsCompletelyDisplayedTest() {
        // Passes if 100 percent of the view is visible.
        onView(withId(R.id.controlTextView)).check(matches(isCompletelyDisplayed()));
    }

    @Test
    public void clearButtonIsDisplayedTest() {
        // Passes if 90 percent of the view is visible.
        onView(withId(R.id.clearButton)).check(matches(isDisplayed()));
    }

    @Test
    public void dotButtonAndNegativeNumberButtonAreSiblingsTest() {
        // Passes if dot button and negative number button are on the same table row.
        onView(withId(R.id.dotButton)).check(matches(hasSibling(withId(R.id.negativeNumberButton))));
    }

    @Test
    public void zeroButtonIsOnFourthTableRowTest() {
        // Passes if fourth table row contains zero button.
        onView(withId(R.id.fourthTableRow)).check(matches(hasDescendant(withId(R.id.zeroButton))));
    }

    @Test
    public void twoButtonIsOnThirdTableRowTest() {
        // Passes if two button is contained within third table row.
        onView(withId(R.id.twoButton)).check(matches(isDescendantOfA(withId(R.id.thirdTableRow))));
    }

    @Test
    public void negativeNumberButtonIsClickableTest() {
        // Passes if negative number button can be pressed.
        onView(withId(R.id.negativeNumberButton)).check(matches(isClickable()));
    }

    @Test
    public void resultTextViewIsVisibleTest() {
        // GONE - can be found by scrolling.
        // INVISIBLE - cannot be seen.
        // VISIBLE - is on the screen.
        onView(withId(R.id.resultTextView)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }

    @Test
    public void elementInTheFirstTableRowWithPlusTextIsDisplayedTest() {
        // allOf selects the view. Passes if the selected view is displayed.
        onView(allOf(isDescendantOfA(withId(R.id.firstTableRow)), withText("+"))).check(matches(isDisplayed()));
    }


    // ViewActions Tests:
    @Test
    public void dotButtonTest() {

        // Passes if when controlTextView is empty, if dotButton is pressed, input is "0."
        onView(withId(R.id.controlTextView)).check(matches(withText("")));
        onView(withId(R.id.dotButton)).perform(click());
        onView(withId(R.id.controlTextView)).check(matches(withText("0.")));

        // Passes if after being pressed, the dotButton is disabled.
        onView(withId(R.id.dotButton)).check(matches(not(isEnabled())));

        // Passes if after pressing clear button two times, controlTextView will be empty.
        onView(withId(R.id.clearButton)).perform(doubleClick());
        onView(withId(R.id.controlTextView)).check(matches(withText("")));

        // Passes if when I have no dot in controlTextView, the dotButton is enabled.
        onView(withId(R.id.dotButton)).check(matches(isEnabled()));

        // Passes if after pressing 5, the text in controlTextView is 5.
        onView(withId(R.id.fiveButton)).perform(click());
        onView(withId(R.id.controlTextView)).check(matches(withText("5")));

        // Passes if after pressing dotButton with 5 in controlTextView, text will be "5."
        onView(withId(R.id.dotButton)).perform(click());
        onView(withId(R.id.controlTextView)).check(matches(withText("5.")));
    }

    @Test
    public void negativeNumberButtonTest() {

        // Passes if when controlTextView is empty the negativeNumberButton is enabled.
        onView(withId(R.id.controlTextView)).check(matches(withText("")));
        onView(withId(R.id.negativeNumberButton)).check(matches(isEnabled()));

        // Passes if negativeNumberButton writes "-" in the controlTextView.
        onView(withId(R.id.negativeNumberButton)).perform(click());
        onView(withId(R.id.controlTextView)).check(matches(withText("-")));

        // Passes if after being pressed, negativeNumberButton is disabled.
        onView(withId(R.id.negativeNumberButton)).check(matches(not(isEnabled())));

        // Passes if clearButton clears the controlTextView.
        onView(withId(R.id.clearButton)).perform(click());
        onView(withId(R.id.controlTextView)).check(matches(withText("")));

        // Passes if after having some input in controlTextView, negativeNumberButton is disabled.
        onView(withId(R.id.sixButton)).perform(click());
        onView(withId(R.id.controlTextView)).check(matches(withText("6")));
        onView(withId(R.id.negativeNumberButton)).check(matches(not(isEnabled())));
    }

    @Test
    public void resultTextViewTest() {

        // Passes if just writing text in controlTextView does not update resultTextView.
        onView(withId(R.id.eightButton)).perform(click());
        onView(withId(R.id.controlTextView)).check(matches(withText("8")));
        onView(withId(R.id.resultTextView)).check(matches(withText("")));

        // Passes if after pressing an operation button, text from controlTextView is written in resultTextView with operation, and controlTextView is empty
        onView(withId(R.id.additionButton)).perform(click());
        onView(withId(R.id.resultTextView)).check(matches(withText("8+")));
        onView(withId(R.id.controlTextView)).check(matches(withText("")));

        // Passes if after pressing some other number button and pressing equal, I have the expected input in resultTextView and controlTextView is empty.
        onView(withId(R.id.negativeNumberButton)).perform(click());
        onView(withId(R.id.threeButton)).perform(click());
        onView(withId(R.id.controlTextView)).check(matches(withText("-3")));
        onView(withId(R.id.equalButton)).perform(click());
        onView(withId(R.id.resultTextView)).check(matches(withText("=5")));
        onView(withId(R.id.controlTextView)).check(matches(withText("")));

        // Passes if when there is "=5" in resultTextView, if I press an division, I'll have "=5/" and controlTextView stays empty.
        onView(withId(R.id.divisionButton)).perform(click());
        onView(withId(R.id.resultTextView)).check(matches(withText("=5/")));
        onView(withId(R.id.controlTextView)).check(matches(withText("")));

        // Passes if when there is "=5/" in resultTextView, if I press on multiplication, I'll have "=5*" and controlTextView stays empty.
        onView(withId(R.id.multiplicationButton)).perform(click());
        onView(withId(R.id.resultTextView)).check(matches(withText("=5*")));
        onView(withId(R.id.controlTextView)).check(matches(withText("")));
    }

    @After
    public void tearDown() {
    }
}