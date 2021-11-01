package com.example.hesham.healthycare;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.step_counter.StepCounterMainActivity;
import com.example.step_counter.Tacker;
import com.example.quiz.QuizMainActivity;
import com.example.advice.AdviceMainActivity;
import com.example.push_trainning.activity.HomeActivity;
import com.example.push_trainning.activity.WelcomesplashActivity;
import com.example.alarmnotfication.AlarmMainActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView userInfoEmail;
    TextView userInfoName;
    String stepvalue = "hesham";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase fDatabase = FirebaseDatabase.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final DatabaseReference myref1 = fDatabase.getReference(user.getUid()).child("Step counter");

        Tacker.setOnIncrementListener(new Runnable() {
            @Override
            public void run() {
                stepvalue = String.valueOf(Tacker.getValue());
                myref1.setValue("step count=" + stepvalue);
            }
        });

        ///////////////////////////////////////////////////////////////////////////////////////
        //StepCounterMainActivity valuues = new StepCounterMainActivity();

        //stepvalue = String.valueOf(Tacker.getValue());
        //myref.setValue("stepcounter =" + stepvalue);
        //myref1.setValue("push =" + stepvalue);
        //////////////////////////////////////////////////////////////////////////////////////
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Chat bot : Coming Soon ;)", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    ////// Start Activites
    public void sTep_counter(View view) {
        Intent intent = new Intent(MainActivity.this, StepCounterMainActivity.class);
        startActivity(intent);
    }

    public void Alarm(View view) {
        Intent intent = new Intent(MainActivity.this, Notfication.class);
        startActivity(intent);
    }

    public void push_calculatr(View view) {
        Intent intent = new Intent(MainActivity.this, WelcomesplashActivity.class);
        startActivity(intent);
    }

    public void Advice(View view) {
        Intent intent = new Intent(MainActivity.this, AdviceMainActivity.class);
        startActivity(intent);
    }

    public void Quiz(View view) {
        Intent intent = new Intent(MainActivity.this, QuizMainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        userInfoEmail = (TextView) findViewById(R.id.email);
        userInfoName = (TextView) findViewById(R.id.name);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String email = user.getEmail();
        String name = user.getDisplayName();
        userInfoEmail.setText(email);
        userInfoName.setText("WELCOME");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(MainActivity.this, Aboutus.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent i = new Intent(MainActivity.this, BMI.class);
            startActivity(i);
        } else if (id == R.id.nav_gallery) {
            Intent i = new Intent(MainActivity.this, Water_Activity.class);
            startActivity(i);
        } else if (id == R.id.nav_slideshow) {
            Intent i = new Intent(MainActivity.this, Sleep_Activity.class);
            startActivity(i);
        } else if (id == R.id.nav_manage) {
            Intent i = new Intent(MainActivity.this, Ideal_Weight.class);
            startActivity(i);
        } else if (id == R.id.nav_send) {
            FirebaseAuth.getInstance().signOut();
            Intent i = new Intent(MainActivity.this, LoginActivity.class);
            Toast.makeText(getApplicationContext(), "Signing Out", Toast.LENGTH_SHORT).show();
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
            finish();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
