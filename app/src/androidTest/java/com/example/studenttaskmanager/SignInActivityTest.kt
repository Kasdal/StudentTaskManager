/*
package com.example.studenttaskmanager


import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.studenttaskmanager.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SignInActivityTest {

    private val email = "test@email.com"
    private val password = "password"

    @Test
    fun testSignInSuccessful() {
        // Start the SignInActivity
        val activityScenario = ActivityScenario.launch(SignInActivity::class.java)

        // Type the email and password in the appropriate EditText views
        onView(withId(R.id.emailEt)).perform(typeText(email))
        onView(withId(R.id.passET)).perform(typeText(password))

        // Click the sign in button
        onView(withId(R.id.button)).perform(click())

        // Check that the MainActivity is displayed
        onView(withId(R.id.main_activity_layout)).check(matches(isDisplayed()))
    }

    @Test
    fun testSignInUnsuccessful() {
        // Start the SignInActivity
        val activityScenario = ActivityScenario.launch(SignInActivity::class.java)

        // Type an incorrect email and password in the appropriate EditText views
        onView(withId(R.id.emailEt)).perform(typeText("incorrect@email.com"))
        onView(withId(R.id.passET)).perform(typeText("incorrect"))

        // Click the sign in button
        onView(withId(R.id.button)).perform(click())

        // Check that a toast message is displayed
        onView(withText(R.string.sign_in_failed_toast)).inRoot(ToastMatcher()).check(matches(isDisplayed()))
    }
}*/
