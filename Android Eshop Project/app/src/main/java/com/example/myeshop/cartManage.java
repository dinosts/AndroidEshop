package com.example.myeshop;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;


/**
 * A simple {@link Fragment} subclass.
 */
public class cartManage extends Fragment implements RecyclerAdapter.OnItemListener {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<String> list ;
    private RecyclerAdapter adapter;
    private List<userCart> cart;
    private List<Item> items;
    private User user = MainActivity.myDatabase.theDao().findUser(UserMenuAct.idSave);

    public cartManage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cart_manage, container, false);

        recyclerView = v.findViewById(R.id.recycler1);// Ksekinaw diadikasia wste to recycler view na xtizete dinamika analoga ta cart items xristi tou db
        layoutManager =new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        cart = MainActivity.myDatabase.theDao().getCart(UserMenuAct.idSave);// pairnw to cart tou user
        int size= cart.size();//pairnw to size
        String[] itempreview =new String[size];//vazw ena String array gia na krataw ta onomata ton items
        for (int i=0;i<size;i++) // apo8ikevw ta names sto string array
        {
            Item item = MainActivity.myDatabase.theDao().findItem(cart.get(i).getCiid());
            itempreview[i] = cart.get(i).getQuantity()+" x "+item.getIname();
        }

        list = Arrays.asList(itempreview);
        adapter = new RecyclerAdapter(list, this);// ftiaxnw to adapter kai tou dinw tin lista me ta onomata kai to view gia to on item listener
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);// 8etw to adapter

        Button order = v.findViewById(R.id.orederbtn);

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int size= cart.size();
                if (!user.getAddress().matches(""))// an einai set to address tou user tote mpainei mesa alliws ton stelnei na to kanei set
                {
                    for (int i=0;i<size;i++)// koitaw an uparxei kapoio value sto cart poy na ksepernaei tin posotita ton items
                    {
                        Item item = MainActivity.myDatabase.theDao().findItem(cart.get(i).getCiid());
                        if (item.getQuantity()<cart.get(i).getQuantity())
                        {
                            Toast.makeText(getContext(), "Cant order more than "+item.getQuantity()+" "+item.getIname()+" .Please edit your order", Toast.LENGTH_LONG).show();
                            return;
                        }
                    }
                    int random;
                    do {
                        int min = 20;
                        int max = 1000;
                        random = new Random().nextInt((max - min) + 1) + min;
                        random = Integer.parseInt(random +""+ MainActivity.myDatabase.theDao().getMainTransactionCount());

                    }while(MainActivity.myDatabase.theDao().findMainTransaction(random)!=null);  // Ftiaxnw ena random ID

                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");// vriskw tin imerominia
                    LocalDateTime now = LocalDateTime.now();

                    MainTransaction mainTransaction= new MainTransaction(
                            random,
                            user.getId(),
                            dtf.format(now)
                    );  //ftiaxnw to antikimeno MainTransaction pou 8a apotelite apo alla itemTransactions, dinontas tou times me ton constructor tou
                    MainActivity.myDatabase.theDao().addMainTransaction(mainTransaction); // kanw insert sto db
                    for (int i=0;i<size;i++)
                    {

                        Item item = MainActivity.myDatabase.theDao().findItem(cart.get(i).getCiid());// psaxnw to item pou einai sto cart to apo8ikevw

                        Transaction transaction= new Transaction(
                                Integer.parseInt(random+""+i),
                                random,
                                cart.get(i).getCiid(),
                                cart.get(i).getQuantity()
                        ); // etimazw ena item transaction
                        MainActivity.myDatabase.theDao().addTransaction(transaction);// vazw to item transaction
                        item.setQuantity(item.getQuantity()-cart.get(i).getQuantity() );// aferw to item quantity pou eixe to item sto cart
                        MainActivity.myDatabase.theDao().updateItem(item);// kanw update to item
                        MainActivity.myDatabase.theDao().delCart(cart.get(i));// diagrafw to item apo to cart
                    }
                    Toast.makeText(getContext(), "All done order has been sent", Toast.LENGTH_LONG).show();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragmentContainer2, new cartManage()).commit();
                }
                else {
                    Toast.makeText(getContext(), "You have to set up your address first", Toast.LENGTH_LONG).show();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragmentContainer2, new accountManage()).commit();
                }
            }
        });


        return v;

    }

    @Override
    public void OnItemClick(final int position) { // otan kanw tap panw se item sto cart ginete enabled
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext()); // ftiaxnw ena alert dialog

        builder.setMessage("Are you sure you want to remove this item?") // vgazw minima
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) { // otan dialegei yes to diagrafei
                    userCart removefromcart = cart.get(position);// vriskw to cartitem
                    MainActivity.myDatabase.theDao().delCart(removefromcart);// to kanw remove
                        FragmentTransaction transaction = getFragmentManager().beginTransaction();
                        transaction.replace(R.id.fragmentContainer2, new cartManage()).commit();// kanw ena refresh wste na animero8ei to cart
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();// to kanw cancel
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();//kanw show
    }
}
