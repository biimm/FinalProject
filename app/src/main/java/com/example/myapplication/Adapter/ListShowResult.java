package com.example.myapplication.Adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.example.myapplication.R;
import com.example.myapplication.connectDB.Clothesmain;

import java.util.ArrayList;

public class ListShowResult  extends BaseAdapter {

    ImageView mimage;
    Context mContext;

    CheckBox[] mChecked;
    CheckBox cBox;

    public String id_choose = "";
    public int position_choose = 0;


    ArrayList<String> id;
    ArrayList<String> pic_cloth;
    ArrayList<String> type_cloth;
    ArrayList<String> status_cloth;
    ArrayList<String> color1;
    ArrayList<String> color2;
    ArrayList<String> color3;
    ArrayList<String> tone;

    Clothesmain clothesmain;

    public ListShowResult(){
        //Empty Contructor
    }


    public ListShowResult(Context applicationContext,ArrayList<String> id
            ,ArrayList<String> pic_cloth
            ,ArrayList<String> type_cloth
            ,ArrayList<String> status_cloth
            ,ArrayList<String> color1
            ,ArrayList<String> color2
            ,ArrayList<String> color3
            ,ArrayList<String> tone)
    {

        this.id = new ArrayList<>();
        this.pic_cloth = new ArrayList<>();
        this.type_cloth = new ArrayList<>();
        this.status_cloth = new ArrayList<>();
        this.color1 = new ArrayList<>();
        this.color2 = new ArrayList<>();
        this.color3 = new ArrayList<>();
        this.tone = new ArrayList<>();

        mContext = applicationContext;

        this.id = id;
        this.pic_cloth = pic_cloth;
        this.type_cloth = type_cloth;
        this.status_cloth = status_cloth;
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
        this.tone = tone;

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
            convertView = mInflater.inflate(R.layout.listresult_adapter,parent,false);
        }

        mimage = convertView.findViewById(R.id.mimage);


        final Uri image_uri = Uri.parse(pic_cloth.get(position));
        mimage.setImageURI(image_uri);


        cBox = (CheckBox) convertView.findViewById(R.id.checkbox);
        cBox.setTag(Integer.valueOf(position)); // set the tag so we can identify the correct row in the listener

        if(cBox.isChecked()){
            System.out.println("CHECK "+position);
        }else{
            System.out.println("NOT CHECK "+position);
        }

        //System.out.println("MCHECK "+ mChecked[position].isChecked());
        //cBox.setChecked(mChecked[position].isChecked()); // set the status as we stored it
        System.out.println(Integer.valueOf(position));
        //cBox.setOnCheckedChangeListener(mListener); // set the listener


        cBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    System.out.println("Check correct : "+position);
                    position_choose = position;
                }else{


                    System.out.println("Check not correct : "+position);
                }
            }
        });

        return convertView;
    }

}
