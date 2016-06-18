package com.developers.devworms.daimler_android;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class fotografias2Activity extends AppCompatActivity {

    int c,numeroImg;

    // Progress Dialog
    private ProgressDialog pDialog;

    Bitmap imgb19,imgb20,imgb21,imgb22,imgb23,imgb24,imgb25,imgb26,imgb27,imgb28,imgb29,imgb30,imgb31,imgb32,imgb33,imgb34,imgb35,imgb36;
    ImageView img19,img20,img21,img22,img23,img24,img25,img26,img27,img28,img29,img30,img31,img32,img33,img34,img35,img36;
    ByteArrayOutputStream bs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fotografias2);

        img19= (ImageView) findViewById(R.id.imgFotos1);
        img20= (ImageView) findViewById(R.id.imgFotos2);
        img21= (ImageView) findViewById(R.id.imgFotos3);
        img22= (ImageView) findViewById(R.id.imgFotos4);
        img23= (ImageView) findViewById(R.id.imgFotos5);
        img24= (ImageView) findViewById(R.id.imgFotos6);
        img25= (ImageView) findViewById(R.id.imgFotos7);
        img26= (ImageView) findViewById(R.id.imgFotos8);
        img27= (ImageView) findViewById(R.id.imgFotos9);
        img28= (ImageView) findViewById(R.id.imgFotos10);
        img29= (ImageView) findViewById(R.id.imgFotos11);
        img30= (ImageView) findViewById(R.id.imgFotos12);
        img31= (ImageView) findViewById(R.id.imgFotos13);
        img32= (ImageView) findViewById(R.id.imgFotos14);
        img33= (ImageView) findViewById(R.id.imgFotos15);
        img34= (ImageView) findViewById(R.id.imgFotos16);
        img35= (ImageView) findViewById(R.id.imgFotos17);
        img36= (ImageView) findViewById(R.id.imgFotos18);
        new LoadAlbums().execute();

    }

    public void cumbreScreen(View view){
        Intent newScreen = new Intent(fotografias2Activity.this, fotoMenuActivity.class);
        startActivity(newScreen);
    }

    public void mostrarimage(int i){


        Intent intent = new Intent(fotografias2Activity.this, FotoSelect.class);


        numeroImg=i;



        if(numeroImg==19){
            bs = new ByteArrayOutputStream();
            imgb19.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==20){
            bs = new ByteArrayOutputStream();
            imgb20.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==21){
            bs = new ByteArrayOutputStream();
            imgb21.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==22){
            bs = new ByteArrayOutputStream();
            imgb22.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==23){
            bs = new ByteArrayOutputStream();
            imgb23.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==24){
            bs = new ByteArrayOutputStream();
            imgb24.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==25){
            bs = new ByteArrayOutputStream();
            imgb25.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==26){
            bs = new ByteArrayOutputStream();
            imgb26.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==27){
            bs = new ByteArrayOutputStream();
            imgb27.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==28){
            bs = new ByteArrayOutputStream();
            imgb28.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==29){
            bs = new ByteArrayOutputStream();
            imgb29.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==30){
            bs = new ByteArrayOutputStream();
            imgb30.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==31){
            bs = new ByteArrayOutputStream();
            imgb31.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==32){
            bs = new ByteArrayOutputStream();
            imgb32.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==33){
            bs = new ByteArrayOutputStream();
            imgb33.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==34){
            bs = new ByteArrayOutputStream();
            imgb34.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==35){
            bs = new ByteArrayOutputStream();
            imgb35.compress(Bitmap.CompressFormat.JPEG, 50, bs);
        }else if(numeroImg==36){
            bs = new ByteArrayOutputStream();
            imgb36.compress(Bitmap.CompressFormat.JPEG, 50, bs);
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
            pDialog = new ProgressDialog(fotografias2Activity.this);
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
                for (int i=19;i<=36;i++){

                    Log.d("foto:", "f"+i);
                    URL url = new URL("http://app-daimler.palindromo.com.mx/galeria/0"+i+".png");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setDoInput(true);
                    connection.connect();
                    InputStream input = connection.getInputStream();
                    if(i==19) {
                        imgb19 = BitmapFactory.decodeStream(input);
                    }else if(i==20){
                        imgb20 = BitmapFactory.decodeStream(input);
                    }else if(i==21){
                        imgb21 = BitmapFactory.decodeStream(input);
                    }else if(i==22){
                        imgb22 = BitmapFactory.decodeStream(input);
                    }else if(i==23){
                        imgb23 = BitmapFactory.decodeStream(input);
                    }else if(i==24){
                        imgb24 = BitmapFactory.decodeStream(input);
                    }else if(i==25){
                        imgb25 = BitmapFactory.decodeStream(input);
                    }else if(i==26){
                        imgb26 = BitmapFactory.decodeStream(input);
                    }else if(i==27){
                        imgb27 = BitmapFactory.decodeStream(input);
                    }else if(i==28){
                        imgb28 = BitmapFactory.decodeStream(input);
                    }else if(i==29) {
                        imgb29 = BitmapFactory.decodeStream(input);
                    }else if(i==30){
                        imgb30 = BitmapFactory.decodeStream(input);
                    }else if(i==31){
                        imgb31 = BitmapFactory.decodeStream(input);
                    }else if(i==32){
                        imgb32 = BitmapFactory.decodeStream(input);
                    }else if(i==33){
                        imgb33 = BitmapFactory.decodeStream(input);
                    }else if(i==34){
                        imgb34 = BitmapFactory.decodeStream(input);
                    }else if(i==35){
                        imgb35 = BitmapFactory.decodeStream(input);
                    }else if(i==36){
                        imgb36 = BitmapFactory.decodeStream(input);
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
                    img19.setImageBitmap(imgb19);
                    img20.setImageBitmap(imgb20);
                    img21.setImageBitmap(imgb21);
                    img22.setImageBitmap(imgb22);
                    img23.setImageBitmap(imgb23);
                    img24.setImageBitmap(imgb24);
                    img25.setImageBitmap(imgb25);
                    img26.setImageBitmap(imgb26);
                    img27.setImageBitmap(imgb27);
                    img28.setImageBitmap(imgb28);
                    img29.setImageBitmap(imgb29);
                    img30.setImageBitmap(imgb30);
                    img31.setImageBitmap(imgb31);
                    img32.setImageBitmap(imgb32);
                    img33.setImageBitmap(imgb33);
                    img34.setImageBitmap(imgb34);
                    img35.setImageBitmap(imgb35);
                    img36.setImageBitmap(imgb36);

                    img19.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "foto"+imgb19.toString());
                            mostrarimage(19);
                        }
                    });
                    img20.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "1");
                            mostrarimage(20);

                        }
                    });
                    img21.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "1");
                            mostrarimage(21);

                        }
                    });
                    img22.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "1");
                            mostrarimage(22);

                        }
                    });
                    img23.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "1");
                            mostrarimage(23);

                        }
                    });
                    img24.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "1");
                            mostrarimage(24);

                        }
                    });
                    img25.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "1");
                            mostrarimage(25);

                        }
                    });
                    img26.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "1");
                            mostrarimage(26);

                        }
                    });
                    img27.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "1");
                            mostrarimage(27);

                        }
                    });
                    img28.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "1");
                            mostrarimage(28);

                        }
                    });
                    img29.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "foto"+imgb29.toString());
                            mostrarimage(29);


                        }
                    });
                    img30.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "1");
                            mostrarimage(30);

                        }
                    });
                    img31.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "1");
                            mostrarimage(31);

                        }
                    });
                    img32.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "1");
                            mostrarimage(32);

                        }
                    });
                    img33.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "1");
                            mostrarimage(33);

                        }
                    });
                    img34.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "1");
                            mostrarimage(34);

                        }
                    });
                    img35.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "1");
                            mostrarimage(35);

                        }
                    });
                    img36.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Log.d("FOTO", "1");
                            mostrarimage(36);

                        }
                    });

                    pDialog.dismiss();
                }
            });

        }





    }

}
