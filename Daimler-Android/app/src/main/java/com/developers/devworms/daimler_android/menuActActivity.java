package com.developers.devworms.daimler_android;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class menuActActivity extends AppCompatActivity {

    List<menuPojo> list = new ArrayList<menuPojo>();
    String fechaCompuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_act);
        List<String> nombres = new ArrayList<String>();
        final ListView listview = (ListView) findViewById(R.id.listview);


        // consultar el jason
        String dia = getIntent().getStringExtra("dia");
        list = ApiRest.consultarListadoMenu(dia);

        TextView fechaCTV = (TextView)findViewById(R.id.fechaCompleta);

        if(dia.equals("lunes"))
            fechaCompuesta = "Lunes 20 de Junio 2016";
        else if(dia.equals("martes"))
            fechaCompuesta = "Martes 21 de Junio 2016";
        else if(dia.equals("miercoles"))
            fechaCompuesta = "Miercoles 20 de Junio 2016";

        fechaCTV.setText(fechaCompuesta);

        //***********************


        for (int i = 0; i< list.size(); i++){
            nombres.add(list.get(i).getNombre());
        }


        final StableArrayAdapter adapter = new StableArrayAdapter(this,
                android.R.layout.simple_list_item_1, nombres);

        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {

                Intent newScreen = new Intent(menuActActivity.this, agendaDetalleActivity
                        .class);
                newScreen.putExtra("nombre", list.get(position).getNombre());
                newScreen.putExtra("salon", list.get(position).getSalon());
                newScreen.putExtra("horario", list.get(position).getHorario());
                newScreen.putExtra("codigo", list.get(position).getCodigo());
                newScreen.putExtra("recomendaciones", list.get(position).getRecomendaciones());
                newScreen.putExtra("fecha", list.get(position).getFecha());
                startActivity(newScreen);

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
        Intent newScreen = new Intent(menuActActivity.this, agendaActivity.class);
        startActivity(newScreen);
    }
}
