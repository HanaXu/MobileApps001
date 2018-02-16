package edu.temple.spinner;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter{

    Context context;
    String[] colors;

    public CustomAdapter(Context context, String[] colors){
        this.context = context;
        this.colors = colors;
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
        textView.setTextSize(20);
        textView.setText(colors[i]);
        textView.setBackgroundColor(Color.parseColor(colors[i]));

        return textView;
    }
}
