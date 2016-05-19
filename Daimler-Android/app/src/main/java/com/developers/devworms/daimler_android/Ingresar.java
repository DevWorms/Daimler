package com.developers.devworms.daimler_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Ingresar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar);
    }

    public  void llamarRegistro (View view)  {
        Intent llamarScreenRegistro = new Intent(this, MainActivity.class);
        startActivity(llamarScreenRegistro);
    }
}
