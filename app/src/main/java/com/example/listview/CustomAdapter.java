package com.example.listview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private List<DataItem> dataItems;
    SharePreference sharedpreferences;


    public CustomAdapter(Context context, List<DataItem> dataItems) {
        this.context = context;
        this.dataItems = dataItems;
    }

    @Override
    public int getCount() {
        return dataItems.size();
    }

    @Override
    public Object getItem(int position) {
        return dataItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_layout, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView textViewName = convertView.findViewById(R.id.textViewName);
        TextView textdescName = convertView.findViewById(R.id.textdescName);
        TextView textTimeName = convertView.findViewById(R.id.textTimeName);

        DataItem item = dataItems.get(position);

        imageView.setImageResource(item.getImageResId());
        textViewName.setText(item.getName());
        textdescName.setText(item.getDesc());
        textTimeName.setText(item.getTime());



        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedpreferences = new SharePreference(context);

//               sharedpreferences.savename(item.getName());
//               sharedpreferences.savedesc(item.getDesc());
//               sharedpreferences.savetime(item.getDesc());

                Intent intent = new Intent(context ,TargetActivity.class);
//                intent.putExtra("name", item.getName());
//                intent.putExtra("desc", item.getDesc());
//                intent.putExtra("time", item.getDesc());
//
                context.startActivity(intent);
//                Toast.makeText(context, (item.getName()+" "+item.getDesc()+" "+item.getTime()), Toast.LENGTH_SHORT).show();
            }
//            private void startActivity(Intent intent) {
//            }
        });
        return convertView;
    }
}

