package com.example.myapplicationemail;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView label;
    EditText email, subject, details;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        label = findViewById(R.id.TextView);
        details = findViewById(R.id.editTextTextPersonName2);
        subject = findViewById(R.id.editTextTextPersonName);
        email = findViewById(R.id.editTextTextEmailAddress);
        send = findViewById(R.id.button);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View Arg0) {

                String body = details.getText().toString();
                String recipient = email.getText().toString();
                String topic = subject.getText().toString();
                //Intent i = new Intent(Intent.ACTION_SEND);
                Intent i = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto",recipient, null));
                //i.setType("message/rfc822");
                //i.putExtra(Intent.EXTRA_EMAIL, recipient);
                i.putExtra(Intent.EXTRA_SUBJECT, topic);
                i.putExtra(Intent.EXTRA_TEXT, body);
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(MainActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}