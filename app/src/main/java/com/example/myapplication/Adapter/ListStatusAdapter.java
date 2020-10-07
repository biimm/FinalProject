package com.example.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.showlist.UseStatus;
import com.example.myapplication.connectDB.Clothesmain;

import java.util.ArrayList;

public class ListStatusAdapter extends BaseAdapter {
    ImageView mimage;
    Button basketcloth;

    Context mContext;
    ArrayList<String> id_cloth;
    ArrayList<String> pic_cloth;
    ArrayList<String> status_cloth;

    Clothesmain clothesmain;

    public ListStatusAdapter(Context applicationContext,ArrayList<String> id,ArrayList<String> pic_cloth,ArrayList<String>status_cloth) {

        this.id_cloth = new ArrayList<>();
        this.pic_cloth = new ArrayList<>();
        this.status_cloth = new ArrayList<>();

        mContext = applicationContext;
        this.id_cloth = id;
        this.pic_cloth = pic_cloth;
        this.status_cloth = status_cloth;

        clothesmain = new Clothesmain(mContext);
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

        if(convertView == null){
            LayoutInflater mInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.activity_list_status_adapter,parent,false);
        }

        mimage = convertView.findViewById(R.id.mimage);

        basketcloth = convertView.findViewById(R.id.basketcloth);

        basketcloth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("click");

                //update status
                clothesmain.updatestatus(String.valueOf(id_cloth.get(position)) , "อยู่ในตะกร้าผ้า");
                Toast.makeText(mContext,"เก็บลงตะกร้าแล้ว" ,Toast.LENGTH_SHORT).show();

                //refresh page
                Intent intent = new Intent(mContext, UseStatus.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                mContext.startActivity(intent);

            }
        });

        final Uri image_uri = Uri.parse(pic_cloth.get(position).toString());
        mimage.setImageURI(image_uri);

        return convertView;
    }
}
