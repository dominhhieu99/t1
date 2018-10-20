package hieudm.com.t1.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBmanager extends SQLiteOpenHelper {

    public static final String TB_SINHVIEN = "sinhvien";
    public static final String MASV = "id";
    public static final String NAME = "name";
    public static final String PHONE = "phone";
    public static final String ADDRESS = "address";
    public static final String EMAIL = "email";

    private String BANG="CREATE TABLE " + TB_SINHVIEN+" ( " +
            MASV + "TEXT primary key,"+
            NAME+ "TEXT,"+
            PHONE+"TEXT,"+
            ADDRESS+"TEXT,"+
            EMAIL+"TEXT)";



    public DBmanager(Context context) {
        super(context, "database", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(BANG);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
