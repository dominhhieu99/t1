package hieudm.com.t1.sqlDAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import hieudm.com.t1.database.DBmanager;
import hieudm.com.t1.model.SinhVien;

public class SinhVienDAO {
    private DBmanager dBmanager;


    public SinhVienDAO(DBmanager dBmanager) {
        this.dBmanager = dBmanager;
    }

    public long themsv(SinhVien sinhVien) {
        SQLiteDatabase sqLiteDatabase = dBmanager.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(DBmanager.MASV, sinhVien.getId());
        contentValues.put(DBmanager.NAME, sinhVien.getName());
        contentValues.put(DBmanager.PHONE, sinhVien.getPhone());
        contentValues.put(DBmanager.ADDRESS, sinhVien.getAddress());
        contentValues.put(DBmanager.EMAIL, sinhVien.getEmail());

        return sqLiteDatabase.insert(DBmanager.TB_SINHVIEN, null, contentValues);
//        return db.insert(DBManager.TB_SINHVIEN,null,contentValues);
    }

    public List<SinhVien> getAllSinhVien() {
        SQLiteDatabase sqLiteDatabase = dBmanager.getWritableDatabase();

        List<SinhVien> sinhVienList = new ArrayList<>();
        String truyvan = "SELECT * FROM " + DBmanager.TB_SINHVIEN;
        Cursor cursor = sqLiteDatabase.rawQuery(truyvan, null);
        if (cursor.moveToFirst()) {
            do {
                String ma = cursor.getString(cursor.getColumnIndex(DBmanager.MASV));
                String name = cursor.getString(cursor.getColumnIndex(DBmanager.NAME));
                String phone = cursor.getString(cursor.getColumnIndex(DBmanager.PHONE));
                String address = cursor.getString(cursor.getColumnIndex(DBmanager.ADDRESS));
                String emali = cursor.getString(cursor.getColumnIndex(DBmanager.EMAIL));
                SinhVien sinhVien = new SinhVien(ma, name, phone, address, emali);

                sinhVienList.add(sinhVien);
            } while (cursor.moveToNext());
        }
        dBmanager.close();
        return sinhVienList;
    }

    public void delete(String ma) {
        SQLiteDatabase sqLiteDatabase = dBmanager.getWritableDatabase();

        sqLiteDatabase.delete(DBmanager.TB_SINHVIEN, DBmanager.MASV + "=?", new String[]{ma});
        sqLiteDatabase.close();
    }

    public void updatesv(SinhVien sinhVien) {
        SQLiteDatabase sqLiteDatabase = dBmanager.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(DBmanager.MASV, sinhVien.getId());
        contentValues.put(DBmanager.NAME, sinhVien.getName());
        contentValues.put(DBmanager.PHONE, sinhVien.getPhone());
        contentValues.put(DBmanager.ADDRESS, sinhVien.getAddress());
        contentValues.put(DBmanager.EMAIL, sinhVien.getEmail());

        sqLiteDatabase.update(DBmanager.TB_SINHVIEN, contentValues, DBmanager.MASV + "=?", new String[]{sinhVien.getId()});
        sqLiteDatabase.close();
    }
}
