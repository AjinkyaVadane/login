package com.example.vsreenathreddy1.login;

import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class activity_deleteevent extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private EditText mId;
    private View mRootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleteevent);
        mRootView = findViewById(R.id.rootView);
        mId = findViewById(R.id.id);

    }
    //TODO: validate all text
    private boolean validateAll() {
        return true;
    }


    private void deleteEvent() {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("events").child(mId.getText().toString()).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Snackbar.make(mRootView, "Event Deleted", Snackbar.LENGTH_LONG).show();

            }
        });
    }


    // submit button call listner
    public void submitDeleteEvent(View view) {
        if (validateAll()) {
            deleteEvent();
        }
    }
}
