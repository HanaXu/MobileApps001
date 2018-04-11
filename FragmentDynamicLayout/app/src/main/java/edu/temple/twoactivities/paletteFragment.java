package edu.temple.twoactivities;


import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class paletteFragment extends Fragment {
    OnGridViewSelectedListener callback;

    public paletteFragment() {
        // Required empty public constructor
    }

    // Container Activity must implement this interface
    public interface OnGridViewSelectedListener {
        public void onViewSelected(String color);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnGridViewSelectedListener) {
            callback = (OnGridViewSelectedListener) context;
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_palette, container, false);

        GridView gridView = view.findViewById(R.id.gridview);
        Resources res = this.getResources();
        final String[] colors_arr = res.getStringArray(R.array.colors_arr);
        final String[] colors_es = res.getStringArray(R.array.colors_es);

        CustomAdapter customAdapter = new CustomAdapter(getContext(), colors_arr, colors_es);
        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("String", "VALUE@@@: " + colors_arr[i]);

                callback.onViewSelected(colors_arr[i]);

            }
        });

        return view;
    }


}
