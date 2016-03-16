package tech.sree.com.sql_db;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void add_UpdateContact(View V){
        Intent intent = new Intent(getApplicationContext(), addNewContact.class);
        startActivity(intent);
    }

    public void viewContactInfo(View V){
        Intent intent = new Intent(getApplicationContext(), view_list.class);
        startActivity(intent);
    }

    public void searchContent(View V){
        Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
        startActivity(intent);
    }
}
