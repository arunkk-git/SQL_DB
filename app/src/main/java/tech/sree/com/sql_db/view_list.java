package tech.sree.com.sql_db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

public class view_list extends AppCompatActivity {
    ListView listView;
    Cursor cursor;
    static int i  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list);
        listView = (ListView)findViewById(R.id.listview);
        dataListAdaptor DataListAdaptor = new dataListAdaptor(getApplicationContext(),R.layout.row_view);
        listView.setAdapter(DataListAdaptor);
        UserDBHelper userDBHelper = new UserDBHelper(getBaseContext());
        SQLiteDatabase sqLiteDatabase = userDBHelper.getReadableDatabase();
        cursor = userDBHelper.getUserInfoFromSQLDB(sqLiteDatabase);

        Toast.makeText(getApplicationContext(),"Num of DB = "+cursor.getCount(),Toast.LENGTH_LONG).show();
        if(cursor.moveToFirst()){

            do {

                String name,mobi,email;
                name = cursor.getString(0);
                mobi = cursor.getString(1);
                email = cursor.getString(2);
                DataProvider dataProvider = new DataProvider(name,mobi,email);
                DataListAdaptor.add(dataProvider);
                Log.d("ARUN", "[  " + i++ + "  ] name : " + name + "  mobile : " + mobi + "  email : " + email);

            }while(cursor.moveToNext());

        }

    }
}
