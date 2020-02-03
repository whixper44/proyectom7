package com.kejora.weightmonitor.ui.home;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.kejora.weightmonitor.R;


public class HomeFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    private View rootView;
    private TextView tvPeso;
    private TextView tvAltura;
    private TextView tvEdad;
    private EditText etPeso;
    private EditText etAltura;
    private EditText etEdad;
    private ImageButton bSubir;
    Spinner spinner;
    SharedPreferences sharedPref;

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
        sharedPref = getContext().getSharedPreferences("MyPref", 0);
        spinner = rootView.findViewById(R.id.gender_spinner);

// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.gender_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onClick(View v) {

        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putInt("Edad", Integer.valueOf(etEdad.getText().toString()));
        editor.putFloat("Altura", Float.valueOf(etAltura.getText().toString()));
        editor.putFloat("Peso", Integer.valueOf(etPeso.getText().toString()));
        editor.commit();

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String genero;
        SharedPreferences.Editor editor = sharedPref.edit();
        genero = parent.getSelectedItem().toString();
        editor.putString("Genero", genero);
        editor.commit();
    }
}