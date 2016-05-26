package com.developers.devworms.daimler_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class sedeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sede);
    }

    public void cumbreScreen(View view){
        Intent newScreen = new Intent(sedeActivity.this, menu.class);
        startActivity(newScreen);
    }
}
