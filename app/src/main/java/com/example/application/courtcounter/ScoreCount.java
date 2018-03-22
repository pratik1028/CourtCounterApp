package com.example.application.courtcounter;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class ScoreCount extends AppCompatActivity {
    private int quantity=0,quantity1=0;
    int end=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        Intent intent=getIntent();
        String player1=intent.getStringExtra("player1name");
        TextView textView1=(TextView)findViewById(R.id.player1);
        textView1.setText(player1);
        String player2=intent.getStringExtra("player2name");

        TextView textView2=(TextView)findViewById(R.id.player2);

        textView2.setText(player2);
    }

    public void submitOrder(View view){
        end=1;
        Intent intent=getIntent();
        String player1=intent.getStringExtra("player1name");
        String player2=intent.getStringExtra("player2name");
        TextView textView=(TextView)findViewById(R.id.price_text_view);
        if(quantity>quantity1){
            textView.setText("Winner is "+player1);
        }
        else if(quantity<quantity1){
            textView.setText("Winner is "+player2);
        }
        else
            textView.setText("It's a DRAW");
    }
    public void startNewGame(View view){
        end=0;
        Intent intent1=new Intent(this,MainActivity.class);
        startActivity(intent1);
        //finish();
    }
    public void increment(View view){
        if(end!=1){
        quantity++;
        display(quantity);}
        else{
            TextView quantityTextView=(TextView)findViewById(R.id.quantity_text_view);
            quantityTextView.setText("Start A New Game");
        }

    }
    public void decrement(View view){
        if(quantity>0&&end!=1){
            quantity--;
            display(quantity);
        }
        else{
            TextView quantityTextView=(TextView)findViewById(R.id.quantity_text_view);
            quantityTextView.setText("Start A New Game");
        }
    }
    public void increment1(View view){
        if(end!=1){
        quantity1++;
        display1(quantity1);
        }
        else{
                TextView quantityTextView=(TextView)findViewById(R.id.quantity_text_view1);
                quantityTextView.setText("Start A New Game");
            }

    }
    public void decrement1(View view){
        if(quantity1>0&&end!=1){
            quantity1--;
            display1(quantity1);
        }
        else{
            TextView quantityTextView=(TextView)findViewById(R.id.quantity_text_view1);
            quantityTextView.setText("Start A New Game");
        }
    }
    private void display(int number) {
        TextView quantityTextView=(TextView)findViewById(R.id.quantity_text_view);
        quantityTextView.setText(""+number);
    }
    private void display1(int number) {
        TextView quantityTextView=(TextView)findViewById(R.id.quantity_text_view1);
        quantityTextView.setText(""+number);
    }
    private void displayPrice(int number){
        TextView priceTextView=(TextView)findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    }


