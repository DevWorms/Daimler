package com.developers.devworms.daimler_android;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class agendaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

    }


    public void agendaActScreen(View view){
        Intent newScreen = new Intent(agendaActivity.this, menuActActivity.class);
        newScreen.putExtra("dia",((Button)view).getText().toString().toLowerCase());
        startActivity(newScreen);

    }
}
