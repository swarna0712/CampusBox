package com.example.campusbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class MyProfile extends AppCompatActivity {

    public static final String TAG = "TAG";
    FirebaseAuth firebaseAuth;
    FirebaseFirestore fStore;
    TextView fullName,email,phone,verifyMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        fullName = findViewById(R.id.profileFullName);
        email = findViewById(R.id.profileEmail);
        phone = findViewById(R.id.profilePhone);
        firebaseAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        final FirebaseUser usersdb = firebaseAuth.getCurrentUser();

        DocumentReference docRef = fStore.collection("USERS").document(firebaseAuth.getCurrentUser().getUid());
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    String full = documentSnapshot.getString("first") + " " + documentSnapshot.getString("last");
                    fullName.setText(full);
                    email.setText(documentSnapshot.getString("email"));
                    phone.setText(firebaseAuth.getCurrentUser().getPhoneNumber());

                }

            }
        });

    }
}
