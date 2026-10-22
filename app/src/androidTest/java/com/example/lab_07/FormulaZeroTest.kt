
package com.example.lab_07

import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FormulaZeroTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    // Test 1: Upcoming Races
    @Test
    fun navigate_to_races_add_race_and_return_home() {

        // Navigate to Upcoming Races
        composeTestRule
            .onNodeWithTag("raceButton")
            .performClick()

        // Verify Upcoming Races screen
        composeTestRule
            .onNodeWithText("Upcoming Races")
            .assertExists()

        // Enter race location
        composeTestRule
            .onNodeWithTag("locationInput")
            .performTextInput("Canada")

        // Add race
        composeTestRule
            .onNodeWithTag("addRaceButton")
            .performClick()

        // Verify race is displayed
        composeTestRule
            .onNodeWithText("Canada")
            .assertExists()

        // Return to Home
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        // Verify Home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }

    // Test 2: Drivers
    @Test
    fun navigate_to_drivers_add_clear_and_return_home() {

        // Navigate to Drivers screen
        composeTestRule
            .onNodeWithTag("driverButton")
            .performClick()

        // Verify Drivers screen
        composeTestRule
            .onNodeWithText("FormulaZero Drivers")
            .assertExists()

        // Enter driver name
        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Lewis Hamilton")

        // Add driver
        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        // Verify driver is displayed
        composeTestRule
            .onNodeWithText("Lewis Hamilton")
            .assertExists()

        // Clear all drivers
        composeTestRule
            .onNodeWithTag("clearDriversButton")
            .performClick()

        // Verify driver is removed
        composeTestRule
            .onNodeWithText("Lewis Hamilton")
            .assertDoesNotExist()

        // Return to Home
        composeTestRule
            .onNodeWithTag("driverBackButton")
            .performClick()

        // Verify Home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }
}
