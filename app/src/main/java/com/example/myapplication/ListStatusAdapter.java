package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.connectDB.Clothesmain;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ListStatusAdapter extends BaseAdapter {
    ImageView mimage;
    CheckBox mShowCheckbox;

    Context mContext;
    ArrayList<String> id;
    ArrayList<String> pic_cloth;

    Clothesmain clothesmain;

    public ListStatusAdapter(Context applicationContext,ArrayList<String> id,ArrayList<String> pic_cloth) {

        this.id = new ArrayList<>();
        this.pic_cloth = new ArrayList<>();

        mContext = applicationContext;
        this.id = id;
        this.pic_cloth = pic_cloth;

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
            convertView = mInflater.inflate(R.layout.activity_list_status_adapter,parent,false);
        }

        mShowCheckbox = convertView.findViewById(R.id.checkbox);

        mimage = convertView.findViewById(R.id.mimage);


        final Uri image_uri = Uri.parse(pic_cloth.get(position).toString());
        mimage.setImageURI(image_uri);

        return convertView;
    }
}
