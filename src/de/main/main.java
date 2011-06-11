package de.main;

import java.io.Console;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AbsoluteLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout.LayoutParams;

public class main extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    
        
        // Die ganzen Buttons initialisieren und onClick methode bereitstellen
        final ImageButton b1 = new ImageButton(getBaseContext());
  		b1.setBackgroundResource(R.drawable.red);
  		b1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				drawSubmenu(1);
				}
			}
		
		);
  		
  		
  		final ImageButton b2 = new ImageButton(getBaseContext());
  		b2.setBackgroundResource(R.drawable.red);
  		b2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				drawSubmenu(2);
				}
			}
		
		);
  		
  		
  		final ImageButton b3 = new ImageButton(getBaseContext());
   		b3.setBackgroundResource(R.drawable.red);
   		b3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				drawSubmenu(3);
				}
			}
		
		);
   		
   		
   		final ImageButton b4 = new ImageButton(getBaseContext());
		b4.setBackgroundResource(R.drawable.red);
		b4.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				drawSubmenu(4);
				}
			}
		
		);
		
	
        //Absolute layout will Google nichtmehr sehen, aber anders gehts nicht mit dem positionieren beim finger
       @SuppressWarnings("deprecation")
       
       //Hier hole ich mir das Layout aus dem main.xml, mehr hab ich mit dem editor nicht gemacht
	   final AbsoluteLayout abs = (AbsoluteLayout) findViewById(R.id.abs1);
       
       
       abs.setOnTouchListener(new OnTouchListener() {
           
           public boolean onTouch(View v, MotionEvent event) {
        	   
        	   //Finger aufs display -> alle alten views(imagebuttons) löschen
        	   	abs.removeAllViewsInLayout();
        	   	
        	   	//Koordinate des touch events
        	    int pos_x = (int)event.getX();
        	    int pos_y = (int)event.getY();
       			Log.v("TAG", "X-Koordinate: "+pos_x);
       			Log.v("TAG", "Y-Koordinate:"+pos_y);
       			
       			//Parameter für die Positionen der Buttons setzen       			
       			AbsoluteLayout.LayoutParams absParam = null;// = new AbsoluteLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, pos_x-50, pos_y-50 );  
       			AbsoluteLayout.LayoutParams absParam2 = null;// = new AbsoluteLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, pos_x, pos_y +50 ); 
       			AbsoluteLayout.LayoutParams absParam3 = null;// = new AbsoluteLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, pos_x-40, pos_y +70 ); 
       			AbsoluteLayout.LayoutParams absParam4 = null;// = new AbsoluteLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, pos_x+70, pos_y +70 ); 
       			
       			double step = (2.0 * Math.PI) / (1.0 * 4);//(items.length));
       			double rotation = (90 / 180) * Math.PI;
       			double radius = 35;//Math.sqrt(this.itemWidth) * Math.sqrt(items.length) * 2.5;
       			
       			for(int i=0; i<4; i++) {
       				double x = pos_x - Math.cos(i*step - rotation) * radius - 50;//(this.itemWidth / 2);
       				double y = pos_y- Math.sin(i*step - rotation) * radius - 50;//(this.itemHeight / 2);
       				       				       				
       				if(i==0) {
       					absParam = new AbsoluteLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, (int)Math.round(x), (int)Math.round(y) );
       				}
       				else if(i==1) {
       					absParam2 = new AbsoluteLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, (int)Math.round(x), (int)Math.round(y) );  
       				}
       				else if(i==2) {
       					absParam3 = new AbsoluteLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, (int)Math.round(x), (int)Math.round(y) );  
       				}
       				else if(i==3) {
       					absParam4 = new AbsoluteLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, (int)Math.round(x), (int)Math.round(y) );  
       				}
       			}
       			
       			//Buttons mit den Parametern dem View hinzufügen
       			abs.addView(b1, absParam);
       			abs.addView(b2, absParam2);
       			abs.addView(b3, absParam3);
       			abs.addView(b4, absParam4);
       			return false;
           }           
        });       
    }
    
	/********************************************************************************************************************
	 * Hier muss dann das Untermenü gemacht werden
	 * 
	 * @param buttonId, die Id des Buttons der gedrückt wurde
	 *******************************************************************************************************************/
    private void drawSubmenu(int buttonId) {
    	
		Log.v("TAG", "Button pressen, Id: "+buttonId);
 	   
    }
    
}