package com.firstapp.jayden.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int int_random;//random number in global scope to be access everywhere

public void generateRandomNUmber() {//A function of generate new random number
    Random rand = new Random(); //instance of random class
    int num = 20;
    //generate random values from 0-20
    int_random = rand.nextInt(num)+1;//anwser random number
    }

public void resetButton(View view){//reset button onclick event
        generateRandomNUmber();
        Toast.makeText(this,"Random number has reset",Toast.LENGTH_SHORT).show();
    }

public void guessTheNumber(View view){//Guess number onclick event
// Don't create random number here otherwise it will keep re-generate a new random number on each click

        EditText editText =  (EditText) findViewById(R.id.guessNumberInput);//target input field
        String guessInputNumber = editText.getText().toString();//assign input value to variable
        int guessInputNumberInt = Integer.parseInt(guessInputNumber);//convert string to int

        String message;
        if(guessInputNumberInt > int_random)//guess number logic
        {
           message = "Too High";
        }
        else if(guessInputNumberInt < int_random)
        {
            message = "Too Low";
        }
        else{
            message = "Congrat";
            generateRandomNUmber();//after guess right then re-generate new random number
            editText.getText().clear();//Once guess the right number we empty the input field
        }
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
    @Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //create random number when App started to run
        generateRandomNUmber();
    }
}
