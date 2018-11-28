package com.example.vsreenathreddy1.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

public class EventDetails extends AppCompatActivity {

    private TextView mName;
    private TextView mDes;
    private TextView mLoc;
    private TextView mDateTime;
    private TextView mAvai;
    private TextView mId;
    private Button mButton;


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
        mButton = findViewById(R.id.buttonRegister);

        Intent intent = getIntent();
        event = intent.getParcelableExtra("event");
        if (event != null) {
            mName.setText("Name: " + event.name);
            mDes.setText("Description: " + event.description);
            mLoc.setText("Location: " + event.location);
            mDateTime.setText("Date & Time: " + event.date_time);
            if ((intent.getExtras().getBoolean("lf"))) {
                mAvai.setVisibility(View.GONE);
                mButton.setVisibility(View.GONE);
            } else {
                mAvai.setText("Availability: " + event.availability);
            }
            mId.setText("Id: " + event.id);
        }
    }

    public void registerUser(View view) {
        Snackbar.make(mRootView, Integer.parseInt(event.availability) >= 1 ? "You are registered" : "Currently seats are full, please try again later", Snackbar.LENGTH_LONG).show();
    }
}

