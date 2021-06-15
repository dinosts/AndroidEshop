package com.example.myeshop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;


/**
 * A simple {@link Fragment} subclass.
 */
public class userInsert extends Fragment implements View.OnClickListener {

    public userInsert() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_user_insert, container, false);

        Button ins = v.findViewById(R.id.uibtn);
        Button upd = v.findViewById(R.id.uupbtn);
        ins.setOnClickListener(this);
        upd.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        EditText id = getView().findViewById(R.id.iuid);
        EditText pass = getView().findViewById(R.id.iupass);
        EditText name = getView().findViewById(R.id.iuname);
        EditText addr = getView().findViewById(R.id.iuaddr);
        Switch adminSw= getView().findViewById(R.id.switch1);
        switch(v.getId())
        {
            case(R.id.uibtn):
                String idS = "";
                String passS = "";
                String nameS = "";
                String addrS = "";
                boolean admin = false;
                if (!id.getText().toString().matches(""))//an den einai empty diladi "" tote tous alazei to value
                    idS = id.getText().toString();
                if (!pass.getText().toString().matches(""))
                    passS = pass.getText().toString();
                if (!name.getText().toString().matches(""))
                    nameS = name.getText().toString();
                if (!addr.getText().toString().matches(""))
                    addrS = addr.getText().toString();
                if (adminSw.isChecked())
                    admin = true;

                User user = new User(
                        idS,
                        passS,
                        nameS,
                        addrS,
                        admin
                );

                MainActivity.myDatabase.theDao().addUser(user);// anevazei to user sto db
                break;
            case(R.id.uupbtn):
                User user2 = MainActivity.myDatabase.theDao().findUser(id.getText().toString());//psaxnei to id kai gurnaei olokliro user
                if (!name.getText().toString().matches(""))// an uparxei value sta edittext tote alazei to item alliws den allazei
                    user2.setName(name.getText().toString());
                if (!pass.getText().toString().matches(""))
                    user2.setPass(pass.getText().toString());
                if (!addr.getText().toString().matches(""))
                    user2.setAddress(addr.getText().toString());
                    user2.setAdmin(adminSw.isChecked());
                MainActivity.myDatabase.theDao().updateUser(user2);// to kanei update
        }
    }
}
