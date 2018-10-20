package hieudm.com.t1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

import hieudm.com.t1.adpterSinhVien.AdapterSinhVien;
import hieudm.com.t1.database.DBmanager;
import hieudm.com.t1.model.SinhVien;
import hieudm.com.t1.sqlDAO.SinhVienDAO;

public class MainActivity extends AppCompatActivity {
    private EditText edId;
    private EditText edName;
    private EditText edPhone;
    private EditText edAddress;
    private EditText edEmail;
    private Button btnSave;
    private Button btnUpdate;
    private ListView lvSinhVien;

    private DBmanager dBmanager;
    private SinhVienDAO sinhVienDAO;
    private List<SinhVien> sinhVienList;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findviewbyid();
        sinhVienDAO = new SinhVienDAO(new DBmanager(this));
        sinhVienList = sinhVienDAO.getAllSinhVien();
        adapter = new AdapterSinhVien(this, R.layout.itemlist_sinhvien, sinhVienList);
        lvSinhVien.setAdapter((ListAdapter) adapter);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = edId.getText().toString();
                String name = edName.getText().toString();
                String phone = edPhone.getText().toString();
                String address = edAddress.getText().toString();
                String mail = edEmail.getText().toString();
                SinhVien sinhVien = new SinhVien(id, name, phone, address, mail);

                sinhVienDAO.themsv(sinhVien);
                sinhVienList.add(0, sinhVien);
            }
        });
    }

    private void findviewbyid() {
        edId = (EditText) findViewById(R.id.edId);
        edName = (EditText) findViewById(R.id.edName);
        edPhone = (EditText) findViewById(R.id.edPhone);
        edAddress = (EditText) findViewById(R.id.edAddress);
        edEmail = (EditText) findViewById(R.id.edEmail);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        lvSinhVien = (ListView) findViewById(R.id.lvSinhVien);

    }
}
