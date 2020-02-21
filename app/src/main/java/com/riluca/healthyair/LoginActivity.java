package com.riluca.healthyair;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.riluca.healthyair.javabean.InterfaceMethods;

public class LoginActivity extends AppCompatActivity implements InterfaceMethods {

    private FirebaseAuth fbAuth;
    private FirebaseUser fbUser;

    EditText etEmail;
    EditText etPassword;

    String email;
    String password;

    Button btnLogin;
    Button btnRegis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        fbAuth = FirebaseAuth.getInstance();
        fbUser = fbAuth.getCurrentUser();

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        if(fbUser != null){
            etEmail.setText(fbUser.getEmail());
        }

        btnLogin = findViewById(R.id.buttonLoggin);
        btnRegis = findViewById(R.id.buttonRegister);

         //IMPORTANTE, TRAS LOGARSE OK LANZAR EL FRAGMENTO DE TIPSFRAGMENT
    }

    public void registrar(View view) {

        String msg = validarDatos();

        if (msg != null){
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        } else {
            fbAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        fbUser = fbAuth.getCurrentUser();
                        Toast.makeText(LoginActivity.this, getString(R.string.msg_registrado), Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(LoginActivity.this, getString(R.string.msg_no_registrado), Toast.LENGTH_LONG).show();
                    }

                }

            });

        }

    }

    public void acceder(View view) {

        String msg = validarDatos();

        if (msg != null){
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        } else {
            fbAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        fbUser = fbAuth.getCurrentUser();

                        etEmail.setText("");
                        etPassword.setText("");

                        lanzarFragment(new TipsFragment());

                    } else {
                        Toast.makeText(LoginActivity.this, getString(R.string.msg_no_accede), Toast.LENGTH_SHORT).show();
                    }

                }

            });

        }

    }

    private String validarDatos(){
        email = etEmail.getText().toString().trim();
        password = etPassword.getText().toString().trim();

        String msg = null;

        if (email.isEmpty() || password.isEmpty()){
            msg = getString(R.string.no_datos);
        }

        return msg;

    }

    private void lanzarFragment(Fragment fragmenLanzar) {
        //En el metodo que valide el login que lance el fragmento, para simular el tiempo le pongo un sleep
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
    public void llamarFrag(Fragment frag) {
        lanzarFragment(frag);
    }

    @Override
    public void pasarAlMap() {
        //Al pinchar Omitir o terminar los tips pasamos difectamente al MainActivity
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
