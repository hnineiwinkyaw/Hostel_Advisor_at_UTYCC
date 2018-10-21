package com.example.hostel_directory;
import java.io.DataOutputStream;

import java.lang.reflect.Method;
import java.util.ArrayList;

import java.util.HashMap;


import android.os.Bundle;
import android.renderscript.Element;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class hostelresultc extends Activity {
	static HashMap<String, String> result;
	 static  String KEY_NAME= "name";
	    static   String KEY_PRICE = "price";
	    static  String KEY_PRICE2 = "pricetwo";
	    static  String KEY_LOCATION= "loaction";
	    static   String KEY_GENDER = "gender";
	   
	    static  String KEY_WATER= "water";
	    static   String KEY_FERRY = "ferry";
	    static  String KEY_CANTEEN = "canteenl";
	    static  String KEY_TOILET= "toilet";
	    static   String KEY_WIFI = "wifi";
	    
	    static  String KEY_PH = "ph";
	    static  String KEY_IMG1 = "imgone";
	    static  String KEY_IMG2 = "imgtwo";
	    /* static  String KEY_NAME;
	    static   String KEY_PRICE ;
	    static  String KEY_PRICE2  ;
	    static  String KEY_LOCATION ;
	    static   String KEY_GENDER  ;
	   
	    static  String KEY_WATER ;
	    static   String KEY_FERRY  ;
	    static  String KEY_CANTEEN  ;
	    static  String KEY_TOILET ;
	    static   String KEY_WIFI  ;
	    
	    static  String KEY_PH  ;
	    static  String KEY_IMG1  ;
	    static  String KEY_IMG2 ;*/
	    private static String name,locforres,priceone,pricetwo,genderforres,water,ferry,canteen,toilet,ph,wifi;
	public static String getLocforres() {
			return locforres;
		}

		public static void setLocforres(String locforres) {
			hostelresultc.locforres = locforres;
		}

		public static String getPriceone() {
			return priceone;
		}

		public static void setPriceone(String priceone) {
			hostelresultc.priceone = priceone;
		}

		public static String getPricetwo() {
			return pricetwo;
		}

		public static void setPricetwo(String pricetwo) {
			hostelresultc.pricetwo = pricetwo;
		}

		public static String getGenderforres() {
			return genderforres;
		}

		public static void setGenderforres(String genderforres) {
			hostelresultc.genderforres = genderforres;
		}

		public static String getWater() {
			return water;
		}

		public static void setWater(String water) {
			hostelresultc.water = water;
		}

		public static String getFerry() {
			return ferry;
		}

		public static void setFerry(String ferry) {
			hostelresultc.ferry = ferry;
		}

		public static String getCanteen() {
			return canteen;
		}

		public static void setCanteen(String canteen) {
			hostelresultc.canteen = canteen;
		}

		public static String getToilet() {
			return toilet;
		}

		public static void setToilet(String toilet) {
			hostelresultc.toilet = toilet;
		}

		public static String getPh() {
			return ph;
		}

		public static void setPh(String ph) {
			hostelresultc.ph = ph;
		}

		public static String getWifi() {
			return wifi;
		}

		public static void setWifi(String wifi) {
			hostelresultc.wifi = wifi;
		}

	public static String getName() {
			return name;
		}

		public void setName(String name) {
			hostelresultc.name = name;
		}

	TextView gender,location,room,price;
	  String gen="";
	   String loc="";
	   String ro="";
	   String pri="";
	
	public String 	g,l,r;
	int p,pricef=0;
	private Cursor values;
	private MyDatabase db;
//	private ListView myListView;
	    ArrayList<String> ArrayAdapter;
	    
	   ListView list;
	   adapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    
	      
		g=searchurhostel.getGender();
		l=searchurhostel.getLocation();
		r=searchurhostel.getRoom_type();
		p=searchurhostel.getPrice();
		setGenderforres(g);
		setLocforres(l);
		
		  setContentView(R.layout.listselector);
		
/*gender=(TextView)findViewById(R.id.resultgender);
location=(TextView)findViewById(R.id.resultlocation);
room=(TextView)findViewById(R.id.resultroom);
price=(TextView)findViewById(R.id.resultprice);

gender.setText(g);
location.setText(l);
room.setText(r);
price.setText(p);*/

db = new MyDatabase(getApplicationContext());
values = db.getValues(g,l,r,p); 
ArrayAdapter = new ArrayList<String>();

ArrayList<HashMap<String, String>> nodes = new ArrayList<HashMap<String, String>>();
if (values.moveToFirst()){
	  HashMap<String, String> map ;
	   do{
		   int check=0;
		   pricef=0;
		   map = new HashMap<String, String>();
		   if(r.equals("single")){
			 
		   
			 
			   if(p==R.id.firstradio){
				   pricef= values.getInt(values.getColumnIndex("price1"));
				  if(pricef<30000){
					  map.put(KEY_PRICE,Integer.toString(pricef));
				  check=pricef;
				  }
			   }
			   else  if(p==R.id.secondradio){
				   pricef= values.getInt(values.getColumnIndex("price1"));
					  if(pricef>30000||pricef==30000) {
						  
						  if(pricef<50000||pricef==50000){
							  
							  map.put(KEY_PRICE,Integer.toString(pricef));
							  check=pricef;
					  }
						 
						  }
					  
				   }
			   else{
				   pricef= values.getInt(values.getColumnIndex("price1"));
					  if(pricef>50000){
						  map.put(KEY_PRICE,Integer.toString(pricef));
						  check=pricef;
					  }
				   }
	
		   }
		   else if(r.equals("double")){
			   
			
			   if(p==R.id.firstradio){
				   pricef= values.getInt(values.getColumnIndex("price2"));
				  if(pricef<30000){
					  map.put(KEY_PRICE,Integer.toString(pricef));
					  check=pricef;
			   }}
			   else  if(p==R.id.secondradio){
				   pricef= values.getInt(values.getColumnIndex("price2"));
					  if(pricef>30000||pricef==30000) {
						  
						  if(pricef<50000||pricef==50000){
							  
							  map.put(KEY_PRICE,Integer.toString(pricef));
							  check=pricef;
					  }
						 
						  }
					  
				   }
			   else{
				   pricef= values.getInt(values.getColumnIndex("price2"));
					  if(pricef>50000){
						 
						  map.put(KEY_PRICE,Integer.toString(pricef));
						  check=pricef;}
				   }
		   
		   
		   }
	
		  

		   map.put(KEY_NAME,values.getString(values.getColumnIndex("name")));
		
		   
 map.put(KEY_WATER, values.getString(values.getColumnIndex("water")));
				 map.put(KEY_FERRY, values.getString(values.getColumnIndex("ferry")));
				 map.put(KEY_PH,values. getString(values.getColumnIndex("phone")));
				 
		 map.put(KEY_TOILET,values. getString(values.getColumnIndex("toilet")));
		
		 map.put(KEY_IMG1,values. getString(values.getColumnIndex("img1")));
	 map.put(KEY_IMG2,values. getString(values.getColumnIndex("img2")));
	 map.put(KEY_CANTEEN,values. getString(values.getColumnIndex("canteen")));
		
		 map.put(KEY_WIFI,values. getString(values.getColumnIndex("wifi")));
		 map.put(KEY_LOCATION,values. getString(values.getColumnIndex("location")));
		 
		
			
				 
		   
				 
				 
				 

		             if(check!=0)
						    nodes.add(map);
		
			 
		   pricef=0;
	   }while(values.moveToNext());
}
	
//int j=ArrayAdapter.size();
//Toast.makeText(this,j, Toast.LENGTH_SHORT);



adapter=new adapter(this, nodes);

list=(ListView)findViewById(R.id.list);

// Getting adapter by passing xml data ArrayList

list.setAdapter(adapter);
   
  list.setOnItemClickListener(new OnItemClickListener() {
      

		@Override
		public void onItemClick(AdapterView<?> a, View v,
				int position, long id) {
			 result = new HashMap<String, String>();
			   result = (adapter.data).get(position);
			 
/*			setName(result.get(hostelresultc.KEY_NAME));
			   
		 setCanteen(result.get(hostelresultc.KEY_CANTEEN));
		 setFerry(result.get(hostelresultc.KEY_FERRY));
	 setPh(result.get(hostelresultc.KEY_PH));
	setToilet(result.get(hostelresultc.KEY_TOILET));
	 setWater(result.get(hostelresultc.KEY_WATER));
		 setWifi(result.get(hostelresultc.KEY_WIFI));*/
	
			 
			//adapter.getView(v,)
			  Intent intent = new Intent(getApplicationContext(),view.class);
			   	startActivity(intent);
		
		}
   });
      
      

	}

	private int getInt(int columnIndex) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public void onBackPressed() {
	   Intent i=new Intent(getApplicationContext(),searchurhostel.class);
	   startActivity(i);
	    super.onBackPressed();
	}
	

}
