package com.example.hp.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import java.util.*;
import android.widget.Toast;
import android.content.Context;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    int answer1= R.id.first;
    String answer2 = "ALPHABET";
    String answer3= "GOA";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
        private boolean question1()
        { RadioGroup radio= findViewById(R.id.radio1);
            return radio.getCheckedRadioButtonId() == answer1;
        }

        private boolean question2() {
            CheckBox check11 =  findViewById(R.id.check1);
            CheckBox check21 =  findViewById(R.id.check2);
            CheckBox check31 =  findViewById(R.id.check3);
            CheckBox check41 =  findViewById(R.id.check4);
            CheckBox check51 =  findViewById(R.id.check5);

            if (check11.isChecked() && check21.isChecked() && !check31.isChecked()&& !check41.isChecked()&& check51.isChecked()) {
                return true;
            }
            return false;
        }
        private boolean question3() {
            EditText edittext = findViewById(R.id.text1);

            return edittext.getText().toString().equalsIgnoreCase(answer2);
        }

        private boolean question4() {
        EditText edittext = findViewById(R.id.text2);
        return edittext.getText().toString().equalsIgnoreCase(answer3);
    }

        public void check(View v) {
            ArrayList<String> incorrectList = new ArrayList<>();

            int correct = 0;
            int score=0;

            if( question1() ){
                correct++;
                score+=10;
            } else
                incorrectList.add("Question 1");

            if( question2() ){
                correct++;
                score+=10;
            } else {
                incorrectList.add("Question 2");
            }

            if( question3() ){
                correct++;  score+=10;
            } else {
                incorrectList.add("Question 3");
            }

            if( question4()){
                correct++;  score+=10;
            } else {
                incorrectList.add("Question 4");

            }

            StringBuilder sb = new StringBuilder();
            for (String s : incorrectList)
            {
                sb.append(s);
                sb.append("\n");
            }

            Context context = getApplicationContext();
            CharSequence text = "Number of Correct Answers " + correct + "\nScore:"+score+"\nRecheck the following:\n" + sb.toString();
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        }

