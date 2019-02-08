package com.androidstartactivityforresult_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by SONU on 25/09/15.
 */
public class SecondActivity  extends AppCompatActivity implements OnClickListener{
    private static EditText inputMessage;
    private static Button cancel, submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        inputMessage = (EditText)findViewById(R.id.inputMessage);
        cancel = (Button)findViewById(R.id.cancel);
        submit = (Button)findViewById(R.id.submit);

        cancel.setOnClickListener(this);
        submit.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
switch (view.getId()){
    case R.id.submit:
        String message=inputMessage.getText().toString();
        if(message.length()!=0 && !message.equals("")) {
            Intent intent = new Intent();
            intent.putExtra("message",message);//Put Message to pass over intent
            setResult(RESULT_OK,intent);//Set result OK
            finish();//finish activity
        }
        else
            Toast.makeText(SecondActivity.this, "Please enter a message.", Toast.LENGTH_SHORT).show();

        break;
    case R.id.cancel:
        Intent intent = new Intent();
        setResult(RESULT_CANCELED, intent);//For cancel button set result CANCEl
        finish();//finish activity
        break;
}
    }




}
