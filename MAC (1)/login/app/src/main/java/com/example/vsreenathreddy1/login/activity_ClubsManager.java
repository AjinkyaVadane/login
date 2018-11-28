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

public class activity_ClubsManager extends AppCompatActivity {
    private static final String TAG = "activityEventsManager";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__clubs_manager);
    }
    @Override
    public boolean  onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menu)
    {
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

    public void sendMsgAddClub(View view){
        DatabaseReference database  = FirebaseDatabase.getInstance().getReference();
        readDBSendMsgAddClub();
    }


    public void sendMsgModifyClub(View view)
    {
        DatabaseReference database  = FirebaseDatabase.getInstance().getReference();
        sendMsgModifyClub();
    }

    public void sendMsgDeleteClub(View view)
    {
        DatabaseReference database  = FirebaseDatabase.getInstance().getReference();
        sendMsgDeleteClub();
    }


    private void readDBSendMsgAddClub() {
        Toast.makeText(this, "Add Event", Toast.LENGTH_SHORT).show();
        SharedPreferences sharedPref = getSharedPreferences("MAC", Context.MODE_PRIVATE);
        final String username = sharedPref.getString("username", "-1");
        Log.e(TAG, "readDB: "+username);
        Toast.makeText(this, "readDB: 2"+username, Toast.LENGTH_SHORT).show();
        // Read from the database
        FirebaseDatabase.getInstance().getReference("Users/manager/manager1")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Toast.makeText(activity_ClubsManager.this, "3", Toast.LENGTH_SHORT).show();

                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        Users value = dataSnapshot.getValue(Users.class);
                        Intent intent;
                        if (value != null) {
                            Toast.makeText(activity_ClubsManager.this, "4", Toast.LENGTH_SHORT).show();
                            if (value.username.equals(username)) { //if manager
                                Toast.makeText(activity_ClubsManager.this, "5", Toast.LENGTH_SHORT).show();

                                intent = new Intent(activity_ClubsManager.this, AddClub.class);
                            } else { //normal user
                                intent = new Intent(activity_ClubsManager.this, displayClubs.class);
                            }
                            startActivity(intent);
                        } else {
                            Toast.makeText(activity_ClubsManager.this, "6", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });
    }



    //2

    private void sendMsgModifyClub() {
        Toast.makeText(this, "Modify Event", Toast.LENGTH_SHORT).show();
        SharedPreferences sharedPref = getSharedPreferences("MAC", Context.MODE_PRIVATE);
        final String username = sharedPref.getString("username", "-1");
        Log.e(TAG, "readDB: "+username);
        Toast.makeText(this, "readDB: 2"+username, Toast.LENGTH_SHORT).show();
        // Read from the database
        FirebaseDatabase.getInstance().getReference("Users/manager/manager1")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Toast.makeText(activity_ClubsManager.this, "3", Toast.LENGTH_SHORT).show();

                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        Users value = dataSnapshot.getValue(Users.class);
                        Intent intent;
                        if (value != null) {
                            Toast.makeText(activity_ClubsManager.this, "4", Toast.LENGTH_SHORT).show();
                            if (value.username.equals(username)) { //if manager
                                Toast.makeText(activity_ClubsManager.this, "5", Toast.LENGTH_SHORT).show();
//need to change
                                intent = new Intent(activity_ClubsManager.this, AddClub.class);
                            } else { //normal user
                                intent = new Intent(activity_ClubsManager.this, displayClubs.class);
                            }
                            startActivity(intent);
                        } else {
                            Toast.makeText(activity_ClubsManager.this, "6", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });
    }


    //2

    private void sendMsgDeleteClub() {
        Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
        SharedPreferences sharedPref = getSharedPreferences("MAC", Context.MODE_PRIVATE);
        final String username = sharedPref.getString("username", "-1");
        Log.e(TAG, "readDB: "+username);
        Toast.makeText(this, "readDB: 2"+username, Toast.LENGTH_SHORT).show();
        // Read from the database
        FirebaseDatabase.getInstance().getReference("Users/manager/manager1")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Toast.makeText(activity_ClubsManager.this, "Delete Event", Toast.LENGTH_SHORT).show();

                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        Users value = dataSnapshot.getValue(Users.class);
                        Intent intent;
                        if (value != null) {
                            Toast.makeText(activity_ClubsManager.this, "4", Toast.LENGTH_SHORT).show();
                            if (value.username.equals(username)) { //if manager
                                Toast.makeText(activity_ClubsManager.this, "5", Toast.LENGTH_SHORT).show();
//need to change
                                intent = new Intent(activity_ClubsManager.this, activity_deleteclub.class);
                            } else { //normal user
                                intent = new Intent(activity_ClubsManager.this, displayClubs.class);
                            }
                            startActivity(intent);
                        } else {
                            Toast.makeText(activity_ClubsManager.this, "6", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });
    }

}
