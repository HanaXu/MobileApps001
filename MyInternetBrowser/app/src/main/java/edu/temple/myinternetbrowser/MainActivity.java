package edu.temple.myinternetbrowser;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements webFragment.onUrlChange{

    Toolbar toolbar;
    EditText urlEditText;

    List<webFragment> webFragments = new ArrayList<webFragment>();
    int currentPage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        urlEditText = findViewById(R.id.urlEditText);
        View.OnFocusChangeListener ofcListener = new FocusChangeListener();
        urlEditText.setOnFocusChangeListener(ofcListener);

        findViewById(R.id.goButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String url = urlEditText.getText().toString();



                        try {
                            String tmpUrl = urlEditText.getText().toString();
                            if(!(tmpUrl.startsWith("http"))){
                                tmpUrl = "http://" + tmpUrl;
                                urlEditText.setText(tmpUrl);
                            }

                            Bundle bundle = new Bundle();
                            bundle.putString("url", tmpUrl);

                            webFragment webFragment = new webFragment();
                            webFragment.setArguments(bundle);

                            webFragments.add(webFragment);

                            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, webFragment).commit();


                        } catch (Exception e) {
                            e.printStackTrace();
                        }


            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int res_id = item.getItemId();

        switch(res_id){
            case R.id.action_prev:
                if(currentPage > 0){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, webFragments.get(--currentPage)).commit();
                }
                Toast.makeText(this,"currentPage " + currentPage, Toast.LENGTH_SHORT).show();
                break;

            case R.id.action_add:
                urlEditText.setText("");
                webFragment webFragment = new webFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, webFragment).commit();
                currentPage++;
                Toast.makeText(this,"currentPage " + currentPage, Toast.LENGTH_SHORT).show();
                break;

            case R.id.action_next:
                if(currentPage < webFragments.size()-1){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, webFragments.get(++currentPage)).commit();
                }
                Toast.makeText(this,"currentPage " + currentPage, Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onUrlChange(String url) {
        urlEditText.setText(url);
    }

    //hide virtual keyboard when edittext not in focus
    private class FocusChangeListener implements View.OnFocusChangeListener {

        public void onFocusChange(View v, boolean hasFocus){

            if(v.getId() == R.id.urlEditText && !hasFocus) {

                InputMethodManager imm =  (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

            }
        }
    }

}
