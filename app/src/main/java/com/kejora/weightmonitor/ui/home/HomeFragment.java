package com.kejora.weightmonitor.ui.home;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.kejora.weightmonitor.R;
import com.kejora.weightmonitor.utils.Constant;


public class HomeFragment extends Fragment implements View.OnClickListener {

    private View rootView;
    private TextView tvPeso;
    private TextView tvAltura;
    private TextView tvEdad;
    private EditText etPeso;
    private EditText etAltura;
    private EditText etEdad;
    private ImageButton bSubir;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_home, container, false);
        tvPeso = rootView.findViewById(R.id.tv_peso);
        tvAltura = rootView.findViewById(R.id.tv_altura);
        tvEdad = rootView.findViewById(R.id.tv_edad);
        etPeso = rootView.findViewById(R.id.et_Peso);
        etAltura = rootView.findViewById(R.id.et_Altura);
        etEdad = rootView.findViewById(R.id.et_edad);
        bSubir = rootView.findViewById(R.id.ib_subir);
        bSubir.setOnClickListener(this);

       return rootView;
    }

    @Override
    public void onClick(View v) {
        SharedPreferences sharedPref = getContext().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putInt("Edad", Integer.valueOf(etEdad.getText().toString()));
        editor.putFloat("Altura", Float.valueOf(etAltura.getText().toString()));
        editor.putFloat("Peso", Integer.valueOf(etPeso.getText().toString()));
        editor.commit();
    }
}