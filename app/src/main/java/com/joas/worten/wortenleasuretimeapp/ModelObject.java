package com.joas.worten.wortenleasuretimeapp;

/**
 * Created by Joas on 25-Mar-18.
 */

public enum ModelObject {

    RED(R.layout.activity_main),
    BLUE(R.layout.activity_main),
    GREEN(R.layout.activity_main);

    private int mTitleResId;
    private int mLayoutResId;

    ModelObject(int layoutResId) {
        mLayoutResId = layoutResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

}
