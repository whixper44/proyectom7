package com.kejora.weightmonitor.ui.imc;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.renderscript.Sampler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kejora.weightmonitor.R;

public class IMCFragment extends Fragment {
    private View rootView;
    private TextView tvIMC;
    private TextView tvPeso;
    SharedPreferences sharedPref;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_imc, container, false);
        sharedPref = getContext().getSharedPreferences("MyPref", 0);
        tvIMC = rootView.findViewById(R.id.tv_imc);
        tvPeso = rootView.findViewById(R.id.tv_ideal);
        tvIMC.setText(getIMC()); // Asignamos IMC al TextView
        tvPeso.setText(getPesoIdeal());
        return rootView;
    }
    // Método para calcular IMC
    public String getIMC () {

        // Recuperamos los valores desde SharedPreferences
        // IMC = Peso(Kg) / Altura(m2)
        double imc = sharedPref.getFloat("Peso",0) /
                Math.pow(sharedPref.getFloat("Altura",0),2);
        // Redondeamos a 2 decimales y pasamos a String
        return Double.toString(Math.round(imc*100.0)/100.0);
    }
    public String getPesoIdeal () {
        double peso;

        if (sharedPref.getString("Genero","").equals("Hombre")) {
            peso = (sharedPref.getFloat("Altura",0) *100 -100) * 0.9;
        } else {
            peso = (sharedPref.getFloat("Altura",0) *100 -100) * 0.85;
        }

       return Double.toString(peso);
    }
}
