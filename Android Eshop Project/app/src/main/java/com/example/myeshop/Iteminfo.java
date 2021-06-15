package com.example.myeshop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class Iteminfo extends Fragment implements View.OnClickListener {

    public Iteminfo() {
        // Required empty public constructor
    }
    Item item = UserMenuAct.itemSave;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_iteminfo, container, false);
        Button btn = view.findViewById(R.id.addButton);
        TextView name= view.findViewById(R.id.ItemName);
        TextView info= view.findViewById(R.id.infoText);
        TextView quan= view.findViewById(R.id.kilatext);
        TextView price= view.findViewById(R.id.price);
        name.setText(item.getIname()); // Pairnw to item save apo to shop fragment opou einai to id tou item poy dialexthike kai enimerwnw ta TextView
        info.setText(item.getInfo());
        if (item.getQuantity()!=0)
            quan.setText(quan.getText().toString()+" "+item.getQuantity());
        else
            quan.setText(quan.getText().toString()+" Out Of Stock");

        price.setText(price.getText().toString()+" "+item.getPrice());
        btn.setOnClickListener(this);

        return view;

    }

    @Override
    public void onClick(View v) {
        EditText posotita = getView().findViewById(R.id.posotita);

        if (!posotita.getText().toString().matches("")) {   // An den einai keno to quantity pou dinete kai den einai miden oute megalitero tou itemQuan apo thn vash tote epitrepei kai to vazei sto cart
            int quan = Integer.parseInt(posotita.getText().toString());
            if (quan>0 && item.getQuantity() != 0 && item.getQuantity() >= quan ) {// prepei na dw8ei timi megaluterh tou midenos mikroterh apo to value tou item me proipo8esi oti to item quan den einai 0
                if (MainActivity.myDatabase.theDao().findItemInCart(item.getItid()) != null) {// an yparxei sto cart tote pros8etei thn posotita
                    userCart cart = MainActivity.myDatabase.theDao().findItemInCart(item.getItid());
                    cart.setQuantity(cart.getQuantity()+quan);
                    MainActivity.myDatabase.theDao().updateCartItem(cart);// Update tou cart afou pros8esi to quan
                    Toast.makeText(getContext(), "Updated cart item", Toast.LENGTH_LONG).show();
                } else {
                    userCart cart = new userCart(
                            MainActivity.myDatabase.theDao().getCartcount(UserMenuAct.idSave) + 1,
                            UserMenuAct.idSave,
                            item.getItid(),
                            quan
                    ); // kanei kainourio cart item kai to vazei db
                    MainActivity.myDatabase.theDao().addtocart(cart);
                    Toast.makeText(getContext(), "Added to cart", Toast.LENGTH_LONG).show();
                }

            } else
                Toast.makeText(getContext(), "Out of stock", Toast.LENGTH_LONG).show();
        }
        else
                Toast.makeText(getContext(), "Add value", Toast.LENGTH_LONG).show();
    }
}
