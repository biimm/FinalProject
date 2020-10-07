package com.example.myapplication.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.connectDB.ClothesWash;
import com.example.myapplication.connectDB.Clothesmain;
import com.example.myapplication.showlist.WashStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ListWashAdapter extends BaseAdapter {
    ImageView mimage;
    Button wardrobe;

    Context mContext;
    ArrayList<String> id_cloth;
    ArrayList<String> pic_cloth;
    ArrayList<String> status_cloth;
    ArrayList<String> date_wash;

    String pic = "";
    String datewash = "";

    Clothesmain clothesmain;
    ClothesWash clothesWash;
    String formattedDate = "";



    public ListWashAdapter(Context applicationContext, ArrayList<String> id, ArrayList<String> pic_cloth,ArrayList<String>date_wash) {
        this.id_cloth = new ArrayList<>();
        this.pic_cloth = new ArrayList<>();
        //this.status_cloth = new ArrayList<>();
        this.date_wash = new ArrayList<>();

        mContext = applicationContext;
        this.id_cloth = id;
        this.pic_cloth = pic_cloth;
        //this.status_cloth = status_cloth;
        this.date_wash = date_wash;

        clothesmain = new Clothesmain(mContext);
        clothesWash = new ClothesWash(mContext);
    }

    @Override
    public int getCount() {
        return id_cloth.size();
    }

    @Override
    public Object getItem(int position) {
        return id_cloth.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.list_wash_adapter, parent, false);
        }
        mimage = convertView.findViewById(R.id.mimage);
        final Uri image_uri = Uri.parse(pic_cloth.get(position).toString());
        mimage.setImageURI(image_uri);

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        formattedDate = df.format(c.getTime()).toString();




        mimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(mContext);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.show_date_wash);

                dialog.setCancelable(true);//
                Button yes_del = dialog.findViewById(R.id.ok_del);
                ImageView image = dialog.findViewById(R.id.mimage);
                EditText date = dialog.findViewById(R.id.edt_date);

                image.setImageURI(image_uri);
                date.setText(formattedDate);
                date.setEnabled(false);

                yes_del.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println("click yes_del");
                        dialog.cancel();

                    }
                });

                dialog.show();
            }
        });

        wardrobe = convertView.findViewById(R.id.wardrobecloth);
        wardrobe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("click");

                //update status
                clothesmain.updatestatus(String.valueOf(id_cloth.get(position)), "พร้อมใช้งาน");
                Toast.makeText(mContext,"เก็บเข้าตู้เสื้อผ้าแล้ว: "+formattedDate ,Toast.LENGTH_SHORT).show();

                //refresh page
                Intent intent = new Intent(mContext, WashStatus.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                mContext.startActivity(intent);
            }
        });

        return convertView;
    }
}
