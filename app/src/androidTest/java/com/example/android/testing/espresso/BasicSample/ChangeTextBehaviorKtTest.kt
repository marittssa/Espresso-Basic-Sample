package com.example.android.testing.espresso.BasicSample

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.clearText
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
@RunWith(AndroidJUnit4::class)
@LargeTest
class ChangeTextBehaviorKtTest {

    @get:Rule
    var activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun changeText_displaysFavoriteFood() {

        val food = "Pizza"

        onView(withId(R.id.editTextUserInput))
            .perform(typeText(food), closeSoftKeyboard())

        onView(withId(R.id.changeTextBt))
            .perform(click())

        onView(withId(R.id.textToBeChanged))
            .check(matches(withText(food)))
    }

    @Test
    fun changeTextAndOpenActivity_displaysSecondMovie() {

        val firstMovie = "The Holiday"
        val secondMovie = "Practical Magic"

        onView(withId(R.id.editTextUserInput))
            .perform(typeText(firstMovie), closeSoftKeyboard())

        onView(withId(R.id.changeTextBt))
            .perform(click())

        onView(withId(R.id.textToBeChanged))
            .check(matches(withText(firstMovie)))

        onView(withId(R.id.editTextUserInput))
            .perform(clearText())

        onView(withId(R.id.editTextUserInput))
            .perform(typeText(secondMovie), closeSoftKeyboard())

        onView(withId(R.id.activityChangeTextBtn))
            .perform(click())

        onView(withId(R.id.show_text_view))
            .check(matches(withText(secondMovie)))
    }
}