package edu.temple.stocks;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class GetStockActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_stock);

        GetStock getStock = new GetStock(getIntent().getStringExtra("symbol"));
        getStock.execute();
    }

    public class GetStock extends AsyncTask<Void,Void,ArrayList<String>> {

        String stockSymbol;

        String symbol;
        String name;
        String price;

        public GetStock(String stockSymbol){
            this.stockSymbol = stockSymbol;
        }


        @Override
        protected ArrayList<String> doInBackground(Void... voids) {
            Document doc = null;
            ArrayList<String> stockInfo = new ArrayList<String>();

            try {
                Log.d("CONNECTING", "connecting..");
                doc = Jsoup.connect("http://dev.markitondemand.com/MODApis/Api/v2/Quote/json/?symbol=" + stockSymbol).get();
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
                Toast.makeText(GetStockActivity.this, "Error could not find stock", Toast.LENGTH_SHORT).show();
            }
            //bundle.putParcelable("stockChart", (Bitmap)result.get(3));

            intent.putExtras(bundle);
            setResult(RESULT_OK, intent);


            finish();
        }
    }


}
