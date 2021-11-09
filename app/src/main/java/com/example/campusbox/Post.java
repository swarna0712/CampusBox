package com.example.campusbox;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import javax.annotation.Nullable;

public class Post extends AppCompatActivity {

    private Toolbar mtoolbar;
    private Button mpost;
    private EditText source, destination, date, time, maxPass, cab;
    private FirebaseAuth fAuth;
    private FirebaseFirestore fStore;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        mtoolbar = findViewById(R.id.update_post);
        source = findViewById(R.id.sourceText);
        destination = findViewById(R.id.destText);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);
        maxPass = findViewById(R.id.coPass);
        mpost =findViewById(R.id.postBtn);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        userID = fAuth.getCurrentUser().getUid();


        setSupportActionBar(mtoolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Update Post");

        mpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DocumentReference docRef = fStore.collection("USERS").document(fAuth.getCurrentUser().getUid());
                docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if(documentSnapshot.exists()){
                            String mname = documentSnapshot.getString("first") + " " + documentSnapshot.getString("last");
                            String memail=documentSnapshot.getString("email");
                            String mphone= fAuth.getCurrentUser().getPhoneNumber();

                            String msource = source.getText().toString();
                            String mdest = destination.getText().toString();
                            String mdate = date.getText().toString();
                            String mtime = time.getText().toString();
                            String mmaxpass = maxPass.getText().toString();

                            if(TextUtils.isEmpty(msource)){
                                source.setError("Enter source");
                                return;
                            }
                            if(TextUtils.isEmpty(mdest)){
                                destination.setError("Enter destination");
                                return;
                            }
                            if(TextUtils.isEmpty(mdate)){
                                date.setError("Enter date");
                                return;
                            }
                            if(TextUtils.isEmpty(mtime)){
                                time.setError("Enter time");
                                return;
                            }
                            if(TextUtils.isEmpty(mmaxpass)){
                                maxPass.setError("Enter maximum co passengers");
                                return;
                            }

                            CollectionReference dbRides= fStore.collection("Conveyance");

                            Display display = new Display(
                                    msource,
                                    mdest,
                                    mdate,
                                    mtime,
                                    mmaxpass,
                                    mname,
                                    memail,
                                    mphone

                            );

                            dbRides.add(display).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Toast.makeText(Post.this, "Posted", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(), AvailableRides.class));

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(Post.this, "Error! " + e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });


                        }

                    }
                });

            }
        });

    }

}
