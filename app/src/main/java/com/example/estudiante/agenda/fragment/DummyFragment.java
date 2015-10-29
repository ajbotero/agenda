package com.example.estudiante.agenda.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.estudiante.agenda.Model.Contact;
import com.example.estudiante.agenda.Preferences.CacheManager;
import com.example.estudiante.agenda.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Estudiante on 28/10/2015.
 */
public class DummyFragment extends Fragment {

    @Bind(R.id.tv_dummy)  TextView tvDummy;

    private CacheManager cacheManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cacheManager = new CacheManager(getContext());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_dummy, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Contact c = cacheManager.getUser();
        tvDummy.setText(c.getName());
    }
}
