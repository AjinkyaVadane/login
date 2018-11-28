package com.example.vsreenathreddy1.login;

import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class activity_addLF extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private EditText mName;
    private EditText mDes;
    private EditText mLoc;
    private EditText mDateTime;
    private EditText mId;
    private View mRootView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lf);
        mRootView = findViewById(R.id.rootView);
        mName = findViewById(R.id.name);
        mDes = findViewById(R.id.description);
        mLoc = findViewById(R.id.location);
        mDateTime = findViewById(R.id.dateTime);
        mId = findViewById(R.id.id);

    }

    //TODO: validate all text
    private boolean validateAll() {
        return true;
    }


    public boolean isEmptyFieldInserted(EditText mName, EditText mDes, EditText mLoc, EditText mDateTime, EditText mId) {
        String mNameField = mName.getText().toString();
        String mDesField = mDes.getText().toString();
        String mLocField = mLoc.getText().toString();
        String mDateTimeField = mDateTime.getText().toString();
        String mIdField = mId.getText().toString();

        return true;
    }


    private void addLF() {
        if(isEmptyFieldInserted (mName, mDes, mLoc, mDateTime, mId)) {
            LostFound lostFound = new LostFound(mName.getText().toString(), mDes.getText().toString(), mLoc.getText().toString(),
                    mDateTime.getText().toString(), mId.getText().toString());
            mDatabase = FirebaseDatabase.getInstance().getReference();
            mDatabase.child("LostFound").child(mId.getText().toString()).setValue(lostFound).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Snackbar.make(mRootView, "Lost Item added", Snackbar.LENGTH_LONG).show();
                }
            });
        }
    }

    // submit button call listner
    public void submitDataLF(View view) {
        if (validateAll()) {
            addLF();
        }
    }



}
