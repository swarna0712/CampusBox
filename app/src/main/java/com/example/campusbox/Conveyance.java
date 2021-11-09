package com.example.campusbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Conveyance extends AppCompatActivity {

    TextView post, rides, myrequest, request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conveyance);
        post = findViewById(R.id.postBtn);
        rides = findViewById(R.id.ridesBtn);
        request = findViewById(R.id.requestBtn);

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Post.class));
                finish();
            }
        });

        rides.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AvailableRides.class));
                finish();
            }
        });
    }
}
