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

public class AddClub extends AppCompatActivity {

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
        setContentView(R.layout.activity_add_club);
        mRootView = findViewById(R.id.rootView);
        mName = findViewById(R.id.name);
        mDes = findViewById(R.id.description);
        mLoc = findViewById(R.id.location);
        mDateTime = findViewById(R.id.dateTime);
        mAvai = findViewById(R.id.availability);
        mId = findViewById(R.id.id);

    }

    //TODO: validate all text
    private boolean validateAll() {
        return true;
    }


    public boolean isEmptyFieldInserted(EditText mName, EditText mDes, EditText mLoc, EditText mDateTime, EditText mAvai, EditText mId) {
        String mNameField = mName.getText().toString();
        String mDesField = mDes.getText().toString();
        String mLocField = mLoc.getText().toString();
        String mDateTimeField = mDateTime.getText().toString();
        String mAvaiField = mAvai.getText().toString();
        String mIdField = mId.getText().toString();

        if (TextUtils.isEmpty(mNameField) || TextUtils.isEmpty(mDesField) || TextUtils.isEmpty(mLocField) || TextUtils.isEmpty(mDateTimeField) || TextUtils.isEmpty(mAvaiField) || TextUtils.isEmpty(mIdField) ) {
            //textInputLayout.setError(message);
            //hideKeyboardFrom(textInputEditText);
            Snackbar.make(mRootView, "One or more fields are Empty", Snackbar.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }






    private void addClub() {
        if(isEmptyFieldInserted (mName, mDes, mLoc, mDateTime, mAvai, mId)) {
            Event event = new Event(mName.getText().toString(), mDes.getText().toString(), mLoc.getText().toString(),
                    mDateTime.getText().toString(), mAvai.getText().toString(), mId.getText().toString());
            mDatabase = FirebaseDatabase.getInstance().getReference();
            mDatabase.child("clubs").child(mId.getText().toString()).setValue(event).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Snackbar.make(mRootView, "Club Created", Snackbar.LENGTH_LONG).show();
                }
            });
        }
    }


    // submit button call listner
    public void submitDataClub(View view) {
        if (validateAll()) {
            addClub();
        }
    }
}

