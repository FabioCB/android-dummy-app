package com.example.android.courtcounter;

import org.junit.Rule;
import org.junit.Test;

import android.support.test.rule.ActivityTestRule;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by fabio.barbosa on 23/03/2018.
 */

public class ButtonsTeamBTestCases {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    private final int ONE_POINT_BUTTON = R.id.one_points_b;
    private final int TWO_POINT_BUTTON = R.id.two_points_b;
    private final int THREE_POINT_BUTTON = R.id.three_points_b;
    private final int TEAM_B_SCORE = R.id.team_b_score;

    @Test
    public void test1PointTeamA() {
        onView(withId(ONE_POINT_BUTTON))
                .check(matches(allOf(isDisplayed(), withText("Free throw"))))
                .perform(click());

        onView(withId(TEAM_B_SCORE))
                .check(matches(allOf(isDisplayed(),withText("1"))));

    }

    @Test
    public void test2PointsTeamA() {
        onView(withId(TWO_POINT_BUTTON))
                .check(matches(allOf(isDisplayed(), withText("+2 Points"))))
                .perform(click());

        onView(withId(TEAM_B_SCORE))
                .check(matches(allOf(isDisplayed(),withText("2"))));

    }

    @Test
    public void test3PointsTeamA() {
        onView(withId(THREE_POINT_BUTTON))
                .check(matches(allOf(isDisplayed(), withText("+3 Points"))))
                .perform(click());

        onView(withId(TEAM_B_SCORE))
                .check(matches(allOf(isDisplayed(),withText("3"))));

    }
}
