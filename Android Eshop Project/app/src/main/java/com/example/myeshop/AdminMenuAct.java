package com.example.myeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AdminMenuAct extends AppCompatActivity {
    String idSave ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);



        Bundle bundle = getIntent().getExtras();
        idSave = bundle.getString("ID");//pairnw to id se periptosh pou xreiastw sto melon to id tou account

        adminMenuFrag frag = new adminMenuFrag();
        frag.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer3, frag).commit();// vazw sto fragment container to frag admin menu

    }
}
