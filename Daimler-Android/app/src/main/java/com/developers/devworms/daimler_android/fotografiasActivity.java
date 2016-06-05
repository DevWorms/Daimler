package com.developers.devworms.daimler_android;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class fotografiasActivity extends AppCompatActivity {

    int c,numeroImg;

    // Progress Dialog
    private ProgressDialog pDialog;

    Bitmap imgb1,imgb2,imgb3,imgb4,imgb5,imgb6,imgb7,imgb8,imgb9,imgb10;
    ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9,img10;
    ByteArrayOutputStream bs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fotografias);

        img1= (ImageView) findViewById(R.id.imgFotos1);
        img2= (ImageView) findViewById(R.id.imgFotos2);
        img3= (ImageView) findViewById(R.id.imgFotos3);
        img4= (ImageView) findViewById(R.id.imgFotos4);
        img5= (ImageView) findViewById(R.id.imgFotos5);
        img6= (ImageView) findViewById(R.id.imgFotos6);
        img7= (ImageView) findViewById(R.id.imgFotos7);
        img8= (ImageView) findViewById(R.id.imgFotos8);
        img9= (ImageView) findViewById(R.id.imgFotos9);
        img10= (ImageView) findViewById(R.id.imgFotos10);
        new LoadAlbums().execute();
    }

    public void cumbreScreen(View view){
        Intent newScreen = new Intent(fotografiasActivity.this, menu.class);
        startActivity(newScreen);
    }

    public void mostrarimage(int i){


        Intent intent = new Intent(fotografiasActivity.this, FotoSelect.class);


        numeroImg=i;



        if(numeroImg==1){
            bs = new ByteArrayOutputStream();
            imgb1.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==2){
            bs = new ByteArrayOutputStream();
            imgb2.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==3){
            bs = new ByteArrayOutputStream();
            imgb3.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==4){
            bs = new ByteArrayOutputStream();
            imgb4.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==5){
            bs = new ByteArrayOutputStream();
            imgb5.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==6){
            bs = new ByteArrayOutputStream();
            imgb6.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==7){
            bs = new ByteArrayOutputStream();
            imgb7.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==8){
            bs = new ByteArrayOutputStream();
            imgb8.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==9){
            bs = new ByteArrayOutputStream();
            imgb9.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==10){
            bs = new ByteArrayOutputStream();
            imgb10.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }
        intent.putExtra("byteArray", bs.toByteArray());
        intent.putExtra("numeroImg",numeroImg);
        startActivity(intent);

    }



    class LoadAlbums extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread Show Progress Dialog
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(fotografiasActivity.this);
            pDialog.setMessage("Cargando...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        /**
         * getting Albums JSON
         * */
        protected String doInBackground(String... args) {
            Log.d("Entro:", "si");
            try {
                c=0;
                for (int i=1;i<=12;i++){

                    Log.d("foto:", "f"+i);
                    URL url = new URL("http://app-daimler.palindromo.com.mx/galeria/0"+i+".png");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setDoInput(true);
                    connection.connect();
                    InputStream input = connection.getInputStream();
                    if(i==1) {
                        imgb1 = BitmapFactory.decodeStream(input);
                    }else if(i==2){
                        imgb2 = BitmapFactory.decodeStream(input);
                    }else if(i==3){
                        imgb3 = BitmapFactory.decodeStream(input);
                    }else if(i==4){
                        imgb4 = BitmapFactory.decodeStream(input);
                    }else if(i==5){
                        imgb5 = BitmapFactory.decodeStream(input);
                    }else if(i==6){
                        imgb6 = BitmapFactory.decodeStream(input);
                    }else if(i==7){
                        imgb7 = BitmapFactory.decodeStream(input);
                    }else if(i==8){
                        imgb8 = BitmapFactory.decodeStream(input);
                    }else if(i==9){
                        imgb9 = BitmapFactory.decodeStream(input);
                    }else if(i==10){
                        imgb10 = BitmapFactory.decodeStream(input);
                    }
                    c=c+1;
                    runOnUiThread(new Runnable() {
                        public void run() {
                            pDialog.setMessage("Listing..." + c * 8+"%");
                        }
                    });

                }


            } catch (IOException e) {


            }
            return null;
        }


        /**
         * After completing background task Dismiss the progress dialog
         * **/
        protected void onPostExecute(String file_url) {
            // dismiss the dialog after getting all albums

            // updating UI from Background Thread
            runOnUiThread(new Runnable() {
                public void run() {
                    pDialog.setMessage("Listing...100%");
                    /**
                     * Updating parsed JSON data into ListView
                     * */
                    img1.setImageBitmap(imgb1);
                    img2.setImageBitmap(imgb2);
                    img3.setImageBitmap(imgb3);
                    img4.setImageBitmap(imgb4);
                    img5.setImageBitmap(imgb5);
                    img6.setImageBitmap(imgb6);
                    img7.setImageBitmap(imgb7);
                    img8.setImageBitmap(imgb8);
                    img9.setImageBitmap(imgb9);
                    img10.setImageBitmap(imgb10);

                    img1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "foto"+imgb1.toString());
                            mostrarimage(1);


                        }
                    });
                    img2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "1");
                            mostrarimage(2);

                        }
                    });
                    img3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "1");
                            mostrarimage(3);

                        }
                    });
                    img4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "1");
                            mostrarimage(4);

                        }
                    });
                    img5.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "1");
                            mostrarimage(5);

                        }
                    });
                    img6.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "1");
                            mostrarimage(6);

                        }
                    });
                    img7.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "1");
                            mostrarimage(7);

                        }
                    });
                    img8.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "1");
                            mostrarimage(8);

                        }
                    });
                    img9.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "1");
                            mostrarimage(9);

                        }
                    });
                    img10.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "1");
                            mostrarimage(10);

                        }
                    });

                    pDialog.dismiss();
                }
            });

        }





    }
}
