package com.developers.devworms.daimler_android;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class avisosActivity extends AppCompatActivity {

    final ArrayList<String> notificaciones = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avisos);

        final ArrayList<String> list = new ArrayList<String>();
        final ListView listview = (ListView) findViewById(R.id.listview);


        SQLiteOpenHelper admin = new SQLiteOpenHelper(this,
                "message", null, 1);

        SQLiteDatabase bd = admin.getWritableDatabase();

        Cursor fila = bd.rawQuery(
                "select * from mensajes; ", null);

        while (fila.moveToNext()) {
            String mensaje  = fila.getString(0);
            list.add("mensaje: " + mensaje.split(" ")[0] + "...");
            notificaciones.add(mensaje);
        }

        bd.close();

        final StableArrayAdapter adapter = new StableArrayAdapter(this,
                android.R.layout.simple_list_item_1, list);

        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {

                Intent newScreen = new Intent(avisosActivity.this, notifActivity.class);
                newScreen.putExtra("mensaje", notificaciones.get(position));
                startActivity(newScreen);
                /*
                final String item = (String) parent.getItemAtPosition(position);
                view.animate().setDuration(2000).alpha(0)
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                list.remove(item);
                                adapter.notifyDataSetChanged();
                                view.setAlpha(1);


                            }
                        });*/
            }

        });


    }

    private class StableArrayAdapter extends ArrayAdapter<String> {

        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

        public StableArrayAdapter(Context context, int textViewResourceId,
                                  List<String> objects) {
            super(context, textViewResourceId, objects);
            for (int i = 0; i < objects.size(); ++i) {
                mIdMap.put(objects.get(i), i);
            }
        }

        @Override
        public long getItemId(int position) {
            String item = getItem(position);
            return mIdMap.get(item);
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

    }



    public void cumbreScreen(View view){
        Intent newScreen = new Intent(avisosActivity.this, menu.class);
        startActivity(newScreen);
    }

}
