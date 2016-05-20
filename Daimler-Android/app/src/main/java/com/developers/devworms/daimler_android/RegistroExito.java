package com.developers.devworms.daimler_android;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroExito extends AppCompatActivity {

    EditText campo;
    int campo_validacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_exito);

        campo = (EditText)findViewById(R.id.numValidText);

    }

    public void validarRegistro(View view){

        campo_validacion = Integer.parseInt(campo.getText().toString());

        if(campo_validacion == 8100 ||
                campo_validacion == 8105 ||
                campo_validacion == 4166 ||
                campo_validacion == 6738 ||
                campo_validacion == 1507 ||
                campo_validacion == 5083 ||
                campo_validacion == 2594 ||
                campo_validacion == 3324 ||
                campo_validacion == 8484 ||
                campo_validacion == 5847 ||
                campo_validacion == 7940 ||
                campo_validacion == 8301 ||
                campo_validacion == 4398 ||
                campo_validacion == 2173 ||
                campo_validacion == 2439 ||
                campo_validacion == 4056 ||
                campo_validacion == 8366 ||
                campo_validacion == 4112 ||
                campo_validacion == 8749 ||
                campo_validacion == 6343 ||
                campo_validacion == 6891 ||
                campo_validacion == 1938 ||
                campo_validacion == 4032 ||
                campo_validacion == 6599 ||
                campo_validacion == 8304 ||
                campo_validacion == 5655 ||
                campo_validacion == 7993 ||
                campo_validacion == 1409 ||
                campo_validacion == 6024 ||
                campo_validacion == 6564 ||
                campo_validacion == 2534 ||
                campo_validacion == 7037 ||
                campo_validacion == 3777 ||
                campo_validacion == 9844 ||
                campo_validacion == 4629 ||
                campo_validacion == 5624 ||
                campo_validacion == 2816 ||
                campo_validacion == 5442 ||
                campo_validacion == 8749 ||
                campo_validacion == 7592 ||
                campo_validacion == 2486 ||
                campo_validacion == 1644 ||
                campo_validacion == 8125 ||
                campo_validacion == 1337 ||
                campo_validacion == 1753 ||
                campo_validacion == 3157 ||
                campo_validacion == 8749 ||
                campo_validacion == 6707 ||
                campo_validacion == 5652 ||
                campo_validacion == 3116 ||
                campo_validacion == 2540 ||
                campo_validacion == 3116 ||
                campo_validacion == 8617 ||
                campo_validacion == 2040 ||
                campo_validacion == 7037 ||
                campo_validacion == 1976 ||
                campo_validacion == 3886 ||
                campo_validacion == 2730 ||
                campo_validacion == 8596 ||
                campo_validacion == 7567 ||
                campo_validacion == 7093 ||
                campo_validacion == 5389 ||
                campo_validacion == 4975 ||
                campo_validacion == 1713 ||
                campo_validacion == 1478 ||
                campo_validacion == 6571 ||
                campo_validacion == 8509 ||
                campo_validacion == 3318 ||
                campo_validacion == 6576 ||
                campo_validacion == 7854 ||
                campo_validacion == 3572 ||
                campo_validacion == 5165 ||
                campo_validacion == 8985 ||
                campo_validacion == 3011 ||
                campo_validacion == 9916 ||
                campo_validacion == 9385 ||
                campo_validacion == 3195 ||
                campo_validacion == 6218 ||
                campo_validacion == 3516 ||
                campo_validacion == 1914 ||
                campo_validacion == 2669 ||
                campo_validacion == 4708 ||
                campo_validacion == 8923 ||
                campo_validacion == 9061 ||
                campo_validacion == 9979 ||
                campo_validacion == 5481 ||
                campo_validacion == 3651 ||
                campo_validacion == 4949 ||
                campo_validacion == 6591 ||
                campo_validacion == 1096 ||
                campo_validacion == 5880 ||
                campo_validacion == 8130 ||
                campo_validacion == 5750 ||
                campo_validacion == 9507 ||
                campo_validacion == 7072 ||
                campo_validacion == 7521 ||
                campo_validacion == 1772 ||
                campo_validacion == 6422 ||
                campo_validacion == 4477 ||
                campo_validacion == 3948 ||
                campo_validacion == 2884 ||
                campo_validacion == 8085 ||
                campo_validacion == 8416 ||
                campo_validacion == 9422 ||
                campo_validacion == 6963 ||
                campo_validacion == 8213 ||
                campo_validacion == 5204 ||
                campo_validacion == 1591 ||
                campo_validacion == 5599 ||
                campo_validacion == 8309 ||
                campo_validacion == 3069 ||
                campo_validacion == 6861 ||
                campo_validacion == 6764 ||
                campo_validacion == 5311 ||
                campo_validacion == 5868 ||
                campo_validacion == 5327 ||
                campo_validacion == 7079 ||
                campo_validacion == 4210 ||
                campo_validacion == 9213 ||
                campo_validacion == 3876 ||
                campo_validacion == 4369 ||
                campo_validacion == 5479 ||
                campo_validacion == 2023 ||
                campo_validacion == 6180 ||
                campo_validacion == 5580 ||
                campo_validacion == 5270 ||
                campo_validacion == 5448 ||
                campo_validacion == 1760 ||
                campo_validacion == 5841 ||
                campo_validacion == 3177 ||
                campo_validacion == 2459 ||
                campo_validacion == 1055 ||
                campo_validacion == 9934 ||
                campo_validacion == 2195 ||
                campo_validacion == 9789 ||
                campo_validacion == 6254 ||
                campo_validacion == 3547 ||
                campo_validacion == 3638 ||
                campo_validacion == 3175 ||
                campo_validacion == 5476 ||
                campo_validacion == 2295 ||
                campo_validacion == 8599 ||
                campo_validacion == 4236 ||
                campo_validacion == 5126 ||
                campo_validacion == 5761 ||
                campo_validacion == 8460 ||
                campo_validacion == 6975 ||
                campo_validacion == 3176 ||
                campo_validacion == 7785 ||
                campo_validacion == 5471 ||
                campo_validacion == 5725 ||
                campo_validacion == 2269 ||
                campo_validacion == 4838 ||
                campo_validacion == 1711 ||
                campo_validacion == 4380 ||
                campo_validacion == 4239 ||
                campo_validacion == 7926 ||
                campo_validacion == 4706 ||
                campo_validacion == 6948 ||
                campo_validacion == 8771 ||
                campo_validacion == 5579 ||
                campo_validacion == 5012 ||
                campo_validacion == 4853 ||
                campo_validacion == 6336 ||
                campo_validacion == 5155 ||
                campo_validacion == 6822 ||
                campo_validacion == 1331 ||
                campo_validacion == 8273 ||
                campo_validacion == 6047 ||
                campo_validacion == 5233 ||
                campo_validacion == 1026 ||
                campo_validacion == 2877 ||
                campo_validacion == 2817 ||
                campo_validacion == 6414 ||
                campo_validacion == 8496 ||
                campo_validacion == 6754 ||
                campo_validacion == 9495 ||
                campo_validacion == 4612 ||
                campo_validacion == 1556 ||
                campo_validacion == 9503 ||
                campo_validacion == 5123 ||
                campo_validacion == 3673 ||
                campo_validacion == 1134 ||
                campo_validacion == 3884 ||
                campo_validacion == 7174 ||
                campo_validacion == 4874 ||
                campo_validacion == 5757 ||
                campo_validacion == 3861 ||
                campo_validacion == 7435 ||
                campo_validacion == 7859 ||
                campo_validacion == 6420 ||
                campo_validacion == 9889 ||
                campo_validacion == 7260 ||
                campo_validacion == 4181 ||
                campo_validacion == 8404 ||
                campo_validacion == 4297 ||
                campo_validacion == 2053 ||
                campo_validacion == 5385 ||
                campo_validacion == 5914 ||
                campo_validacion == 8216 ||
                campo_validacion == 8380 ||
                campo_validacion == 9760 ||
                campo_validacion == 9800 ||
                campo_validacion == 7348 ||
                campo_validacion == 9374 ||
                campo_validacion == 1483 ||
                campo_validacion == 7539 ||
                campo_validacion == 5231 ||
                campo_validacion == 4800 ||
                campo_validacion == 6702 ||
                campo_validacion == 6089 ||
                campo_validacion == 3118 ||
                campo_validacion == 8862 ||
                campo_validacion == 8742 ||
                campo_validacion == 2976 ||
                campo_validacion == 9581 ||
                campo_validacion == 6162 ||
                campo_validacion == 5776 ||
                campo_validacion == 6024 ||
                campo_validacion == 5850 ||
                campo_validacion == 4327 ||
                campo_validacion == 7636 ||
                campo_validacion == 8570 ||
                campo_validacion == 2093 ||
                campo_validacion == 4753 ||
                campo_validacion == 8697 ||
                campo_validacion == 7198 ||
                campo_validacion == 5641 ||
                campo_validacion == 5419 ||
                campo_validacion == 4550 ||
                campo_validacion == 9385 ||
                campo_validacion == 2982 ||
                campo_validacion == 4995 ||
                campo_validacion == 8118 ||
                campo_validacion == 3179 ||
                campo_validacion == 3181 ||
                campo_validacion == 5827 ||
                campo_validacion == 4376 ||
                campo_validacion == 6009 ||
                campo_validacion == 2300 ||
                campo_validacion == 8777 ||
                campo_validacion == 1119 ||
                campo_validacion == 7290 ||
                campo_validacion == 1521 ||
                campo_validacion == 1470 ||
                campo_validacion == 4608 ||
                campo_validacion == 5198 ||
                campo_validacion == 1013 ||
                campo_validacion == 6826 ||
                campo_validacion == 6504){

            Context context = getApplicationContext();
            CharSequence text = "Bienvenido";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            Intent registrarScreen = new Intent(RegistroExito.this, menu.class);
            startActivity(registrarScreen);

        }

        else{

            Context context = getApplicationContext();
            CharSequence text = "Código inválido";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        }

    }
}
