package com.sharjeel.quickwidgets;

import android.content.Context;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.format.DateFormat;
import android.util.AttributeSet; 
import android.widget.TextView;

import java.util.Calendar;

 public class QDigitalClock extends TextView {
 
     private Calendar mCalendar;
     private final static String m12 = "hh:mm:ss a";
     private final static String m24 = "kk:mm:ss";
     private FormatChangeObserver mFormatChangeObserver;

     private Runnable mTicker;
     private Handler mHandler;
 
     private boolean mTickerStopped = false;
 
     private String mFormat;
 
     public QDigitalClock(Context context) {
         super(context);
         initClock(context);
     }
 
     public QDigitalClock(Context context, AttributeSet attrs) {
         super(context, attrs);
         initClock(context);
     }
 
     private void initClock(Context context) {
         Resources r = context.getResources();
 
         if (mCalendar == null) {
             mCalendar = Calendar.getInstance();
         }
 
         mFormatChangeObserver = new FormatChangeObserver();
         getContext().getContentResolver().registerContentObserver(
                 Settings.System.CONTENT_URI, true, mFormatChangeObserver);
 
         setFormat();
     }
 
     @Override
     protected void onAttachedToWindow() {
         mTickerStopped = false;
         super.onAttachedToWindow();
         mHandler = new Handler();
 
         mTicker = new Runnable() {
                public void run() {
                     if (mTickerStopped) return;
                     mCalendar.setTimeInMillis(System.currentTimeMillis());
                     setText(DateFormat.format(mFormat, mCalendar));
                     invalidate();
                     long now = SystemClock.uptimeMillis();
                     long next = now + (1000 - now % 1000);
                     mHandler.postAtTime(mTicker, next);
                 }
             };
         mTicker.run();
     }
 
     @Override
     protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mTickerStopped = true;
    }

    private boolean get24HourMode() {
        return android.text.format.DateFormat.is24HourFormat(getContext());
   }

   private void setFormat() {
        if (get24HourMode()) {
            mFormat = m24;
        } else {
            mFormat = m12;
        }
    }

    private class FormatChangeObserver extends ContentObserver {
        public FormatChangeObserver() {
            super(new Handler());
        }

        @Override
        public void onChange(boolean selfChange) {
            setFormat();
        }
    }
}

