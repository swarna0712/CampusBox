package com.example.campusbox;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AllPosts extends AppCompatActivity {

    Button request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_posts);

        request = findViewById(R.id.requestBtn);

        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AllPosts.this, "REQUESTED!!!  Notification sent", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
