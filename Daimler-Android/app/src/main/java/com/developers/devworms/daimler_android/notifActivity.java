package com.developers.devworms.daimler_android;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class notifActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notif);

        TextView txtMensaje = (TextView) findViewById(R.id.txt_mensajes);

        String mensaje = getIntent().getExtras().getString("mensaje");

        txtMensaje.setText(mensaje);


    }
}
