package com.example.hostel_directory;

import java.util.ArrayList;
import java.util.HashMap;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class workshop extends Activity {
	static HashMap<String, String> result;
	 static  String KEY_WNAME= "name";
	    static   String KEY_WPH = "ph";
	    static   String KEY_WLOC= "location";
	    private Cursor values;
		private MyDatabase db;
		   ListView list;
		   adapterforph adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ict);
		db = new MyDatabase(getApplicationContext());
		values = db.getWorkshop(); 
		
		
		ArrayList<HashMap<String, String>> nodes = new ArrayList<HashMap<String, String>>();
		
		if (values.moveToFirst()){
		  HashMap<String, String> map ;
		   do{
			  
			   map = new HashMap<String, String>();
			   
			 map.put(KEY_WNAME,values. getString(values.getColumnIndex("name")));
			 map.put(KEY_WPH,values. getString(values.getColumnIndex("ph1")));
			 map.put(KEY_WLOC,values. getString(values.getColumnIndex("w_location")));
						    nodes.add(map);
			
				 
			  
		   }while(values.moveToNext());

		
		
		
		}
		adapter=new adapterforph(this, nodes);

		list=(ListView)findViewById(R.id.listict);
		
		list.setAdapter(adapter);
		
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long id) {
				// TODO Auto-generated method stub
				 result = new HashMap<String, String>();
				   result = (adapter.data).get(position);
				   Intent intent = new Intent(Intent.ACTION_DIAL);
				   intent.setData(Uri.parse("tel:"+result.get(workshop.KEY_WPH)));
				   startActivity(intent);
			}
			
			
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ict, menu);
		return true;
	}

}
