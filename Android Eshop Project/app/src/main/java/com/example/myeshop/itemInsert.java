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
public class itemInsert extends Fragment implements View.OnClickListener {

    public itemInsert() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_item_insert, container, false);

        Button ins = v.findViewById(R.id.uibtn2); // setting onclicklisteners
        Button up = v.findViewById(R.id.upibtn);
        up.setOnClickListener(this);
        ins.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        EditText id = getView().findViewById(R.id.insid);
        EditText name = getView().findViewById(R.id.insname);
        EditText info = getView().findViewById(R.id.insinfo);
        EditText price = getView().findViewById(R.id.insprice);
        EditText quan = getView().findViewById(R.id.insquan);
        switch (v.getId()){
            case(R.id.uibtn2):
                int idS=0;
                String nameS="";
                String infoS="";
                int priceS=0;
                int quanS=0;

                if (!id.getText().toString().matches("")) //an den einai empty diladi "" tote tous alazei to value
                    idS=Integer.parseInt(id.getText().toString());
                if (!name.getText().toString().matches(""))
                    nameS=name.getText().toString();
                if (!info.getText().toString().matches(""))
                    infoS=info.getText().toString();
                if (!price.getText().toString().matches(""))
                    priceS=Integer.parseInt(price.getText().toString());
                if (!quan.getText().toString().matches(""))
                    quanS=Integer.parseInt(quan.getText().toString());

                Item item = new Item(
                        idS,
                        nameS,
                        infoS,
                        priceS,
                        quanS
                );// ftiaxnei to item

                MainActivity.myDatabase.theDao().addItem(item);// anevazei to item db
                break;
            case(R.id.upibtn):
                Item item2 = MainActivity.myDatabase.theDao().findItem(Integer.parseInt(id.getText().toString()));//psaxnei to id kai gurnaei olokliro item
                if (!name.getText().toString().matches(""))// an uparxei value sta edittext tote alazei to item alliws den allazei
                    item2.setIname(name.getText().toString());
                if (!info.getText().toString().matches(""))
                    item2.setInfo(info.getText().toString());
                if (!quan.getText().toString().matches(""))
                    item2.setQuantity(Integer.parseInt(quan.getText().toString()));
                if (!price.getText().toString().matches(""))
                    item2.setPrice(Integer.parseInt(quan.getText().toString()));
                MainActivity.myDatabase.theDao().updateItem(item2);// to kanei update

        }
    }
}
