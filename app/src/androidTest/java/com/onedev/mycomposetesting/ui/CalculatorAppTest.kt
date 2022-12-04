package com.onedev.mycomposetesting.ui

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.onedev.mycomposetesting.R
import com.onedev.mycomposetesting.ui.theme.MyComposeTestingTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CalculatorAppTest {
//    @get:Rule
//    val composeTestRule = createComposeRule()
//
//    @Before
//    fun setUp() {
//        composeTestRule.setContent {
//            MyComposeTestingTheme {
//                CalculatorApp()
//            }
//        }
//    }
//
//    @Test
//    fun calculate_area_of_rectangle_correct() {
//        composeTestRule.apply {
//            onNodeWithText("Masukkan panjang").performTextInput("3")
//            onNodeWithText("Masukkan lebar").performTextInput("4")
//            onNodeWithText("Hitung!").performClick()
//            onNodeWithText("Hasil: 12.0").assertExists()
//        }
//    }

    @get:Rule
    val composeTestAndroidRule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setUp() {
        composeTestAndroidRule.setContent {
            MyComposeTestingTheme {
                CalculatorApp()
            }
        }
    }

    @Test
    fun calculate_area_of_rectangle_correct_with_compose_test_android_rule() {
        composeTestAndroidRule.apply {
            onNodeWithText(activity.getString(R.string.enter_length)).performTextInput("3")
            onNodeWithText(activity.getString(R.string.enter_width)).performTextInput("4")
            onNodeWithText(activity.getString(R.string.count)).performClick()
            onNodeWithText(activity.getString(R.string.result, 12.0)).assertExists()
        }
    }

    @Test
    fun wrong_input_not_calculated() {
        composeTestAndroidRule.apply {
            onNodeWithText(activity.getString(R.string.enter_length)).performTextInput("..3")
            onNodeWithText(activity.getString(R.string.enter_width)).performTextInput("4")
            onNodeWithText(activity.getString(R.string.count)).performClick()
            onNodeWithText(activity.getString(R.string.result, 0.0)).assertExists()
        }
    }
}