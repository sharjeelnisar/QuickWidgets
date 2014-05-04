package com.sharjeel.quickwidgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;

public class QuickBarGraph extends View{ 

	private int barXCoordinate;
	private int barYCoordinate;
	private int barWidth;
	private int barHeight;
	private String xLabel;
	private int xLabelXCoordinate;
	private int xLabelYCoordinate;
	private int xLabelTextSize;
	private String xLabelFont;
	private String yLabel;
	private int yLabelXCoordinate;
	private int yLabelYCoordinate;
	private int yLabelTextSize;
	private String yLabelFont;
	private String annotation;
	private int annotationXCoordinate;
	private int annotationYCoordinate;
	private int annotationTextSize;
	private String annotationFont;
	private Paint barPaint;
	private Paint xLabelPaint;
	private Paint yLabelPaint;
	private Paint annotationPaint;
	private String barColor;
	private String xLabelColor;
	private String yLabelColor;
	private String annotationColor;
	private Rect bar;
	private Context context;
	public QuickBarGraph (Context context,String xLabelFont,String annotationFont,String yLabelFont)
	{
	    super(context);
	    this.barPaint = new Paint();
	    this.barPaint.setColor(context.getResources().getColor(R.color.alarming));
	    this.xLabelPaint = new Paint();
	    this.xLabelPaint.setTypeface(Typeface.createFromAsset(context.getAssets(), xLabelFont)); 
	    this.annotationPaint = new Paint();
	    this.annotationPaint.setTypeface(Typeface.createFromAsset(context.getAssets(), annotationFont));
	    this.context = context;
	    this.yLabelPaint = new Paint();
	    this.yLabelPaint.setTypeface(Typeface.createFromAsset(context.getAssets(), yLabelFont));
	    
	}

	@Override
	protected void onDraw (Canvas canvas){
		this.bar = new Rect(barXCoordinate, barYCoordinate, barXCoordinate+barWidth, barYCoordinate+barHeight);
	    canvas.drawRect(bar, barPaint);
	    xLabelPaint.setTextSize(xLabelTextSize);
	    canvas.drawText(xLabel, barXCoordinate,barYCoordinate+barHeight, xLabelPaint);
	    annotationPaint.setTextSize(annotationTextSize);
	    canvas.drawText(annotation, barXCoordinate, barYCoordinate+barHeight, annotationPaint);
	    yLabelPaint.setTextSize(yLabelTextSize);
	    canvas.drawText(yLabel, barXCoordinate, barYCoordinate, yLabelPaint);
	    	 
	}


	public String getxLabelFont() {
		return xLabelFont;
	}

	public void setxLabelFont(String xLabelFont) {
		this.xLabelFont = xLabelFont;
	}

	public String getyLabelFont() {
		return yLabelFont;
	}

	public void setyLabelFont(String yLabelFont) {
		this.yLabelFont = yLabelFont;
	}

	public String getAnnotationFont() {
		return annotationFont;
	}

	public void setAnnotationFont(String annotationFont) {
		this.annotationFont = annotationFont;
	}

	public int getBarXCoordinate() {
		return barXCoordinate;
	}

	public void setBarXCoordinate(int barXCoordinate) {
		this.barXCoordinate = barXCoordinate;
	}

	public int getBarYCoordinate() {
		return barYCoordinate;
	}

	public void setBarYCoordinate(int barYCoordinate) {
		this.barYCoordinate = barYCoordinate;
	}

	public int getBarWidth() {
		return barWidth;
	}

	public void setBarWidth(int barWidth) {
		this.barWidth = barWidth;
	}

	public int getBarHeight() {
		return barHeight;
	}

	public void setBarHeight(int barHeight) {
		this.barHeight = barHeight;
	}

	public String getxLabel() {
		return xLabel;
	}

	public void setxLabel(String xLabel) {
		this.xLabel = xLabel;
	}

	public int getxLabelXCoordinate() {
		return xLabelXCoordinate;
	}

	public void setxLabelXCoordinate(int xLabelXCoordinate) {
		this.xLabelXCoordinate = xLabelXCoordinate;
	}

	public int getxLabelYCoordinate() {
		return xLabelYCoordinate;
	}

	public void setxLabelYCoordinate(int xLabelYCoordinate) {
		this.xLabelYCoordinate = xLabelYCoordinate;
	}

	public String getyLabel() {
		return yLabel;
	}

	public void setyLabel(String yLabel) {
		this.yLabel = yLabel;
	}

	public int getyLabelXCoordinate() {
		return yLabelXCoordinate;
	}

	public void setyLabelXCoordinate(int yLabelXCoordinate) {
		this.yLabelXCoordinate = yLabelXCoordinate;
	}

	public int getyLabelYCoordinate() {
		return yLabelYCoordinate;
	}

	public void setyLabelYCoordinate(int yLabelYCoordinate) {
		this.yLabelYCoordinate = yLabelYCoordinate;
	}

	public String getAnnotation() {
		return annotation;
	}

	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}

	public int getAnnotationXCoordinate() {
		return annotationXCoordinate;
	}

	public void setAnnotationXCoordinate(int annotationXCoordinate) {
		this.annotationXCoordinate = annotationXCoordinate;
	}

	public int getAnnotationYCoordinate() {
		return annotationYCoordinate;
	}

	public void setAnnotationYCoordinate(int annotationYCoordinate) {
		this.annotationYCoordinate = annotationYCoordinate;
	}

	public String getBarColor() {
		return barColor;
	}

	public void setBarColor(String barColor) {
		this.barPaint.setColor(Color.parseColor(barColor));
		this.barColor = barColor;
	}

	public String getxLabelColor() {
		return xLabelColor;
	}

	public void setxLabelColor(String xLabelColor) {
		this.xLabelPaint.setColor(Color.parseColor(xLabelColor));
		this.xLabelColor = xLabelColor;
	}

	public String getyLabelColor() {
		return yLabelColor;
	}

	public void setyLabelColor(String yLabelColor) {
		this.yLabelPaint.setColor(Color.parseColor(yLabelColor));
		this.yLabelColor = yLabelColor;
	}

	public String getAnnotationColor() {
		return annotationColor;
	}

	public void setAnnotationColor(String annotationColor) {
		this.annotationPaint.setColor(Color.parseColor(annotationColor));
		this.annotationColor = annotationColor;
	}

	public int getxLabelTextSize() {
		return xLabelTextSize;
	}

	public void setxLabelTextSize(int xLabelTextSize) {
		this.xLabelTextSize = xLabelTextSize;
	}

	public int getyLabelTextSize() {
		return yLabelTextSize;
	}

	public void setyLabelTextSize(int yLabelTextSize) {
		this.yLabelTextSize = yLabelTextSize;
	}

	public int getAnnotationTextSize() {
		return annotationTextSize;
	}

	public void setAnnotationTextSize(int annotationTextSize) {
		this.annotationTextSize = annotationTextSize;
	}

	@Override
	public boolean onTouchEvent(MotionEvent  e) {
		switch(e.getAction()){
		case MotionEvent.ACTION_UP:
         if(this.isClickable()){
        	
           }
             break;
              
         
		}
		 return true;
		
	}

	

	}


