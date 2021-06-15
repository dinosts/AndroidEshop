package com.example.myeshop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class queryMenu extends Fragment implements View.OnClickListener {

    public queryMenu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_query_menu, container, false);

        Button userq= v.findViewById(R.id.userQuery);
        Button itemq= v.findViewById(R.id.itemQuery);
        Button transq= v.findViewById(R.id.transQuery);
        Button sales= v.findViewById(R.id.sales);

        userq.setOnClickListener(this);
        itemq.setOnClickListener(this);
        transq.setOnClickListener(this);
        sales.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        TextView txt = getView().findViewById(R.id.apotelesmaq);
        txt.setText("");
        switch (v.getId())
        {
            case (R.id.userQuery): // analogos thn epilogi fernei to query
                List<User> users = MainActivity.myDatabase.theDao().getUsers();//guranei lista users kai emfanizei pio katw
                for (User i:users)
                    txt.setText(txt.getText().toString()+"ID: "+i.getId()+" Pass:"+i.getPass()+" Name:"+i.getName()+" Addr:"+i.getAddress()+"\n\r\n\r");
                break;
            case (R.id.itemQuery):
                List<Item> items = MainActivity.myDatabase.theDao().getItems();//guranei lista items kai emfanizei pio katw me to sales extra pou pros8eti oti ItemTransactionQuantity uparxei gia to ka8e item
                for (Item i:items)
                    txt.setText(txt.getText().toString()+"ID: "+i.getItid()+" Name:"+i.getIname()+" Info:"+i.getInfo()+" Quan:"+i.getQuantity()+" Price:"+i.getPrice()+"Sold:"+MainActivity.myDatabase.theDao().getItemSales(i.getItid())+"\r\n\r\n");
                break;
            case(R.id.transQuery):
                List<MainTransaction> list = MainActivity.myDatabase.theDao().getMainTransactions();//guranei lista MainTransaction kai emfanizei pio katw to id tis kai ta items tis
                for (MainTransaction i:list)
                {
                    txt.setText(txt.getText().toString()+"Trans:"+i.getId()+" User: "+i.getTuid()+" Date: "+i.getTdate()+"\n\rItems:\n\r");
                    List<Transaction> list2 = MainActivity.myDatabase.theDao().getTransactionItems(i.getId());
                    for (Transaction j:list2)
                    {
                        txt.setText(txt.getText().toString()+"itemTransId: "+j.getId()+"| "+j.getIquant()+"x"+MainActivity.myDatabase.theDao().findItem(j.getTiid()).getIname()+"(item id: "+j.getTiid()+")\n\r");
                    }

                }
                txt.setText(txt.getText().toString()+"\n\r");
                break;
            case(R.id.sales):
                List<Item> items1 = MainActivity.myDatabase.theDao().getItems(); //guranei lista items kai emfanizei pio katw to kathe item transaction pou uparxei gia to ka8e item
                for (Item i:items1) {
                    List<Transaction> transaction = MainActivity.myDatabase.theDao().getTransactionItemSearch(i.getItid());
                    txt.setText(txt.getText().toString()+i.getItid()+" "+i.getIname()+" Sales: \n\r");
                    for (Transaction j:transaction)
                        txt.setText(txt.getText().toString()+"itemTransId: "+j.getId()+"| "+j.getIquant()+"x"+MainActivity.myDatabase.theDao().findItem(j.getTiid()).getIname()+")\n\r");

                    txt.setText(txt.getText().toString() + "");

                }
        }
    }
}
