package com.nutri.pro.nutripro.model;

import java.util.Date;

/**
 * Created by Christian.Andres on 18.03.2016.
 */
public class Activity {
    protected Date mDate;

    public Activity() {
        mDate = new Date();
    }

    public Activity(Date date) {
        mDate = date;
    }

    public Date getDate() {
        return mDate;
    }
    public void setDate(Date date) {
        mDate = date;
    }

    @Override
    public String toString() {
        return "Activity: " + mDate.toString();
    }
}
