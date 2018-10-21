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
 
public class adapterforph extends BaseAdapter {
 
    Activity activity;
     ArrayList<HashMap<String, String>> data;
    private static LayoutInflater inflater=null;
 //   public ImageLoader imageLoader; 
 
    public adapterforph(Activity a, ArrayList<HashMap<String,String>> nodes) {
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
            vi = inflater.inflate(R.layout.phrow, null);
 
        TextView name = (TextView)vi.findViewById(R.id.nameinphrow); // title
        TextView price = (TextView)vi.findViewById(R.id.phinphrow); // artist name
    //    TextView duration = (TextView)vi.findViewById(R.id.duration); // duration
        TextView extra = (TextView)vi.findViewById(R.id.extrainfo);
 
     HashMap<String, String> result = new HashMap<String, String>();
   result = data.get(position);
  
 String myclass=activity.getClass().getSimpleName();
 int i=1;
    if(myclass.equals("Ict")){
    	extra.setVisibility(View.GONE);
  name.setText(result.get(Ict.KEY_TNAME));
    price.setText(result.get(Ict.KEY_TPH)); 
    }
    else  if(myclass.equals("Ece")){
    	extra.setVisibility(View.GONE);
  name.setText(result.get(Ece.KEY_TNAME));
    price.setText(result.get(Ece.KEY_TPH)); 
    }
    else  if(myclass.equals("Pre")){
    	extra.setVisibility(View.GONE);
  name.setText(result.get(Pre.KEY_TNAME));
    price.setText(result.get(Pre.KEY_TPH)); 
    }
    else if(myclass.equals("Ame")){
    	extra.setVisibility(View.GONE);
  name.setText(result.get(Ame.KEY_TNAME));
    price.setText(result.get(Ame.KEY_TPH)); 
    }
    else if(myclass.equals("Others")) {
    	  name.setText(result.get(Others.KEY_ONAME));
    	    price.setText(result.get(Others.KEY_OPH)); 
    	    extra.setText(result.get(Others.KEY_ODEPARTMENTS));
    	    }
    else if(myclass.equals("workshop")) {
  	  name.setText(result.get(workshop.KEY_WNAME));
  	    price.setText(result.get(workshop.KEY_WPH)); 
  	    extra.setText(result.get(workshop.KEY_WLOC));
  	    }
    else if(myclass.equals("restaurant")) {
    	  name.setText(result.get(restaurant.KEY_WNAME));
    	    price.setText(result.get(restaurant.KEY_WPH)); 
    	    extra.setText(result.get(restaurant.KEY_WLOC));
    	    }
  /*  switch(myclass) {
      case "Ict" :  name.setText(result.get(Ict.KEY_TNAME));
                                                                     price.setText(result.get(Ict.KEY_TPH));
                                                                      break;
      case "Ece" :  name.setText(result.get(Ict.KEY_TNAME));
                                                                      price.setText(result.get(Ict.KEY_TPH));
                                                                      break;       
      case "Pre" :  name.setText(result.get(Ict.KEY_TNAME));
                                                                    price.setText(result.get(Ict.KEY_TPH));
                                                                     break;
      case "Ame" :  name.setText(result.get(Ict.KEY_TNAME));
                                                                      price.setText(result.get(Ict.KEY_TPH));
                                                                      break;
      case "Others" :  name.setText(result.get(Ict.KEY_TNAME));
                                                                      price.setText(result.get(Ict.KEY_TPH));
                                                                      break;
      }
    */
      
     
	

        return vi;
    }
}