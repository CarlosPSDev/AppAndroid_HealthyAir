package com.riluca.healthyair;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.riluca.healthyair.javabean.InterfaceMethods;

public class LoginActivity extends AppCompatActivity implements InterfaceMethods {
    Button btnLogin;
    Button btnRegis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        btnLogin = findViewById(R.id.buttonLoggin);
        btnRegis = findViewById(R.id.buttonRegister);

        lanzarFragment(new TipsFragment()); //IMPORTANTE, TRAS LOGARSE OK LANZAR EL FRAGMENTO DE TIPSFRAGMENT
    }



    private void lanzarFragment(Fragment fragmenLanzar) {
        //En el metodo q valide el login q lance el fragmento, para simular el tiempo le pongo un sleep
        try {
            Thread.sleep(2300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        btnLogin.setVisibility(View.INVISIBLE);
        btnRegis.setVisibility(View.INVISIBLE);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.flContenedor, fragmenLanzar); //No hay que referenciar el fragment, aqui ya le das el id
        ft.addToBackStack(null); //Por si se da a retroceder q sepa q el fragmento tb esta
        ft.commit();
    }

    @Override
    public void llamarSiguienteFrag() {
        lanzarFragment(new TipsFrag2());
    }

    @Override
    public void pasarAlMap() {
        //Al pinchar Omitir o terminar los tips pasamos difectamente al MainActivity
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
