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
public class insertMenu extends Fragment implements View.OnClickListener {

    public insertMenu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_insert_menu, container, false);

        Button ubtn = v.findViewById(R.id.Userin); // vazw ta onclick listener
        Button ibtn = v.findViewById(R.id.Itemin);
        Button tbtn = v.findViewById(R.id.Transactionin);
        Button itbtn = v.findViewById(R.id.ITransactionin);

        ubtn.setOnClickListener(this);
        ibtn.setOnClickListener(this);
        tbtn.setOnClickListener(this);
        itbtn.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        switch (v.getId()) // analogws tin epilogi pigainei se sigekrimeno insert fragment
        {
            case (R.id.Userin):
                transaction.replace(R.id.fragmentContainer3, new userInsert() ).addToBackStack(null).commit();
                break;
            case (R.id.Itemin):
                transaction.replace(R.id.fragmentContainer3, new itemInsert() ).addToBackStack(null).commit();
                break;
            case (R.id.Transactionin):
                transaction.replace(R.id.fragmentContainer3, new mainTransactionInsert() ).addToBackStack(null).commit();
                break;
            case (R.id.ITransactionin):
                transaction.replace(R.id.fragmentContainer3, new transactionItemInsert() ).addToBackStack(null).commit();
        }
    }
}
