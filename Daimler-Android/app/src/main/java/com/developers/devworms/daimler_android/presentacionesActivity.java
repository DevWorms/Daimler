package com.developers.devworms.daimler_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class presentacionesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentaciones);
    }

    public void cumbreScreen(View view){
        Intent newScreen = new Intent(presentacionesActivity.this, menu.class);
        startActivity(newScreen);
    }

}
