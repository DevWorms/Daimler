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

public class fotografias3Activity extends AppCompatActivity {

    int c,numeroImg;

    // Progress Dialog
    private ProgressDialog pDialog;

    Bitmap imgb37,imgb38,imgb39,imgb40,imgb41,imgb42,imgb43,imgb44,imgb45,imgb46,imgb47,imgb48,imgb49,imgb50,imgb51,imgb52,imgb53,imgb54;
    ImageView img37,img38,img39,img40,img41,img42,img43,img44,img45,img46,img47,img48,img49,img50,img51,img52,img53,img54;
    ByteArrayOutputStream bs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fotografias3);

        img37= (ImageView) findViewById(R.id.imgFotos1);
        img38= (ImageView) findViewById(R.id.imgFotos2);
        img39= (ImageView) findViewById(R.id.imgFotos3);
        img40= (ImageView) findViewById(R.id.imgFotos4);
        img41= (ImageView) findViewById(R.id.imgFotos5);
        img42= (ImageView) findViewById(R.id.imgFotos6);
        img43= (ImageView) findViewById(R.id.imgFotos7);
        img44= (ImageView) findViewById(R.id.imgFotos8);
        img45= (ImageView) findViewById(R.id.imgFotos9);
        img46= (ImageView) findViewById(R.id.imgFotos10);
        img47= (ImageView) findViewById(R.id.imgFotos11);
        img48= (ImageView) findViewById(R.id.imgFotos12);
        img49= (ImageView) findViewById(R.id.imgFotos13);
        img50= (ImageView) findViewById(R.id.imgFotos14);
        img51= (ImageView) findViewById(R.id.imgFotos15);
        img52= (ImageView) findViewById(R.id.imgFotos16);
        img53= (ImageView) findViewById(R.id.imgFotos17);
        img54= (ImageView) findViewById(R.id.imgFotos18);
        new LoadAlbums().execute();
    }

    public void cumbreScreen(View view){
        Intent newScreen = new Intent(fotografias3Activity.this, fotoMenuActivity.class);
        startActivity(newScreen);
    }

    public void mostrarimage(int i){


        Intent intent = new Intent(fotografias3Activity.this, FotoSelect.class);


        numeroImg=i;



        if(numeroImg==37){
            bs = new ByteArrayOutputStream();
            imgb37.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==38){
            bs = new ByteArrayOutputStream();
            imgb38.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==39){
            bs = new ByteArrayOutputStream();
            imgb39.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==40){
            bs = new ByteArrayOutputStream();
            imgb40.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==41){
            bs = new ByteArrayOutputStream();
            imgb41.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==42){
            bs = new ByteArrayOutputStream();
            imgb42.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==43){
            bs = new ByteArrayOutputStream();
            imgb43.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==44){
            bs = new ByteArrayOutputStream();
            imgb44.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==45){
            bs = new ByteArrayOutputStream();
            imgb45.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==46){
            bs = new ByteArrayOutputStream();
            imgb46.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==47){
            bs = new ByteArrayOutputStream();
            imgb47.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==48){
            bs = new ByteArrayOutputStream();
            imgb48.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==49){
            bs = new ByteArrayOutputStream();
            imgb49.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==50){
            bs = new ByteArrayOutputStream();
            imgb50.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==51){
            bs = new ByteArrayOutputStream();
            imgb51.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==52){
            bs = new ByteArrayOutputStream();
            imgb52.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==53){
            bs = new ByteArrayOutputStream();
            imgb53.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==54){
            bs = new ByteArrayOutputStream();
            imgb54.compress(Bitmap.CompressFormat.JPEG, 50, bs);
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
            pDialog = new ProgressDialog(fotografias3Activity.this);
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
                for (int i=37;i<=54;i++){

                    Log.d("foto:", "f"+i);
                    URL url = new URL("http://app-daimler.palindromo.com.mx/galeria/0"+i+".png");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setDoInput(true);
                    connection.connect();
                    InputStream input = connection.getInputStream();
                    if(i==37) {
                        imgb37 = BitmapFactory.decodeStream(input);
                    }else if(i==38){
                        imgb38 = BitmapFactory.decodeStream(input);
                    }else if(i==39){
                        imgb39 = BitmapFactory.decodeStream(input);
                    }else if(i==40){
                        imgb40 = BitmapFactory.decodeStream(input);
                    }else if(i==41){
                        imgb41 = BitmapFactory.decodeStream(input);
                    }else if(i==42){
                        imgb42 = BitmapFactory.decodeStream(input);
                    }else if(i==43){
                        imgb43 = BitmapFactory.decodeStream(input);
                    }else if(i==44){
                        imgb44 = BitmapFactory.decodeStream(input);
                    }else if(i==45){
                        imgb45 = BitmapFactory.decodeStream(input);
                    }else if(i==46){
                        imgb46 = BitmapFactory.decodeStream(input);
                    }else if(i==47) {
                        imgb47 = BitmapFactory.decodeStream(input);
                    }else if(i==48){
                        imgb48 = BitmapFactory.decodeStream(input);
                    }else if(i==49){
                        imgb49 = BitmapFactory.decodeStream(input);
                    }else if(i==50){
                        imgb50 = BitmapFactory.decodeStream(input);
                    }else if(i==51){
                        imgb51 = BitmapFactory.decodeStream(input);
                    }else if(i==52){
                        imgb52 = BitmapFactory.decodeStream(input);
                    }else if(i==53){
                        imgb53 = BitmapFactory.decodeStream(input);
                    }else if(i==54){
                        imgb54 = BitmapFactory.decodeStream(input);
                    }
                    c=c+1;
                    runOnUiThread(new Runnable() {
                        public void run() {
                            pDialog.setMessage("Listing..." + c * 5+"%");
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
                    img37.setImageBitmap(imgb37);
                    img38.setImageBitmap(imgb38);
                    img39.setImageBitmap(imgb39);
                    img40.setImageBitmap(imgb40);
                    img41.setImageBitmap(imgb41);
                    img42.setImageBitmap(imgb42);
                    img43.setImageBitmap(imgb43);
                    img44.setImageBitmap(imgb44);
                    img45.setImageBitmap(imgb45);
                    img46.setImageBitmap(imgb46);
                    img47.setImageBitmap(imgb47);
                    img48.setImageBitmap(imgb48);
                    img49.setImageBitmap(imgb49);
                    img50.setImageBitmap(imgb50);
                    img51.setImageBitmap(imgb51);
                    img52.setImageBitmap(imgb52);
                    img53.setImageBitmap(imgb53);
                    img54.setImageBitmap(imgb54);

                    img37.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "foto"+imgb37.toString());
                            mostrarimage(37);
                        }
                    });
                    img38.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "1");
                            mostrarimage(38);

                        }
                    });
                    img39.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "1");
                            mostrarimage(39);

                        }
                    });
                    img40.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "1");
                            mostrarimage(40);

                        }
                    });
                    img41.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "1");
                            mostrarimage(41);

                        }
                    });
                    img42.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "1");
                            mostrarimage(42);

                        }
                    });
                    img43.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "1");
                            mostrarimage(43);

                        }
                    });
                    img44.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "1");
                            mostrarimage(44);

                        }
                    });
                    img45.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "1");
                            mostrarimage(45);

                        }
                    });
                    img46.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "foto"+imgb46.toString());
                            mostrarimage(46);


                        }
                    });
                    img47.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "1");
                            mostrarimage(47);

                        }
                    });
                    img48.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "1");
                            mostrarimage(48);

                        }
                    });
                    img49.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "1");
                            mostrarimage(49);

                        }
                    });
                    img50.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "1");
                            mostrarimage(50);

                        }
                    });
                    img51.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "1");
                            mostrarimage(51);

                        }
                    });
                    img52.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "1");
                            mostrarimage(52);

                        }
                    });
                    img53.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "1");
                            mostrarimage(53);

                        }
                    });
                    img54.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "1");
                            mostrarimage(54);

                        }
                    });

                    pDialog.dismiss();
                }
            });

        }


    }

}
