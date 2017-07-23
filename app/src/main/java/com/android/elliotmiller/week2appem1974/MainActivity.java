package com.android.elliotmiller.week2appem1974;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import fragments.SalesItems;

public class MainActivity extends AppCompatActivity implements SalesItems.SalesItemsListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // add root fragment here
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fragment_holder, SalesItems.newInstance());
        ft.commit();
    }

    @Override
    public void selectItem(int id) {
        Toast.makeText(this, "You have selected item " + id, Toast.LENGTH_SHORT).show();
    }
}
