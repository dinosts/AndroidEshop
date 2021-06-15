package com.example.myeshop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class signUp extends Fragment implements View.OnClickListener {

    public signUp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        Button btn = view.findViewById(R.id.addUserbutton);
        btn.setOnClickListener(this);


        return view;


    }
    public void onClick(View v) {
        User newUser = new User(
                "admin",
                "1",
                "Kostas kosteglis",
                "papanagiotou 12",
                true);
        User newUser1 = new User(
                "user",
                "1",
                "Kostas kosteglis",
                "",
                false);
        MainActivity.myDatabase.theDao().addUser(newUser);
        MainActivity.myDatabase.theDao().addUser(newUser1);
        Item newItem = new Item(
                112334,
                "Laxana",
                "Laxanakia viologika",
                10,
                50);
        Item newItem2 = new Item(
                112314,
                "portokalia",
                "portokala viologika",
                15,
                10);
        MainActivity.myDatabase.theDao().addItem(newItem);
        MainActivity.myDatabase.theDao().addItem(newItem2);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, new login()).commit();
    }
}
