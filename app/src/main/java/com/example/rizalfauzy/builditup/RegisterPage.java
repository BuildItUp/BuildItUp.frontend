package com.example.rizalfauzy.builditup;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rizalfauzy.builditup.model.user.UserUpdate;
import com.example.rizalfauzy.builditup.rest.APIClient;
import com.example.rizalfauzy.builditup.rest.UserAPIInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPage extends AppCompatActivity {
    Button btnSignup, btnCancel;
    EditText edtUsername, edtEmail, edtPassword;
    UserAPIInterface mUserAPIInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        btnSignup = (Button)findViewById(R.id.button);
        btnCancel = (Button)findViewById(R.id.button2);
        edtUsername = (EditText)findViewById(R.id.txUsername);
        edtEmail = (EditText)findViewById(R.id.txEmail);
        edtPassword = (EditText)findViewById(R.id.txPassword);
        mUserAPIInterface = APIClient.getClient().create(UserAPIInterface.class);

        btnSignup.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (edtUsername.getText().toString().equals("") || edtPassword.getText().toString().equals("") || edtEmail.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "All field must be filled",Toast.LENGTH_SHORT).show();
                } else {
                    Call<UserUpdate> result = mUserAPIInterface.userRegister(edtUsername.getText().toString(), edtPassword.getText().toString(), edtEmail.getText().toString());
                    result.enqueue(new Callback<UserUpdate>(){
                        @Override
                        public void onResponse(Call<UserUpdate> call, Response<UserUpdate> response) {
                            if (response.body().getStatus().equals("success")) {
                                Call<UserUpdate> newResult = mUserAPIInterface.userLogin(edtUsername.getText().toString(), edtPassword.getText().toString());
                                newResult.enqueue(new Callback<UserUpdate>() {
                                    @Override
                                    public void onResponse(Call<UserUpdate> call, Response<UserUpdate> response) {
                                        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(RegisterPage.this);
                                        SharedPreferences.Editor editor = sharedPref.edit();
                                        editor.putInt("id", response.body().getUser().getId());
                                        editor.putString("username", response.body().getUser().getUsername());
                                        editor.putString("access_token", response.body().getUser().getAccess_token());
                                        editor.putString("login_as", response.body().getUser().getLogin_as());
                                        editor.commit();

                                        Toast.makeText(getApplicationContext(), sharedPref.getInt("id", 0) + " = ID ANDA REGISTER",Toast.LENGTH_LONG).show();

                                        Intent i = new Intent(RegisterPage.this, Biodata1Page.class);
                                        startActivity(i);
                                    }

                                    @Override
                                    public void onFailure(Call<UserUpdate> call, Throwable t) {
                                        Toast.makeText(getApplicationContext(), "AutoLogin Failed",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            } else {
                                Toast.makeText(getApplicationContext(), response.body().getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<UserUpdate> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Register Failed",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }

        });

    }
}
