package com.example.randomizerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import rubikstudio.library.LuckyWheelView;
import rubikstudio.library.model.LuckyItem;

public class SpinWheelActivity extends AppCompatActivity {

    LuckyWheelView luckyWheelView;

    ArrayList<LuckyItem> arrayListItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spin_wheel);
        luckyWheelView = findViewById(R.id.LuckyWheel);

        arrayListItems = new ArrayList<>();

        LuckyItem luckyItem1 = new LuckyItem();
        luckyItem1.text = "0";
        luckyItem1.color = Color.parseColor("#8574F1");
        arrayListItems.add(luckyItem1);

        LuckyItem luckyItem2 = new LuckyItem();
        luckyItem2.text = "20";
        luckyItem2.color = Color.parseColor("#8574F1");
        arrayListItems.add(luckyItem2);

        LuckyItem luckyItem3 = new LuckyItem();
        luckyItem3.text = "40";
        luckyItem3.color = Color.parseColor("#8574F1");
        arrayListItems.add(luckyItem3);

        LuckyItem luckyItem4 = new LuckyItem();
        luckyItem4.text = "60";
        luckyItem4.color = Color.parseColor("#8574F1");
        arrayListItems.add(luckyItem4);

        luckyWheelView.setData(arrayListItems);
        luckyWheelView.setRound(getRandomRound());

        luckyWheelView.setLuckyRoundItemSelectedListener(new LuckyWheelView.LuckyRoundItemSelectedListener() {
            @Override
            public void LuckyRoundItemSelected(int index) {
                if (index == 1) {
                    Toast.makeText(SpinWheelActivity.this, "0 is Selected", Toast.LENGTH_SHORT).show();
                }
                else if (index == 2) {
                    Toast.makeText(SpinWheelActivity.this, "20 is Selected", Toast.LENGTH_SHORT).show();
                }
                else if (index == 3) {
                    Toast.makeText(SpinWheelActivity.this, "40 is Selected", Toast.LENGTH_SHORT).show();
                }
                else if (index == 4) {
                    Toast.makeText(SpinWheelActivity.this, "60 is Selected", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private int getRandomRound() {
        Random rand = new Random();
        return rand.nextInt(10)+ 15;
    }
    public void playGame(View v) {
        int index = getRandomIndex();
        luckyWheelView.startLuckyWheelWithTargetIndex(index);
    }
    private int getRandomIndex() {
        int[] intArray = new int[]{1,2,3,4};
        int rand = new Random().nextInt(intArray.length);
        return intArray[rand];
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_flip_coin:
                Intent intentFlip = new Intent(SpinWheelActivity.this, FlipCoinActivity.class);
                startActivity(intentFlip);
                return true;
            case R.id.action_spin_wheel:
                Intent intentSpin = new Intent(SpinWheelActivity.this, SpinWheelActivity.class);
                startActivity(intentSpin);
                return true;
            case R.id.action_randomize_text:
                Intent intentRandomize = new Intent(SpinWheelActivity.this, RandomUserInput.class);
                startActivity(intentRandomize);
            case R.id.action_home:
                Intent intentHome = new Intent(SpinWheelActivity.this, MainActivity.class);
                startActivity(intentHome);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}