package com.onedev.mycomposetesting.ui

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.onedev.mycomposetesting.ui.theme.MyComposeTestingTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CalculatorAppTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            MyComposeTestingTheme {
                CalculatorApp()
            }
        }
    }

    @Test
    fun calculate_area_of_rectangle_correct() {
        composeTestRule.apply {
            onNodeWithText("Masukkan panjang").performTextInput("3")
            onNodeWithText("Masukkan lebar").performTextInput("4")
            onNodeWithText("Hitung!").performClick()
            onNodeWithText("Hasil: 12.0").assertExists()
        }
    }
}