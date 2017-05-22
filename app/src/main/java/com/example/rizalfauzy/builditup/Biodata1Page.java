package com.example.rizalfauzy.builditup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Biodata1Page extends AppCompatActivity {

    Button btnSave;
    EditText edtFullname, edtCtzId, edtPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodata1_page);

        edtFullname = (EditText)findViewById(R.id.txFullname);
        edtCtzId = (EditText)findViewById(R.id.txCtz);
        edtPhone = (EditText)findViewById(R.id.txPhoneN);

        btnSave = (Button)findViewById(R.id.btnSave);
    }
}
