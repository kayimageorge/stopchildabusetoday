package com.example.stopchildabusetoday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Report_case extends AppCompatActivity {

    private EditText mEditTextTo;
    private EditText mEditTextSubject;
    private EditText mEditTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_case);

        getSupportActionBar().setTitle("Child Rights");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mEditTextSubject=findViewById(R.id.edit_text_subject);
        mEditTextMessage=findViewById(R.id.edit_text_message);
        Button buttonsend=findViewById(R.id.button_send);
        buttonsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMail();
            }
        });

    }
    private void sendMail(){

        String subject=mEditTextSubject.getText().toString();
        String message=mEditTextMessage.getText().toString();

        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("email"));
        String[] s={"kayimageorge42@gmail.com"};
        intent.putExtra(Intent.EXTRA_EMAIL,s);
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT,message);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"choose an email client"));

    }
}