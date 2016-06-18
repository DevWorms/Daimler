package com.developers.devworms.daimler_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class fotoMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto_menu);
    }

    public void lunesScreen(View view){
        Intent newScreen = new Intent(fotoMenuActivity.this, fotografiasActivity.class);
        startActivity(newScreen);
    }

    public void martesScreen(View view){
        Intent newScreen = new Intent(fotoMenuActivity.this, fotografias2Activity.class);
        startActivity(newScreen);
    }

    public void miercolesScreen(View view){
        Intent newScreen = new Intent(fotoMenuActivity.this, fotografias3Activity.class);
        startActivity(newScreen);
    }
}
