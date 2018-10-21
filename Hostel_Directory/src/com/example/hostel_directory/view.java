package com.example.hostel_directory;

import com.squareup.picasso.Picasso;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;

public class view extends Activity {
	  ListView list;
	  String[] detail= new String[9];
	  adapterforview adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view);
		list=(ListView)findViewById(R.id.listviewforviewimg);
		
			detail[0]=(hostelresultc.result).get(hostelresultc.KEY_NAME);
			detail[1]=(hostelresultc.result).get(hostelresultc.KEY_PRICE);
			detail[2]=(hostelresultc.result).get(hostelresultc.KEY_LOCATION);
			detail[3]=(hostelresultc.result).get(hostelresultc.KEY_WATER);
			detail[4]=(hostelresultc.result).get(hostelresultc.KEY_WIFI);
			detail[5]=(hostelresultc.result).get(hostelresultc.KEY_PH);
			detail[6]=(hostelresultc.result).get(hostelresultc.KEY_TOILET);
			detail[7]=(hostelresultc.result).get(hostelresultc.KEY_CANTEEN);
			detail[8]=(hostelresultc.result).get(hostelresultc.KEY_FERRY);
			adapter=new adapterforview(this,detail);
			list.setAdapter(adapter);
			
		//Initialize ImageView
		final ImageView imageView = (ImageView) findViewById(R.id.ngaryoema);
		final ToggleButton next=(ToggleButton)findViewById(R.id.nextbutton);
		if((hostelresultc.result).get(hostelresultc.KEY_IMG2)!=null){
		
		
	
	//	TextView t=(TextView)findViewById(R.id.namefor);
	//	TextView wi=(TextView)findViewById(R.id.wififor);
		//TextView wa=(TextView)findViewById(R.id.waterfor);
//		TextView ph=(TextView)findViewById(R.id.phfor);

		//Loading image from below url into imageView
		next.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				// TODO Auto-generated method stub
				if(next.isChecked()){
					Picasso.with(view.this)
				    .load((hostelresultc.result).get(hostelresultc.KEY_IMG2))
				    .placeholder(R.drawable. load) // optional
				    .error(R.drawable.error)         // optional
				    .into(imageView);
				}
				else{
					Picasso.with(view.this)
				    .load((hostelresultc.result).get(hostelresultc.KEY_IMG1))
				    .placeholder(R.drawable. load) // optional
				    .error(R.drawable.error)         // optional
				    .into(imageView);
				}
				
			}
		});
		}
		
		else{
			next.setVisibility(View.GONE);
						Picasso.with(view.this)
					    .load((hostelresultc.result).get(hostelresultc.KEY_IMG1))
					    .placeholder(R.drawable. load) // optional
					    .error(R.drawable.error)         // optional
					    .into(imageView);
					
					
					
		
		}
	
	
	//	t.setText((hostelresultc.result).get(hostelresultc.KEY_NAME));
	//	wi.setText((hostelresultc.result).get(hostelresultc.KEY_WIFI));
	//	wa.setText((hostelresultc.result).get(hostelresultc.KEY_WATER));
	//	ph.setText((hostelresultc.result).get(hostelresultc.KEY_PH));
		

		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
