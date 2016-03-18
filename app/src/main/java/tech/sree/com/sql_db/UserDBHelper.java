package tech.sree.com.sql_db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
/**
 * Created by ananth on 3/12/2016.
 */
public class UserDBHelper extends SQLiteOpenHelper {

    private static final String DB_Name = "USER_INFO.DB";
    private static final int DB_Version =1;
    private static final String CREATE_QUERY =
            "CREATE TABLE " +Contract.NewUserInfo.USER_TABLE+"("+
                    Contract.NewUserInfo.USER_NAME+" TEXT,"+
                    Contract.NewUserInfo.USER_MOBILE+" TEXT,"+
                    Contract.NewUserInfo.USER_EMAIL+" TEXT);";



    public UserDBHelper(Context context){

        super(context, DB_Name, null, DB_Version);
        Log.v("ARUN", "UserDBHelper DB_Name =  " + DB_Name + " [ " + DB_Version + " ]");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.v("ARUN", " QUERY =  " + CREATE_QUERY);
        db.execSQL(CREATE_QUERY);

    }
    public void addUserInfo(String name,String mobi,String email,SQLiteDatabase database){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Contract.NewUserInfo.USER_NAME,name);
        contentValues.put(Contract.NewUserInfo.USER_MOBILE,mobi);
        contentValues.put(Contract.NewUserInfo.USER_EMAIL,email);
        database.insert(Contract.NewUserInfo.USER_TABLE, null, contentValues);
        Log.v("ARUN", "ONE ROW is INSERTED");
    }
    public Cursor getUserInfoFromSQLDB(SQLiteDatabase db)
    {
        String [] projection = {Contract.NewUserInfo.USER_NAME,Contract.NewUserInfo.USER_MOBILE,
                Contract.NewUserInfo.USER_EMAIL};
        Cursor cursor = db.query(Contract.NewUserInfo.USER_TABLE, projection, null, null, null,null, null);
        return cursor;
    }

    public Cursor getUserInfoBasedOnName(String name,SQLiteDatabase db){
        Cursor cursor;
        String [] projection={Contract.NewUserInfo.USER_MOBILE, Contract.NewUserInfo.USER_EMAIL};
        String selection = Contract.NewUserInfo.USER_NAME+" LIKE ?";
        String[] selection_args={name};
        cursor = db.query(Contract.NewUserInfo.USER_TABLE,projection,selection,selection_args,null,null,null);
        return cursor;

    }
    public  int updateExistingEntry(String old_name,String new_name,String new_mobile,String new_email,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Contract.NewUserInfo.USER_NAME,new_name);
        contentValues.put(Contract.NewUserInfo.USER_MOBILE,new_mobile);
        contentValues.put(Contract.NewUserInfo.USER_EMAIL, new_mobile);

        String selection = Contract.NewUserInfo.USER_NAME+" LIKE ?";
        String [] selection_args ={old_name};

        return db.update(Contract.NewUserInfo.USER_TABLE,contentValues,selection,selection_args);

    }

    public void deleteEntryFromDataBase(String name,SQLiteDatabase db){
        String selection = Contract.NewUserInfo.USER_NAME+" LIKE ?";
        String[] selection_args={name};
        db.delete(Contract.NewUserInfo.USER_TABLE,selection,selection_args);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
