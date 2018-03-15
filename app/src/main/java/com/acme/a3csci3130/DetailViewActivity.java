package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DetailViewActivity extends Activity {

    private EditText nameField, primaryBusinessField,
            addressField, provinceOrTerritoryField;
    private TextView businessNumField;
    Business receivedBusinessInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedBusinessInfo = (Business)getIntent().getSerializableExtra("Business");

        businessNumField = (TextView) findViewById(R.id.txtBNum);
        nameField = (EditText)findViewById(R.id.edtTxtName);
        primaryBusinessField = (EditText)findViewById(R.id.edtTxtPBus);
        addressField = (EditText)findViewById(R.id.edtTxtAddr);
        provinceOrTerritoryField = (EditText)findViewById(R.id.edtTxtPrOrTr);

        if(receivedBusinessInfo != null){
            businessNumField.setText("business number: " +receivedBusinessInfo.getBusinessNumber());
            nameField.setText(receivedBusinessInfo.getName());
            primaryBusinessField.setText(receivedBusinessInfo.getPrimaryBusiness());
            addressField.setText(receivedBusinessInfo.getAddress());
            provinceOrTerritoryField.setText(receivedBusinessInfo.getProvinceOrTerritory());
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
