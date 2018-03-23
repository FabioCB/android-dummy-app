package com.example.android.courtcounter;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import android.support.test.rule.ActivityTestRule;
import android.widget.TextView;

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

public class DrawsTestCases {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    private final int ONE_POINT_BUTTON_TEAM_A = R.id.one_points_a;
    private final int ONE_POINT_BUTTON_TEAM_B = R.id.one_points_b;
    private final int TWO_POINT_BUTTON = R.id.two_points_a;
    private final int THREE_POINT_BUTTON = R.id.three_points_a;
    private final int TEAM_A_SCORE = R.id.team_a_score;
    private final int TEAM_B_SCORE = R.id.team_b_score;

    @Test
    public void Draws1Point() {
        onView(withId(ONE_POINT_BUTTON_TEAM_A))
                .check(matches(allOf(isDisplayed(), withText("Free throw"))))
                .perform(click());

        onView(withId(TEAM_A_SCORE))
                .check(matches(allOf(isDisplayed(), withText("1"))));

        onView(withId(ONE_POINT_BUTTON_TEAM_B))
                .check(matches(allOf(isDisplayed(), withText("Free throw"))))
                .perform(click());

        onView(withId(TEAM_B_SCORE))
                .check(matches(allOf(isDisplayed(), withText("1"))));

        TextView teamAScore = mActivityTestRule.getActivity().findViewById(TEAM_A_SCORE);
        TextView teamBScore = mActivityTestRule.getActivity().findViewById(TEAM_B_SCORE);

        Assert.assertEquals("1 Point Draw", Integer.parseInt(teamAScore.getText().toString()), Integer.parseInt(teamBScore.getText().toString()));

    }
}
