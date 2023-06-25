package com.example.mobileapp.Activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.mobileapp.Domain.FoodDomain;
import com.example.mobileapp.Helper.ManagmentCart;
import com.example.mobileapp.R;

public class DetailActivty extends AppCompatActivity {
    private Button addToCartBtn;
    private TextView plusBtn, minusBtn,titleTxt,feeTxt,descriptionTxt,numberOderTxt,startTxt,caloryTxt,timeTxt;
    private ImageView picFood;
    private FoodDomain object;
    private int numberOrder = 1;
    private ManagmentCart managmentCart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_activty);

        managmentCart = new ManagmentCart(DetailActivty.this);

        initView();
        getBundle();

    }
    private void getBundle(){
        object = (FoodDomain) getIntent().getSerializableExtra("object");
         int drawableResourceId = this.getResources().getIdentifier(object.getPicUrl(),"drawable",this.getPackageName());

        Glide.with(this)
                .load(drawableResourceId)
                .into(picFood);
        titleTxt.setText(object.getTitle());
        feeTxt.setText("$"+object.getPrice());
        descriptionTxt.setText(object.getDescription());
        numberOderTxt.setText("" +numberOrder);
        caloryTxt.setText(object.getEnergy()+ "Cal");
        startTxt.setText(object.getScore()+"");
        timeTxt.setText(object.getTime()+"min");
        addToCartBtn.setText("Add to cart - $"+Math.round(numberOrder*object.getPrice()));

        plusBtn.setOnClickListener(view -> {
            numberOrder =  numberOrder +1;
            numberOderTxt.setText("" +numberOrder);
            addToCartBtn.setText("Add to cart - $"+Math.round(numberOrder*object.getPrice()));

        });
        minusBtn.setOnClickListener(view -> {
            numberOrder =  numberOrder -1;
            numberOderTxt.setText("" +numberOrder);
            addToCartBtn.setText("Add to cart - $"+Math.round(numberOrder*object.getPrice()));

        });

        addToCartBtn.setOnClickListener(view -> {
            object.setNumberinCarl(numberOrder);
            managmentCart.insertFood(object);
        });
    }

    private void initView() {
        addToCartBtn = findViewById(R.id.addToCartBtn);
        timeTxt =  findViewById(R.id.timeTxt);
        feeTxt = findViewById(R.id.priceTxt);
        titleTxt = findViewById(R.id.titleTxt);
        descriptionTxt= findViewById(R.id.descriptionTxt);
        numberOderTxt = findViewById(R.id.numberItemTxt);
         plusBtn = findViewById(R.id.plusCartBtn);
         minusBtn=findViewById(R.id.MinusCartBtn);
         picFood = findViewById(R.id.foodPic);
         startTxt = findViewById(R.id.StarTxt);
         caloryTxt = findViewById(R.id.calTxt);
    }
}