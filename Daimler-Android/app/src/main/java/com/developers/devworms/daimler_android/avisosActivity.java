package com.developers.devworms.daimler_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class avisosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avisos);
    }

    public void cumbreScreen(View view){
        Intent newScreen = new Intent(avisosActivity.this, menu.class);
        startActivity(newScreen);
    }
}
