package com.example.vsreenathreddy1.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class displayHomeScreen extends AppCompatActivity {

    public boolean ad = false;
    private static final String TAG = "displayHomeScreen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_home_screen);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menu) {
        // Handle item selection
        switch (menu.getItemId()) {
            case R.id.line1:
                openEvent();
                return true;
            case R.id.line2:
                openClub();
                return true;
            case R.id.line3:
                opelLF();
                return true;
            case R.id.line4:
                openHD();
                return true;
            case R.id.line5:
                Intent intent1 = new Intent(this, MainActivity.class);
                this.startActivity(intent1);
                return true;
            default:
                return super.onOptionsItemSelected(menu);
        }
    }

    private void openHD() {
        Intent startNewActivity122 = new Intent(this, displayHelpDesk.class).putExtra("isAdmin", Utils.checkIfUserIsAdmin(this));
        startActivity(startNewActivity122);
    }

    private void opelLF() {
        Intent startNewActivity121 = new Intent(this, activity_LF.class).putExtra("isAdmin", Utils.checkIfUserIsAdmin(this));
        startActivity(startNewActivity121);
    }

    private void openClub() {
        SharedPreferences sharedPref = getSharedPreferences("MAC", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPref.edit();
        final String username = sharedPref.getString("username", "-1");
        Log.e(TAG, "readDB: " + username);
        // Read from the database
        FirebaseDatabase.getInstance().getReference("Users/manager/manager1")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        Users value = dataSnapshot.getValue(Users.class);
                        Intent intent;
                        if (value != null) {
                            if (value.username.equals(username)) {
                                intent = new Intent(displayHomeScreen.this, activity_ClubsManager.class);
                                editor.putBoolean("isAdmin", true);
                            } else { //normal user
                                editor.putBoolean("isAdmin", false);
                                intent = new Intent(displayHomeScreen.this, ViewAllEvents.class).putExtra("path", "clubs");
                            }
                            editor.apply();
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });
    }

    private void openEvent() {
        SharedPreferences sharedPref = getSharedPreferences("MAC", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPref.edit();
        final String username = sharedPref.getString("username", "-1");
        Log.e(TAG, "readDB: " + username);
        // Read from the database
        FirebaseDatabase.getInstance().getReference("Users/manager/manager1")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        Users value = dataSnapshot.getValue(Users.class);
                        Intent intent;
                        if (value != null) {
                            if (value.username.equals(username)) { //if manager
                                intent = new Intent(displayHomeScreen.this, activity_EventsManager.class).putExtra("path", "events");
                                editor.putBoolean("isAdmin", true);
                            } else { //normal user
                                editor.putBoolean("isAdmin", false);
                                intent = new Intent(displayHomeScreen.this, ViewAllEvents.class).putExtra("path", "events");
                            }
                            editor.apply();
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });
    }

    public void sendMsg11(View view) {
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        openEvent();
    }


    //changed by ajinkya
    //TODO:1
    public void sendMsg12(View view) {
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        openClub();
        /*Intent startNewActivity12 = new Intent(this, displayClubs.class);
        startActivity(startNewActivity12);*/
    }


//changed by ajinkya 25/11/2018


    public void sendMsg21(View view) {
        opelLF();
    }


    public void sendMsg22(View view) {
        openHD();
    }



}

