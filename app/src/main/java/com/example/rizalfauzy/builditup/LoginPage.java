package com.example.rizalfauzy.builditup;

import android.app.Activity;
import android.content.Intent;
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
    Button b1,b2;
    EditText ed1,ed2;
    UserAPIInterface mUserAPIInterface;

    TextView tx1;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        b1 = (Button)findViewById(R.id.button);
        ed1 = (EditText)findViewById(R.id.editText);
        ed2 = (EditText)findViewById(R.id.editText2);

        b2 = (Button)findViewById(R.id.button2);
        tx1 = (TextView)findViewById(R.id.textView3);
        tx1.setVisibility(View.GONE);

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

                            tx1.setText(Integer.toString(counter));
                            Intent i = new Intent(LoginPage.this, Homepage.class);
                            startActivity(i);
                        }else{
                            Toast.makeText(getApplicationContext(), response.body().getMessage(),Toast.LENGTH_SHORT).show();

                            tx1.setVisibility(View.VISIBLE);
                            tx1.setBackgroundColor(Color.RED);
                            counter--;

                            if (counter == 0) {
                                b1.setEnabled(false);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<UserUpdate> call, Throwable t) {
                        Log.e("Retrofit Get", t.toString());
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
    }
}