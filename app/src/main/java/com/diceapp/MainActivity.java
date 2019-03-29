package com.diceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rollButton;
        rollButton = (Button) findViewById(R.id.roll_button);

        final ImageView leftDice = (ImageView) findViewById(R.id.image_left_dice);
        final ImageView rightDice = (ImageView) findViewById(R.id.image_right_dice);

        final TextView winText = (TextView) findViewById(R.id.win_text);
        winText.setVisibility(View.INVISIBLE);

        final int [] diceArray = {
                R.drawable.dice_1,
                R.drawable.dice_2,
                R.drawable.dice_3,
                R.drawable.dice_4,
                R.drawable.dice_5,
                R.drawable.dice_6,
        };

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("DiceApp","rollButton is pressed");
                Random randomNumber = new Random();
                int number = randomNumber.nextInt(6);

                Log.d("DiceApp","The random number is " + number);

                leftDice.setImageResource(diceArray[number]);

                int number2 = randomNumber.nextInt(6);

                rightDice.setImageResource(diceArray[number2]);

                if (number == 5 && number2 == 5){
                    winText.setVisibility(View.VISIBLE);
                } else {
                    winText.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}
