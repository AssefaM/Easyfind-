package com.example.asse.sweapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by user on 5/23/2016.
 */
public class Register extends Activity {
    EditText USER_NAME, USER_PASS, CON_PASS;
    String user_name, user_pass, con_pass;
    Button REG;
    Context ctc = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        USER_NAME = (EditText)findViewById(R.id.reg_user);
        USER_PASS = (EditText)findViewById(R.id.reg_pass);
        CON_PASS = (EditText)findViewById(R.id.con_pass);
        REG = (Button) findViewById(R.id.user_reg);
        REG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_name = USER_NAME.getText().toString();
                user_pass = USER_PASS.getText().toString();
                con_pass = CON_PASS.getText().toString();

                if(!(user_pass.equals(con_pass))) {
                    Toast.makeText(getBaseContext(), "Passwords are not matching", Toast.LENGTH_LONG).show();

                    USER_NAME.setText(" ");
                    USER_PASS.setText("");
                    CON_PASS.setText("");
                } else {
                    if (user_name.isEmpty() || user_pass.isEmpty() || con_pass.isEmpty()) {
                        Toast.makeText(getBaseContext(), "Enter Required fields", Toast.LENGTH_LONG).show();

                    } else {
                        DatabaseOperations db = new DatabaseOperations(ctc);
                        db.putInformation(db, user_name, user_pass);
                        Toast.makeText(getBaseContext(), "Registration is successfull", Toast.LENGTH_LONG).show();
                        finish();
                    }
                }
            }
        });

    }
}
