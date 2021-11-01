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

public class Sleep_Activity extends AppCompatActivity {

    EditText lenghtEtxt;
    Button calc;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep);
        lenghtEtxt = findViewById(R.id.lenght_etxt_bloodvolume);
        calc = findViewById(R.id.calc_bloodvolume);
        result = findViewById(R.id.result_bloodvolume); //////// Hesham Work

        calc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int finalResult = 0;
                int lenghtValue = Integer.parseInt(lenghtEtxt.getText().toString());
                if (lenghtValue<8)
                {
                    finalResult = 8 - lenghtValue ;
                }
                result.setText("You Need to sleep for  " + String.valueOf(finalResult) + "Houre");
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                FirebaseDatabase fDatabase = FirebaseDatabase.getInstance();
                final DatabaseReference myref = fDatabase.getReference(user.getUid()).child("Sleeping Req");
                myref.push().setValue("sleeping time= " + finalResult);
            }
        });
    }

}
