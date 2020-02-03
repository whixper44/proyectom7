package com.kejora.weightmonitor.ui.estadisticas;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kejora.weightmonitor.R;

public class EstadisticasFragment extends Fragment {
    private View rootView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_estadisticas, container, false);
        //final TextView textView = rootView.findViewById(R.id.text_home);

        return rootView;
    }
}
