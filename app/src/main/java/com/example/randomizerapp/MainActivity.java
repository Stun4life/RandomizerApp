package com.example.randomizerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_flip_coin:
                Intent intentFlip = new Intent(MainActivity.this, FlipCoinActivity.class);
                startActivity(intentFlip);
                return true;
            case R.id.action_spin_wheel:
                Intent intentSpin = new Intent(MainActivity.this, SpinWheelActivity.class);
                startActivity(intentSpin);
                return true;
            case R.id.action_randomize_text:
                Intent intentRandomize = new Intent(MainActivity.this, RandomUserInput.class);
                startActivity(intentRandomize);
            case R.id.action_home:
                Intent intentHome = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intentHome);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}