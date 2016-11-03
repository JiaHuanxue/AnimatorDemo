package com.example.gridviewandlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private GridView gridView;
    private ListViewAdapter listViewAdapter;
    private GridViewAdapter gridViewAdapter;
    int[] imgs = {R.drawable.gv1,R.drawable.gv2,R.drawable.gv3,R.drawable.gv4,
            R.drawable.gv5,R.drawable.gv6,R.drawable.gv7,R.drawable.gv8,
            R.drawable.gv9,R.drawable.gv10,R.drawable.gv11,R.drawable.gv12,
            R.drawable.gv13,R.drawable.gv14,R.drawable.gv13,R.drawable.gv14};
    String [] gridView_textView_titles={"作家协会","美术家协会","杂技家协会","戏剧家协会","舞蹈家协会","音乐家协会","曲艺家协会","民间文艺家协会",
            "书法家协会","电影家协会","摄影家协会","电视艺术家协会","评论家协会","飞天编辑部","文学院","伦理研究室",};
    String [] listView_titles = {"第四届“甘肃黄河文学奖”拟获奖名单公示","叶舟获得第六届鲁迅文学奖","第五届甘肃黄河文学奖获奖名单",
            "第三节中国西北音乐节圆满闭幕","省民协召开全省民间文艺界学习习近平总理",
            "第四届“甘肃黄河文学奖”拟获奖名单公示","叶舟获得第六届鲁迅文学奖","第五届甘肃黄河文学奖获奖名单",
            "第三节中国西北音乐节圆满闭幕","省民协召开全省民间文艺界学习习近平总理"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        gridView = (GridView) findViewById(R.id.gridView);
        listViewAdapter = new ListViewAdapter(this,listView_titles);
        gridViewAdapter = new GridViewAdapter();
        gridView.setAdapter(gridViewAdapter);
        listView.setAdapter(listViewAdapter);
    }


    class  GridViewAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return gridView_textView_titles.length;
        }

        @Override
        public Object getItem(int position) {
            return gridView_textView_titles[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = View.inflate(MainActivity.this,R.layout.grid_item,null);
            ImageView gridView_image = (ImageView) convertView.findViewById(R.id.gridView_image);
            gridView_image.setImageResource(imgs[position]);
            TextView gridView_textView = (TextView) convertView.findViewById(R.id.gridView_textView);
            gridView_textView.setText(gridView_textView_titles[position]);
            return convertView;
        }
    }
}
