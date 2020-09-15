package com.littersun.mylibrary;

public class Configuration {
    private final Object mItem1;
    private final Object mItem2;

    public Configuration(Object item1, Object item2) {
        mItem1 = item1;
        mItem2 = item2;
    }

    public Object getItem1() {
        return mItem1;
    }

    public Object getItem2() {
        return mItem2;
    }
}
