package com.developers.devworms.daimler_android;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class FotoSelect extends AppCompatActivity {
    ImageView imgSelect;
    Bitmap b;
    int numeroImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fotoselect);

        numeroImg = getIntent().getIntExtra("numeroImg", 0);
        Log.d("numeroImg", "numeroImg " + numeroImg);
        if (getIntent().hasExtra("byteArray")) {
            ImageView previewThumbnail = new ImageView(this);
            b = BitmapFactory.decodeByteArray(
                    getIntent().getByteArrayExtra("byteArray"), 0, getIntent().getByteArrayExtra("byteArray").length);
            previewThumbnail.setImageBitmap(b);
        }
        //Bitmap bitmap = getIntent().getParcelableExtra("BitmapImage");
        // Log.d("bitmap", "bitmap"+bitmap.toString());
        imgSelect = (ImageView) findViewById(R.id.imgDialogImage);
        imgSelect.setImageBitmap(b);
    }
}
