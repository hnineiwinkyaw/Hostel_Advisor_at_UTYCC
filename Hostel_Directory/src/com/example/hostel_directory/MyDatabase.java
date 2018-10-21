package com.example.hostel_directory;


import android.content.Context;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;


public class MyDatabase extends SQLiteAssetHelper {

	
	public MyDatabase(Context context) {
		super(context, "d.db", null, 1);
	}

	public Cursor getValues(String gender,String location,String room, int p) {

		SQLiteDatabase db = getReadableDatabase();
		SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
		
if(gender.equals("male")) gender="m";
else gender="f";

if(location.equals("thone taung")) location="tt";
else location="ps";

		
		String sqlTables = "hostel_detail";
		String whereClause = null;
		String[] whereArgs = null;
		qb.setTables(sqlTables);
		
			
	 whereClause = "gender = ? AND location = ?  ";
	  whereArgs = new String[] {
	    gender,
		    location,
		  
	};
			
	
		
	
		Cursor c = qb.query(db,null,whereClause,whereArgs,
				null, null, null);
	
		
		

		c.moveToFirst();
		return c;

	}
	public Cursor getWorkshop(){


		SQLiteDatabase db = getReadableDatabase();
		SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
	
	
		String sqlTables = "workshop";
		qb.setTables(sqlTables);
		Cursor c = qb.query(db,null,null,null,
				null, null, null);

		c.moveToFirst();
		return c;

	
	}
	
	public Cursor getRestaurant(){


		SQLiteDatabase db = getReadableDatabase();
		SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
	
	
		String sqlTables = "restaurant";
		qb.setTables(sqlTables);
		Cursor c = qb.query(db,null,null,null,
				null, null, null);

		c.moveToFirst();
		return c;

	
	}
	
	
	
	public Cursor getPh(String departmentname){


		SQLiteDatabase db = getReadableDatabase();
		SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
		


		
		String sqlTables = "teacher_phone";
		String whereClause = null;
		String[] whereArgs = null;
		qb.setTables(sqlTables);
		
			
	 whereClause = "t_department = ?  ";
	  whereArgs = new String[] {
	    departmentname
		    
		  
	};
			
	
		
	
		Cursor c = qb.query(db,null,whereClause,whereArgs,
				null, null, null);
	
		
		

		c.moveToFirst();
		return c;

	
	}
	
	public Cursor getOthers(){


		SQLiteDatabase db = getReadableDatabase();
		SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
		


		
		String sqlTables = "ycc_phone";
		
		qb.setTables(sqlTables);
		
			
	
			
	
		
	
		Cursor c = qb.query(db,null,null,null,
				null, null, null);
	
		
		

		c.moveToFirst();
		return c;

	
	}
	
	
	
	
	

	

}