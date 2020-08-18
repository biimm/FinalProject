package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.myapplication.connectDB.Clothesmain;

import java.util.ArrayList;

public class ListSearchAdapter extends BaseAdapter {

    ImageView mimage;

    Context mContext;
    ArrayList<String> id;
    ArrayList<String> pic_cloth;
    ArrayList<String> color1;
    ArrayList<String> color2;
    ArrayList<String> color3;

    Clothesmain clothesmain;
    public ListSearchAdapter(Context applicationContext,ArrayList<String> id
            ,ArrayList<String> pic_cloth
            ,ArrayList<String> color1
            ,ArrayList<String> color2
            ,ArrayList<String> color3)
    {

        this.id = new ArrayList<>();
        this.pic_cloth = new ArrayList<>();
        this.color1 = new ArrayList<>();
        this.color2 = new ArrayList<>();
        this.color3 = new ArrayList<>();

        mContext = applicationContext;
        this.id = id;
        this.pic_cloth = pic_cloth;
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;

        clothesmain = new Clothesmain(mContext);
    }

    @Override
    public int getCount() {
        return id.size();
    }

    @Override
    public Object getItem(int position) {
        return id.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater mInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.listsearch_adapter,parent,false);
        }

        mimage = convertView.findViewById(R.id.mimage);

        final Uri image_uri = Uri.parse(pic_cloth.get(position));
        mimage.setImageURI(image_uri);



        return convertView;
    }
}

