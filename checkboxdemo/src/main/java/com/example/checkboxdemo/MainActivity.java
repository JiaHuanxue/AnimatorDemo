package com.example.checkboxdemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends Activity {

    private ListView listView;
    private Button button_all;
    private Button button_no;
    private Button button_fan;
    private Button button_hind;
    private CheckAdapter checkAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        button_all = (Button) findViewById(R.id.buttonAll);
        button_no = (Button) findViewById(R.id.buttonNo);
        button_fan = (Button) findViewById(R.id.buttonFan);
        button_hind = (Button) findViewById(R.id.buttonHind);
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 15; i++) {
            list.add("这是条目" + i);
        }
        checkAdapter = new CheckAdapter(getApplicationContext(),list);
        listView.setAdapter(checkAdapter);
        //全部选
        button_no.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                boolean flag = false;
                for (int i = 0; i < checkAdapter.getSelect().size(); i++) {
                    checkAdapter.getSelect().set(i, flag);
                }
                checkAdapter.notifyDataSetChanged();

            }
        });
        //全选
        button_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = true;
                for (int i = 0; i < checkAdapter.getSelect().size(); i++) {
                    checkAdapter.getSelect().set(i, flag);
                }
                checkAdapter.notifyDataSetChanged();
            }
        });
        //反选

        //反选
        button_fan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (! checkAdapter.getSelect().contains(true)) {
                    Toast.makeText(MainActivity.this, "先选一个",Toast.LENGTH_SHORT).show();
                }else {
                    for (int i = 0; i < checkAdapter.getSelect().size(); i++) {
                        if (checkAdapter.getSelect().get(i)) {
                            checkAdapter.getSelect().set(i, false);
                        }else {
                            checkAdapter.getSelect().set(i, true);
                        }
                    }

                    checkAdapter.notifyDataSetChanged();
                }
            }
        });


    }

    public class CheckAdapter extends BaseAdapter {
        private List<String> list;
        private Context context;
        //创建一个集合 去记录选中与未选中的状态
        LinkedList<Boolean> linkedList = new LinkedList<Boolean>();
        public CheckAdapter(Context context, List<String> list) {
            // TODO Auto-generated constructor stub
            this.list = list;
            this.context = context;

            for (int i = 0; i < list.size(); i++) {
                linkedList.add(false);
            }

        }
        //对外提供一个方法 获取这个集合
        private List<Boolean> getSelect() {
            return linkedList;
        }
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView==null){
                convertView = View.inflate(context,R.layout.list_item,null);
                holder = new ViewHolder();
                holder.checkBox = (CheckBox) convertView.findViewById(R.id.ck);
                convertView.setTag(holder);
            }else{
                holder = (ViewHolder) convertView.getTag();
            }
                holder.checkBox.setChecked(linkedList.get(position));

                holder.checkBox.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //点中的时候改成相反的值
                        linkedList.set(position,!linkedList.get(position));

                        notifyDataSetChanged();
                    }
                });


            return convertView;
        }

        class  ViewHolder{
            CheckBox checkBox;
        }
    }
}
