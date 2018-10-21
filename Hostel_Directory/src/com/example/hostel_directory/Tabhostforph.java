package com.example.hostel_directory;

 
import android.app.TabActivity;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
 
public class Tabhostforph extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabhostforph);
         
        @SuppressWarnings("deprecation")
		TabHost tabHost = getTabHost();
         
        // Tab for Photos
        TabSpec ict = tabHost.newTabSpec("ICT");
        // setting Title and Icon for the Tab
      //  photospec.setIndicator("ICT", getResources().getDrawable(R.drawable.micx));
       ict.setIndicator("ICT");
        Intent i = new Intent(this, Ict.class);
        ict.setContent(i);
         
        // Tab for Songs
        TabSpec ece = tabHost.newTabSpec("EcE");        
       ece.setIndicator("EcE");
        Intent e = new Intent(this, Ece.class);
        ece.setContent(e);
  
        TabSpec pre = tabHost.newTabSpec("PrE");        
        pre.setIndicator("PrE");
         Intent p = new Intent(this, Pre.class);
         pre.setContent(p);
         
         TabSpec ame = tabHost.newTabSpec("AME");        
         ame.setIndicator("AME");
          Intent a = new Intent(this, Ame.class);
          ame.setContent(a);
          
          TabSpec others = tabHost.newTabSpec("Others");        
          others.setIndicator("အျခား");
           Intent o = new Intent(this, Others.class);
           others.setContent(o);
         
        // Adding all TabSpec to TabHost
    //    tabHost.addTab(photospec); // Adding photos tab
        tabHost.addTab(ict); // Adding songs tab
        tabHost.addTab(ece);
        tabHost.addTab(pre);
        tabHost.addTab(ame);
        tabHost.addTab(others);// Adding photos tab
         // Adding videos tab
    }
}