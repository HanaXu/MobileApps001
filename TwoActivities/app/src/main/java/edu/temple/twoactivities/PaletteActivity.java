package edu.temple.twoactivities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class PaletteActivity extends Activity{

    final String[] colors = {"White", "Red", "Blue", "Green", "Black", "Purple", "Yellow", "Gray", "Magenta", "Cyan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        setTitle("Palette Activity");
        final View layout = findViewById(R.id.activity_palette);
        GridView gridView = findViewById(R.id.gridview);
        CustomAdapter customAdapter = new CustomAdapter(this, colors);
        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(PaletteActivity.this, CanvasActivity.class);
                intent.putExtra("color", colors[i]); //pass String value and make the key "color"
                startActivity(intent); //start CanvasActivity
            }
        });
    }
}
