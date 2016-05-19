package com.developers.devworms.daimler_android;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.io.StringReader;


public class MainActivity extends AppCompatActivity {

    // Progress Dialog
    private ProgressDialog pDialog;

    //  Datos Usuario
    EditText nombre;
    EditText paterno;
    EditText materno;
    EditText mail;

    Spinner tipo;
    EditText puesto;
    EditText empresa;

    EditText contrasena;
    EditText repiteContrasena;

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

        //  Datos Usuario
        nombre = (EditText)findViewById(R.id.nombreText);
        paterno = (EditText)findViewById(R.id.apellidoPText);
        materno = (EditText)findViewById(R.id.apellidoMText);
        mail = (EditText)findViewById(R.id.mailText);

        tipo = (Spinner) findViewById(R.id.tipoSpinner);
        puesto = (EditText)findViewById(R.id.selecPuestoText);
        empresa = (EditText)findViewById(R.id.selecEmpresaText);

        contrasena = (EditText)findViewById(R.id.passText);
        repiteContrasena = (EditText)findViewById(R.id.cnfPassText);

        //  Vuelo
        vuelo_text = (EditText)findViewById(R.id.vueloText);
        horaLlegada_text = (EditText)findViewById(R.id.horaLlegadaText);
        spinnerDia = (Spinner)findViewById(R.id.spinnerDia);
        spinnerMes = (Spinner)findViewById(R.id.spinnerMes);
        spinnerAno = (Spinner)findViewById(R.id.spinnerAno);

        //  Hospedaje
        sencillo = (RadioButton)findViewById(R.id.sencilloBtn);
        doble = (RadioButton)findViewById(R.id.dobleBtn);
        acompanant = (EditText)findViewById(R.id.acompananteText);



        //  SPINNER TIPO
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
        String pass = contrasena.getText().toString();
        String rePass = repiteContrasena.getText().toString();


        if(pass.equals(rePass)) {
            new LoadAlbums().execute();
        }

        else    {

            Context context = getApplicationContext();
            CharSequence text = "Las contraseñas no coinciden";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

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


        String nombreStr = nombre.getText().toString();
        String patStr = paterno.getText().toString();
        String matStr = materno.getText().toString();
        String mailStr = mail.getText().toString();
        String tipoStr = tipo.getSelectedItem().toString();
        String puestoStr = puesto.getText().toString();
        String empresaStr = empresa.getText().toString();
        String vueloStr = vuelo_text.getText().toString();
        String diaStr = spinnerDia.getSelectedItem().toString();
        String mesStr = spinnerMes.getSelectedItem().toString();
        String anoStr = spinnerAno.getSelectedItem().toString();
        String horaStr = horaLlegada_text.getText().toString();
        String sencilloStr = sencillo.getText().toString();
        String dobleStr = doble.getText().toString();
        String acompStr = acompanant.getText().toString();
        String passStr = contrasena.getText().toString();

        /**
         * Before starting background thread Show Progress Dialog
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Registrando...");
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
            RequestBody body = RequestBody.create(mediaType, "{\n    'nombre' : '" + nombreStr + "',\n    \"a_paterno\" : " + patStr + ",\n    \"a_materno\" : " + matStr + ",\n    \"email\" : " + mailStr + ",\n    \"tipo\" : " + tipoStr + ",\n    \"puesto\" : " + puestoStr + ",\n    \"empresa\" : " + empresaStr + ",\n    \"translado\" : \"translado\",\n    \"llegada_vuelo\" : " + vueloStr + ",\n    \"dia\" : " + diaStr + ",\n    \"mes\" : " + mesStr + ",\n    \"ano\" : " + anoStr + ",\n    \"hora_llegada\" : " + horaStr + ",\n    \"hospedaje\" : \"Miércoles\",\n    \"tipo_habitacion\" : " + tipoStr + ",\n    \"nombre_acompanante\" : " + acompStr + ",\n    \"contrasena\" : " + passStr + "\n}");
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