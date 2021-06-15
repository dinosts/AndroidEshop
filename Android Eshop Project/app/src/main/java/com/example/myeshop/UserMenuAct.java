package com.example.myeshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class UserMenuAct extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    public static Item itemSave;
    public static String idSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_menu);// diadikasia gia na valw to Navigation Drawer
        Bundle bundle = getIntent().getExtras();
        idSave = bundle.getString("ID");// pairnw to id pou dothike apo to login kai to apo8ikevw

        toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.DrawerLayout);
        navigationView = findViewById(R.id.navigation_view);

        welcomeFrag frag = new welcomeFrag();
        frag.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer2, frag).commit();// vazw ena arxiko fragment sto frag container



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.shop: // analogws tin epilogi pigainw sto sigekrimeno parathiro
                        menuItem.setChecked(true);
                        Toast.makeText(getApplicationContext(),"Heading to shop",Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawers();
                        shop frag = new shop();
                        frag.setArguments(getIntent().getExtras());
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer2, frag).commit();
                        return true;
                    case R.id.cart:
                        menuItem.setChecked(true);
                        Toast.makeText(getApplicationContext(),"Heading to cart",Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawers();
                        cartManage frag1 = new cartManage();
                        frag1.setArguments(getIntent().getExtras());
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer2, frag1).commit();
                        return true;
                    case R.id.account:
                        menuItem.setChecked(true);
                        Toast.makeText(getApplicationContext(),"Heading to account",Toast.LENGTH_LONG).show();
                        accountManage frag2 = new accountManage();
                        frag2.setArguments(getIntent().getExtras());
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer2, frag2).commit();
                        drawerLayout.closeDrawers();
                        return true;
                }
                return false;

            }
        });
    }
}
