package com.example.asse.sweapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by user on 5/24/2016.
 */
public class Login extends Activity {

   Button Login = null;
    EditText USERname, USERpass;
    String username, userpass;
    Context context = this;
    boolean login_status = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Login = (Button)findViewById(R.id.login_button);
        USERname = (EditText)findViewById(R.id.username);
        USERpass = (EditText)findViewById(R.id.pass);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getBaseContext(), "Just a moment ", Toast.LENGTH_LONG).show();
                username = USERname.getText().toString();
                userpass = USERpass.getText().toString();
                DatabaseOperations db1 = new DatabaseOperations(context);
                Cursor cursor = db1.loginInfo(db1);
                // first move the cursor to the first row
                cursor.moveToFirst();
                String name = "";
                do {
                    if (username.equals(cursor.getString(0)) && userpass.equals(cursor.getString(1))) {
                        login_status = true;
                        name = cursor.getString(0);
                    }

                }while (cursor.moveToNext());

                //check the login is successful or not
                if (login_status) {
                    Toast.makeText(getBaseContext(), "Login success  Hi "+name, Toast.LENGTH_LONG).show();
                    Intent log_intent = new Intent(getBaseContext(), OrdersListPage.class);
                    startActivity(log_intent);
                } else {
                    Toast.makeText(getBaseContext(), "Login Failed", Toast.LENGTH_LONG).show();
                    finish();
                }

            }
        });

    }
}
