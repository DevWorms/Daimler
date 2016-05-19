package com.developers.devworms.daimler_android;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    // Progress Dialog
    private ProgressDialog pDialog;

    // Vuelo
    EditText vuelo_text;
    EditText horaLlegada_text;
    Spinner spinnerDia;
    Spinner spinnerMes;
    Spinner spinnerAno;


    //  Hospedaje
    RadioButton sencillo;
    RadioButton doble;
    EditText acompanant;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vuelo_text = (EditText)findViewById(R.id.vueloText);

        //  SPINNER AREA
            Spinner spinnerArea = (Spinner) findViewById(R.id.tipoSpinner);

            ArrayAdapter<CharSequence> adapterTipo = ArrayAdapter.createFromResource(this,
                    R.array.daimler_tipo_array, android.R.layout.simple_spinner_item);

            adapterTipo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerArea.setAdapter(adapterTipo);


        //  SPINNER TARJETA
            Spinner spinnerTarjeta = (Spinner) findViewById(R.id.tarjetaSpinner);

            ArrayAdapter<CharSequence> adapterTarjeta = ArrayAdapter.createFromResource(this,
                    R.array.tarjeta_tipo_array, android.R.layout.simple_spinner_item);

            adapterTipo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerTarjeta.setAdapter(adapterTarjeta);

        // SPINNER DIA
            spinnerDia = (Spinner) findViewById(R.id.spinnerDia);

            ArrayAdapter<CharSequence> adapterDia = ArrayAdapter.createFromResource(this,
                    R.array.dias, android.R.layout.simple_spinner_item);

            adapterDia.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerDia.setAdapter(adapterDia);

        // SPINNER MES
            spinnerMes = (Spinner) findViewById(R.id.spinnerMes);

            ArrayAdapter<CharSequence> adapterMes = ArrayAdapter.createFromResource(this,
                    R.array.mes, android.R.layout.simple_spinner_item);

            adapterMes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerMes.setAdapter(adapterMes);

        // SPINNER AÑO
            spinnerAno = (Spinner) findViewById(R.id.spinnerAno);

            ArrayAdapter<CharSequence> adapterAno = ArrayAdapter.createFromResource(this,
                    R.array.ano, android.R.layout.simple_spinner_item);

            adapterAno.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerAno.setAdapter(adapterAno);

    }

    public void moduloRegistro (View view){
        new LoadAlbums().execute();
    }


    public void trasladoFalse (View view) {
        vuelo_text.setFocusable(false);
        vuelo_text.setEnabled(false);

        spinnerDia.setFocusable(false);
        spinnerDia.setEnabled(false);

        spinnerMes.setFocusable(false);
        spinnerMes.setEnabled(false);

        spinnerAno.setFocusable(false);
        spinnerAno.setEnabled(false);

        horaLlegada_text.setFocusable(false);
        horaLlegada_text.setEnabled(false);

    }

    public void trasladoTrue (View view) {
        vuelo_text.setFocusable(true);
        vuelo_text.setEnabled(true);

        spinnerDia.setFocusable(true);
        spinnerDia.setEnabled(true);

        spinnerMes.setFocusable(true);
        spinnerMes.setEnabled(true);

        spinnerAno.setFocusable(true);
        spinnerAno.setEnabled(true);

        horaLlegada_text.setFocusable(true);
        horaLlegada_text.setEnabled(true);

    }

    public void hospedajeTrue (View view) {
        sencillo.setFocusable(true);
        sencillo.setEnabled(true);

        doble.setFocusable(true);
        doble.setEnabled(true);

        acompanant.setFocusable(true);
        acompanant.setEnabled(true);
    }

    public void hospedajeFalse (View view) {
        sencillo.setFocusable(false);
        sencillo.setEnabled(false);

        doble.setFocusable(false);
        doble.setEnabled(false);

        acompanant.setFocusable(false);
        acompanant.setEnabled(false);
    }


    class LoadAlbums extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread Show Progress Dialog
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Listing...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        /**
         * getting Albums JSON
         * */
        protected String doInBackground(String... args) {
            // Building Parameters
            OkHttpClient client = new OkHttpClient();

            MediaType mediaType = MediaType.parse("application/octet-stream");
            RequestBody body = RequestBody.create(mediaType, "{\n    'nombre' : 'Ricardo',\n    \"a_paterno\" : \"Rojas\",\n    \"a_materno\" : \"Mirón\",\n    \"email\" : \"mail@1234.com\",\n    \"tipo\" : \"Distribuidor\",\n    \"puesto\" : \"COO\",\n    \"empresa\" : \"UVG\",\n    \"translado\" : \"translado\",\n    \"llegada_vuelo\" : \"4444\",\n    \"dia\" : \"lunes\",\n    \"mes\" : \"febrero\",\n    \"ano\" : \"2016\",\n    \"hora_llegada\" : \"1250\",\n    \"hospedaje\" : \"Miércoles\",\n    \"tipo_habitacion\" : \"doble\",\n    \"nombre_acompanante\" : \"Salvador\",\n    \"contrasena\" : \"1234\"\n}");
            Request request = new Request.Builder()
                    .url("http://app-daimler.palindromo.com.mx/APP/registro.php")
                    .post(body)
                    .build();

            try {
                Response response = client.newCall(request).execute();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        /**
         * After completing background task Dismiss the progress dialog
         * **/
        protected void onPostExecute(String file_url) {
            // dismiss the dialog after getting all albums

            pDialog.dismiss();

            Intent registrarScreen = new Intent(MainActivity.this, RegistroExito.class);
            startActivity(registrarScreen);
        }

    }

}
