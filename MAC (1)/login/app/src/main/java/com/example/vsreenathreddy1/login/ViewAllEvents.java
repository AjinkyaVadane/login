package com.example.vsreenathreddy1.login;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ViewAllEvents extends AppCompatActivity {

    RecyclerView mRecyclerView;
    List<Event> mList = new ArrayList<>();
    private static final String TAG = "ViewAllEvents";
    RVAdapter rvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_events);
        mRecyclerView = findViewById(R.id.recyclerView);
        Intent intent = getIntent();

        getAllEvents(intent);

        rvAdapter = new RVAdapter(this, mList, getIntent().getStringExtra("path").equals("LostFound"));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mRecyclerView.setAdapter(rvAdapter);
    }

    private void getAllEvents(Intent intent) {
        Log.e(TAG, "getAllEvents: "+ intent.getStringExtra("path"));
        FirebaseDatabase.getInstance().getReference(intent.getStringExtra("path"))
                .addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                        Event event = dataSnapshot.getValue(Event.class);
                        Log.e(TAG, "onChildAdded: " + event.name);
                        mList.add(event);
                        rvAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    }

                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                        Event eventDelete = dataSnapshot.getValue(Event.class);
                        if (eventDelete != null) {
                            for (Event event : mList) {
                                if (event.id.equals(eventDelete.id)) {
                                    mList.remove(event);
                                }
                            }
                        }
                        rvAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
    }
}
