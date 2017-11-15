package com.wwj.listivew.refresh.local;

import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/11/15 0015.
 */
public class CommonUtil {

    public static <T extends View> T get(View view, int id) {
        SparseArray<View> viewHolder= (SparseArray<View>) view.getTag();
        if(null==viewHolder){
            viewHolder=new SparseArray<>();
            view.setTag(viewHolder);
        }
        View childView=viewHolder.get(id);
        if(null==childView){
            childView=view.findViewById(id);
            viewHolder.put(id,childView);
        }
        return (T) childView;
    }
}
