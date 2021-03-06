package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.Random;

public class CreateBusinessActivity extends Activity {

    private Button submitButton;
    private EditText nameField, primaryBusinessField, addressField, provinceOrTerritoryField;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_business);
        //Get the app wide shared variables
        appState = ((MyApplicationData)getApplicationContext());

        submitButton = (Button)findViewById(R.id.submitButton);
        nameField = (EditText)findViewById(R.id.edtTxtName);
        primaryBusinessField = (EditText)findViewById(R.id.edtTxtPBus);
        addressField = (EditText)findViewById(R.id.edtTxtAddr);
        provinceOrTerritoryField = (EditText)findViewById(R.id.edtTxtPrOrTr);
    }

    /**
     * Generates a random 9 digit number for business num.
     * @return
     */
    private String getBusNum(){
        String num = "";
        Random rand = new Random();
        for(int i = 0; i < 9; i++){
            num += ((Integer)rand.nextInt(10)).toString();
        }
        return num;
    }

    /**
     * Send data off to firebase to create business in DB.
     * @param v
     */
    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String busNum= getBusNum();
        String name = nameField.getText().toString();
        String pBus = primaryBusinessField.getText().toString();
        String addr = addressField.getText().toString();
        String prOrTr = provinceOrTerritoryField.getText().toString();
        Business business = new Business(busNum, name, pBus,addr,prOrTr);

        appState.firebaseReference.child(busNum).setValue(business);

        finish();
    }
}
