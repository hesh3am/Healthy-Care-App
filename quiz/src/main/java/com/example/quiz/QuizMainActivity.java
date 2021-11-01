package com.example.quiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuizMainActivity extends AppCompatActivity {
    Button b_ans1, b_ans2, b_ans3, b_ans4;
    ImageView flag;
    List<Country> list;
    int turn = 1;
    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_activity_main);
        r = new Random();
        flag = (ImageView) findViewById(R.id.imageView);
        b_ans1 = (Button) findViewById(R.id.b_ans1);
        b_ans2 = (Button) findViewById(R.id.b_ans2);
        b_ans3 = (Button) findViewById(R.id.b_ans3);
        b_ans4 = (Button) findViewById(R.id.b_ans4);
        list = new ArrayList<>();
        // Add all flags and names to the list.
        for (int i = 0; i < new Database().answers.length; i++) {
            list.add(new Country(new Database().answers[i], new Database().flags[i]));
        }
        // Shuffle the countries.

        newQuestion(turn);

        b_ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if the answer is correct.
                if (b_ans1.getText().toString().equalsIgnoreCase(list.get(turn - 1).getName())) {
                    // Check if the last question
                    if (turn < list.size()) {
                        turn++;
                        newQuestion(turn);
                    } else {
                        Toast.makeText(QuizMainActivity.this, "You finished,Your Eye is Perfect", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                } else {
                    Toast.makeText(QuizMainActivity.this, "You failed, you need a glass please go to the doctor", Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });

        b_ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if the answer is correct.
                if (b_ans2.getText().toString().equalsIgnoreCase(list.get(turn - 1).getName())) {
                    // Check if the last question
                    if (turn < list.size()) {
                        turn++;
                        newQuestion(turn);
                    } else {
                        Toast.makeText(QuizMainActivity.this, "You finished,Your Eye is Perfect", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                } else {
                    Toast.makeText(QuizMainActivity.this, "You failed, you need a glass please go to the doctor", Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });

        b_ans3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if the answer is correct.
                if (b_ans3.getText().toString().equalsIgnoreCase(list.get(turn - 1).getName())) {
                    // Check if the last question
                    if (turn < list.size()) {
                        turn++;
                        newQuestion(turn);
                    } else {
                        Toast.makeText(QuizMainActivity.this, "You finished,Your Eye is Perfect", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                } else {
                    Toast.makeText(QuizMainActivity.this, "You failed, you need a glass please go to the doctor", Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });

        b_ans4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if the answer is correct.
                if (b_ans4.getText().toString().equalsIgnoreCase(list.get(turn - 1).getName())) {
                    // Check if the last question
                    if (turn < list.size()) {
                        turn++;
                        newQuestion(turn);
                    } else {
                        Toast.makeText(QuizMainActivity.this, "You finished,Your Eye is Perfect", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                } else {
                    Toast.makeText(QuizMainActivity.this, "You failed, you need a glass please go to the doctor", Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });
    }

    private void newQuestion(int number) {
        // set flag image to the screen.
        flag.setImageResource(list.get(number - 1).getImage());
        // decide on which button to place the correct answer.
        int correct_answer = r.nextInt(4) + 1;
        int firstButton = number - 1;
        int secondButton;
        int thirdButton;
        int forthButton;

        switch (correct_answer) {
            case 1:
                b_ans1.setText(list.get(firstButton).getName());
                secondButton = firstButton + 1;
                thirdButton = firstButton + 2;
                forthButton = firstButton + 3;
                if (secondButton == 16)
                    secondButton = 0;
                if (thirdButton == 16)
                    thirdButton = 0;
                if (thirdButton == 17)
                    thirdButton = 1;
                if (forthButton == 16)
                    forthButton = 0;
                if (forthButton == 17)
                    forthButton = 1;
                if (forthButton == 18)
                    forthButton = 2;
                b_ans2.setText(list.get(secondButton).getName());
                b_ans3.setText(list.get(thirdButton).getName());
                b_ans4.setText(list.get(forthButton).getName());
                break;
            case 2:
                b_ans2.setText(list.get(firstButton).getName());
                secondButton = firstButton + 1;
                thirdButton = firstButton + 2;
                forthButton = firstButton + 3;
                if (secondButton == 16)
                    secondButton = 0;
                if (thirdButton == 16)
                    thirdButton = 0;
                if (thirdButton == 17)
                    thirdButton = 1;
                if (forthButton == 16)
                    forthButton = 0;
                if (forthButton == 17)
                    forthButton = 1;
                if (forthButton == 18)
                    forthButton = 2;
                b_ans1.setText(list.get(secondButton).getName());
                b_ans3.setText(list.get(thirdButton).getName());
                b_ans4.setText(list.get(forthButton).getName());
                break;
            case 3:
                b_ans3.setText(list.get(firstButton).getName());
                secondButton = firstButton + 1;
                thirdButton = firstButton + 2;
                forthButton = firstButton + 3;
                if (secondButton == 16)
                    secondButton = 0;
                if (thirdButton == 16)
                    thirdButton = 0;
                if (thirdButton == 17)
                    thirdButton = 1;
                if (forthButton == 16)
                    forthButton = 0;
                if (forthButton == 17)
                    forthButton = 1;
                if (forthButton == 18)
                    forthButton = 2;
                b_ans2.setText(list.get(secondButton).getName());
                b_ans1.setText(list.get(thirdButton).getName());
                b_ans4.setText(list.get(forthButton).getName());
                break;
            case 4:
                b_ans4.setText(list.get(firstButton).getName());
                secondButton = firstButton + 1;
                thirdButton = firstButton + 2;
                forthButton = firstButton + 3;
                if (secondButton == 16)
                    secondButton = 0;
                if (thirdButton == 16)
                    thirdButton = 0;
                if (thirdButton == 17)
                    thirdButton = 1;
                if (forthButton == 16)
                    forthButton = 0;
                if (forthButton == 17)
                    forthButton = 1;
                if (forthButton == 18)
                    forthButton = 2;
                b_ans2.setText(list.get(secondButton).getName());
                b_ans3.setText(list.get(thirdButton).getName());
                b_ans1.setText(list.get(forthButton).getName());
                break;
        }


    }
}
