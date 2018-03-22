package com.example.application.courtcounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    /*public static final String EXTRA_MESSAGE="com.example.application.courtcounter";
    public static final String EXTRA_MESSAGE1="com.example.application.courtcounter";*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Start(View view){
        Intent intent=new Intent(this,ScoreCount.class);
        EditText editText1=(EditText)findViewById(R.id.editText1);
        EditText editText2=(EditText)findViewById(R.id.editText2);
        String player1=editText1.getText().toString();
        String player2=editText2.getText().toString();
        intent.putExtra("player1name", player1);
        intent.putExtra("player2name", player2);
        startActivity(intent);
    }
}
