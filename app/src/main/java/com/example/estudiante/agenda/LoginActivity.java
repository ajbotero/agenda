package com.example.estudiante.agenda;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.example.estudiante.agenda.Model.Contact;
import com.example.estudiante.agenda.Preferences.CacheManager;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @Bind(R.id.et_name)
    EditText etName;
    @Bind(R.id.et_mail)
    EditText etMail;
    @Bind(R.id.et_celular)
    EditText etCelular;
    @Bind(R.id.et_phone)
    EditText etPhone;

    private CacheManager cacheManager;

    private final String emailPattern = "[a-zA-Z0-9.-_]+@[a-z]+\\.+[a-z]+";
    boolean valid = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        cacheManager = new CacheManager(this);
    }

    @OnClick(R.id.btn_login)
    public void clickLogin(View v) {
    valid = true;

        String name = etName.getText().toString().trim();
        String mail = etMail.getText().toString().trim();
        String celular = etCelular.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

        if (name.length() > 0 &&
                mail.length() > 0 &&
                (celular.length() > 0 || phone.length() > 0)) {
            if (name.length() < 4) {
                showError("El nombre debe tener 4 caracteres", v);
            } else if (!mail.matches(emailPattern)) {
                showError("El email es invalido", v);
            } else if (celular.length() > 0 && celular.length() != 10){
                    showError("No es un celular valido", v);
            } else if (phone.length() > 0 && phone.length() != 7){
                    showError("No es un telofono valido", v);
            }

            if (valid) {
                //paso todas las validaciones
                Contact c = new Contact(name,mail,celular, phone);
                cacheManager.setUser(c);

                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
            }

        }else {
            showError("Error todos los datos son requeridos", v);
        }
    }

    private void showError(String err, View v) {
        valid = false;
        Snackbar snackbar = Snackbar.make(v, err, Snackbar.LENGTH_LONG);
        snackbar.show();
    }

}
