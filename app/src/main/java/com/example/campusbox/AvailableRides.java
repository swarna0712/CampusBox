package com.example.campusbox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ProgressBar;
import android.view.View;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import android.os.Bundle;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.List;
import java.util.ArrayList;

public class AvailableRides extends AppCompatActivity {

    private RecyclerView postList;
    private FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    private RecyclerView recyclerView;
    private RidesAdapter adapter;
    private List<Display> rideList;
    private ProgressBar progressBar;
    private Button request;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_rides);

        progressBar = findViewById(R.id.progressbar);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        request = findViewById(R.id.requestBtn);

        postList = findViewById(R.id.all_users_post);
        postList.setHasFixedSize(true);
        postList.setLayoutManager(new LinearLayoutManager(this));

        rideList = new ArrayList<>();
        adapter = new RidesAdapter(this,rideList);

        postList.setAdapter(adapter);

        fStore.collection("Conveyance").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                progressBar.setVisibility(View.GONE);
                if(!queryDocumentSnapshots.isEmpty()){
                    List <DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();

                    for(DocumentSnapshot d: list){
                        Display p = d.toObject(Display.class);
                        rideList.add(p);

                    }

                    adapter.notifyDataSetChanged();
                }
            }
        });

    }
}
