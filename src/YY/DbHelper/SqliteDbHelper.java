package YY.DbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SqliteDbHelper extends SQLiteOpenHelper {

	private static final String DbName="info.db";
	private static final int DbVersion=1;
	
	public SqliteDbHelper(Context context) {
		super(context, DbName, null, DbVersion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("create table t_info(id integer primary key AutoIncrement,title varchar(500));");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
}
