package com.example.rizalfauzy.builditup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rizalfauzy.builditup.model.user.UserUpdate;
import com.example.rizalfauzy.builditup.rest.APIClient;
import com.example.rizalfauzy.builditup.rest.UserAPIInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginPage extends Activity  {
    Button b1,b2,b3;
    EditText ed1,ed2;


    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        final UserAPIInterface mUserAPIInterface;

        ed1 = (EditText)findViewById(R.id.username);
        ed2 = (EditText)findViewById(R.id.pass);

        b1 = (Button)findViewById(R.id.button);
        b2 = (Button)findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.signup);

        mUserAPIInterface = APIClient.getClient().create(UserAPIInterface.class);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<UserUpdate> result = mUserAPIInterface.userLogin(ed1.getText().toString(), ed2.getText().toString());
                result.enqueue(new Callback<UserUpdate>() {
                    @Override
                    public void onResponse(Call<UserUpdate> call, Response<UserUpdate> response) {
                        if(response.body().getStatus().equals("success")) {
                            Toast.makeText(getApplicationContext(), "Redirecting...",Toast.LENGTH_SHORT).show();

                            SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPref.edit();
                            editor.putInt("id", response.body().getUser().getId());
                            editor.putString("username", response.body().getUser().getUsername());
                            editor.putString("access_token", response.body().getUser().getAccess_token());
                            editor.putString("login_as", response.body().getUser().getLogin_as());
                            editor.commit();

                            Intent i = new Intent(LoginPage.this, Homepage.class);
                            startActivity(i);
                        }else{
                            Toast.makeText(getApplicationContext(), response.body().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<UserUpdate> call, Throwable t) {

                    }
                });
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginPage.this, RegisterPage.class);
                startActivity(i);
            }
        });
    }
}