package com.example.myeshop;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class login extends Fragment implements View.OnClickListener {

    public login() {
        // Required empty public constructor
    }

    Button btn,btn2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        btn = view.findViewById(R.id.loginButton);// VAZW TA CLICK LISTENER STA BUTTONS
        btn2 = view.findViewById(R.id.signB);
        btn.setOnClickListener(this);
        btn2.setOnClickListener(this);
        return view;

    }

    public void onClick(View v) {

        FragmentTransaction transaction = getFragmentManager().beginTransaction();//KSEKINAW TRANSACTION



        switch (v.getId()) {
            case R.id.loginButton:
                EditText name = getView().findViewById(R.id.nameText);
                EditText pass = getView().findViewById(R.id.passText);


                User acc = MainActivity.myDatabase.theDao().findUser(name.getText().toString(), pass.getText().toString());// Psaxnei an uparxei o user
                if (acc!=null) {
                    Intent myIntent;
                    if (acc.isAdmin())//analogos an einai admin h oxi mpainei se sigekrimeno menu
                        myIntent = new Intent(v.getContext(), AdminMenuAct.class);
                    else
                        myIntent = new Intent(v.getContext(), UserMenuAct.class);
                    myIntent.putExtra("ID", acc.getId());//stelnw to id
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(myIntent);

                }
                else
                    Toast.makeText(getActivity(),"Not Found",Toast.LENGTH_LONG).show();
                break;
            case R.id.signB:
                transaction.replace(R.id.fragmentContainer, new signUp()).addToBackStack(null).commit();
        }

    }
}
