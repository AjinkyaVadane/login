package com.example.vsreenathreddy1.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Utils {

    public static boolean ad = false;
    public static boolean checkIfUserIsAdmin(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences("MAC", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPref.edit();
        final String username = sharedPref.getString("username", "-1");
        FirebaseDatabase.getInstance().getReference("Users/manager/manager1")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        Users value = dataSnapshot.getValue(Users.class);
                        if (value != null) {
                            if (value.username.equals(username)) {
                                ad = true;
                            } else { //normal user
                                ad = false;
                            }
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        ad = false;
                    }
                });
        return ad;
    }





}


