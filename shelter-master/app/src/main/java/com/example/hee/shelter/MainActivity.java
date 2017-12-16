package com.example.hee.shelter;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static MyAdapter adapter;
    private static final int request_code = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();


        //lisview에 들어갈 객체 선언
        final ArrayList<MyItem> data = new ArrayList<MyItem>();
        data.add(new MyItem(R.drawable.shelter_01, "한성대학교 주차장", "서울특별시 성북구 삼선교로16길 116", "by국민재난안전포털"));
        data.add(new MyItem(R.drawable.shelter_02, "과학기술원", "서울특별시 동대문구 회기로 85", "by국민재난안전포털"));
        data.add(new MyItem(R.drawable.shelter_03, "서울성심병원", "서울특별시 동대문구 왕산로 259", "by국민재난안전포털"));
        data.add(new MyItem(R.drawable.shelter_04, "동부센트레빌103동", "서울특별시 동대문구 홍릉로10길 48", "by국민재난안전포털"));
        data.add(new MyItem(R.drawable.shelter_05, "홍릉동부제2임대아파트 105동", "서울특별시 동대문구 제기로26길 26", "by국민재난안전포털"));
        data.add(new MyItem(R.drawable.shelter_06, "한신아파트(106동)", "서울특별시 동대문구 제기로 131", "by국민재난안전포털"));
        data.add(new MyItem(R.drawable.shelter_07, "한성대입구역(4호선)", "서울특별시 성북구 삼선교로 지하1", "by국민재난안전포털" ));
        data.add(new MyItem(R.drawable.shelter_08, "동소문송산아파트 101동 \n지하주차장", "서울특별시 성북구 동소문로3길 101", "by국민재난안전포털"));

        //list어댑터 생성
        adapter = new MyAdapter(this,R.layout.listview_main, data);

        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);

        //listview기타 설정
        listView.setDivider(new ColorDrawable(Color.GRAY));
        listView.setDividerHeight(5);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View vClicked, int position, long id) {
                //   String name = (String) ((TextView)vClicked.findViewById(R.id.textItem1)).getText();
                String shelter = ((MyItem)adapter.getItem(position)).nShelterNameView;
                Toast.makeText(MainActivity.this, shelter + " selected",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
                intent.putExtra("name",data.get(position).nShelterNameView);
                intent.putExtra("location",data.get(position).nShelterLocationView);
                intent.putExtra("image",data.get(position).mShelterImageView);
                intent.putExtra("provider",data.get(position).nShelterProviderView);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_secondActivity:
                Intent intent=new Intent(this, ThirdActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_pulse:
                startActivity(new Intent(this, FourthActivity.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

