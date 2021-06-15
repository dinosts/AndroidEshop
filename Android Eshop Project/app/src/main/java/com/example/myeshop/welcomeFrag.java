package com.example.myeshop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class welcomeFrag extends Fragment {

    public welcomeFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // apla ena starter fragment wste na min einai keno to container
        View v =inflater.inflate(R.layout.fragment_welcome, container, false);

        TextView txt = v.findViewById(R.id.welcometxt);
        txt.setText("Καλως ορισες "+ UserMenuAct.idSave);




        return v;
    }
}
