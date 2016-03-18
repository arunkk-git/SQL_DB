package tech.sree.com.sql_db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update_Info extends AppCompatActivity {
    Button search,update;
    EditText oldName,newName,newMobile,newEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update__info);

        oldName = (EditText)findViewById(R.id.find_text_Update);
        newName = (EditText)findViewById(R.id.new_name);
        newMobile = (EditText)findViewById(R.id.new_mobile);
        newEmail = (EditText)findViewById(R.id.new_email);
        search = (Button)findViewById(R.id.search_update);
        update =(Button)findViewById(R.id.new_update);
       // update.setVisibility(View.GONE);

    }

    public void searchInfo(View V){
        String toFind =  oldName.getText().toString();

        UserDBHelper userDBHelper = new UserDBHelper(getBaseContext());
        SQLiteDatabase sqLiteDatabase = userDBHelper.getReadableDatabase();
        Cursor cursor = userDBHelper.getUserInfoBasedOnName(toFind, sqLiteDatabase);

        if (cursor.moveToNext()){
            newName.setText(toFind);
            newMobile.setText(cursor.getString(0));
            newEmail.setText(cursor.getString(1));
            update.setVisibility(View.VISIBLE);
        }

    }
    public void updateInfo(View V){
        String toFind =  oldName.getText().toString();

        UserDBHelper userDBHelper = new UserDBHelper(getBaseContext());
        SQLiteDatabase sqLiteDatabase = userDBHelper.getReadableDatabase();
        int count= userDBHelper.updateExistingEntry(toFind,newName.getText().toString(),
                newMobile.getText().toString(),newEmail.getText().toString(),
                sqLiteDatabase);
        if (count== 1){
            Toast.makeText(getApplicationContext(),"Updated with New details",Toast.LENGTH_LONG).show();
        }

    }
}
