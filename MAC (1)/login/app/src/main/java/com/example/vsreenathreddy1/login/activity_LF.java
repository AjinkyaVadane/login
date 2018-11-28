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

public class activity_LF extends AppCompatActivity {
    private static final String TAG = "activityEventsManager";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__lf);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menu) {
// Handle item selection
        switch (menu.getItemId()) {
            case R.id.line1:
                Intent startNewActivity111 = new Intent(this, getIntent().getExtras().getBoolean("isAdmin") ?
                        activity_EventsManager.class : ViewAllEvents.class).putExtra("path", "events");
                startActivity(startNewActivity111);
                return true;
            case R.id.line2:
                Intent startNewActivity112 = new Intent(this, getIntent().getExtras().getBoolean("isAdmin") ?
                        activity_ClubsManager.class : ViewAllEvents.class).putExtra("path", "clubs");
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

    public void sendMsgUploadLF(View view) {
        Intent startNewActivity = new Intent(this, activity_addLF.class);
        startActivity(startNewActivity);
    }

    public void sendMsgViewLF(View view) {
        Intent startNewActivity = new Intent(this, ViewAllEvents.class).putExtra("path", "LostFound");
        startActivity(startNewActivity);
    }

}
