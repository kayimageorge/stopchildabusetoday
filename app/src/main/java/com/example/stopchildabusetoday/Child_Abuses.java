package com.example.stopchildabusetoday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Child_Abuses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_abuses);
        getSupportActionBar().setTitle("About Child Abuse");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView textView=findViewById(R.id.learnButton);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLearnmore();

            }
        });

    }
    public void openLearnmore(){
        Intent intent=new Intent(this,Learn_more.class);
        startActivity(intent);
    }
}