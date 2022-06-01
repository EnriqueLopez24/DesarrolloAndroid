package com.danielalvarez.formulario;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mostrarSnackbar(View view) {
        Snackbar.make(view, R.string.hola, Snackbar.LENGTH_LONG).show();
    }

    public void abrirFormularrio(View view) {
        Intent intent = new Intent(this, SegundaActivity.class);
        startActivity(intent);
    }
}