package com.example.estudiante.agenda.Preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.estudiante.agenda.Model.Contact;

/**
 * Created by Estudiante on 27/10/2015.
 */
public class CacheManager {
    private final static int PRIVATE_MODE = 0;
    private final static String PREF_NAME = "app.com.name.preferences";

    private SharedPreferences pref;
    private SharedPreferences.Editor mEditor;

    public CacheManager(Context context){
        this.pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        this.mEditor = pref.edit();
    }

    public void setUser(Contact contact){
        mEditor.putString(KeysShared.KEY_NAME, contact.getName());
        mEditor.putString(KeysShared.KEY_EMAIL, contact.getEmail());
        mEditor.putString(KeysShared.KEY_PHONE, contact.getPhone());
        mEditor.putString(KeysShared.KEY_CEL, contact.getCel());
        mEditor.putBoolean(KeysShared.KEY_FIRST, true);
        mEditor.commit();
                    }

    public Contact getUser(){

        String name = pref.getString(KeysShared.KEY_NAME, "");
        String email = pref.getString(KeysShared.KEY_EMAIL, "");
        String cel = pref.getString(KeysShared.KEY_CEL, "0");
        String phone = pref.getString(KeysShared.KEY_PHONE, "0");

        Contact c = new Contact(name, email, cel, phone);

        return c;
    }

    public boolean isLoggin(){
        return pref.getBoolean(KeysShared.KEY_FIRST, false);
    }


    class KeysShared{
        final static String KEY_NAME = "_name";
        final static String KEY_EMAIL = "_email";
        final static String KEY_CEL = "_cel";
        final static String KEY_PHONE = "_phone";
        final static String KEY_FIRST = "_first";
    }
}
