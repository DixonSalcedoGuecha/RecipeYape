package com.example.ricipeyape.view

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.example.ricipeyape.R

@RunWith(AndroidJUnit4ClassRunner::class)
class RecipeActivityTest{

    @get:Rule
    var activityTestScenarioRule: ActivityScenarioRule<RecipeActivity> = ActivityScenarioRule(RecipeActivity::class.java)

    @Test
    fun dataEntryFilterNameRecipe() {
        Espresso.onView(withId(R.id.search_recipe))
            .perform(ViewActions.typeText("Asparagus"), ViewActions.closeSoftKeyboard())
    }
}
