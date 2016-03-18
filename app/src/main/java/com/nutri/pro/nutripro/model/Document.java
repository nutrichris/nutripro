package com.nutri.pro.nutripro.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Christian.Andres on 18.03.2016.
 */
public class Document {
    private static final String TAG = "document";
    private static Document mInstance = new Document();
    public static Document getInstance() {
        return mInstance;
    }

    private List<Activity> mActivities;

    private Document() {
        mActivities = new ArrayList<Activity>();
        load();
    }

    public List<Activity> getActivities() {
        return mActivities;
    }

    public List<Activity> getActivities(Date date) {
        List<Activity> rv = new ArrayList<Activity>();

        Calendar c1 = new GregorianCalendar();
        c1.setTime(date);

        for (Activity a: mActivities) {
            Calendar c2 = new GregorianCalendar();
            c2.setTime(a.getDate());

            if (
                    (c1.get(Calendar.DATE) == c2.get(Calendar.DATE)) &&
                    (c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH)) &&
                    (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR))
                    ) {
                rv.add(a);
            }
        }

        return rv;
    }

    public List<Activity> getActivities(Date start, Date end) {
        List<Activity> rv = new ArrayList<Activity>();

        for (Activity a: mActivities) {
            Date d = a.getDate();
            if (d.before(end) && d.after(start)) {
                rv.add(a);
            }
        }

        return rv;
    }

    public void save() {
        Log.i(TAG, "Saving document to database");
    }

    public void load() {
        Log.i(TAG, "Loading document from database");

        Measure m1 = new Measure(new Date(), 130, 80, 70);
        mActivities.add(m1);
        Measure m2 = new Measure(new Date(), 140, 85, 70);
        mActivities.add(m2);
        Measure m3 = new Measure(new Date(), 120, 75, 70);
        mActivities.add(m3);
        Measure m4 = new Measure(new Date(), 110, 65, 70);
        mActivities.add(m4);
        Measure m5 = new Measure(new Date(), 150, 50, 70);
        mActivities.add(m5);
        Measure m6 = new Measure(new Date(), 130, 80, 70);
        mActivities.add(m6);
    }
}
