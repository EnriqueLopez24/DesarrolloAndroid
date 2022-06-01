package com.danielalvarez.formulario;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;

import java.util.regex.Pattern;

public class SegundaActivity extends AppCompatActivity {

    private EditText nombreEditText;
    private EditText correoEditText;
    private EditText telefonoEditText;

    private TextInputLayout nombreTextInputLayout;
    private TextInputLayout correoTextInputLayout;
    private TextInputLayout telefonoTextInputLayout;

    private RadioButton masculinoRadioButton;
    private RadioButton femeninoRadioButton;

    private CheckBox javaCheckBox;
    private CheckBox swiftCheckBox;
    private CheckBox csharpCheckBox;

    private Switch correosSwitch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        nombreEditText = (EditText) findViewById(R.id.nombreEditText);
        correoEditText = (EditText) findViewById(R.id.emailEditText);
        telefonoEditText = (EditText) findViewById(R.id.telefonoEditText);

        nombreTextInputLayout = (TextInputLayout) findViewById(R.id.nombreTextInputLayout);
        correoTextInputLayout = (TextInputLayout) findViewById(R.id.correoTextInputLayout);
        telefonoTextInputLayout = (TextInputLayout) findViewById(R.id.telefonoTextInputLayout);

        masculinoRadioButton = (RadioButton) findViewById(R.id.masculinoRadioButton);
        femeninoRadioButton = (RadioButton) findViewById(R.id.femeninoRadioButton);

        javaCheckBox = (CheckBox) findViewById(R.id.javaCheckBox);
        swiftCheckBox = (CheckBox) findViewById(R.id.swiftCheckBox);
        csharpCheckBox = (CheckBox) findViewById(R.id.csharpCheckBox);

        correosSwitch = (Switch) findViewById(R.id.correosSwitch);
    }

    public void enviarFormulario(View view) {

        String nombre = nombreEditText.getText().toString();
        String correo = correoEditText.getText().toString();
        String telefono = telefonoEditText.getText().toString();

        if (esNombreValido(nombre)) {

            if (esCorreoValido(correo)) {

                if (esTelefonoValido(telefono)) {

                    Log.i("MIFOR", nombre);
                    Log.i("MIFOR", correo);
                    Log.i("MIFOR", telefono);

                    if (masculinoRadioButton.isChecked()) {
                        Log.i("MIFOR", "Es masculino");
                    } else {
                        Log.i("MIFOR", "Es femenino");
                    }

                    Log.i("MIFOR", "Intereses");
                    if (javaCheckBox.isChecked()) {
                        Log.i("MIFOR", " Java");
                    }
                    if (swiftCheckBox.isChecked()) {
                        Log.i("MIFOR", " Swift");
                    }
                    if (csharpCheckBox.isChecked()) {
                        Log.i("MIFOR", " CSharp");
                    }

                    if (correosSwitch.isChecked()) {
                        Log.i("MIFOR", "Si enviar correos");
                    } else {
                        Log.i("MIFOR", "No enviar correos");
                    }
                    
                } else {
                    telefonoTextInputLayout.setError(getString(R.string.telefono_invalido));
                }

            } else {
                correoTextInputLayout.setError(getString(R.string.correo_invalido));
            }

        } else {
            nombreTextInputLayout.setError(getString(R.string.nombre_invalido));

//            Toast.makeText(getApplicationContext(), R.string.informacion_invalida, Toast.LENGTH_LONG).show();
        }

    }

    private boolean esNombreValido(String nombre) {
        Pattern patron = Pattern.compile("^[a-zA-Z ]+$");
        return patron.matcher(nombre).matches();
    }

    public boolean esTelefonoValido(String telefono) {
        return Patterns.PHONE.matcher(telefono).matches();
    }

    public boolean esCorreoValido(String correo) {
        return Patterns.EMAIL_ADDRESS.matcher(correo).matches();
    }

}