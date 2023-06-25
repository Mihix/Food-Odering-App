package com.example.mobileapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileapp.Adapter.FoodListAdapter;
import com.example.mobileapp.Domain.FoodDomain;
import com.example.mobileapp.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterFoodList;
    private RecyclerView recyclerViewFood;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerview();
        bottomNavigation();
    }

    private void bottomNavigation() {
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout cartBtn = findViewById(R.id.cardBtn);

        homeBtn.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this,MainActivity.class));
            //In Android development, Intent is a class that represents an intention or an action to be performed. It is used to facilitate communication
            // between components of an Android application, such as activities, services, and broadcast receivers.
        });
    cartBtn.setOnClickListener(view -> startActivity(new Intent(MainActivity.this,CartActivity2.class)));
    }

    private void initRecyclerview() {
        ArrayList<FoodDomain> items = new ArrayList<>();
        items.add(new FoodDomain("Cheese Burger","Our food ordering app is the easiest\n " +
                "way to get delicious food delivered to your door. With our app,\n " +
                "you can browse a wide selection of restaurants, view menus,\n" +
                " and place orders with just a few taps. We offer fast and \n" +
                "reliable delivery, so you can enjoy your food in no time.","fast_1",15,20,120,4));
        items.add(new FoodDomain("Pizza Peperoni","Our food ordering app is" +
                " the easiest way to get delicious food delivered to your door." +
                " With our app, you can browse a wide selection of restaurants, view menus, and " +
                "place orders with just a few taps. We offer fast and reliable delivery, " +
                "so you can enjoy your food in no time.","fast_2",10,25,200,0));
        items.add(new FoodDomain("Vegetable Pizza","Our food ordering app is the easiest way" +
                " to get delicious food delivered to your door. With our app, " +
                "you can browse a wide selection of restaurants, view menus," +
                " and place orders with just a few taps. We offer fast and reliable delivery," +
                " so you can enjoy your food in no time.","fast_3",13,30,100,4.5));

        recyclerViewFood = findViewById(R.id.view1);
        recyclerViewFood.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        adapterFoodList = new FoodListAdapter(items);
        recyclerViewFood.setAdapter(adapterFoodList);

    }
}