package com.example.ricipeyape.view

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.example.ricipeyape.R
import com.example.ricipeyape.view.viewholders.RecipeViewHolder

@RunWith(AndroidJUnit4ClassRunner::class)
class RecipeActivityTest{

    @get:Rule
    var activityTestScenarioRule: ActivityScenarioRule<RecipeActivity> = ActivityScenarioRule(RecipeActivity::class.java)

    @Test
    fun dataEntryFilterNameRecipe() {
        Espresso.onView(withId(R.id.search_recipe))
            .perform(ViewActions.typeText("Asparagus"), ViewActions.closeSoftKeyboard())
    }

    @Test
    fun dataEntryClickNameRecipe() {
        Espresso.onView(withId(R.id.search_recipe))
            .perform(ViewActions.typeText("As"), ViewActions.closeSoftKeyboard())
        Espresso.onView(withId(R.id.rcv_recipe))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecipeViewHolder>(0, click()));
    }
}
