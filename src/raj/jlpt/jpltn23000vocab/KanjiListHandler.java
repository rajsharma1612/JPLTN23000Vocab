package raj.jlpt.jpltn23000vocab;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class KanjiListHandler {
	public static final String Database_name="MyKanjiList.db";
	public static final String Table_name="KanjiRomEng";
	public static final int Database_Version=1;
	SQLiteDatabase sqdb;
	Context context;
	
	public KanjiListHandler(Context context){
		this.context=context;
		OpenHelper op=new OpenHelper(context);
		sqdb=op.getWritableDatabase();
	
	}
	
	public void AddKanji(String numbers){
		ContentValues cv=new ContentValues();
		cv.put("_Kanji", numbers);
		sqdb.insert(Table_name, null, cv);
	}
	
	public List<String> RetreiveKanji(){
		List<String> list=new ArrayList<String>();
		int i=0;
		Cursor c=sqdb.query(Table_name, new String[]{"_Kanji"},null,null,null,null,null);
		if(c.moveToFirst()){
			do{
				String numbers=c.getString(1);
				list.add(numbers);
				i++;
			}
			while(c.moveToNext());
		}
		c.close();
		
		return list;
	}
	
	class OpenHelper extends SQLiteOpenHelper{
		
		

		public OpenHelper(Context context) {
			super(context,Database_name,null,Database_Version);
			context.deleteDatabase(Database_name);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			//db.execSQL("drop table if exists "+Table_name);
			db.execSQL("create table "+Table_name+"(_Kanji text)");
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("drop table if exists "+Table_name);
			onCreate(db);
		}
	}

}
