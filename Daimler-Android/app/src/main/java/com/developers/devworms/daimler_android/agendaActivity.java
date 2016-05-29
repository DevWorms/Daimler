package com.developers.devworms.daimler_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class agendaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        WebView vistaWeb = (WebView)findViewById(R.id.cumbreWeb);
        vistaWeb.getSettings().setJavaScriptEnabled(true);

        String pdf = "http://palindromo.mx/daimlerapp/pdf/Vista8_Agenda.pdf";
        vistaWeb.loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url=" + pdf);
    }

    public void cumbreScreen(View view){
        Intent newScreen = new Intent(agendaActivity.this, menu.class);
        startActivity(newScreen);
    }
}
