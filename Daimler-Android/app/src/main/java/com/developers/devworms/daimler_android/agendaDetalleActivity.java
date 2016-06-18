package com.developers.devworms.daimler_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class agendaDetalleActivity extends AppCompatActivity {

    String fechaCompuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda_detalle);

        String nombre = getIntent().getStringExtra("nombre");
        String salon = getIntent().getStringExtra("salon");
        String horario = getIntent().getStringExtra("horario");
        String codigo = getIntent().getStringExtra("codigo");
        String recomendaciones = getIntent().getStringExtra("recomendaciones");
        String fecha = getIntent().getStringExtra("fecha");

        TextView fechaCTV = (TextView)findViewById(R.id.fechaCompleta);
        TextView nombreTV = (TextView)findViewById(R.id.nombre);
        TextView salonTV = (TextView)findViewById(R.id.lugar);
        TextView horarioTV = (TextView)findViewById(R.id.horario);
        TextView codigoTV = (TextView)findViewById(R.id.recom);
        TextView oRecomTV = (TextView)findViewById(R.id.oRecom);

        if(fecha.equals("lunes"))
            fechaCompuesta = "Lunes 20 de Junio 2016 - ";
        else if(fecha.equals("martes"))
            fechaCompuesta = "Martes 21 de Junio 2016 - ";
        else if(fecha.equals("miercoles"))
            fechaCompuesta = "Miercoles 20 de Junio 2016 - ";

        fechaCTV.setText(fechaCompuesta);
        nombreTV.setText(nombre);
        salonTV.setText(salon);
        horarioTV.setText(horario);
        codigoTV.setText(codigo);
        oRecomTV.setText(recomendaciones);

    }
}
