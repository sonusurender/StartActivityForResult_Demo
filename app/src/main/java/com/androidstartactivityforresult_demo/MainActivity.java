package com.androidstartactivityforresult_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int IntentId =1; //Intent Request Code
    private static TextView resultMessage;
    private static Button getMessageBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultMessage = (TextView)findViewById(R.id.resultMessage);
        getMessageBtn = (Button)findViewById(R.id.secondActivityBtn);

        getMessageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Open second activity with request code
                Intent in = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(in, IntentId);
            }
        });
    }

    // Call Back method to get the Message form other Activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is IntentId
        if (requestCode == IntentId) {
            if (resultCode == RESULT_OK) {

                //If result code is OK then get String extra and set message
                String message = data.getStringExtra("message");
                resultMessage.setText(message);
            }

            if (resultCode == RESULT_CANCELED)

                //When result is cancelled display toast
                Toast.makeText(MainActivity.this, "Activity cancelled.", Toast.LENGTH_SHORT).show();


        }
    }
    }




