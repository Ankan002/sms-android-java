package com.exponents.mymessenger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText phoneNumberBox, messageBox;
    Button sendMessageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hooUp();

        actions();
    }

    private void hooUp(){
        phoneNumberBox = findViewById(R.id.phoneNumber);
        messageBox = findViewById(R.id.enterMessage);
        sendMessageButton = findViewById(R.id.send_message);
    }

    private void actions(){
        sendMessageButton.setOnClickListener(this);
    }

    public void onClick(View view){
        if(view.getId() == R.id.send_message){
            String mobileNumber = phoneNumberBox.getText().toString();
            if (mobileNumber.length() != 10) return;

            String message = messageBox.getText().toString();

            try{
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(mobileNumber, null, message, null, null);
                phoneNumberBox.setText("");
                messageBox.setText("");
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }
}