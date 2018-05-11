package edu.temple.stocks;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class NavigationFragment extends Fragment {

    ArrayList<String> stocks;

    ArrayList<Stock> stockObjs;

    public NavigationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_navigation, container, false);

        final ListView listView = view.findViewById(R.id.stockNavigation);
        stocks = new ArrayList<String>();

        if (getArguments() != null) {
            stocks = getArguments().getStringArrayList("stockSymbols");
            CustomAdapter customAdapter = new CustomAdapter(getContext(), stocks);
            listView.setAdapter(customAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    new GetStock2(stocks.get(i)).execute();
                }
            });
        }else{
            TextView textView = view.findViewById(R.id.placeholder);
            textView.setText(R.string.placeholder_text);
        }
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }


    public class GetStock2 extends AsyncTask<Void,Void,ArrayList<String>> {

        String stockSymbol;

        String symbol;
        String name;
        String price;

        public GetStock2(String stockSymbol) {
            this.stockSymbol = stockSymbol;
        }


        @Override
        protected ArrayList<String> doInBackground(Void... voids) {
            Document doc = null;
            ArrayList<String> stockInfo = new ArrayList<String>();

            try {
                Log.d("CONNECTING", "connecting..");
                doc = Jsoup.connect("http://dev.markitondemand.com/MODApis/Api/v2/Quote/json/?symbol=" + stockSymbol).timeout(10000).get();
                Log.d("WEBSITE2", doc.html());
                Elements e = (Elements) doc.getElementsByTag("body");
                Log.d("TAG2", e.html());

                String result = e.html();
                JSONObject jObject = new JSONObject(result);

                symbol = jObject.getString("Symbol");
                stockInfo.add(symbol);
                name = jObject.getString("Name");
                stockInfo.add(name);
                price = jObject.getString("LastPrice");
                stockInfo.add(price);

                //System.out.println(stock);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return stockInfo;
        }

        @Override
        protected void onPostExecute(ArrayList<String> result) {

            Intent intent = new Intent();
            Bundle bundle = new Bundle();

            try{
                bundle.putString("symbol", result.get(0));
                bundle.putString("name", result.get(1));
                bundle.putString("price", result.get(2));
            }
            catch(IndexOutOfBoundsException e){
                // Toast.makeText(get, "Error could not find stock", Toast.LENGTH_SHORT).show();
            }
            //bundle.putParcelable("stockChart", (Bitmap)result.get(3));

            intent.putExtras(bundle);

            DetailsFragment detailsFragment = new DetailsFragment();
            detailsFragment.setArguments(bundle);

            getFragmentManager().beginTransaction().replace(R.id.detailsLayout, detailsFragment).commit();


        }

    }
}



