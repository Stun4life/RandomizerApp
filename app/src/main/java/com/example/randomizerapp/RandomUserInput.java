package com.example.randomizerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class RandomUserInput extends AppCompatActivity {

    TextView displayResults;

    Button randomizeBtn;

    EditText userInputs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_user_input);

        displayResults = findViewById(R.id.resultRandomDisplay);

        randomizeBtn = findViewById(R.id.buttonRandomizeUserInputs);

        userInputs = findViewById(R.id.userRandomInput);

        String output = "";

        if (!userInputs.getText().toString().equals("")) {
            Toast.makeText(this, "Please enter something to randomize", Toast.LENGTH_SHORT).show();
        }
        else {
            String userinput = userInputs.getText().toString().trim();
            String[] randomArray = userinput.split(",");
            ArrayList<String> randomArrayCheck = new ArrayList<String>();

            for (int i = 0; i < randomArray.length; i++) {
                int newIndex = new Random().nextInt(randomArray.length);
                randomArrayCheck.add(randomArray[newIndex]);
                int position = i + 1;
                for (int a = 0; a < randomArrayCheck.size(); a++) {
                    if (randomArrayCheck.get(a).equals(randomArray[newIndex])) {

                    }
                    else {
                        output += position + ": " +randomArray[newIndex] + "\n";
                    }
                }
            }
        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_flip_coin:
                Intent intentFlip = new Intent(RandomUserInput.this, FlipCoinActivity.class);
                startActivity(intentFlip);
                return true;
            case R.id.action_spin_wheel:
                Intent intentSpin = new Intent(RandomUserInput.this, SpinWheelActivity.class);
                startActivity(intentSpin);
                return true;
            case R.id.action_randomize_text:
                Intent intentRandomize = new Intent(RandomUserInput.this, RandomUserInput.class);
                startActivity(intentRandomize);
            case R.id.action_home:
                Intent intentHome = new Intent(RandomUserInput.this, MainActivity.class);
                startActivity(intentHome);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}