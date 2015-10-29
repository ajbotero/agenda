package com.example.estudiante.agenda.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.example.estudiante.agenda.MainActivity;
import com.example.estudiante.agenda.Model.Contact;
import com.example.estudiante.agenda.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Estudiante on 28/10/2015.
 */
public class FormFragment extends Fragment {

    @Bind(R.id.et_name)  EditText etName;
    @Bind(R.id.et_mail)  EditText etMail;
    @Bind(R.id.et_celular)  EditText etCelular;
    @Bind(R.id.et_phone)   EditText etPhone;

    private final String emailPattern = "[a-zA-Z0-9.-_]+@[a-z]+\\.+[a-z]+";
    boolean valid = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.form_fragment, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @OnClick(R.id.btn_guardar)
    public void clickLogin(View v) {
        valid = true;

        String name = etName.getText().toString().trim();
        String mail = etMail.getText().toString().trim();
        String celular = etCelular.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        //InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        //imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

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
                //Contact c = new Contact(name,mail,celular, phone);
                //cacheManager.setUser(c);

                //Intent i = new Intent(this, MainActivity.class);
                //startActivity(i);
                Snackbar snackbar = Snackbar.make(v, "TODO OK", Snackbar.LENGTH_LONG);
                snackbar.show();

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

