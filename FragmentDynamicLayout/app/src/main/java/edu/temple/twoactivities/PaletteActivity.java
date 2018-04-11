package edu.temple.twoactivities;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class PaletteActivity extends Activity implements paletteFragment.OnGridViewSelectedListener{

    boolean twoPanes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        setTitle("Two Fragments");

        twoPanes = (findViewById(R.id.canvas_fragment) != null);
        getFragmentManager().beginTransaction().replace(R.id.palette_fragment, new paletteFragment()).commit(); //portrait mode


    }

    @Override
    public void onViewSelected(String s) {
        Bundle bundle = new Bundle();
        bundle.putString("color", s);

        canvasFragment canvasFragment = new canvasFragment();
        canvasFragment.setArguments(bundle);

        if(twoPanes){ //landscape mode
            getFragmentManager().beginTransaction().replace(R.id.canvas_fragment, canvasFragment).commit();
        }
        else{ //portrait mode
            getFragmentManager().beginTransaction().replace(R.id.activity_palette, canvasFragment).commit();
        }

    }
}
