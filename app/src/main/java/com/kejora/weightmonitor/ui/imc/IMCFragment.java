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

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_imc, container, false);
        tvIMC = rootView.findViewById(R.id.tv_imc);
        tvIMC.setText(getIMC());
        return rootView;
    }
    public String getIMC () {
        SharedPreferences sharedPref = getContext().getSharedPreferences("MyPref", 0);
        sharedPref.getInt("Edad",0);

        double imc = Math.round(sharedPref.getFloat("Peso",0) /
                Math.pow(sharedPref.getFloat("Altura",0),2));
        return Double.toString(imc);
    }
}
