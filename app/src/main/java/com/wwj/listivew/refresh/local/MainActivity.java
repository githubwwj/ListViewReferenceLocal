package com.wwj.listivew.refresh.local;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ListView mListView;
    private ArrayList<String> mDataList;
    private CommonAdater<String> mCommonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();

    }

    private void initData() {
        mDataList=new ArrayList<>();
        for(int i=0;i<20;i++){
            mDataList.add("测试数据"+i);
        }
    }

    private void initView() {
        mListView=(ListView)findViewById(R.id.listView);

        mCommonAdapter=new CommonAdater<String>(mDataList,this) {
            @Override
            public void convertView(View view, String s) {
                TextView textView=CommonUtil.get(view, R.id.tvContent);
                textView.setText(s);
            }
        };

        mListView.setAdapter(mCommonAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mDataList.set(position,"更新测试数据"+position);
                mCommonAdapter.notifyDataSetChanged(mListView,position);
            }
        });
    }
}
