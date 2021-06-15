package com.example.myeshop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class transactionItemInsert extends Fragment implements View.OnClickListener {


    public transactionItemInsert() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_transaction_item_insert, container, false);

        Button b1 = v.findViewById(R.id.uittbtn);
        Button b2 = v.findViewById(R.id.tiupbtn);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);


        return v;
    }

    @Override
    public void onClick(View v) {
        EditText id = getView().findViewById(R.id.itid);
        EditText mainid = getView().findViewById(R.id.mainitid);
        EditText iid = getView().findViewById(R.id.ititid);
        EditText quan = getView().findViewById(R.id.itquan);

        switch(v.getId()) {
            case(R.id.uittbtn):
                int idS = 0;
                int mainidS = 0;
                int iidS = 0;
                int quanS = 0;
                if (!id.getText().toString().matches(""))//an den einai empty diladi "" tote tous alazei to value
                    idS = Integer.parseInt(id.getText().toString());
                if (!mainid.getText().toString().matches(""))
                    mainidS = Integer.parseInt(mainid.getText().toString());
                if (!iid.getText().toString().matches(""))
                    iidS = Integer.parseInt(iid.getText().toString());
                if (!quan.getText().toString().matches(""))
                    quanS = Integer.parseInt(quan.getText().toString());
                Transaction transaction = new Transaction(
                        idS,
                        mainidS,
                        iidS,
                        quanS
                );
                MainActivity.myDatabase.theDao().addTransaction(transaction);// anevazei to itemtransaction sto db
                break;
            case(R.id.tiupbtn):
                Transaction transaction1 = MainActivity.myDatabase.theDao().findItemTransaction(Integer.parseInt(id.getText().toString()));//psaxnei to id kai gurnaei olokliro item tou Transaction
                if (!id.getText().toString().matches(""))// an uparxei value sta edittext tote alazei to item Transaction alliws den allazei
                    transaction1.setId(Integer.parseInt(id.getText().toString()));
                if (!mainid.getText().toString().matches(""))
                    transaction1.setMainid(Integer.parseInt(mainid.getText().toString()));
                if (!iid.getText().toString().matches(""))
                    transaction1.setTiid(Integer.parseInt(iid.getText().toString()));
                if (!id.getText().toString().matches(""))
                    transaction1.setIquant(Integer.parseInt(quan.getText().toString()));
                MainActivity.myDatabase.theDao().updatetransactionItem(transaction1);// kanei update
        }
    }
}
