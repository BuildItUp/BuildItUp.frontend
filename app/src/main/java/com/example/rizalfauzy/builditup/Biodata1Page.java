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

import com.example.rizalfauzy.builditup.model.customer.CustomerUpdate;
import com.example.rizalfauzy.builditup.rest.APIClient;
import com.example.rizalfauzy.builditup.rest.CustomerAPIInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Biodata1Page extends AppCompatActivity {

    Button btnSave;
    EditText edtFullname, edtCtzId, edtPhone;
    CustomerAPIInterface mCustomerAPIInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodata1_page);

        edtFullname = (EditText)findViewById(R.id.txFullname);
        edtCtzId = (EditText)findViewById(R.id.txCtz);
        edtPhone = (EditText)findViewById(R.id.txPhoneN);

        btnSave = (Button)findViewById(R.id.btnSave);

        mCustomerAPIInterface = APIClient.getClient().create(CustomerAPIInterface.class);

        btnSave.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (edtFullname.getText().toString().equals("") || edtCtzId.getText().toString().equals("") || edtPhone.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "All field must be filled",Toast.LENGTH_SHORT).show();
                } else {
                    SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(Biodata1Page.this);
                    int id = sharedPref.getInt("id", 0);

                    Toast.makeText(getApplicationContext(), id + " = ID ANDA BIODATA",Toast.LENGTH_LONG).show();

                    Call<CustomerUpdate> result = mCustomerAPIInterface.customerRegister(id, edtFullname.getText().toString(), edtCtzId.getText().toString(), edtPhone.getText().toString());
                    result.enqueue(new Callback<CustomerUpdate>(){
                        @Override
                        public void onResponse(Call<CustomerUpdate> call, Response<CustomerUpdate> response) {
                            if (response.body().getStatus().equals("success")) {
                                Intent i = new Intent(Biodata1Page.this, Homepage.class);
                                startActivity(i);
                            } else {
                                Toast.makeText(getApplicationContext(), response.body().getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<CustomerUpdate> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Register Failed",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}
