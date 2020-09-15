package com.littersun.beforeapponcreate;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import androidx.test.internal.runner.RunnerArgs;
import androidx.test.runner.AndroidJUnitRunner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TestAndroidJUnitRunner extends AndroidJUnitRunner {
    private static final String TAG  = "TestAndroidJUnitRunner";

    private ClassLoader mClassLoader;
    private String mTestClass;

    @Override
    public void onCreate(Bundle arguments) {
        Log.e(TAG, "arguments is " + arguments.toString());
        RunnerArgs runnerArgs = new RunnerArgs.Builder().fromManifest(this).fromBundle(this, arguments).build();
        if (runnerArgs.tests != null && !runnerArgs.tests.isEmpty()) {
            mTestClass = runnerArgs.tests.get(0).testClassName;
            Log.e(TAG, "TestClass is " + mTestClass);
        }
        super.onCreate(arguments);
    }

    @Override
    public void callApplicationOnCreate(Application app) {
        if (!TextUtils.isEmpty(mTestClass)) {
            try {
                Class<?> clazz = mClassLoader.loadClass(mTestClass);
                Method[] methods = clazz.getMethods();
                for (Method method : methods) {
                    if (method.getAnnotation(BeforeAppOnCreate.class) != null) {
                        if (!Modifier.isStatic(method.getModifiers())) {
                            IllegalArgumentException exception = new IllegalArgumentException(method.getName() + "() should be static");
                            Log.e(TAG, "callApplicationOnCreate: " + exception);
                            throw exception;
                        }
                        method.invoke(null);
                        break;
                    }
                }
            } catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException e) {
                Log.e(TAG, e.getMessage(), e);
            }
        }

        super.callApplicationOnCreate(app);
    }

    @Override
    public Application newApplication(ClassLoader cl, String className, Context context) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        mClassLoader = cl;
        return super.newApplication(cl, className, context);
    }
}
