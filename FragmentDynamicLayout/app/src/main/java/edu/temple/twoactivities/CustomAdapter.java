package edu.temple.twoactivities;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter{

    Context context;
    String[] colors;
    String[] colors_es;

    public CustomAdapter(Context context, String[] colors, String[] colors_es){
        this.context = context;
        this.colors = colors;
        this.colors_es = colors_es;
    }

    @Override
    public int getCount() {
        return colors.length;
    }

    @Override
    public Object getItem(int i) {
        return colors[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = new TextView(context);
        textView.setTextSize(30);
        textView.setHeight(200);
        textView.setText(colors_es[i]);
        textView.setBackgroundColor(Color.parseColor(colors[i])); //set view background color

        return textView;
    }
}