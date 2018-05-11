package edu.temple.stocks;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {

    String symbol;
    String name;
    String price;

    public DetailsFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        symbol = getArguments().getString("symbol");
        name = getArguments().getString("name");
        price = getArguments().getString("price");

        TextView s = view.findViewById(R.id.symbol);
        s.setText(symbol);
        TextView n = view.findViewById(R.id.name);
        n.setText(name);
        TextView p = view.findViewById(R.id.price);
        p.setText(price);


        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

      //  outState.putString("symbol",symbol);
        //outState.putString("name", name);
        //outState.putString("price", price);

    }
}
