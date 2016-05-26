package com.developers.devworms.daimler_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }


    public void cumbreScreen(View view){
        Intent newScreen = new Intent(menu.this, cumbreActivity.class);
        startActivity(newScreen);
    }

    public void sedeScreen(View view){
        Intent newScreen = new Intent(menu.this, sedeActivity.class);
        startActivity(newScreen);
    }

    public void agendaScreen(View view){
        Intent newScreen = new Intent(menu.this, agendaActivity.class);
        startActivity(newScreen);
    }

    public void avisosScreen(View view){
        Intent newScreen = new Intent(menu.this, avisosActivity.class);
        startActivity(newScreen);
    }

    public void presentacionesScreen(View view){
        Intent newScreen = new Intent(menu.this, presentacionesActivity.class);
        startActivity(newScreen);
    }

    public void fotografiasScreen(View view){
        Intent newScreen = new Intent(menu.this, fotografiasActivity.class);
        startActivity(newScreen);
    }
}
