package com.example.stopchildabusetoday;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;

import com.google.android.material.navigation.NavigationView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this
                , drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState==null) {

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                checkLanguage();
                break;
            case R.id.nav_help:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HelpFragment()).commit();
                checkLanguage();
                break;

            case R.id.nav_feedback:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FeedbackFragment()).commit();
                checkLanguage();
                break;

            case R.id.nav_privacy:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PolicyFragment()).commit();
                checkLanguage();
                break;

            case R.id.nav_terms:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new TermsFragment()).commit();
                checkLanguage();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }
    @Override
    public boolean onCreateOptionsMenu (Menu menu){

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.about) {
            Intent intent = new Intent(this, About.class);
            startActivity(intent);
            return true;
        }
       else if (id == R.id.cloud) {
            Intent intent = new Intent(this, Upload_Images.class);
            startActivity(intent);
            return true;
        }
        if (id== R.id.eng){
            Toast.makeText(this,"Language changed",Toast.LENGTH_SHORT).show();
            setLocale("");
            recreate();

        }
        else if (id==R.id.lug){
            Toast.makeText(this,"Language changed",Toast.LENGTH_SHORT).show();
            setLocale("fr");
            recreate();

        }
        else if (id==R.id.swahiri){
            Toast.makeText(this,"Language changed",Toast.LENGTH_SHORT).show();
            setLocale("sw");
            recreate();

        }
        else {
            setLocale("");
            recreate();

        }

        return super.onOptionsItemSelected(item);
    }
    public void setLocale(String language){
        Locale locale=new Locale(language);
        Locale.setDefault(locale);
        Configuration configuration=new Configuration();
        configuration.locale=locale;
        getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());

        SharedPreferences.Editor editor=getSharedPreferences("my_prefs", Context.MODE_PRIVATE).edit();
        editor.apply();
    }
    public void checkLanguage(){
        SharedPreferences preferences=getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
        String language=preferences.getString("language", "");
        setLocale(language);
    }

}