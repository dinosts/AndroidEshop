package com.example.myeshop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class deleteMenu extends Fragment implements View.OnClickListener {

    public deleteMenu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_delete_menu, container, false);
        Button b1=v.findViewById(R.id.deluser);
        Button b2=v.findViewById(R.id.delitems);
        Button b3=v.findViewById(R.id.deltrans);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);


        return v;
    }

    @Override
    public void onClick(View v) {
        EditText txt= getView().findViewById(R.id.idDel);
        switch (v.getId()) { // analogws tin epilogi koumpiou diagrafei to id pou dinete apo to antikimeno pou dialegete
            case(R.id.deluser):
                User user= MainActivity.myDatabase.theDao().findUser(txt.getText().toString());
                MainActivity.myDatabase.theDao().delUser(user);
                break;
            case(R.id.delitems):
                Item item= MainActivity.myDatabase.theDao().findItem(Integer.parseInt(txt.getText().toString()));
                MainActivity.myDatabase.theDao().delItem(item);
                break;
            case(R.id.deltrans):
                MainTransaction trans= MainActivity.myDatabase.theDao().findMainTransaction(Integer.parseInt(txt.getText().toString()));
                MainActivity.myDatabase.theDao().delTrans(trans);
                break;
        }
    }
}
