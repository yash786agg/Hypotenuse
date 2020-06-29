package com.app.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.app.common.ConstantAndroidTest.Companion.ANGLE_FIRST
import com.app.common.ConstantAndroidTest.Companion.ANGLE_SECOND
import com.app.common.ConstantAndroidTest.Companion.AREA_MM
import com.app.common.ConstantAndroidTest.Companion.AREA_SQ_INCH
import com.app.common.ConstantAndroidTest.Companion.FIRST_COORDINATES
import com.app.common.ConstantAndroidTest.Companion.LENGTH
import com.app.common.ConstantAndroidTest.Companion.SECOND_COORDINATES
import com.app.hypotenuse.R
import org.hamcrest.CoreMatchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class HypotenuseActivityTest {

    @get:Rule
    var activityRule: ActivityTestRule<HypotenuseActivity>
            = ActivityTestRule(HypotenuseActivity::class.java)

    @Test
    fun calculateRightTriangleValue() {

        onView(withId(R.id.edtText_first_coordinates)).perform(clearText())
        onView(withId(R.id.edtText_first_coordinates)).perform(typeText(FIRST_COORDINATES))

        onView(withId(R.id.edtText_second_coordinates)).perform(clearText())
        onView(withId(R.id.edtText_second_coordinates)).perform(typeText(SECOND_COORDINATES))

        calculateBtnClick()
    }

    @Test
    fun checkRightTriangleCalculatedValue() {
        calculateBtnClick()
        onView(withId(R.id.length_text)).check(matches(withText(containsString(LENGTH.toString()))))
        onView(withId(R.id.area_mm_text)).check(matches(withText(containsString(AREA_MM.toString()))))
        onView(withId(R.id.area_sq_inches_text)).check(matches(withText(containsString(AREA_SQ_INCH.toString()))))
        onView(withId(R.id.angle_first_text)).check(matches(withText(containsString(ANGLE_FIRST.toString()))))
        onView(withId(R.id.angle_second_text)).check(matches(withText(containsString(ANGLE_SECOND.toString()))))
    }

    private fun calculateBtnClick() {
        // withId(R.id.my_view) is a ViewMatcher
        // click() is a ViewAction
        // matches(isDisplayed()) is a ViewAssertion
        onView(withId(R.id.button_calculate))
            .perform(click())
            .check(matches(isDisplayed()))
    }
}