package com.example.myeshop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class adminMenuFrag extends Fragment implements View.OnClickListener {

    public adminMenuFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_admin_menu, container, false);

        Button insert = v.findViewById(R.id.insertBtn); // vazw ta click listener
        Button query = v.findViewById(R.id.querybtn);
        Button delete = v.findViewById(R.id.delbtn);
        query.setOnClickListener(this);
        insert.setOnClickListener(this);
        delete.setOnClickListener(this);
        return v;
        }

    @Override
    public void onClick(View v) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        switch(v.getId()) // analoga to koumpi pou 8a pati8ei pigainei sto katalilo menu
        {
            case (R.id.insertBtn):
                transaction.replace(R.id.fragmentContainer3, new insertMenu() ).addToBackStack(null).commit();
                break;
            case(R.id.delbtn):
                transaction.replace(R.id.fragmentContainer3, new deleteMenu() ).addToBackStack(null).commit();
                break;
            case(R.id.querybtn):
                transaction.replace(R.id.fragmentContainer3, new queryMenu() ).addToBackStack(null).commit();
                break;
        }
    }
}
