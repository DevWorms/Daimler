package com.developers.devworms.daimler_android;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

/**
 * Created by sergio on 29/05/16.
 */
public class ActivityWeb extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        String url = getIntent().getExtras().getString("url");


        WebView vistaWeb = (WebView)findViewById(R.id.web_archivos);
        vistaWeb.getSettings().setJavaScriptEnabled(true);

        vistaWeb.loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url=" + url);



    }
}

