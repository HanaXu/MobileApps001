package edu.temple.twoactivities;


import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class canvasFragment extends Fragment {

    View view;

    public canvasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_canvas, container, false);
        if(getArguments() != null){
            view.setBackgroundColor(Color.parseColor(getArguments().getString("color")));
        }

        return view;
    }

}
