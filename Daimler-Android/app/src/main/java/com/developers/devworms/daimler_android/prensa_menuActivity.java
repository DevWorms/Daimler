package com.developers.devworms.daimler_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class prensa_menuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prensa_menu);
    }


    public void cumbreScreen(View view){
        Intent newScreen = new Intent(prensa_menuActivity.this, cumbre2Activity.class);
        startActivity(newScreen);
    }

    public void sedeScreen(View view){
        Intent newScreen = new Intent(prensa_menuActivity.this, sede2Activity.class);
        startActivity(newScreen);
    }

}
