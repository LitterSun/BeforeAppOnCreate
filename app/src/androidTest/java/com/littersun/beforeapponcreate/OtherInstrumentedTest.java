package com.littersun.beforeapponcreate;

import android.util.Log;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class OtherInstrumentedTest {
    @BeforeAppOnCreate
    public static void beforeAppOnCreate() {
        Log.e("xxx", "Other beforeAppOnCreate: ");
    }

    @BeforeClass
    public static void beforeClass() throws Exception {
        Log.e("xxx", "Other beforeClass: ");
    }

    @Before
    public void setUp() throws Exception {
        Log.e("xxx", "Other setUp: ");
    }

    @Test
    public void beforeApplicationOnCreateTest() {
        Log.e("xxx", "Other beforeApplicationOnCreateTest: ");
    }
}