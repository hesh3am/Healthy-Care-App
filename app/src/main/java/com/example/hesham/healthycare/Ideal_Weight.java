package com.example.hesham.healthycare;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Ideal_Weight extends AppCompatActivity {

    EditText lenghtEtxt;
    RadioButton female, male;
    Button calc;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ideal_weight);
        lenghtEtxt = findViewById(R.id.lenght_etxt_bloodvolume);
        female = findViewById(R.id.female_radio_bloodvolume);
        male = findViewById(R.id.male_radio_bloodvolume);
        calc = findViewById(R.id.calc_bloodvolume);
        result = findViewById(R.id.result_bloodvolume); //////// Hesham Work

        calc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int finalResult = 0;

                int lenghtValue = Integer.parseInt(lenghtEtxt.getText().toString());

                finalResult =  lenghtValue - radioButtongender();
               result.setText("Result : " + String.valueOf(finalResult));
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                FirebaseDatabase fDatabase = FirebaseDatabase.getInstance();
                final DatabaseReference myref = fDatabase.getReference(user.getUid()).child("WorkIdealweight");
                myref.push().setValue("ideal weight= " + finalResult);
            }
        });
    }

    ///////////////////////////////////////////////////////////////////////////////////////////// Hesham
    public int radioButtongender() {
        int choice = 0;
        RadioButton male = (RadioButton) findViewById(R.id.male_radio_bloodvolume);
        boolean maleRadio = male.isChecked();
        if (maleRadio)
            return 90; /// return  number of male  example , return choice = xxxx ;
        else
            return 100; /// return  number of female  example , return choice = xxxx ;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////  Ending
}
