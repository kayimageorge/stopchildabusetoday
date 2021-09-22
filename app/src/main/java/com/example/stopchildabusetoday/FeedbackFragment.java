package com.example.stopchildabusetoday;

import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.stopchildabusetoday.R;


public class FeedbackFragment extends Fragment {
    private EditText mEditTextTo;
    private EditText mEditTextSubject;
    private EditText mEditTextMessage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_feedback, container, false);


        mEditTextSubject=view.findViewById(R.id.edit_text_subject);
        mEditTextMessage=view.findViewById(R.id.edit_text_message);
        Button button=view.findViewById(R.id.button_send);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             sendMail();
            }
        });
        return view;
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