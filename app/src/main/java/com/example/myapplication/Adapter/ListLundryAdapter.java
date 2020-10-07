package com.example.myapplication.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.connectDB.ClothesWash;
import com.example.myapplication.connectDB.Clothesmain;
import com.example.myapplication.showlist.LundryStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class ListLundryAdapter extends BaseAdapter {
    ImageView mimage;
    Button washcloth;

    Context mContext;
    ArrayList<String> id_cloth;
    ArrayList<String> pic_cloth;
    ArrayList<String> status_cloth;
    ArrayList<String> date_cloth;

    Clothesmain clothesmain;

    ClothesWash clothesWash;

    String formattedDate = "";

    EditText edtdate;


    public ListLundryAdapter(Context applicationContext, ArrayList<String> id, ArrayList<String> pic_cloth,ArrayList<String>status_cloth,ArrayList<String>date_cloth) {

        this.id_cloth = new ArrayList<>();
        this.pic_cloth = new ArrayList<>();
        this.status_cloth = new ArrayList<>();
        this.date_cloth = new ArrayList<>();

        mContext = applicationContext;
        this.id_cloth = id;
        this.pic_cloth = pic_cloth;
        this.status_cloth = status_cloth;
        this.date_cloth = date_cloth;


        clothesmain = new Clothesmain(mContext);
        clothesWash = new ClothesWash(mContext);

        //pic_use = applicationContext.getIntent().getStringExtra("pic_use");

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
            convertView = mInflater.inflate(R.layout.list_lundry_adapter, parent, false);
        }
        mimage = convertView.findViewById(R.id.mimage);
        final Uri image_uri = Uri.parse(pic_cloth.get(position).toString());
        mimage.setImageURI(image_uri);

        washcloth = convertView.findViewById(R.id.washcloth);
        washcloth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("click");

                //update status
                clothesmain.updatestatus(String.valueOf(id_cloth.get(position)) , "ส่งซักรีด");

                //add date wash
                Calendar c = Calendar.getInstance();
                @SuppressLint("SimpleDateFormat") SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                formattedDate = df.format(c.getTime());

//                SQLiteDatabase dbccloth = clothesWash.getWritableDatabase();
//                ContentValues addwash = new ContentValues();
//                addwash.put(PIC_CLOTH , String.valueOf(mimage));
//                addwash.put(WASH_SENT , formattedDate);
//                dbccloth.insert(TABLE_NAME4,null,addwash);

                Toast.makeText(mContext,"ส่งซักรีดแล้ว: " +formattedDate,Toast.LENGTH_SHORT).show();

                //refresh page
                Intent intent = new Intent(mContext, LundryStatus.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                mContext.startActivity(intent);
            }
        });

        return convertView;
    }
}
