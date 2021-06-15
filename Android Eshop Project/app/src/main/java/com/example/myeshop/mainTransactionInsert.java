package com.example.myeshop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * A simple {@link Fragment} subclass.
 */
public class mainTransactionInsert extends Fragment implements View.OnClickListener {

    public mainTransactionInsert() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main_transaction_insert, container, false);

        Button btn = v.findViewById(R.id.uibtn3);
        Button btn2 = v.findViewById(R.id.tupbtn);
        btn.setOnClickListener(this);
        btn.setOnClickListener(this);

        return v;
    }


    @Override
    public void onClick(View v) {
        EditText id = getView().findViewById(R.id.tidins);
        EditText tuid = getView().findViewById(R.id.tuidins);
        int idS = 0;
        String tuidS = "";

        switch (v.getId()) {
            case (R.id.uibtn3):
                if (!id.getText().toString().matches(""))//an den einai empty diladi "" tote tous alazei to value
                    idS = Integer.parseInt(id.getText().toString());
                if (!tuid.getText().toString().matches(""))
                    tuidS = tuid.getText().toString();

                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();// vriskei imerominia

                MainTransaction mainTransaction = new MainTransaction(
                        idS,
                        tuidS,
                        dtf.format(now)
                );

                MainActivity.myDatabase.theDao().addMainTransaction(mainTransaction);//kanei insert

            case (R.id.tupbtn):
                MainTransaction mainTransaction1 = MainActivity.myDatabase.theDao().findMainTransaction(Integer.parseInt(id.getText().toString()));// psaxnei to maintransaction meso id
                if (!tuid.getText().toString().matches(""))// an uparxei value sta edittext tote alazei to maintransaction alliws den allazei
                    mainTransaction1.setTuid(tuid.getText().toString());
                MainActivity.myDatabase.theDao().updateTransaction(mainTransaction1);//kanei update
        }
    }
}
