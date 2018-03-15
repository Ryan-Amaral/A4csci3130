package com.acme.a3csci3130;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.core.deps.guava.base.Preconditions.checkNotNull;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.EasyMock2Matchers.equalTo;
import static org.hamcrest.Matchers.hasToString;
import static org.junit.Assert.*;

import android.view.View;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void createBusiness() throws Exception {

        // go to create
        onView(withId(R.id.submitButton))
                .perform(click());

        // type name
        onView(withId(R.id.edtTxtName))
                .perform(typeText("Test Company"));

        // type business
        onView(withId(R.id.edtTxtPBus))
                .perform(typeText("Fisher"));

        // type address
        onView(withId(R.id.edtTxtAddr))
                .perform(typeText("123 Fake Street"));

        // type province
        onView(withId(R.id.edtTxtPrOrTr))
                .perform(typeText("NS"));

        // create it
        onView(withId(R.id.submitButton))
                .perform(click());

        Thread.sleep(1000);

        onData(allOf(withText("Test Company")));
    }

    @Test
    public void updateBusiness() throws Exception {

        // view data
        onData(anything()).inAdapterView(allOf(withId(R.id.listView))).atPosition(0)
                .perform(click());
        closeSoftKeyboard();

        // type name
        onView(withId(R.id.edtTxtName))
                .perform(replaceText("Test Company 2"));

        // create it
        onView(withId(R.id.updateButton))
                .perform(click());

        Thread.sleep(1000);

        onData(allOf(endsWith("Test Company 2")));
    }

    @Test
    public void zdeleteBusiness() throws Exception {

        // view data
        onData(anything()).inAdapterView(allOf(withId(R.id.listView))).atPosition(0)
                .perform(click());
        closeSoftKeyboard();

        // type name
        onView(withId(R.id.edtTxtName))
                .perform(replaceText("Test Company 2"));

        // create it
        onView(withId(R.id.updateButton))
                .perform(click());

        Thread.sleep(1000);

        onData(allOf(endsWith("Test Company 2")));
    }
}