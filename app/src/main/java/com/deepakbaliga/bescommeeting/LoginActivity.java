package com.deepakbaliga.bescommeeting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.deepakbaliga.bescommeeting.callback.Login;
import com.deepakbaliga.bescommeeting.model.User;
import com.deepakbaliga.bescommeeting.retrofit.APIAdapter;
import com.pixplicity.easyprefs.library.Prefs;

public class LoginActivity extends AppCompatActivity {

    private EditText username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        if(Prefs.getBoolean("loggedin",false)){

            startActivity(new Intent(this,MainActivity.class));
            this.finish();
        }

    }

    public void login(View view){

        String sUsername = username.getText().toString();
        if (sUsername.matches("")) {
            Toast.makeText(this, "You did not enter a username", Toast.LENGTH_SHORT).show();
            return;
        }

        String sPassword = password.getText().toString();
        if (sUsername.matches("")) {
            Toast.makeText(this, "You did not enter a username", Toast.LENGTH_SHORT).show();
            return;
        }


        new APIAdapter().login(sUsername, sPassword, new Login() {
            @Override
            public void success(User user) {
                Log.e("Success", user.getUniqueID());

                Prefs.putString("userid",user.getUniqueID());
                Prefs.putBoolean("loggedin",true);
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                finish();

            }

            @Override
            public void failed(String err) {
                Log.e("Failed", err);

                Toast.makeText(LoginActivity.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                Prefs.putBoolean("loggedin",true);
            }
        });


    }
}
