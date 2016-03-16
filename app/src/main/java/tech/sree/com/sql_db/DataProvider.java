package tech.sree.com.sql_db;

import android.widget.ArrayAdapter;

/**
 * Created by ananth on 3/14/2016.
 */
public class DataProvider {

    public DataProvider(String name, String mobi, String email) {
                this.name = name;
        this.mobi = mobi;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobi() {
        return mobi;
    }

    public void setMobi(String mobi) {
        this.mobi = mobi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String name,mobi,email;

}
