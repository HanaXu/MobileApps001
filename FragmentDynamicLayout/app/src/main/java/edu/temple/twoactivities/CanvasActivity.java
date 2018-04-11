package edu.temple.twoactivities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

public class CanvasActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        setTitle("Canvas Activity");
        Intent getIntent = getIntent();
        findViewById(R.id.activity_canvas).setBackgroundColor(Color.parseColor(getIntent.getStringExtra("color"))); //get value associated with the string "color"
    }
}
