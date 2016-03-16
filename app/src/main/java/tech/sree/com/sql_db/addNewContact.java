package tech.sree.com.sql_db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import tech.sree.com.sql_db.R;

public class addNewContact extends AppCompatActivity {
    private static EditText uName,uMobile,uEmail;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contact);
        uName = (EditText)findViewById(R.id.name);
        uMobile = (EditText)findViewById(R.id.mobile);
        uEmail = (EditText)findViewById(R.id.email);
    }
    public void add_Update_Contact(View V){
        UserDBHelper userDBHelper = new UserDBHelper(context);
        SQLiteDatabase sqLiteDatabase = userDBHelper.getWritableDatabase();
        userDBHelper.addUserInfo(uName.getText().toString(),uMobile.getText().toString(),
                uEmail.getText().toString(),sqLiteDatabase);
        Toast.makeText(getBaseContext(),"ONE ROW is ADDED",Toast.LENGTH_LONG).show();
        sqLiteDatabase.close();
    }
}

