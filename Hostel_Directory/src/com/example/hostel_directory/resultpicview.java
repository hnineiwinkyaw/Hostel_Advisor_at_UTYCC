package com.example.hostel_directory;
import com.squareup.picasso.Picasso;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class resultpicview extends Activity {

	ImageView imageView ;
	   
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		imageView = (ImageView) findViewById(R.id.pic_viewer);
	
		setContentView(R.layout.resultpicview);
Picasso.with(getApplicationContext())
	    .load("https://www.mediafire.com/convkey/8030/pfci2hgdvawsyxs4g.jpg")
	    .placeholder(R.drawable.bton) // optional
	    .error(R.drawable.bttg)         // optional
	    .into(imageView);
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
