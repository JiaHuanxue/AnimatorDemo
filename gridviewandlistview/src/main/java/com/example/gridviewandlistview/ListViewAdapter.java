package com.example.gridviewandlistview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by 贾焕雪 on 2016-11-03.
 */
public class  ListViewAdapter extends BaseAdapter {

    private Context context;
    private String [] listView_titles;
    public ListViewAdapter(Context context,String [] listView_titles){
        super();
        this.listView_titles = listView_titles;
        this.context = context;
    }
    @Override
    public int getCount() {
        return listView_titles.length;
    }

    @Override
    public Object getItem(int position) {
        return listView_titles[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = View.inflate(context,R.layout.list_item,null);
        TextView list_textView_title = (TextView) convertView.findViewById(R.id.list_textView_title);
        list_textView_title.setText(listView_titles[position]);

        return convertView;
    }
}