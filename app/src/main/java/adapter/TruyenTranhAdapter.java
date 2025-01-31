package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.appdoctruyen.R;

import java.util.ArrayList;
import java.util.List;

import object.TruyenTranh;

public class TruyenTranhAdapter extends ArrayAdapter<TruyenTranh> {
    private Context ct;
    private ArrayList<TruyenTranh> arr;
    public TruyenTranhAdapter(@NonNull Context context, int resource, @NonNull List<TruyenTranh> objects) {
        super(context, resource, objects);
        this.ct = context;
        this.arr = new ArrayList<>(objects);
    }

    public void sortTruyen(String s){
        s=s.toUpperCase();
        int k=0;
        for(int i=0;i<arr.size();i++){
            TruyenTranh t =arr.get(i);
            String ten= t.getTenTruyen().toUpperCase();
            if(ten.indexOf(s)>=0){
                arr.set(i,arr.get(k));
                arr.set(k,t);
                k++;
            }
        }
        notifyDataSetChanged();
    }
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView==null){
            LayoutInflater inflater =(LayoutInflater)ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView =inflater.inflate(R.layout.item_truyen,null);
        }

        if(arr.size()>0){
            TruyenTranh truyentranh= this.arr.get(position);

            TextView tenTenTruyen= convertView.findViewById(R.id.txvTenTruyen);
            TextView tenTenChap =convertView.findViewById(R.id.txvTenChap);
            ImageView imgAnhtruyen = convertView.findViewById(R.id.imgAnhTruyen);

            tenTenTruyen.setText(truyentranh.getTenTruyen());
            tenTenChap.setText(truyentranh.getTenChap());
            Glide.with(this.ct).load(truyentranh.getLinkAnh()).into(imgAnhtruyen);
        }
        return convertView;
    }
}
