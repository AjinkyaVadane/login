package com.example.vsreenathreddy1.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EventDetails extends AppCompatActivity {

    private TextView mName;
    private TextView mDes;
    private TextView mLoc;
    private TextView mDateTime;
    private TextView mAvai;
    private TextView mId;


    private static final String TAG = "EventDetails";
    private DatabaseReference mDatabase;
    private View mRootView;
    public Event event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);
        mRootView = findViewById(R.id.rv);
        mName = findViewById(R.id.name);
        mDes = findViewById(R.id.description);
        mLoc = findViewById(R.id.location);
        mDateTime = findViewById(R.id.dateTime);
        mAvai = findViewById(R.id.availability);
        mId = findViewById(R.id.id);

        Intent intent = getIntent();
        event = intent.getParcelableExtra("event");
        Log.e(TAG, "onCreate: " + event.name);
        if (event != null) {
            mName.setText("Event Name: " + event.name);
            mDes.setText("Event Description: " + event.description);
            mLoc.setText("Event Location: " + event.location);
            mDateTime.setText("Event Date & Time: " + event.date_time);
            mAvai.setText("Event Availability: " + event.availability);
            mId.setText("Event Id: " + event.id);
        }
    }

    public void registerUser(View view) {
        Snackbar.make(mRootView, Integer.parseInt(event.availability) >= 1 ? "You are registered" : "Currently seats are full, please try again later", Snackbar.LENGTH_LONG).show();
    }
}

