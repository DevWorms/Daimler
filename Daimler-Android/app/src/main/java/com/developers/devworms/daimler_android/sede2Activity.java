package com.developers.devworms.daimler_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class sede2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sede2);
    }

    public void cumbreScreen(View view){
        Intent newScreen = new Intent(sede2Activity.this, prensa_menuActivity.class);
        startActivity(newScreen);
    }
}
