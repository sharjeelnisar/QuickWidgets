package com.sharjeel.quickwidgets;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class QuickJestureDetector implements OnTouchListener {
	
	private float downX, downY, upX, upY;
	
	public boolean onTouch(View v, MotionEvent event) {
		switch (event.getAction()) {
	    case MotionEvent.ACTION_DOWN: 
	    	downX = event.getX();
    		downY = event.getY();
	        break;
	    case MotionEvent.ACTION_MOVE:
                //this.scrollBy(20, 0);
            break;
	    case MotionEvent.ACTION_UP: 
	    	   upX = event.getX();
		        upY = event.getY();
		        
	        break;
	        }
	    
	    return true;
	    }
}

