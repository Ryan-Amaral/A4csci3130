package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DetailViewActivity extends Activity {

    private EditText nameField, primaryBusinessField, addressField, provinceOrTerritoryField;
    Business receivedBusinessInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedBusinessInfo = (Business)getIntent().getSerializableExtra("Business");

        nameField = (EditText) findViewById(R.id.name);
        emailField = (EditText) findViewById(R.id.email);

        if(receivedBusinessInfo != null){
            nameField.setText(receivedBusinessInfo.name);
            emailField.setText(receivedBusinessInfo.name);
        }
    }

    public void updateBusiness(View v){
        //TODO: Update contact funcionality
    }

    public void eraseBusiness(View v)
    {
        //TODO: Erase contact functionality
    }
}
