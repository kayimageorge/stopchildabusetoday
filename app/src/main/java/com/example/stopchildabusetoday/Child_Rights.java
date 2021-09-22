package com.example.stopchildabusetoday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Child_Rights extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_rights);
        getSupportActionBar().setTitle("Child Rights");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView textView=findViewById(R.id.nextButton);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChildRightsPart2();
            }
        });
    }
    public void openChildRightsPart2() {
        Intent intent = new Intent(this, Child_Rights2.class);
        startActivity(intent);
    }
}