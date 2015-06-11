package com.example.sqlitetest;

import java.util.ArrayList;

import YY.DbHelper.SqliteDbHelper;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class InfoDal {
	private Context pContext=null;
	private SqliteDbHelper sqlitedbhelper;
	private SQLiteDatabase db;
	
	public InfoDal(Context pContext) {
		this.pContext = pContext;
	}
	
	public void AddInfo(String title)
	{
		sqlitedbhelper=new SqliteDbHelper(pContext);
		db=sqlitedbhelper.getWritableDatabase();
		db.execSQL("insert into t_info(title) values('"+title+"')");
	}
	
	public ArrayList<InfoMode> GetListInfo()
	{
		ArrayList<InfoMode> list=new ArrayList<InfoMode>();
		sqlitedbhelper=new SqliteDbHelper(pContext);
		db=sqlitedbhelper.getReadableDatabase();
		Cursor c=db.rawQuery("select id,title from t_info", new String[]{});
		while(c.moveToNext())
		{
			InfoMode d=new InfoMode();
			d.Id=c.getInt(c.getColumnIndex("id"));
			d.Title=c.getString(c.getColumnIndex("title"));
			list.add(d);
		}
		c.close();
		return list;
	}
}
