package com.example.myeshop;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class shop extends Fragment implements RecyclerAdapter.OnItemListener {

    public shop() {
        // Required empty public constructor
    }
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<String> list ;
    private RecyclerAdapter adapter;
    List<Item> items;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_shop, container, false);

        recyclerView = view.findViewById(R.id.recycler); // Ksekinaw diadikasia wste to recycler view na xtizete dinamika analoga ta items tou dao
        layoutManager =new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        items = MainActivity.myDatabase.theDao().getItems();// pairnw ta items tou db
        int size= items.size();//vriskw size
        String[] itemarr =new String[size];// kanw String array gia to preview text pou 8a exoun ta koumpia tou recycler
        for (int i=0;i<size;i++)
        {
            itemarr[i]=items.get(i).getIname();
        }

        list = Arrays.asList(itemarr);// to kanw list to array
        adapter = new RecyclerAdapter(list, this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);// 8etw adapter
        return view;
    }

    @Override
    public void OnItemClick(int position) {
        UserMenuAct.itemSave=items.get(position);//analogos ti ginei clicked vazw to item wste na to exw apo8ikevmeno

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer2, new Iteminfo() ).commit();// vazw to item info frag sto frag container

    }
}
