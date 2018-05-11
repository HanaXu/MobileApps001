package edu.temple.stocks;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    EditText input;

    AlertDialog.Builder builder;
    AlertDialog dialog;
    Boolean twoPanes;

    ArrayList<String> stockSymbols;
   // ArrayList<Stock> stockObjs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        twoPanes = (findViewById(R.id.button) != null);

        stockSymbols = new ArrayList<String>();
        //stockObjs = new ArrayList<Stock>();

        builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Add stocks");
        builder.setMessage("Enter stock symbol");
        input = new EditText(MainActivity.this);
        builder.setView(input);
        builder.setPositiveButton("Search", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String stockSymbol = input.getText().toString();
                stockSymbols.add(stockSymbol);

                Bundle bundle = new Bundle();
                bundle.putStringArrayList("stockSymbols", stockSymbols);


                NavigationFragment navigationFragment = new NavigationFragment();
                navigationFragment.setArguments(bundle);

                getSupportFragmentManager().beginTransaction().replace(R.id.navLayout, navigationFragment).commit();

                Intent intent = new Intent(MainActivity.this, GetStockActivity.class);
                intent.putExtra("symbol", stockSymbol);
                startActivityForResult(intent, 100);

                input.setText("");

            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.dismiss();
            }
        });
        dialog = builder.create();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });

        getSupportFragmentManager().beginTransaction().replace(R.id.navLayout, new NavigationFragment()).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            String symbol = bundle.getString("symbol");
            String name = bundle.getString("name");
            String price = bundle.getString("price");

           // Stock stock = new Stock(symbol, name, price);
            //stockObjs.add(stock);

            System.out.println(symbol);
            System.out.println(name);
            System.out.println(price);


            DetailsFragment detailsFragment = new DetailsFragment();
            detailsFragment.setArguments(bundle);

            this.getSupportFragmentManager().beginTransaction().replace(R.id.detailsLayout, detailsFragment).commit();


        }
    }




}
