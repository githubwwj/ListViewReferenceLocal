package com.wwj.listivew.refresh.local;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * Created by Administrator on 2017/11/15 0015.
 */
public abstract class CommonAdater<T> extends BaseAdapter {

    private final Context context;
    private final List<T> data;

    public CommonAdater(List<T> data,Context context){
        this.data=data;
        this.context=context;
    }

    @Override
    public int getCount() {
        return data==null ? 0 : data.size();
    }

    @Override
    public T getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(null==convertView){
            convertView=LayoutInflater.from(context).inflate(R.layout.item_textview,null);
        }
        Log.d("tag","======================getView="+position);
        T t=getItem(position);
        convertView(convertView,t);
        return convertView;
    }


    public abstract void convertView(View view,T t);

    /**
     * 谷歌推荐的写法
     * @param mListView
     * @param position
     */
    public void notifyDataSetChanged(ListView mListView,int position) {
        int firstVisiable=mListView.getFirstVisiblePosition();
        int lastVisiable=mListView.getLastVisiblePosition();

        if(position>=firstVisiable && position<=lastVisiable){
            View view=mListView.getChildAt(position-firstVisiable);
            getView(position,view,mListView);
        }

    }
}
