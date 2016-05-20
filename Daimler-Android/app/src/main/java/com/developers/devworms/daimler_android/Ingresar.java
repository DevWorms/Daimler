package com.developers.devworms.daimler_android;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Ingresar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar);

    }

    public void llamarRegistro(View view) {
        Intent llamarScreenRegistro = new Intent(this, MainActivity.class);
        startActivity(llamarScreenRegistro);

    }

    public void pantallaCodigo(View view) {
        Intent llamarScreenCodigo = new Intent(this, RegistroExito.class);
        startActivity(llamarScreenCodigo);
    }
}
