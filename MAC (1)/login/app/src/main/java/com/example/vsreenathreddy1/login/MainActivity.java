package com.example.vsreenathreddy1.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.content.Context;
import android.widget.Toast;


public class
MainActivity extends AppCompatActivity {
    private Context context;
    private View mRootView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            mRootView = findViewById(R.id.rootView);
    }

    public void sendMessage(View view) {
        EditText username = (EditText)findViewById(R.id.editText);
        EditText password = (EditText)findViewById(R.id.editText2);
        if(isUsernameTextFilled(username,password)) {
            if ((username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) || (username.getText().toString().equals("abc") && password.getText().toString().equals("abc"))){

                SharedPreferences sharedPref = getSharedPreferences("MAC", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString(getString(R.string.username), username.getText().toString());
                editor.apply();

                Intent startNewActivity = new Intent(this, displayHomeScreen.class);
                startActivity(startNewActivity);
                finish();
                //correcct password
            } else {
                Snackbar.make(mRootView, "User not Found", Snackbar.LENGTH_SHORT).show();
                Intent intent1 = new Intent(this, MainActivity.class);
                this.startActivity(intent1);

                /*switch (view.getId()) {
                    case R.id.button2:
                        Intent intent1 = new Intent(this, MainActivity.class);
                        this.startActivity(intent1);
                        break;
                }*/
            }
        }
    }


    public boolean isUsernameTextFilled(EditText username, EditText password) {
        String musername = username.getText().toString();
        String mpassword = password.getText().toString();
        if (TextUtils.isEmpty(musername) || TextUtils.isEmpty(mpassword)) {
            //textInputLayout.setError(message);
            //hideKeyboardFrom(textInputEditText);
            Snackbar.make(mRootView, "Username or Password is missing", Snackbar.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


}
