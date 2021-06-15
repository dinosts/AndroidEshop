package com.example.myeshop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class accountManage extends Fragment implements View.OnClickListener {
    User user;

    public accountManage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_account_manage, container, false);
        user = MainActivity.myDatabase.theDao().findUser(UserMenuAct.idSave);
        TextView idtxt= v.findViewById(R.id.ID);
        TextView nametxt= v.findViewById(R.id.name);
        TextView addresstxt= v.findViewById(R.id.address);

        idtxt.setText(idtxt.getText()+" "+user.getId());// Vazw ta info tou account oste na fainontai
        nametxt.setText(nametxt.getText()+" "+user.getName());
        addresstxt.setText(addresstxt.getText()+" "+user.getAddress());
        Button btn = v.findViewById(R.id.updatebtn);
        btn.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        EditText editName = getView().findViewById(R.id.editname);
        EditText editPass = getView().findViewById(R.id.editPass);
        EditText editAddress = getView().findViewById(R.id.editAddress);
        if (editName.getText().toString().matches("") && editPass.getText().toString().matches("") && editAddress.getText().toString().matches(""))// An einai adio den kanw tipota kai enimerwnw
            Toast.makeText(getContext(),"Nothing Changed",Toast.LENGTH_LONG).show();
        else {
            if (!editName.getText().toString().matches(""))  // analoga oti exei content mesa to kanw update alliws den peirazete ka8olou
                user.setName(editName.getText().toString());
            if (!editPass.getText().toString().matches(""))
                user.setPass(editPass.getText().toString());
            if (!editAddress.getText().toString().matches(""))
                user.setAddress(editAddress.getText().toString());
            MainActivity.myDatabase.theDao().updateUser(user);

            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentContainer2, new accountManage()).commit(); // kanw ena refresh wste na mpoun ta values pou alaksan sta text pou ta kanoun fetch apo thn DB
        }

    }
}
