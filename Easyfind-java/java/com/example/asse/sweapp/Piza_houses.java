package com.example.asse.sweapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Piza_houses extends AppCompatActivity {

    Button but1 = null;
    Button but2 = null;
    Button but3 = null;
    Button but4 = null;
    Button but5 = null;
    Button but6 = null;
    Button but7 = null;
    Button but8 = null;
    Button but9 = null;
    Button next = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piza_houses);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        but1 = (Button)findViewById(R.id.description1);
        but2 = (Button)findViewById(R.id.description2);
        but3 = (Button)findViewById(R.id.description3);
        but4 = (Button)findViewById(R.id.description4);
        but5 = (Button)findViewById(R.id.description5);
        but6 = (Button)findViewById(R.id.description6);
        but7 = (Button)findViewById(R.id.description7);
        but8 = (Button)findViewById(R.id.description8);
        but9 = (Button)findViewById(R.id.description9);
        next = (Button)findViewById(R.id.next_Button);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Piza_houses.this, Pop.class));

            }
        }) ;
        but2.setOnClickListener(new View.OnClickListener() {
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Piza_houses.this, Pizza2.class));
            }
        });
        but3.setOnClickListener(new View.OnClickListener() {
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Piza_houses.this, Hawaiian_Shrimp_Pizza.class));
            }
        });
        but4.setOnClickListener(new View.OnClickListener() {
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Piza_houses.this, Derry_Pizza.class));
            }
        });
        but5.setOnClickListener(new View.OnClickListener(){

            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                startActivity(new  Intent(Piza_houses.this, Tender_Chicken_Pizza.class));
            }
        });
        but6.setOnClickListener(new View.OnClickListener() {

            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Piza_houses.this, Italian_cheese_Pizza.class));
            }
        });
        but7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(Piza_houses.this, Maru_Combination_Pizza.class));
            }
        });
        but8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(Piza_houses.this, Bulgogi_Pizza.class));
            }
        });
        but9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(Piza_houses.this, Sweet_Potato_Pizza.class));
            }
        });

/*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
