package com.example.studenttaskmanager

//import org.junit.runner.RunWith
//
//@RunWith(AndroidJUnit4::class)
//class SignUpActivityTest {
//
//    private val email = "test@email.com"
//    private val password = "password"
//    private val confirmPassword = "password"
//
//    @Test
//    fun testSignUpSuccessful() {
//        // Start the SignUpActivity
//        val activityScenario = ActivityScenario.launch(SignUpActivity::class.java)
//
//        // Type the email, password, and confirm password in the appropriate EditText views
//        onView(withId(R.id.emailEt)).perform(typeText(email))
//        onView(withId(R.id.passET)).perform(typeText(password))
//        onView(withId(R.id.confirmPassEt)).perform(typeText(confirmPassword))
//
//        // Click the sign up button
//        onView(withId(R.id.button)).perform(click())
//
//        // Check that a toast message is displayed
//        onView(withText(R.string.sign_up_successful_toast)).inRoot(ToastMatcher()).check(matches(isDisplayed()))
//    }
//
//    @Test
//    fun testSignUpUnsuccessful() {
//        // Start the SignUpActivity
//        val activityScenario = ActivityScenario.launch(SignUpActivity::class.java)
//
//        // Type the email, password, and confirm password in the appropriate EditText views
//        onView(withId(R.id.emailEt)).perform(typeText("incorrect@email"))
//        onView(withId(R.id.passET)).perform(typeText("incorrect"))
//        onView(withId(R.id.confirmPassEt)).perform(typeText("incorrect"))
//
//        // Click the sign up button
//        onView(withId(R.id.button)).perform(click())
//
//        // Check that a toast message is displayed
//        onView(withText(R.string.sign_up_failed_toast)).inRoot(ToastMatcher()).check(matches(isDisplayed()))
//    }
//}
