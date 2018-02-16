package edu.temple.signupform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    EditText name;
    EditText email;
    EditText password;
    EditText confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        confirmPassword = (EditText) findViewById(R.id.confirmPassword);

        findViewById(R.id.button).setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        if(TextUtils.isEmpty(name.getText())
                               || TextUtils.isEmpty(email.getText())
                               || TextUtils.isEmpty(password.getText())
                               || TextUtils.isEmpty(confirmPassword.getText())
                           )
                        {
                            Toast.makeText(FormActivity.this, "Please Enter all information", Toast.LENGTH_SHORT).show();
                        }
                        else if(!password.getText().toString().equals(confirmPassword.getText().toString())){
                            Toast.makeText(FormActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(FormActivity.this, "Info saved", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
