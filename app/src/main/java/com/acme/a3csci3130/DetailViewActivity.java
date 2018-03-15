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
    private MyApplicationData appState;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedBusinessInfo = (Business)getIntent().getSerializableExtra("Business");
        appState = ((MyApplicationData)getApplicationContext());

        businessNumField = (TextView) findViewById(R.id.txtBNum);
        nameField = (EditText)findViewById(R.id.edtTxtName);
        primaryBusinessField = (EditText)findViewById(R.id.edtTxtPBus);
        addressField = (EditText)findViewById(R.id.edtTxtAddr);
        provinceOrTerritoryField = (EditText)findViewById(R.id.edtTxtPrOrTr);

        if(receivedBusinessInfo != null){
            businessNumField.setText(receivedBusinessInfo.getBusinessNumber());
            nameField.setText(receivedBusinessInfo.getName());
            primaryBusinessField.setText(receivedBusinessInfo.getPrimaryBusiness());
            addressField.setText(receivedBusinessInfo.getAddress());
            provinceOrTerritoryField.setText(receivedBusinessInfo.getProvinceOrTerritory());
        }
    }

    public void updateBusiness(View v){
        String busNum= businessNumField.getText().toString();
        String name = nameField.getText().toString();
        String pBus = primaryBusinessField.getText().toString();
        String addr = addressField.getText().toString();
        String prOrTr = provinceOrTerritoryField.getText().toString();
        Business business = new Business(busNum, name, pBus,addr,prOrTr);

        appState.firebaseReference.child(busNum).setValue(business);

        finish();
    }

    public void eraseBusiness(View v)
    {
        appState.firebaseReference.child(businessNumField.getText().toString()).setValue(null);

        finish();
    }
}
