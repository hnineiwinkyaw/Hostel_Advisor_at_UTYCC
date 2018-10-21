package com.example.hostel_directory;

import java.util.ArrayList;

import java.util.HashMap;


import com.squareup.picasso.Picasso;
 
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
 
public class adapter extends BaseAdapter {
 
    Activity activity;
     ArrayList<HashMap<String, String>> data;
    private static LayoutInflater inflater=null;
 //   public ImageLoader imageLoader; 
 
    public adapter(Activity a, ArrayList<HashMap<String,String>> nodes) {
        activity = a;
        data=nodes;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
     //   imageLoader=new ImageLoader(activity.getApplicationContext());
    }
 
    public int getCount() {
        return data.size();
    }
 
    public Object getItem(int position) {
        return position;
    }
 
    public long getItemId(int position) {
        return position;
    }
 
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.list_row, null);
 
        TextView name = (TextView)vi.findViewById(R.id.nameforlistrow); // title
        TextView price = (TextView)vi.findViewById(R.id.priceforlistrow); // artist name
    //    TextView duration = (TextView)vi.findViewById(R.id.duration); // duration
        ImageView thumb_image=(ImageView)vi.findViewById(R.id.list_image); // thumb image
 
     HashMap<String, String> result = new HashMap<String, String>();
   result = data.get(position);
 
     
     name.setText(result.get(hostelresultc.KEY_NAME));
    price.setText(result.get(hostelresultc.KEY_PRICE));
//     duration.setText(song.get(CustomizedListView.KEY_DURATION));
      
    try {
    	  Picasso.with(activity.getApplicationContext())
    	 .load(result.get(hostelresultc.KEY_IMG1))
    	  .placeholder(R.drawable.load) 
          .error(R.drawable.error)     
          .into(thumb_image);
    	    }
    	catch (Exception e) {
    	      thumb_image.setImageResource(R.drawable. btoff2);
    	       // this set the default img source if the path provided in .load is null or some error happened on download.
    	 }
      
      
      
     
	

        return vi;
    }
}