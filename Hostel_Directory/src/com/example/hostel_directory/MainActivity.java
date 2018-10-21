package com.example.hostel_directory;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MainActivity extends Activity {
	ImageButton searchurhostel,phno,restaurant,workshop ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		searchurhostel=(ImageButton)findViewById(R.id.hayfirst);
		phno=(ImageButton)findViewById(R.id.secondbutforph);
		workshop=(ImageButton)findViewById(R.id.workshop);
		restaurant=(ImageButton)findViewById(R.id.restaurant);
		
		searchurhostel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			      Intent intent = new Intent(getApplicationContext(), searchurhostel.class);
				   	startActivity(intent);
				
			}
		});
		
	phno.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			      Intent intent = new Intent(getApplicationContext(), Tabhostforph.class);
				   	startActivity(intent);
				
			}
		});
	
	workshop.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
		      Intent intent = new Intent(getApplicationContext(), workshop.class);
			   	startActivity(intent);
			
		}
	});
	
	restaurant.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
		      Intent intent = new Intent(getApplicationContext(), restaurant.class);
			   	startActivity(intent);
			
		}
	});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
