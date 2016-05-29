package com.developers.devworms.daimler_android;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.developers.devworms.daimler_android.mobile.AWSMobileClient;
import com.developers.devworms.daimler_android.mobile.user.IdentityManager;

public class menu extends AppCompatActivity {

    private IdentityManager identityManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Obtain a reference to the mobile client. It is created in the Application class,
        // but in case a custom Application class is not used, we initialize it here if necessary.
        AWSMobileClient.initializeMobileClientIfNecessary(this);

        // Obtain a reference to the mobile client. It is created in the Application class.
        final AWSMobileClient awsMobileClient = AWSMobileClient.defaultMobileClient();

        // Obtain a reference to the identity manager.
        identityManager = awsMobileClient.getIdentityManager();

    }


    @Override
    protected void onResume() {
        super.onResume();


        final AWSMobileClient awsMobileClient = AWSMobileClient.defaultMobileClient();

        // register notification receiver
        LocalBroadcastManager.getInstance(this).registerReceiver(notificationReceiver,
                new IntentFilter(PushListenerService.ACTION_SNS_NOTIFICATION));
    }

    private final BroadcastReceiver notificationReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            Bundle data = intent.getBundleExtra(PushListenerService.INTENT_SNS_NOTIFICATION_DATA);
            String message = PushListenerService.getMessage(data);


            new AlertDialog.Builder(menu.this)
                    .setTitle(R.string.push_demo_title)
                    .setMessage(message)
                    .setPositiveButton(android.R.string.ok, null)
                    .show();

            SQLiteOpenHelper admin = new SQLiteOpenHelper(menu.this,
                    "message", null, 1);

            SQLiteDatabase bd = admin.getWritableDatabase();

            ContentValues registro = new ContentValues();
            registro.put("descripcion", message);

            bd.insert("mensajes", null, registro);
            bd.close();

        }
    };

    @Override
    protected void onPause() {
        super.onPause();

        // unregister notification receiver
        LocalBroadcastManager.getInstance(this).unregisterReceiver(notificationReceiver);
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
