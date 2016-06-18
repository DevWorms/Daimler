package com.developers.devworms.daimler_android;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
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


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {

    // Progress Dialog
    private ProgressDialog pDialog;

    //  Datos Usuario
    EditText nombre;
    EditText paterno;
    EditText materno;
    EditText mail;
    EditText telefono;

    Spinner tipo;
    EditText puesto;
    EditText empresa;

    EditText contrasena;
    EditText repiteContrasena;

    // Traslado
    RadioButton siTras;

    // Hospedaje
    RadioButton siHosp;

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

    // Pago
    RadioButton pago;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  Datos Usuario
        nombre = (EditText)findViewById(R.id.nombreText);
        paterno = (EditText)findViewById(R.id.apellidoPText);
        materno = (EditText)findViewById(R.id.apellidoMText);
        mail = (EditText)findViewById(R.id.mailText);
        telefono = (EditText)findViewById(R.id.telefonoText);

        tipo = (Spinner) findViewById(R.id.tipoSpinner);
        puesto = (EditText)findViewById(R.id.selecPuestoText);
        empresa = (EditText)findViewById(R.id.selecEmpresaText);

        contrasena = (EditText)findViewById(R.id.passText);
        repiteContrasena = (EditText)findViewById(R.id.cnfPassText);

        //  Traslado
        siTras = (RadioButton)findViewById(R.id.siTrasBtn);

        //  Vuelo
        vuelo_text = (EditText)findViewById(R.id.vueloText);
        horaLlegada_text = (EditText)findViewById(R.id.horaLlegadaText);
        spinnerDia = (Spinner)findViewById(R.id.spinnerDia);
        spinnerMes = (Spinner)findViewById(R.id.spinnerMes);
        spinnerAno = (Spinner)findViewById(R.id.spinnerAno);

        //  Hospedaje
        siHosp = (RadioButton)findViewById(R.id.siHospBtn);
        sencillo = (RadioButton)findViewById(R.id.sencilloBtn);
        doble = (RadioButton)findViewById(R.id.dobleBtn);
        acompanant = (EditText)findViewById(R.id.acompananteText);

        //  Pago
        pago = (RadioButton)findViewById(R.id.pagoTarjetaBtn);


        //  SPINNER TIPO
            Spinner spinnerArea = (Spinner) findViewById(R.id.tipoSpinner);

            ArrayAdapter<CharSequence> adapterTipo = ArrayAdapter.createFromResource(this,
                    R.array.daimler_tipo_array, android.R.layout.simple_spinner_item);

            adapterTipo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerArea.setAdapter(adapterTipo);

            spinnerArea.setOnItemSelectedListener(this);


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

        if(pass.trim().length() == 0 || rePass.trim().length() == 0 ) {
            Context context = getApplicationContext();
            CharSequence text = "Ingresa contraseña";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

        else {

            if (pass.equals(rePass)) {
                new LoadAlbums().execute();
            } else {

                Context context = getApplicationContext();
                CharSequence text = "Las contraseñas no coinciden";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        }

    }


    public void trasladoFalse (View view) {
        vuelo_text.setEnabled(false);
        spinnerDia.setEnabled(false);
        spinnerMes.setEnabled(false);
        spinnerAno.setEnabled(false);
        horaLlegada_text.setEnabled(false);
    }

    public void trasladoTrue (View view) {
        vuelo_text.setEnabled(true);
        spinnerDia.setEnabled(true);
        spinnerMes.setEnabled(true);
        spinnerAno.setEnabled(true);
        horaLlegada_text.setEnabled(true);
    }

    public void hospedajeTrue (View view) {
        sencillo.setEnabled(true);
        doble.setEnabled(true);
        acompanant.setEnabled(true);
    }

    public void hospedajeFalse (View view) {
        sencillo.setEnabled(false);
        doble.setEnabled(false);
        acompanant.setEnabled(false);
    }

    public void acompananteTrue(View view){
        acompanant.setEnabled(true);
    }

    public void acompananteFalse(View view){
        acompanant.setEnabled(false);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        /*
            if(position == 0)    {
                puesto.setEnabled(true);
                empresa.setEnabled(true);
            }
            else {
                puesto.setEnabled(false);
                empresa.setEnabled(false);
            }
        */
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    class LoadAlbums extends AsyncTask<String, String, String> {


        String nombreStr = nombre.getText().toString();
        String patStr = paterno.getText().toString();
        String matStr = materno.getText().toString();
        String mailStr = mail.getText().toString();
        String telefonoStr = telefono.getText().toString();
        String tipoStr = tipo.getSelectedItem().toString();
        String puestoStr = puesto.getText().toString();
        String empresaStr = empresa.getText().toString();
        String vueloStr = vuelo_text.getText().toString();
        String diaStr = spinnerDia.getSelectedItem().toString();
        String mesStr = spinnerMes.getSelectedItem().toString();
        String anoStr = spinnerAno.getSelectedItem().toString();
        String horaStr = horaLlegada_text.getText().toString();
        String acompStr = acompanant.getText().toString();
        String passStr = contrasena.getText().toString();
        String translado;
        String hospedaje;
        String tipoHabitacion;
        String tipoPago;

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

            if(siTras.isChecked())
                translado = "Si";
            else
                translado = "No";

            if(siHosp.isChecked())
                hospedaje = "Si";
            else
                hospedaje = "No";

            if(sencillo.isChecked())
                tipoHabitacion = "Sencilla";
            else
                tipoHabitacion = "Doble";

            if(pago.isChecked())
                tipoPago = "Tarjeta";
            else
                tipoPago = "Transferencia";
        }

        /**
         * getting Albums JSON
         * */
        protected String doInBackground(String... args) {
            // Building Parameters
            OkHttpClient client = new OkHttpClient();

            MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
            RequestBody body = RequestBody.create(mediaType, "nombre=" + nombreStr + "&a_paterno=" + patStr + "&a_materno=" + matStr +
                    "&email=" + mailStr + "&tipo=" + tipoStr + "&puesto=" + puestoStr + "&empresa=" + empresaStr + "&translado=" + translado +
                    "&llegada_vuelo=" + vueloStr + "&dia=" + diaStr + "&mes=" + mesStr + "&ano=" + anoStr + "&hora_llegada=" + horaStr +
                    "&hospedaje=" + hospedaje + "&dias_hospedaje=" + "2" + "&tipo_habitacion=" + tipoHabitacion + "&nombre_acompanante=" + acompStr +
                    "&contrasena=" + passStr + "&pago=" + tipoPago + "&telefono=" + telefonoStr);
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