package com.android.elliotmiller.week2appem1974;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import fragments.SalesItemFullView;
import fragments.SalesItems;

public class MainActivity extends AppCompatActivity implements
        SalesItems.SalesItemsListener, SalesItemFullView.SalesItemFullViewInterface {

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
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_holder, SalesItemFullView.newInstance(id));
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void addToCart(int itemId) {
        Toast.makeText(this, "Add Item " + itemId + " to cart", Toast.LENGTH_SHORT).show();
    }
}
