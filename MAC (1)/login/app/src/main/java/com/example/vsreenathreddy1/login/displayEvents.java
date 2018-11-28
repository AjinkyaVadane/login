package com.example.vsreenathreddy1.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class displayEvents extends AppCompatActivity {
    private static final String TAG = "activityDisplayEvents";
    private DatabaseReference mDatabase;
    private EditText mName;
    private EditText mDes;
    private EditText mLoc;
    private EditText mDateTime;
    private EditText mAvai;
    private EditText mId;
    private View mRootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events);
        getAllEvents();
    }

    private void getAllEvents() {
        FirebaseDatabase.getInstance().getReference("events/")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menu) {
        // Handle item selection
        switch (menu.getItemId()) {
            case R.id.line1:
                Intent startNewActivity111 = new Intent(this, activity_EventsManager.class);
                startActivity(startNewActivity111);
                return true;
            case R.id.line2:
                Intent startNewActivity112 = new Intent(this, activity_ClubsManager.class);
                startActivity(startNewActivity112);
                return true;
            case R.id.line3:
                Intent startNewActivity121 = new Intent(this, activity_LF.class);
                startActivity(startNewActivity121);
                return true;
            case R.id.line4:
                Intent startNewActivity122 = new Intent(this, displayHelpDesk.class);
                startActivity(startNewActivity122);
                return true;
            case R.id.line5:
                Intent intent1 = new Intent(this, MainActivity.class);
                this.startActivity(intent1);
                return true;
            default:
                return super.onOptionsItemSelected(menu);
        }
    }
   /* public void sendE(View view){
        Intent startNewActivity = new Intent(this, sendEvent.class);
        startActivity(startNewActivity);
    }*/


   //by ajju


    private void ShowEvent() {
        //Event event = new Event(mName.getText().toString(), mDes.getText().toString(), mLoc.getText().toString(),
               // mDateTime.getText().toString(), mAvai.getText().toString(), mId.getText().toString());
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("events").getParent();
        Log.e(TAG, "readDB: "+mDatabase);
        /*mDatabase.child("events").child(mId.getText().toString()).setValue(event).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Snackbar.make(mRootView, "Event Created", Snackbar.LENGTH_LONG).show();*/
            }




}
