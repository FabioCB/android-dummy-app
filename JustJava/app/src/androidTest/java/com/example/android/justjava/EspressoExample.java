package com.example.android.justjava;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by fabio.barbosa on 21/05/2017.
 */

@RunWith(AndroidJUnit4.class)
public class EspressoExample {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void checkOrder(){
        ViewInteraction quantity = onView(withId(R.id.quantity_text_view));
        quantity.check(matches(withText("2")));

        onView(withId(R.id.order_button)).perform(click());

        quantity.check(matches(withText("2")));

    }

}
