package com.example.vsreenathreddy1.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class sendClub extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_club);
    }
    public void onClickC(View v) {

        switch(v.getId())
        {
            case R.id.buttonRC1:
                Toast.makeText(this, "Registered", Toast.LENGTH_LONG).show();
                break;
        }


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
}
