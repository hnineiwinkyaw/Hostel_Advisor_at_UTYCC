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
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class Others extends Activity {
	 static  String KEY_ONAME= "name";
	    static   String KEY_ODEPARTMENTS = "dep";
	    static   String KEY_OPH = "ph";
	    
	    private Cursor values;
		private MyDatabase db;
		   ListView list;
		   adapterforph adapter;
		   static HashMap<String, String> result;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ict);
		db = new MyDatabase(getApplicationContext());
		values = db.getOthers();
		
		
		ArrayList<HashMap<String, String>> nodes = new ArrayList<HashMap<String, String>>();
		
		if (values.moveToFirst()){
		  HashMap<String, String> map ;
		   do{
			  
			   map = new HashMap<String, String>();
			 
		
			  

			   
			 map.put(KEY_ONAME,values. getString(values.getColumnIndex("ycc_name")));
			 map.put(KEY_ODEPARTMENTS,values. getString(values.getColumnIndex("ycc_department")));
			 map.put(KEY_OPH,values. getString(values.getColumnIndex("ycc_ph")));
			
				
					 
			   
					 
					 
					 

			     
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
				   intent.setData(Uri.parse("tel:"+result.get(Others.KEY_OPH)));
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
