package com.developers.devworms.daimler_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class cumbre2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cumbre2);

        WebView vistaWeb = (WebView)findViewById(R.id.cumbreWeb);
        vistaWeb.getSettings().setJavaScriptEnabled(true);

        String pdf = "http://palindromo.mx/daimlerapp/pdf/Vista6.pdf";
        vistaWeb.loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url=" + pdf);
    }


    public void cumbreScreen(View view){
        Intent newScreen = new Intent(cumbre2Activity.this, prensa_menuActivity.class);
        startActivity(newScreen);
    }
}
