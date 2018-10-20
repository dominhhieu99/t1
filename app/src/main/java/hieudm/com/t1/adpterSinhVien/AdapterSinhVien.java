package hieudm.com.t1.adpterSinhVien;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import hieudm.com.t1.R;
import hieudm.com.t1.model.SinhVien;

public class AdapterSinhVien extends ArrayAdapter {
    private Context context;
    private int resource;
    private List<SinhVien> sinhVienList;

    public AdapterSinhVien(Context context, int resource, List<SinhVien> sinhVienList) {
        super(context, resource, sinhVienList);
        this.context = context;
        this.resource = resource;
        this.sinhVienList = sinhVienList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.itemlist_sinhvien, parent, false);
            viewHolder.tvId = (TextView) convertView.findViewById(R.id.tv_id);
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.tvPhone = (TextView) convertView.findViewById(R.id.tv_phone);
            viewHolder.tvAddress = (TextView) convertView.findViewById(R.id.tv_address);
            viewHolder.tvEmail = (TextView) convertView.findViewById(R.id.tv_email);

            convertView.setTag(viewHolder);
        } else {

            viewHolder = (ViewHolder) convertView.getTag();

        }
        SinhVien sinhVien = sinhVienList.get(position);
        viewHolder.tvId.setText(sinhVien.getId());
        viewHolder.tvName.setText(sinhVien.getName());
        viewHolder.tvPhone.setText(sinhVien.getPhone());
        viewHolder.tvAddress.setText(sinhVien.getAddress());
        viewHolder.tvEmail.setText(sinhVien.getEmail());

        return convertView;

    }

    public class ViewHolder {
        TextView tvId;
        TextView tvName;
        TextView tvPhone;
        TextView tvAddress;
        TextView tvEmail;


    }
}
