package com.example.stopchildabusetoday;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.stopchildabusetoday.R;



public class HomeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_home, container, false);
        ImageView view1= view.findViewById(R.id.imageChildAbuse);
        ImageView view2= view.findViewById(R.id.typesOfChildAbuses);
        ImageView view3= view.findViewById(R.id.childRights);
        ImageView view4= view.findViewById(R.id.videos);
        ImageView view5= view.findViewById(R.id.reportCase);
        ImageView view6= view.findViewById(R.id.learnMore);

        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Child_Abuses.class);

                startActivity(intent);
            }
        }); view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Types_Of_Child_Abuses.class);
                startActivity(intent);
            }
        });
        view3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Child_Rights.class);
                startActivity(intent);

            }

        });

        view4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Videos.class);
                startActivity(intent);
            }
        });

        view5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Report_case.class);
                startActivity(intent);
            }
        });
        view6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Learn_more.class);
                startActivity(intent);
            }
        });
        return view;
    }


}