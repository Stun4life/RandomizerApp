package com.example.randomizerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class FlipCoinActivity extends AppCompatActivity {

    public static final Random randomNum = new Random();

    ImageView coin;

    Button flipCoinBtn;

    TextView flipCoinResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flip_coin);

        coin = findViewById(R.id.coinImage);
        flipCoinBtn = findViewById(R.id.flipCoinButton);
        flipCoinResult = findViewById(R.id.coinResultDisplay);

        flipCoinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipCoin();
            }
        });

    }
    private void flipCoin() {
        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator());
        fadeOut.setDuration(1000);
        fadeOut.setFillAfter(true);
        fadeOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                coin.setImageResource(randomNum.nextFloat() > 0.5f ? R.drawable.heads : R.drawable.heads);
                if (randomNum.nextFloat() > 0.5f) {
                    flipCoinResult.setText("Heads!");
                }
                else {
                    flipCoinResult.setText("Tails!");
                }
                Animation fadeIn = new AlphaAnimation(0,1);
                fadeIn.setInterpolator(new DecelerateInterpolator());
                fadeIn.setDuration(3000);
                fadeIn.setFillAfter(true);

                coin.startAnimation(fadeIn);
                flipCoinResult.startAnimation(fadeIn);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        flipCoinResult.startAnimation(fadeOut);
        coin.startAnimation(fadeOut);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_flip_coin:
                Intent intentFlip = new Intent(FlipCoinActivity.this, FlipCoinActivity.class);
                startActivity(intentFlip);
                return true;
            case R.id.action_spin_wheel:
                Intent intentSpin = new Intent(FlipCoinActivity.this, SpinWheelActivity.class);
                startActivity(intentSpin);
                return true;
            case R.id.action_randomize_text:
                Intent intentRandomize = new Intent(FlipCoinActivity.this, RandomUserInput.class);
                startActivity(intentRandomize);
            case R.id.action_home:
                Intent intentHome = new Intent(FlipCoinActivity.this, MainActivity.class);
                startActivity(intentHome);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}