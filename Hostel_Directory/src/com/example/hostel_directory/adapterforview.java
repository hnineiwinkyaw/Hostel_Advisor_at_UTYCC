package com.example.hostel_directory;

import java.util.ArrayList;

import java.util.HashMap;


import com.squareup.picasso.Picasso;
 
import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
 
public class adapterforview extends BaseAdapter {
	 String result="" ;
    Activity activity;
     String[] data;
    private static LayoutInflater inflater=null;
 //   public ImageLoader imageLoader; 
 
    public adapterforview(Activity a, String[] detail) {
        activity = a;
        data=detail;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
     //   imageLoader=new ImageLoader(activity.getApplicationContext());
    }
 
    public int getCount() {
        return data.length;
        
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
            vi = inflater.inflate(R.layout.viewrow, null);
 
        TextView name = (TextView)vi.findViewById(R.id.nameinviewrow); // title
    
        ImageView thumb_image=(ImageView)vi.findViewById(R.id.imageinviewrow); // thumb image
 
    
  result = data[position];
  switch(position){
  case 0:  name.setText(data[position]);
  thumb_image.setImageResource(R.drawable.namef);
  break;
  case 1:  name.setText("ေစ်းႏႈန္း :"+data[position]);
  thumb_image.setImageResource(R.drawable.ic_launcher);
  break;
  case 2:  if(data[position].equals("tt"))
	             name.setText("သံုးေတာင္");
 
               else
	            name.setText( "ျပင္စာ");
              thumb_image.setImageResource(R.drawable.locationf);
                 break;
 
  case 3:   if(data[position].equals("y")){
             name.setText("ေရပူေရေအးရွိပါသည္။");
             thumb_image.setImageResource(R.drawable.waterf);
  }
               else{
                 name.setText("ေရပူေရေအးမရွိပါ။");
               thumb_image.setImageResource(R.drawable.waternf);}
                 break; 
    case 4: if(data[position].equals("y")){
              name.setText("  Wifi ရပါသည္။ ");
              thumb_image.setImageResource(R.drawable.wifif);
    }
             else{
              name.setText("  Wifi မရပါ။");
              thumb_image.setImageResource(R.drawable.wifinf);
             }
              break;
  case 5:     name.setText("ဖုန္းနံပါတ္ : +"+data[position]);
                      thumb_image.setImageResource(R.drawable.phf);
                  break;
  case 6:   if(data[position].equals("y")){
                name.setText("အခန္းတြင္း ေရခ်ိဳးခန္းအိမ္သာပါသည္။");
                thumb_image.setImageResource(R.drawable.broomf);
  }
                else{
                name.setText("အခန္းတြင္း ေရခ်ိဳးခန္းအိမ္သာမပါပါ။");
                  thumb_image.setImageResource(R.drawable.broomnf);}
                 break;
  case 7:   if(data[position].equals("y")){
                  name.setText("အေဆာင္တြင္ ကန္တင္းရွိသည္။");
                  thumb_image.setImageResource(R.drawable.canteenf);
  }
                  else{
                name.setText("အေဆာင္တြင္ ကန္တင္းမရွိပါ။");
                thumb_image.setImageResource(R.drawable.canteennf);
                  }

                break;
  case 8:   if(data[position].equals("y")){
                 name.setText("အေဆာင္တြင္ ဖယ္ရီရွိပါသည္။");
                 thumb_image.setImageResource(R.drawable.ferryf);
  }
                  else{
                   name.setText("အေဆာင္တြင္ ဖယ္ရီမရွိပါ။");
                   thumb_image.setImageResource(R.drawable.ferrynf);
                  }
  
                  break;
  }
 
	Typeface font = Typeface.createFromAsset(activity.getAssets(), "zawgyi-one.ttf");  
	name.setTypeface(font); 
    
  //   name.setText(result.get(hostelresultc.KEY_NAME));
    //price.setText(result.get(hostelresultc.KEY_PRICE));
//     duration.setText(song.get(CustomizedListView.KEY_DURATION));
      
  /*  try {
    	  Picasso.with(activity.getApplicationContext())
    	 .load("https://www.mediafire.com/convkey/8030/pfci2hgdvawsyxs4g.jpg")
    	  .placeholder(R.drawable.arrow) 
          .error(R.drawable.ic_launcher)     
          .into(thumb_image);
    	    }
    	catch (Exception e) {
    	      thumb_image.setImageResource(R.drawable. btoff2);
    	       // this set the default img source if the path provided in .load is null or some error happened on download.
    	 }*/
      
      
      
     
	

        return vi;
    }
}