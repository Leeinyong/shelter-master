package com.example.hee.shelter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hee on 2017-10-10.
 */

class MyItem {
    int mShelterImageView;   //대피소 이미지
    String nShelterNameView; // 대피소명
    String nShelterLocationView; //대피소 위치
    String nShelterProviderView; //대피소 제공자명

    MyItem(int aShelterImageView, String aShelterNameView, String aShelterLocationView, String aShelterProviderView) {
        mShelterImageView = aShelterImageView;
        nShelterNameView = aShelterNameView;
        nShelterLocationView = aShelterLocationView;
        nShelterProviderView = aShelterProviderView;
    }

}

public class MyAdapter extends BaseAdapter {
    private Context mContext;
    private  int mResource;
    private ArrayList<MyItem>mItems = new ArrayList<MyItem>();

    //내 어댑터 생성자로 itemdata받음
    public MyAdapter(Context context, int resource, ArrayList<MyItem> items){
        mContext = context;
        mItems = items;
        mResource = resource;
    }
    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            //레이아웃 초기화 불러옴 , 콘텍스트 불러오고 뷰객체 만듦
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(mResource, parent, false);

        }

        //-main---------
        //아이템 객체 정의  Set image
        ImageView Image = (ImageView) convertView.findViewById(R.id.shelterImageView);
        Image.setImageResource(mItems.get(position).mShelterImageView);

        // Set 대피소명
        TextView name = (TextView) convertView.findViewById(R.id.shelterNameView);
        name.setText(mItems.get(position).nShelterNameView);

        // Set 위치
        TextView location = (TextView) convertView.findViewById(R.id.shelterLocationView);
        location.setText(mItems.get(position).nShelterLocationView);

        // Set 제공자
        TextView provider = (TextView) convertView.findViewById(R.id.shelterProviderView);
        provider.setText(mItems.get(position).nShelterProviderView);





        return convertView;
    }
}

