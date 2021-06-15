package com.example.myeshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public static FragmentManager fragmentManager;
    public static myDatabase myDatabase;// thetw tin DB moy

    public static String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myDatabase = Room.databaseBuilder(getApplicationContext(), myDatabase.class ,"userDB").allowMainThreadQueries().build();// kanw initialize thn db

        setContentView(R.layout.activity_main);
        login frag = new login();
        frag.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, frag).commit();// vazw sto fragcontainer to frag gia na paw sto login()
    }
}
