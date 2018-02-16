package edu.temple.spinner;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class PaletteActivity extends Activity{

    String[] colors = {"White", "Red", "Blue", "Green", "Purple"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        final View layout = findViewById(R.id.activity_palette);
        Spinner spinner = findViewById(R.id.spinner);
        CustomAdapter customAdapter = new CustomAdapter(this, colors);
        spinner.setAdapter(customAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                layout.setBackgroundColor(Color.parseColor(colors[i]));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
