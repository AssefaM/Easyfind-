package com.example.asse.sweapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
import android.view.View.OnClickListener;
import android.content.Context;

public class MainActivity extends AppCompatActivity {
    Button b=null;
    EditText et=null;
    TextView tv=null;
    Button user_login = null;
    Button reg = null;
    int state = 0;
    //Button login = null;

   // ImageButton user_button = null;
    Button login = null;
    Context myContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        myContext = this.getApplicationContext();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
      //  user_button = (ImageButton)findViewById(R.id.imageButton);
        login = (Button)findViewById(R.id.provider);
        user_login = (Button)findViewById(R.id.user);
        reg = (Button) findViewById(R.id.reg);
        user_login.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent ser_intent = new Intent(myContext, UserServices.class);
                startActivity(ser_intent);

            }
        });
        reg.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reg_intent = new Intent(myContext, Register.class);
                startActivity(reg_intent);
            }
        });
        login.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                state = 1;
                Bundle bundle = new Bundle();
                bundle.putInt("state", state);
                Intent login_intent = new Intent(myContext, Login.class);
                startActivity(login_intent);

            }
        });

      /*  user_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent ser_intent = new Intent(myContext, UserServices.class);

                startActivity(ser_intent);
            }
        });
        */
/*
        b=(Button)findViewById(R.id.my_Button);
        et=(EditText)findViewById(R.id.my_EditText);
        tv=(TextView)findViewById(R.id.my_TextView);
        quitbutton=(Button) findViewById(R.id.quit);
        b.setOnClickListener(new OnClickListener() {

                                 @Override
                                 public void onClick(View v) {
                                     String temp=tv.getText().toString();
                                     temp=temp.toUpperCase();
                                     et.setText(temp);
                                 }
                             });



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/
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
}
