package com.developers.devworms.daimler_android;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by sergio on 29/05/16.
 */
public class ActivityWeb extends AppCompatActivity {

    String tipo;
    WebView wb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        wb = (WebView) findViewById(R.id.web_archivos);
        WebSettings wbs=wb.getSettings();
        wbs.setBuiltInZoomControls(true);
        wbs.setJavaScriptEnabled(true);

        new CargaPdf().execute();
        //vistaWeb.loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url=" + url);

    }

    class CargaPdf extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread Show Progress Dialog
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        /**
         * getting song json and parsing
         * */
        protected String doInBackground(String... args) {
            // Building Parameters

            return null;
        }

        /**
         * After completing background task Dismiss the progress dialog
         * **/
        protected void onPostExecute(String file_url) {
            // dismiss the dialog after getting song information

            // updating UI from Background Thread
            runOnUiThread(new Runnable() {
                public void run() {



                    wb.setWebViewClient(new WebViewClient() {
                        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

                        }

                        @Override
                        public void onPageStarted(WebView view, String url, Bitmap favicon)
                        {

                        }


                        @Override
                        public void onPageFinished(WebView view, String url) {
                            String webUrl = wb.getUrl();

                        }

                    });

                    String url = getIntent().getExtras().getString("url");
                    wb.loadUrl("http://docs.google.com/gview?embedded=true&url="+url);

                }
            });

        }

    }
}

