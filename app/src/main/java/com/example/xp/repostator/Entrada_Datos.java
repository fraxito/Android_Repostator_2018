package com.example.xp.repostator;

import android.app.Activity;
import android.app.Fragment;

import android.os.Bundle;
import android.app.FragmentTransaction;

public class Entrada_Datos extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrada__datos);

        Fragment fragmento = new Repostaje();
        FragmentTransaction cambio = getFragmentManager().beginTransaction();
        cambio.replace(R.id.marcoInicial, fragmento);
        cambio.commit();
    }
}
