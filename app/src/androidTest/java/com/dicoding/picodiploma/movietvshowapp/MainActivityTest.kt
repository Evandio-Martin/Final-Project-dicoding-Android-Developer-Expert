package com.dicoding.picodiploma.movietvshowapp

import android.view.Gravity
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.DrawerActions
import androidx.test.espresso.contrib.DrawerMatchers.isClosed
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.dicoding.movietvshowapp.MainActivity
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun loadMoviesandTvShows() {
        Espresso.onView(withId(R.id.rv_movies))
            .check(matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rv_movies))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(5))

        Espresso.onView(withId(R.id.drawer_layout))
            .check(matches(isClosed(Gravity.LEFT)))
            .perform(DrawerActions.open())
        Espresso.onView(withId(R.id.nav_tv_show)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_tv_shows))
            .check(matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rv_tv_shows))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(5))

        Espresso.onView(withId(R.id.drawer_layout))
            .check(matches(isClosed(Gravity.LEFT)))
            .perform(DrawerActions.open())
        Espresso.onView(withId(R.id.nav_movie)).perform(ViewActions.click())
    }

    @Test
    fun loadDetailMovie() {
        Espresso.onView(withId(R.id.rv_movies))
            .check(matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )
        Espresso.onView(withId(R.id.text_title))
            .check(matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.text_vote_average))
            .check(matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.text_release_date))
            .check(matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.text_description))
            .check(matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.poster))
            .check(matches(ViewMatchers.isDisplayed()))

        Espresso.pressBack()
    }

    @Test
    fun loadDetailTvShow() {
        Espresso.onView(withId(R.id.drawer_layout))
            .check(matches(isClosed(Gravity.LEFT)))
            .perform(DrawerActions.open())
        Espresso.onView(withId(R.id.nav_tv_show)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_tv_shows)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )
        Espresso.onView(withId(R.id.text_title))
            .check(matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.text_vote_average))
            .check(matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.text_release_date))
            .check(matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.text_description))
            .check(matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.poster))
            .check(matches(ViewMatchers.isDisplayed()))

        Espresso.pressBack()
    }

    @Test
    fun insertAndUpdateFavorite() {
        Espresso.onView(withId(R.id.rv_movies))
            .check(matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1,
            ViewActions.click()
        ))
        Espresso.onView(withId(R.id.fab)).perform(ViewActions.click())
        Espresso.pressBack()

        Espresso.onView(withId(R.id.drawer_layout))
            .check(matches(isClosed(Gravity.LEFT)))
            .perform(DrawerActions.open())
        Espresso.onView(withId(R.id.nav_tv_show)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1,
            ViewActions.click()
        ))
        Espresso.onView(withId(R.id.fab)).perform(ViewActions.click())
        Espresso.pressBack()

        Espresso.onView(withId(R.id.drawer_layout))
            .check(matches(isClosed(Gravity.LEFT)))
            .perform(DrawerActions.open())
        Espresso.onView(withId(R.id.nav_favorite_movie)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_favorite_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
            ViewActions.click()
        ))
        Espresso.onView(withId(R.id.fab)).perform(ViewActions.click())
        Espresso.pressBack()

        Espresso.onView(withId(R.id.drawer_layout))
            .check(matches(isClosed(Gravity.LEFT)))
            .perform(DrawerActions.open())
        Espresso.onView(withId(R.id.nav_favorite_tv_show)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.rv_favorite_tv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
            ViewActions.click()
        ))
        Espresso.onView(withId(R.id.fab)).perform(ViewActions.click())
        Espresso.pressBack()

    }
}