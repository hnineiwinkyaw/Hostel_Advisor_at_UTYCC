package com.example.hostel_directory;


import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ToggleButton;

public class searchurhostel extends Activity {
	
	private static String gender;
	private static String location ;
	private static String room_type;
	private static int price;
	public static int getPrice() {
		return price;
	}

	public static void setPrice(int price) {
		searchurhostel.price = price;
	}

	Context c= this;
	public static String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public static String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public static String getRoom_type() {
		return room_type;
	}

	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}

	ToggleButton gen,loc,room;
	ImageButton find;
	RadioGroup gp;
	int selectedId;
	 RadioButton p;
	
	boolean g,l,r;
	//default gender=boy, location= pyinsar, room=single
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		gender="male";
		 location="pyin sar";
		room_type="single";
		 price=0;
		setContentView(R.layout.searchurhostel);
		gen=(ToggleButton)findViewById(R.id.gender);
		room=(ToggleButton)findViewById(R.id.roomtype);
		loc=(ToggleButton)findViewById(R.id.location);
		find=(ImageButton)findViewById(R.id.imageButton1);
		gp = (RadioGroup) findViewById(R.id.radioGroup1);
	
	

         
		
	
	
		
		find.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				selectedId  = gp.getCheckedRadioButtonId();
				if(gen.isChecked()){
					setGender("female");
					gen.setChecked(false);
				}
			
				
				
				if(loc.isChecked()){
					setLocation("thone taung");
					loc.setChecked(false);
				}
			
				
				
				if(room.isChecked()){
					setRoom_type("double");
					room.setChecked(false);
				}
				
				 p = (RadioButton) findViewById(selectedId);
				 price= p.getId();
			setPrice(price);
				
				Intent i=new Intent(c,hostelresultc .class);
				startActivity(i);
			
				
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
