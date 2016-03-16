package tech.sree.com.sql_db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {
    EditText keySearch;
    TextView mobi,email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        keySearch = (EditText)findViewById(R.id.searchKey);
        mobi=(TextView)findViewById(R.id.foundMobile);
        email=(TextView)findViewById(R.id.foundEmail);
    }

    public void searchDetail(View V){

        String  keySearch1 = keySearch.getText().toString();
        mobi.setVisibility(View.GONE);
        email.setVisibility(View.GONE);
        UserDBHelper userDBHelper = new UserDBHelper(getBaseContext());
        SQLiteDatabase sqLiteDatabase = userDBHelper.getReadableDatabase();
        Cursor cursor = userDBHelper.getUserInfoBasedOnName(keySearch1, sqLiteDatabase);
        if (cursor.moveToNext()) {
            String mobile, emailID;
            mobile = cursor.getString(0);
            emailID = cursor.getString(1);
            mobi.setText(mobile);
            email.setText(emailID);
            mobi.setVisibility(View.VISIBLE);
            email.setVisibility(View.VISIBLE);
             }
        else{
            Toast.makeText(getApplicationContext(), "***** NOT FOUND***********", Toast.LENGTH_LONG).show();

        }
    }
public void deleteEntryFromDB(View V){
    UserDBHelper userDBHelper = new UserDBHelper(getBaseContext());
    SQLiteDatabase sqLiteDatabase = userDBHelper.getReadableDatabase();
    int
    userDBHelper.deleteEntryFromDataBase(keySearch.getText().toString(),sqLiteDatabase);
}
}
