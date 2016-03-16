package tech.sree.com.sql_db;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ananth on 3/14/2016.
 */
public class dataListAdaptor extends ArrayAdapter {
    List list = new ArrayList();
    public dataListAdaptor(Context context, int resource) {
        super(context, resource);
    }
    static class myLayoutHandler{
        TextView NAME,MOBI,EMAIL;
    }
    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView ;
        myLayoutHandler LayoutHandler;
        if ( row ==  null){
            LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_view,parent,false);
            LayoutHandler = new myLayoutHandler();
            LayoutHandler.NAME = (TextView)row.findViewById(R.id.uName);
            LayoutHandler.MOBI = (TextView)row.findViewById(R.id.uMobi);
            LayoutHandler.EMAIL = (TextView)row.findViewById(R.id.uEmail);
            row.setTag(LayoutHandler);
        }
        else {
            LayoutHandler = (myLayoutHandler) row.getTag();
        }
        DataProvider dataProvider =  (DataProvider)this.getItem(position);
        LayoutHandler.NAME.setText(dataProvider.getName().toString());
        LayoutHandler.MOBI.setText(dataProvider.getMobi().toString());
        LayoutHandler.EMAIL.setText(dataProvider.getEmail().toString());
        return row ;
    }
}
