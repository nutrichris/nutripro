package com.nutri.pro.nutripro.model;

import java.util.Date;

/**
 * Created by Christian.Andres on 18.03.2016.
 */
public class Measure extends Activity {
    private int mPulse;
    private int mSystholic;
    private int mDiatholic;

    public Measure(Date date, int systholic, int diatholic, int pulse) {
        super(date);
        mSystholic = systholic;
        mDiatholic = diatholic;
        mPulse = pulse;
    }

    public int getPulse() {
        return mPulse;
    }
    public void setPulse(int value) {
        mPulse = value;
    }

    public int getSystholic() {
        return mSystholic;
    }
    public void setSystholic(int systholic) {
        mSystholic = systholic;
    }

    public int getDiatholic() {
        return mDiatholic;
    }

    public void setDiatholic(int diatholic) {
        mDiatholic = diatholic;
    }

    @Override
    public String toString() {
        return "[" + mDate.toString() + "] Measure: " + mSystholic + "/" + mDiatholic + " - " + mPulse;
    }
}
